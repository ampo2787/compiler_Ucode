import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;
import org.antlr.v4.runtime.tree.TerminalNode;

public class UcodeGenListener  extends MiniGoBaseListener {
    final String space11 = "           ";
    final String lineChange = "\n";
    private int BranchName = -1;
    private int IfForName = 0;

    ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();
    symbolTable globalSymtab = new symbolTable();
    symbolTable currentTable = globalSymtab;

    public int getBranchName(){
        BranchName++;
        return BranchName;
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
            if(ctx.children.size() == 0){
                newTexts.put(ctx,"");
            }
            else{
                newTexts.put(ctx, ctx.children.get(0).getText());
            }
        }
        else if(isSmallCompoundOperation(ctx)){
            newTexts.put(ctx, newTexts.get(ctx.expr(0)));
        }
        else if(isBigCompoundOperation(ctx)){

        }
        else if(isSmallCompoundArgsOperation(ctx)){

        }
        else if(isFMTOperation(ctx)){

        }
        else if(isBinarySingleOperation(ctx)){
            String temp = ctx.op.getText();
            if(temp.equals("-") || temp.equals("+")){
                s1 += space11 + "lod ";
                s1 += currentTable.offset + " ";
                s1 += currentTable.recursivefindTable(newTexts.get(ctx.expr(0))).var.get(newTexts.get(ctx.expr(0))) + lineChange;
                s1 += space11 + "neg";
                newTexts.put(ctx, s1);
            }
            else if(temp.equals("--")){
                s1 += space11 + "lod ";
                s1 += currentTable.offset + " ";
                s1 += currentTable.recursivefindTable(newTexts.get(ctx.expr(0))).var.get(newTexts.get(ctx.expr(0))) + lineChange;
                s1 += space11 + "dec" +lineChange;
                newTexts.put(ctx, s1);
            }
            else if(temp.equals("++")){
                s1 += space11 + "lod ";
                s1 += currentTable.offset + " ";
                s1 += currentTable.recursivefindTable(newTexts.get(ctx.expr(0))).var.get(newTexts.get(ctx.expr(0))) + lineChange;
                s1 += space11 + "inc" +lineChange;
                newTexts.put(ctx, s1);
            }
            else{ //!
                s1 += space11 + "lod ";
                s1 += currentTable.offset + " ";
                s1 += currentTable.recursivefindTable(newTexts.get(ctx.expr(0))).var.get(newTexts.get(ctx.expr(0))) + lineChange;
                s1 += space11 + "notop" +lineChange;
                newTexts.put(ctx, s1);
            }
        }
        else if(isBinaryOperation(ctx)){
            String temp = ctx.op.getText();
            s1 += space11 + "lod ";
            s1 += currentTable.blockLevel + " " + currentTable.recursivefindTable(newTexts.get(ctx.left)).var.get(newTexts.get(ctx.left)) + lineChange;
            s1 += space11 + "lod ";
            s1 += currentTable.blockLevel + " " + currentTable.recursivefindTable(newTexts.get(ctx.left)).var.get(newTexts.get(ctx.right)) + lineChange;
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
            s1 += space11 + "lod ";
            s1 += currentTable.blockLevel + " " + currentTable.recursivefindTable(ctx.IDENT().getText()).var.get(ctx.IDENT().getText()) + lineChange;
            s1 += space11 + "lod ";
            s1 += currentTable.blockLevel + " " + currentTable.recursivefindTable(newTexts.get(ctx.expr(0))).var.get(newTexts.get(ctx.expr(0))) + lineChange;
            s1 += space11 + "str " + currentTable.blockLevel + " " + currentTable.recursivefindTable(ctx.IDENT().getText()).var.get(ctx.IDENT().getText());
            s1 += lineChange;
            newTexts.put(ctx, s1);
        }
        else{
            s1 += space11 + "ldc " + newTexts.get(ctx.expr(0)) + lineChange;
            s1 += space11 + "lda ";
            s1 += currentTable.blockLevel + " " + currentTable.recursivefindTable(ctx.IDENT().getText()).var.get(ctx.IDENT().getText()) + lineChange;
            s1 += space11 + "add" + lineChange;
            s1 += space11 + "lod ";
            s1 += currentTable.blockLevel + " " + currentTable.recursivefindTable(newTexts.get(ctx.expr(1))).var.get(newTexts.get(ctx.expr(1))) + lineChange;
            s1 += space11 + "str " + currentTable.blockLevel + " " + currentTable.recursivefindTable(ctx.IDENT().getText()).var.get(ctx.IDENT().getText());
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
        newTexts.put(ctx, temp);
        System.out.print(temp);
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
        temp += "2 " +lineChange;

        for(int i=0; i<ctx.children.size(); i++){
            temp += newTexts.get(ctx.getChild(i));
        }
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
            temp += newTexts.get(ctx.getChild(i));
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
        super.exitParam(ctx);
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

        }
        else if(ctx.children.size() == 4){

        }
        else{

        }
    }

    @Override
    public void exitAssign_stmt(MiniGoParser.Assign_stmtContext ctx) {
        if(ctx.children.size() == 9){

        }
        else if (ctx.children.size() == 5){

        }
        else if(ctx.children.size() == 4){

        }
        else{

        }
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
        String childText = String.valueOf(IfForName++);
        currentTable.setChild(childText);
        currentTable = currentTable.childTable.get(childText);
    }

    @Override
    public void exitIf_stmt(MiniGoParser.If_stmtContext ctx) {
        String temp = "";
        int tempBranch;
        if(ctx.children.size() == 3){
            tempBranch = getBranchName();
            temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
            temp += newTexts.get(ctx.expr());
            tempBranch = getBranchName();
            temp += space11 + "fjp " + tempBranch + lineChange;
            temp += newTexts.get(ctx.compound_stmt(0));
            temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
        }
        else{
            tempBranch = getBranchName();
            temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
            temp += newTexts.get(ctx.expr());
            tempBranch = getBranchName();
            temp += space11 + "fjp " + tempBranch + lineChange;
            temp += newTexts.get(ctx.compound_stmt(0));
            temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
            temp += newTexts.get(ctx.compound_stmt(1));
        }
        //System.out.print(temp);
        newTexts.put(ctx, temp);
        currentTable = currentTable.parent;
    }

    @Override
    public void enterFor_stmt(MiniGoParser.For_stmtContext ctx) {
        String childText = String.valueOf(IfForName++);
        currentTable.setChild(childText);
        currentTable = currentTable.childTable.get(childText);
    }

    @Override
    public void exitFor_stmt(MiniGoParser.For_stmtContext ctx) {
        String temp = "";
        int tempBranch1, tempBranch2;
        tempBranch1 = getBranchName();
        temp += tempBranch1 + space(String.valueOf(tempBranch1)) + "nop" + lineChange;
        temp += newTexts.get(ctx.expr());
        tempBranch2 = getBranchName();
        temp += space11 + "fjp " + tempBranch2 + lineChange;
        temp += newTexts.get(ctx.compound_stmt());
        temp += space11 + "ujp"  + tempBranch1 + lineChange;
        temp += tempBranch2 + space(String.valueOf(tempBranch2)) + "nop" + lineChange;


        newTexts.put(ctx,temp);
    }

    @Override
    public void enterReturn_stmt(MiniGoParser.Return_stmtContext ctx) {
        super.enterReturn_stmt(ctx);
    }

    @Override
    public void exitReturn_stmt(MiniGoParser.Return_stmtContext ctx) {
        String temp = "";
        if(ctx.children.size() == 4){
            temp += space11 + "ldi" + newTexts.get(ctx.expr(0)) + lineChange;
            temp += space11 + "retv" + lineChange;
            temp += space11 + "ldi" + newTexts.get(ctx.expr(1)) + lineChange;
            temp += space11 + "retv" + lineChange;
        }
        else if(ctx.children.size() == 2){
            temp += space11 + "ldi" + newTexts.get(ctx.expr(0)) + lineChange;
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
            currentTable.varSize.put(ctx.children.get(1).getText() ,1);
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
        super.exitArgs(ctx);
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
