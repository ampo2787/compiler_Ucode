import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class UcodeGenListener  extends MiniGoBaseListener {
    final String space11 = "           ";
    final String lineChange = "\n";
    private int BranchName = 0;
    private int IfForName = 0;

    ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();
    symbolTable globalSymtab = new symbolTable();
    symbolTable currentTable = globalSymtab;

    private String IFForName(){
        return "$$" + IfForName++;
    }
    private String BranchName(){
        return "$$" + BranchName++;
    }


    boolean isNormalOperation(MiniGoParser.ExprContext ctx){
        return ctx.getChildCount() == 1 || ctx.getChildCount() == 0;
    }
    boolean isSmallCompoundOperation(MiniGoParser.ExprContext ctx){
        return ctx.getChildCount() == 3 && ctx.expr().size() == 1 && ctx.getChild(1) == ctx.expr(0);
    }
    boolean isBigCompoundOperation(MiniGoParser.ExprContext ctx){
        return ctx.getChildCount() == 4 && ctx.expr().size() == 1;
    }
    boolean isSmallCompoundArgsOperation(MiniGoParser.ExprContext ctx){
        return ctx.getChildCount() == 4 && ctx.args() != null;
    }
    boolean isFMTOperation(MiniGoParser.ExprContext ctx){
        return ctx.getChildCount() == 6 && ctx.expr().size() == 0;
    }
    boolean isBinarySingleOperation(MiniGoParser.ExprContext ctx){
        return ctx.getChildCount() == 2;
    }

    boolean isBinaryOperation(MiniGoParser.ExprContext ctx){
        return ctx.getChildCount() == 3 && ctx.expr().size() == 2;
    }
    boolean isEqualOperation(MiniGoParser.ExprContext ctx){
        return ctx.getChildCount() == 3 && ctx.expr().size() == 1 && ctx.getChild(2) == ctx.expr(0);
    }
    boolean isArrayOperation(MiniGoParser.ExprContext ctx){
        return ctx.getChildCount() == 6 && ctx.expr().size() == 2;
    }

    @Override
    public void exitExpr(MiniGoParser.ExprContext ctx){
        String s1 = "", s2 = "", op = "";
        if(isNormalOperation(ctx)){
            if(ctx.LITERAL().size() != 0){
                s1 += space11 + "ldc " + ctx.LITERAL(0).getText() + lineChange;
                newTexts.put(ctx, s1);
            }
            else{
                if(ctx.IDENT().getText().equals("")){

                }
                else {
                    s1 += space11 + "lod " + currentTable.recursivefindTable(ctx.IDENT().getText()).blockLevel + " ";
                    s1 += currentTable.recursivefindTable(ctx.IDENT().getText()).var.get(ctx.IDENT().getText()) + lineChange;
                    newTexts.put(ctx, s1);
                }
            }
        }
        else if(isSmallCompoundOperation(ctx)){
            newTexts.put(ctx, newTexts.get(ctx.expr(0)));
        }
        else if(isBigCompoundOperation(ctx)){
            s1 += space11 + "ldc " + ctx.expr(0).getText() + lineChange;
            s1 += space11 + "lda " + currentTable.blockLevel + " ";
            s1 += currentTable.var.get(ctx.IDENT()) + lineChange;
            s1 += space11 + "add" +lineChange;
            newTexts.put(ctx, s1);
        }
        else if(isSmallCompoundArgsOperation(ctx)){
            s1 += space11 + "ldp" +lineChange; //args에서
            if(!newTexts.get(ctx.args()).equals("")){
                for(int i=0; i<ctx.args().expr().size(); i++){
                    s1 += newTexts.get(ctx.args().expr(i));
                }
            }
            s1 += space11 + "call " + ctx.IDENT().getText() + lineChange;
            newTexts.put(ctx, s1);
        }
        else if(isFMTOperation(ctx)){
            s1 += space11 + "ldp" +lineChange;
            s1 += newTexts.get(ctx.args());
            s1 += space11 + "call " + ctx.IDENT() + lineChange;
            newTexts.put(ctx, s1);
        }
        else if(isBinarySingleOperation(ctx)){
            String temp = ctx.op.getText();
            if(temp.equals("-") || temp.equals("+")){
                s1 += newTexts.get(ctx.expr(0));
                s1 += space11 + "neg";
                newTexts.put(ctx, s1);
            }
            else if(temp.equals("--")){
                s1 += newTexts.get(ctx.expr(0));
                s1 += space11 + "dec" +lineChange;
                newTexts.put(ctx, s1);
            }
            else if(temp.equals("++")){
                s1 += newTexts.get(ctx.expr(0));
                s1 += space11 + "inc" +lineChange;
                newTexts.put(ctx, s1);
            }
            else{ //!
                s1 += newTexts.get(ctx.expr(0));
                s1 += space11 + "notop" +lineChange;
                newTexts.put(ctx, s1);
            }
        }
        else if(isBinaryOperation(ctx)){
            String temp = ctx.op.getText();
            s1 += newTexts.get(ctx.expr(0));
            s1 += newTexts.get(ctx.expr(1));
            switch (temp) {
                case "==":
                    s1 += space11 + "eq" + lineChange;
                    break;
                case "!=":
                    s1 += space11 + "ne" + lineChange;
                    break;
                case "<=":
                    s1 += space11 + "le" + lineChange;
                    break;
                case "<":
                    s1 += space11 + "lt" + lineChange;
                    break;
                case ">=":
                    s1 += space11 + "ge" + lineChange;
                    break;
                case ">":
                    s1 += space11 + "gt" + lineChange;
                    break;
                case "&&":
                    s1 += space11 + "and" + lineChange;
                    break;
                case "||":
                    s1 += space11 + "or" + lineChange;
                    break;
                case "*":
                    s1 += space11 + "mult" + lineChange;
                    break;
                case "/":
                    s1 += space11 + "div" + lineChange;
                    break;
                case "%":
                    s1 += space11 + "mod" + lineChange;
                    break;
                case "+":
                    s1 += space11 + "add" + lineChange;
                    break;
                case "-":
                    s1 += space11 + "sub" + lineChange;
                    break;
            }
            newTexts.put(ctx, s1);

        }
        else if(isEqualOperation(ctx)){
            symbolTable thisTable = currentTable;
            if(!currentTable.var.containsKey(ctx.IDENT().getText())){
                thisTable = currentTable.recursivefindTable(ctx.IDENT().getText());
                s1 += space11 + "lod ";
                s1 += thisTable.blockLevel + " " + thisTable.var.get(ctx.IDENT().getText()) + lineChange;
            }
            s1 += newTexts.get(ctx.expr(0));
            s1 += space11 + "str " + currentTable.blockLevel + " " + currentTable.recursivefindTable(ctx.IDENT().getText()).var.get(ctx.IDENT().getText());
            s1 += lineChange;
            newTexts.put(ctx, s1);
        }
        else{
            s1 += space11 + "ldc " + newTexts.get(ctx.expr(0)) + lineChange;
            s1 += space11 + "lda ";
            s1 += currentTable.blockLevel + " " + currentTable.recursivefindTable(ctx.IDENT().getText()).var.get(ctx.IDENT().getText()) + lineChange;
            s1 += space11 + "add" + lineChange;
            s1 += newTexts.get(ctx.expr(1));
            s1 += space11 + "sti " + currentTable.blockLevel + " " + currentTable.recursivefindTable(ctx.IDENT().getText()).var.get(ctx.IDENT().getText());
            s1 += lineChange;
            newTexts.put(ctx, s1);
        }
    }


    @Override
    public void exitProgram(MiniGoParser.ProgramContext ctx) {
        String temp = "";
        for(int i=0; i<ctx.children.size(); i++){
            temp += newTexts.get(ctx.getChild(i));
        }
        temp += space11  + "bgn 0" + lineChange;
        temp += space11 + "ldp" + lineChange;
        temp += space11 + "call " + "main" + lineChange;
        temp += space11  + "end" + lineChange;
        System.out.println(temp);
        newTexts.put(ctx, temp);
    }

    @Override
    public void exitDecl(MiniGoParser.DeclContext ctx) {
        String temp = "";
        for(int i=0; i<ctx.children.size(); i++){
            temp += newTexts.get(ctx.getChild(i));
        }
        newTexts.put(ctx, temp);
    }

    @Override
    public void enterVar_decl(MiniGoParser.Var_declContext ctx) {
        if(ctx.children.size() == 3) {
            currentTable.var.put(ctx.children.get(1).getText(), currentTable.offset + 1);
            currentTable.funcVarArg.add(ctx.children.get(0).getText());
            currentTable.varSize.put(ctx.children.get(1).getText(), 1);
            currentTable.offset++;
        }
        else if(ctx.children.size() == 5){
            currentTable.var.put(ctx.children.get(1).getText(), currentTable.offset + 1);
            currentTable.funcVarArg.add(ctx.children.get(0).getText());
            currentTable.type_spec.add(ctx.children.get(4).getText());
            currentTable.varSize.put(ctx.children.get(1).getText(), 1);
            currentTable.offset++;

            currentTable.var.put(ctx.children.get(3).getText(), currentTable.offset + 1);
            currentTable.funcVarArg.add(ctx.children.get(0).getText());
            currentTable.type_spec.add(ctx.children.get(4).getText());
            currentTable.varSize.put(ctx.children.get(1).getText(), 1);
            currentTable.offset++;

        }
        else{
            currentTable.var.put(ctx.children.get(1).getText(), currentTable.offset + 1);
            currentTable.funcVarArg.add(ctx.children.get(0).getText());
            currentTable.type_spec.add(ctx.children.get(5).getText() + ctx.children.get(3).getText());
            currentTable.varSize.put(ctx.children.get(1).getText(), Integer.parseInt(ctx.LITERAL().getText()));
            currentTable.offset += Integer.parseInt(ctx.LITERAL().getText());
        }
    }

    @Override
    public void exitVar_decl(MiniGoParser.Var_declContext ctx) {
        String temp = "";
        String ident;
        String ident2;
        if(ctx.IDENT().size() == 1 && ctx.children.size() == 3) {
            ident = ctx.IDENT().get(0).getText();
            temp += space11 + "sym ";
            temp += "1 ";
            temp += currentTable.var.get(ident) + " ";
            temp += "1 " + lineChange;
        }
        else if(ctx.IDENT().size() == 2){
            ident = ctx.IDENT().get(0).getText();
            ident2 = ctx.IDENT().get(1).getText();

            temp += space11 + "sym ";
            temp += "1 ";
            temp += currentTable.var.get(ident) + " ";
            temp += "1 " + lineChange;
            temp += space11 + "sym ";
            temp += "1 ";
            temp += currentTable.var.get(ident2) + " ";
            temp += "1 " + lineChange;
        }
        else{
            ident = ctx.IDENT().get(0).getText();

            temp += space11 + "sym ";
            temp += "1 ";
            temp += currentTable.var.get(ident) + " ";
            temp += currentTable.varSize.get(ident) + lineChange;
        }
        newTexts.put(ctx, temp);
    }

    @Override
    public void enterType_spec(MiniGoParser.Type_specContext ctx) {

    }

    @Override
    public void exitType_spec(MiniGoParser.Type_specContext ctx) {
        super.exitType_spec(ctx);
    }

    @Override
    public void enterFun_decl(MiniGoParser.Fun_declContext ctx) {
        String childText = ctx.IDENT().getText();
        globalSymtab.setChild(childText);
        currentTable = globalSymtab.childTable.get(childText);
    }

    @Override
    public void exitFun_decl(MiniGoParser.Fun_declContext ctx) {
        String temp = "";
        temp += ctx.IDENT().getText() + space(ctx.IDENT().getText()) + "proc ";
        temp += currentTable.offset + " ";
        temp += "2 ";
        temp += "2 " + lineChange;
        temp += newTexts.get(ctx.params());
        temp += newTexts.get(ctx.compound_stmt());
        temp += space11 + "ret" + lineChange;
        temp += space11  + "end" + lineChange;
        newTexts.put(ctx, temp);
        currentTable = currentTable.parent;
    }

    @Override
    public void enterParams(MiniGoParser.ParamsContext ctx) {

    }

    @Override
    public void exitParams(MiniGoParser.ParamsContext ctx) {
        String temp = "";
        for(int i=0; i< ctx.param().size(); i++){
            temp += newTexts.get(ctx.param(i));
        }
        newTexts.put(ctx, temp);
    }

    @Override
    public void enterParam(MiniGoParser.ParamContext ctx) {
        if(ctx.children.size() == 2){
            currentTable.var.put(ctx.children.get(0).getText(), currentTable.offset);
            currentTable.type_spec.add(ctx.children.get(1).getText());
        }
        else{
            currentTable.var.put(ctx.children.get(0).getText(), currentTable.offset);
            currentTable.type_spec.add(ctx.children.get(3).getText());
        }
    }

    @Override
    public void exitParam(MiniGoParser.ParamContext ctx) {
        String temp = "";
        temp += space11 + "sym " + currentTable.blockLevel + " "  + currentTable.var.get(ctx.IDENT().getText()) + " ";
        temp += "1" + lineChange;
        newTexts.put(ctx, temp);
    }

    @Override
    public void enterStmt(MiniGoParser.StmtContext ctx) {
        super.enterStmt(ctx);
    }

    @Override
    public void exitStmt(MiniGoParser.StmtContext ctx) {
        newTexts.put(ctx, newTexts.get(ctx.children.get(0)));
    }

    @Override
    public void enterExpr_stmt(MiniGoParser.Expr_stmtContext ctx) {
        super.enterExpr_stmt(ctx);
    }

    @Override
    public void exitExpr_stmt(MiniGoParser.Expr_stmtContext ctx) {
        newTexts.put(ctx, newTexts.get(ctx.children.get(0)));
    }

    @Override
    public void enterAssign_stmt(MiniGoParser.Assign_stmtContext ctx) {
        if(ctx.children.size() == 9){
            currentTable.var.put(ctx.IDENT().get(0).getText(), currentTable.offset);
            currentTable.funcVarArg.add(ctx.IDENT().get(0).getText());
            currentTable.offset++;
            currentTable.var.put(ctx.IDENT().get(1).getText(), currentTable.offset);
            currentTable.funcVarArg.add(ctx.IDENT().get(1).getText());
            currentTable.offset++;
        }
        else if (ctx.children.size() == 5){
            currentTable.var.put(ctx.IDENT().get(0).getText(), currentTable.offset);
            currentTable.funcVarArg.add(ctx.IDENT().get(0).getText());
            currentTable.type_spec.add(ctx.IDENT().get(0).getText());
            currentTable.offset++;
        }
        else if(ctx.children.size() == 4){

        }
        else{

        }
    }

    @Override
    public void exitAssign_stmt(MiniGoParser.Assign_stmtContext ctx) {
        String temp = "";
        if(ctx.children.size() == 9){
            temp += space11 + "sym " + currentTable.blockLevel + " ";
            temp += currentTable.var.get(ctx.IDENT(0)) + " " + "1" + lineChange;
            temp += space11 + "ldc " + ctx.LITERAL(0) + lineChange;
            temp += space11 + "str " + currentTable.blockLevel + " " + currentTable.var.get(ctx.IDENT(0)) + lineChange;

            temp += space11 + "sym " + currentTable.blockLevel + " ";
            temp += currentTable.var.get(ctx.IDENT(1)) + " " + "1" + lineChange;
            temp += space11 + "ldc " + ctx.LITERAL(1) + lineChange;
            temp += space11 + "str " + currentTable.blockLevel + " " + currentTable.var.get(ctx.IDENT(1)) + lineChange;

        }
        else if (ctx.children.size() == 5){
            temp += space11 + "sym " + currentTable.blockLevel + " ";
            temp += currentTable.var.get(ctx.IDENT(0)) + " " + "1" + lineChange;
            temp += space11 + "lod ";
            temp += currentTable.blockLevel + " " + currentTable.var.get(newTexts.get(ctx.expr(0))) + lineChange;
            temp += space11 + "str " + currentTable.blockLevel + " " + currentTable.var.get(ctx.IDENT(0)) + lineChange;
        }
        else if(ctx.children.size() == 4){
            symbolTable thisTable = currentTable;
            if(thisTable.var.get(ctx.IDENT(0).getText()) == null) {
                thisTable = currentTable.recursivefindTable(ctx.IDENT(0).getText());
                temp += space11 + "lod ";
                temp += thisTable.blockLevel + " ";
                temp += thisTable.var.get(ctx.IDENT(0).getText()) + lineChange;
            }
            temp += space11 + "lod ";
            temp += currentTable.blockLevel + " " + currentTable.var.get(newTexts.get(ctx.expr(0))) + lineChange;
            temp += space11 + "str " + thisTable.blockLevel + " " + thisTable.var.get(ctx.IDENT(0)) + lineChange;
        }
        else{
            symbolTable thisTable = currentTable.recursivefindTable(ctx.IDENT(0).getText());
            temp += space11 + "ldc " + newTexts.get(ctx.expr(0));
            temp += space11 + "lda ";
            temp += thisTable.blockLevel + " ";
            temp += thisTable.var.get(ctx.IDENT(0).getText()) + lineChange;
            temp += space11 + "add" + lineChange;
            temp += space11 + "lod ";
            temp += currentTable.blockLevel + " " + currentTable.var.get(newTexts.get(ctx.expr(0))) + lineChange;
            temp += space11 + "sti " + thisTable.blockLevel + " " + thisTable.var.get(ctx.IDENT(0)) + lineChange;
        }
        newTexts.put(ctx, temp);
    }

    @Override
    public void enterCompound_stmt(MiniGoParser.Compound_stmtContext ctx) {

    }

    @Override
    public void exitCompound_stmt(MiniGoParser.Compound_stmtContext ctx) {
        String temp = "";
        for(int i=0; i<ctx.local_decl().size(); i++){
            temp += newTexts.get(ctx.local_decl(i));
        }

        for (int i=0; i<ctx.stmt().size(); i++){
            temp += newTexts.get(ctx.stmt(i));
        }
        newTexts.put(ctx, temp);
    }

    @Override
    public void enterIf_stmt(MiniGoParser.If_stmtContext ctx) {
        String childText = IFForName();
        currentTable.setChild(childText);
        currentTable = currentTable.childTable.get(childText);
    }

    @Override
    public void exitIf_stmt(MiniGoParser.If_stmtContext ctx) {
        String temp = "";
        String tempBranch;
        if(ctx.children.size() == 3){
            tempBranch = BranchName();
            temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
            temp += newTexts.get(ctx.expr());
            tempBranch = BranchName();
            temp += space11 + "fjp " + tempBranch + lineChange;
            temp += newTexts.get(ctx.compound_stmt(0));
            temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
        }
        else{
            tempBranch = BranchName();
            temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
            temp += newTexts.get(ctx.expr());
            tempBranch = BranchName();
            temp += space11 + "fjp " + tempBranch + lineChange;
            temp += newTexts.get(ctx.compound_stmt(0));
            temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
            temp += newTexts.get(ctx.compound_stmt(1));
        }
        newTexts.put(ctx, temp);
        currentTable = currentTable.parent;
    }

    @Override
    public void enterFor_stmt(MiniGoParser.For_stmtContext ctx) {
        String childText = IFForName();
        currentTable.setChild(childText);
        currentTable = currentTable.childTable.get(childText);
    }

    @Override
    public void exitFor_stmt(MiniGoParser.For_stmtContext ctx) {
        String temp = "";
        String tempBranch1, tempBranch2;
        tempBranch1 = BranchName();
        temp += tempBranch1 + space(String.valueOf(tempBranch1)) + "nop" + lineChange;
        temp += newTexts.get(ctx.expr());
        tempBranch2 = BranchName();
        temp += space11 + "fjp " + tempBranch2 + lineChange;
        temp += newTexts.get(ctx.compound_stmt());
        temp += space11 + "ujp "  + tempBranch1 + lineChange;
        temp += tempBranch2 + space(String.valueOf(tempBranch2)) + "nop" + lineChange;
        newTexts.put(ctx,temp);
        currentTable = currentTable.parent;
    }

    @Override
    public void enterReturn_stmt(MiniGoParser.Return_stmtContext ctx) {
        super.enterReturn_stmt(ctx);
    }

    @Override
    public void exitReturn_stmt(MiniGoParser.Return_stmtContext ctx) {
        String temp = "";
        if(ctx.children.size() == 4){
            temp += newTexts.get(ctx.expr(0));
            temp += space11 + "retv" + lineChange;
            temp += newTexts.get(ctx.expr(1));
            temp += space11 + "retv" + lineChange;
        }
        else if(ctx.children.size() == 2){
            temp += newTexts.get(ctx.expr(0));
            temp += space11 + "retv" + lineChange;
        }
        else{
            temp += space11 + "ret" + lineChange;
        }
        newTexts.put(ctx, temp);
    }

    @Override
    public void enterLocal_decl(MiniGoParser.Local_declContext ctx) {
        if(ctx.children.size() == 3){
            currentTable.var.put(ctx.children.get(1).getText(), currentTable.offset + 1);
            currentTable.funcVarArg.add(ctx.children.get(0).getText());
            currentTable.varSize.put(ctx.children.get(1).getText() , 1);
            currentTable.offset++;
        }
        else{
            currentTable.var.put(ctx.children.get(1).getText(), currentTable.offset + 1);
            currentTable.funcVarArg.add(ctx.children.get(0).getText());
            currentTable.type_spec.add(ctx.children.get(5).getText() + ctx.children.get(3).getText());
            currentTable.varSize.put(ctx.children.get(1).getText(), Integer.parseInt(ctx.LITERAL().getText()));
            int temp = Integer.parseInt(ctx.LITERAL().getText());
            currentTable.offset += temp;
        }
    }

    @Override
    public void exitLocal_decl(MiniGoParser.Local_declContext ctx) {
        String temp = "";
        String ident;
        if(ctx.children.size() == 3) {
            temp += space11 + "sym ";
            temp += currentTable.blockLevel + " ";
            temp += currentTable.offset + " ";
            temp += "1 " + lineChange;
        }
        else{
            ident = ctx.IDENT().getText();

            temp += space11 + "sym ";
            temp += currentTable.blockLevel + " ";
            temp += currentTable.var.get(ident) + " ";
            temp += currentTable.varSize.get(ident) + lineChange;
        }
        newTexts.put(ctx, temp);
    }

    @Override
    public void enterExpr(MiniGoParser.ExprContext ctx) {
        super.enterExpr(ctx);
    }

    @Override
    public void enterArgs(MiniGoParser.ArgsContext ctx) {
        super.enterArgs(ctx);
    }

    @Override
    public void exitArgs(MiniGoParser.ArgsContext ctx) {
        String temp = "";
        for(int i=0; i<ctx.expr().size(); i++){
            temp += space11 + "lod " + currentTable.recursivefindTable(ctx.expr(i).getText()).blockLevel +" ";
            temp += currentTable.recursivefindTable(ctx.expr(i).getText()).var.get(ctx.expr(i).getText()) + lineChange;
        }
        newTexts.put(ctx, temp);
    }

    @Override
    public void enterEveryRule(ParserRuleContext ctx) {
        super.enterEveryRule(ctx);
    }

    @Override
    public void exitEveryRule(ParserRuleContext ctx) {
        super.exitEveryRule(ctx);
    }

    public String space(String title){
        int spaceSize = 11 - title.length();
        String finalSpace = "";
        for(int i=0; i<spaceSize; i++){
            finalSpace += " ";
        }
        return finalSpace;
    }
}
