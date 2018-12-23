import org.antlr.v4.runtime.tree.ParseTreeProperty;

public class UcodeGenListener  extends MiniGoBaseListener {
    final String space11 = "           ";
    final String lineChange = "\n";
    private int BranchName = 0;
    private int ForName = 0;

    private int ifPointer = 0;
    private int elsePointer = 0;
    private int SwitchPointer = 0;

    ParseTreeProperty<String> newTexts = new ParseTreeProperty<String>();
    symbolTable globalSymtab = new symbolTable();
    symbolTable currentTable = globalSymtab;

    private String ForName(){
        return "For" + ForName++;
    }
    private String BranchName(){
        return "$$" + BranchName++;
    }
    private String getIfPointer(){
        return "IF" + ifPointer++;
    }
    private String getElsePointer(){
        return "ELSE" + elsePointer++;
    }
    private String getSwitchPorinter() { return "Switch" + SwitchPointer++; }

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

    @Override
    public void exitExpr(MiniGoParser.ExprContext ctx){
        String s1 = "";
        if(isNormalOperation(ctx)){
            if(ctx.LITERAL().size() != 0){
                s1 += space11 + "ldc " + ctx.LITERAL(0).getText() + lineChange;
                newTexts.put(ctx, s1);
            }
            else{
                if(ctx.IDENT().getText().equals("")){

                }
                else {
                    if(currentTable.recursivefindTable(ctx.IDENT().getText()).varSize.get(ctx.IDENT().getText()) == 1) {
                        s1 += space11 + "lod " + currentTable.recursivefindTable(ctx.IDENT().getText()).blockLevel + " ";
                    }else{
                        s1 += space11 + "lda " + currentTable.recursivefindTable(ctx.IDENT().getText()).blockLevel + " ";
                    }
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
            if (currentTable.ArgList.contains(ctx.IDENT().getText())) {
                s1 += space11 + "lod " + currentTable.blockLevel + " ";
            }else {
                s1 += space11 + "lda " + currentTable.blockLevel + " ";
            }
            s1 += currentTable.var.get(ctx.IDENT().getText()) + lineChange;
            s1 += space11 + "add" +lineChange;
            s1 += space11 + "ldi" +lineChange;

            newTexts.put(ctx, s1);
        }
        else if(isSmallCompoundArgsOperation(ctx)){
            s1 += space11 + "ldp" +lineChange; //args에서
            s1 += newTexts.get(ctx.args());
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

        }else if(ctx.children.size() == 3 && ctx.LITERAL().size() == 2){ //LITERAL, LITERAL
            s1 += space11 + "ldc " + ctx.LITERAL(0).getText() + lineChange;
            s1 += space11 + "ldc " + ctx.LITERAL(1).getText() + lineChange;
            newTexts.put(ctx, s1);
        }
        else if(isEqualOperation(ctx)){
            symbolTable thisTable = currentTable;
            if(!thisTable.var.containsKey(ctx.IDENT().getText())){
                thisTable = thisTable.recursivefindTable(ctx.IDENT().getText());
                s1 += space11 + "lod ";
                s1 += thisTable.blockLevel + " " + thisTable.var.get(ctx.IDENT().getText()) + lineChange;
            }
            s1 += newTexts.get(ctx.expr(0));
            s1 += space11 + "str " + thisTable.blockLevel + " " + thisTable.var.get(ctx.IDENT().getText());
            s1 += lineChange;
            newTexts.put(ctx, s1);
        }
        else{
            symbolTable thisTable = currentTable;
            if(!thisTable.var.containsKey(ctx.IDENT().getText())){
                thisTable = thisTable.recursivefindTable(ctx.IDENT().getText());
            }
            s1 += newTexts.get(ctx.expr(0));
            s1 += space11 + "lda ";
            s1 += thisTable.blockLevel + " " + thisTable.var.get(ctx.IDENT().getText()) + lineChange;
            s1 += space11 + "add" + lineChange;
            s1 += newTexts.get(ctx.expr(1));
            s1 += space11 + "sti";
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
        System.out.println(newTexts.get(ctx));
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
            currentTable.varSize.put(ctx.children.get(1).getText(), 1);
            currentTable.offset++;
        }
        else if(ctx.children.size() == 5){
            currentTable.var.put(ctx.children.get(1).getText(), currentTable.offset + 1);
            currentTable.type_spec.add(ctx.children.get(4).getText());
            currentTable.varSize.put(ctx.children.get(1).getText(), 1);
            currentTable.offset++;

            currentTable.var.put(ctx.children.get(3).getText(), currentTable.offset + 1);
            currentTable.type_spec.add(ctx.children.get(4).getText());
            currentTable.varSize.put(ctx.children.get(1).getText(), 1);
            currentTable.offset++;

        }
        else{
            currentTable.var.put(ctx.children.get(1).getText(), currentTable.offset + 1);
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
            temp += "1" + lineChange;
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
        temp += "2" + lineChange;
        temp += newTexts.get(ctx.params());
        temp += newTexts.get(ctx.compound_stmt());
        temp += space11 + "ret" + lineChange;
        temp += space11  + "end" + lineChange;
        newTexts.put(ctx, temp);
        currentTable = currentTable.parent;
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
        currentTable.var.put(ctx.children.get(0).getText(), currentTable.offset + 1);
        currentTable.varSize.put(ctx.children.get(0).getText(), 1);
        if(ctx.children.size() == 2){
            currentTable.type_spec.add(ctx.children.get(1).getText());
        }
        else{
            currentTable.type_spec.add(ctx.children.get(3).getText());
            currentTable.ArgList.add(ctx.children.get(0).getText());
        }
        currentTable.offset++;
    }

    @Override
    public void exitParam(MiniGoParser.ParamContext ctx) {
        String temp = "";
        temp += space11 + "sym " + currentTable.blockLevel + " "  + currentTable.var.get(ctx.IDENT().getText()) + " ";
        temp += "1" + lineChange;
        newTexts.put(ctx, temp);
    }


    @Override
    public void exitStmt(MiniGoParser.StmtContext ctx) {
        newTexts.put(ctx, newTexts.get(ctx.children.get(0)));
    }


    @Override
    public void exitExpr_stmt(MiniGoParser.Expr_stmtContext ctx) {
        newTexts.put(ctx, newTexts.get(ctx.children.get(0)));
    }

    @Override
    public void enterAssign_stmt(MiniGoParser.Assign_stmtContext ctx) {
        if(ctx.children.size() == 9){
            currentTable.var.put(ctx.IDENT().get(0).getText(), currentTable.offset + 1);
            currentTable.varSize.put(ctx.IDENT().get(0).getText(), 1);
            currentTable.offset++;
            currentTable.var.put(ctx.IDENT().get(1).getText(), currentTable.offset + 1);
            currentTable.varSize.put(ctx.IDENT().get(1).getText(), 1);
            currentTable.offset++;
        }
        else if (ctx.children.size() == 5){
            currentTable.var.put(ctx.IDENT().get(0).getText(), currentTable.offset + 1);
            currentTable.type_spec.add(ctx.IDENT().get(0).getText());
            currentTable.varSize.put(ctx.IDENT().get(0).getText(), 1);
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
            temp += currentTable.var.get(ctx.IDENT(0).getText()) + " " + "1" + lineChange;
            temp += space11 + "ldc " + ctx.LITERAL(0) + lineChange;
            temp += space11 + "str " + currentTable.blockLevel + " " + currentTable.var.get(ctx.IDENT(0).getText()) + lineChange;

            temp += space11 + "sym " + currentTable.blockLevel + " ";
            temp += currentTable.var.get(ctx.IDENT(1).getText()) + " " + "1" + lineChange;
            temp += space11 + "ldc " + ctx.LITERAL(1) + lineChange;
            temp += space11 + "str " + currentTable.blockLevel + " " + currentTable.var.get(ctx.IDENT(1).getText()) + lineChange;

        }
        else if (ctx.children.size() == 5){
            temp += space11 + "sym " + currentTable.blockLevel + " ";
            temp += currentTable.var.get(ctx.IDENT(0).getText()) + " " + "1" + lineChange;
            temp += newTexts.get(ctx.expr(0));
            temp += space11 + "str " + currentTable.blockLevel + " " + currentTable.var.get(ctx.IDENT(0).getText()) + lineChange;
        }
        else if(ctx.children.size() == 4){
            symbolTable thisTable = currentTable;
            if(thisTable.var.get(ctx.IDENT(0).getText()) == null) {
                thisTable = currentTable.recursivefindTable(ctx.IDENT(0).getText());
                temp += space11 + "lod ";
                temp += thisTable.blockLevel + " ";
                temp += thisTable.var.get(ctx.IDENT(0).getText()) + lineChange;
            }
            temp += newTexts.get(ctx.expr(0));
            temp += space11 + "str " + thisTable.blockLevel + " " + thisTable.var.get(ctx.IDENT(0).getText()) + lineChange;
        }
        else{
            symbolTable thisTable = currentTable.recursivefindTable(ctx.IDENT(0).getText());
            temp += newTexts.get(ctx.expr(0));
            temp += space11 + "lda ";
            temp += thisTable.blockLevel + " ";
            temp += thisTable.var.get(ctx.IDENT(0).getText()) + lineChange;
            temp += space11 + "add" + lineChange;
            temp += newTexts.get(ctx.expr(0));
            temp += space11 + "sti";
        }
        newTexts.put(ctx, temp);
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
        String childText;
        if(ctx.expr().size() == 1){ //if만 존재
            childText = getIfPointer();
            currentTable.setChild(childText);
            currentTable = currentTable.childTable.get(childText);
        }
        else if(ctx.expr().size() != ctx.compound_stmt().size() && ctx.compound_stmt().size() == 1) { //else 존재.
            childText = getIfPointer();
            currentTable.setChild(childText);
            currentTable = currentTable.childTable.get(childText);
            childText = getElsePointer();
            currentTable.setChild(childText);
            currentTable = currentTable.childTable.get(childText);
        }
        else {childText = getIfPointer();
            currentTable.setChild(childText);
            currentTable = currentTable.childTable.get(childText);
            for(int i=0; i< ctx.expr().size() - 1; i++){
                childText = getElsePointer();
                currentTable.setChild(childText);
                currentTable = currentTable.childTable.get(childText);
            }
        }
    }

    @Override
    public void exitIf_stmt(MiniGoParser.If_stmtContext ctx) {
        String temp = "";
        String ENDIF = "endIF";
        String tempBranch, tempBranch1;
            if(ctx.expr().size() == 1){
                temp += newTexts.get(ctx.expr(0));
                tempBranch = BranchName();
                temp += space11 + "fjp " + tempBranch + lineChange;
                temp += newTexts.get(ctx.compound_stmt(0));
                temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
            }
            else if(ctx.expr().size() != ctx.compound_stmt().size() && ctx.compound_stmt().size() == 1) { //else 존재.
                temp += newTexts.get(ctx.expr(0));
                tempBranch = BranchName();
                temp += space11 + "fjp " + tempBranch + lineChange;
                temp += newTexts.get(ctx.compound_stmt(0));
                tempBranch1 = BranchName();
                temp += space11 + "ujp " + tempBranch1 + lineChange;
                temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
                temp += newTexts.get(ctx.compound_stmt(1));
                temp += tempBranch1 + space(String.valueOf(tempBranch)) + "nop" + lineChange;

            }
            /*else if(ctx.expr().size() == ctx.compound_stmt().size()) { // if와 else if 만 존재.
                for (int i = 0; i < ctx.expr().size() - 1; i++) {
                    temp += newTexts.get(ctx.expr(i));
                    tempBranch = BranchName();
                    temp += space11 + "fjp " + tempBranch + lineChange;
                    temp += newTexts.get(ctx.compound_stmt(i));
                    temp += space11 + "ujp " + ENDIF + lineChange;
                    temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
                }
                temp += ENDIF + space(String.valueOf(ENDIF)) + "nop" + lineChange;
            }*/
            else{ //if, else if, else.
                for (int i = 0; i < ctx.expr().size() - 1; i++) {
                    temp += newTexts.get(ctx.expr(i));
                    tempBranch = BranchName();
                    temp += space11 + "fjp " + tempBranch + lineChange;
                    temp += newTexts.get(ctx.compound_stmt(i));
                    temp += space11 + "ujp " + ENDIF + lineChange;
                    temp += tempBranch + space(String.valueOf(tempBranch)) + "nop" + lineChange;
                }

                if(ctx.expr().size() == ctx.compound_stmt().size()) { //else 없음.
                    temp += newTexts.get(ctx.expr(ctx.expr().size() - 1));
                    temp += space11 + "fjp " + ENDIF + lineChange;
                    temp += newTexts.get(ctx.compound_stmt(ctx.compound_stmt().size() - 1));
                    temp += ENDIF + space(String.valueOf(ENDIF)) + "nop" + lineChange;
                }
                else{ //else 있음.
                    temp += newTexts.get(ctx.expr(ctx.expr().size() - 1));
                    temp += space11 + "fjp " + ENDIF + lineChange;
                    temp += newTexts.get(ctx.compound_stmt(ctx.compound_stmt().size() - 1));
                    temp += ENDIF + space(String.valueOf(ENDIF)) + "nop" + lineChange;
                }
            }
            newTexts.put(ctx, temp);
            currentTable = currentTable.parent;
    }

    @Override
    public void enterFor_stmt(MiniGoParser.For_stmtContext ctx) {
        String childText = ForName();
        currentTable.setChild(childText);
        currentTable = currentTable.childTable.get(childText);
    }

    @Override
    public void exitFor_stmt(MiniGoParser.For_stmtContext ctx) {
        String temp = "";
        String tempBranch1, tempBranch2;
        tempBranch1 = BranchName();

        if(ctx.children.size() != 3) {
            temp += newTexts.get(ctx.expr(0));
        }
        temp += tempBranch1 + space(String.valueOf(tempBranch1)) + "nop" + lineChange;

        if(ctx.children.size() == 3) {
            temp += newTexts.get(ctx.expr(0));
        }
        else{
            temp += newTexts.get(ctx.expr(1));
        }

        tempBranch2 = BranchName();
        temp += space11 + "fjp " + tempBranch2 + lineChange;
        temp += newTexts.get(ctx.compound_stmt());

        if(ctx.children.size() != 3){
            temp += newTexts.get(ctx.expr(2));
            temp += space11 + "inc" +lineChange;
        }

        temp += space11 + "ujp " + tempBranch1 + lineChange;
        temp += tempBranch2 + space(String.valueOf(tempBranch2)) + "nop" + lineChange;
        newTexts.put(ctx, temp);
        currentTable = currentTable.parent;
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
            currentTable.varSize.put(ctx.children.get(1).getText() , 1);
            currentTable.offset++;
        }
        else{
            currentTable.var.put(ctx.children.get(1).getText(), currentTable.offset + 1);
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
            temp += "1" + lineChange;
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
    public void exitArgs(MiniGoParser.ArgsContext ctx) {
        String temp = "";
        for(int i=0; i<ctx.expr().size(); i++){
            temp += newTexts.get(ctx.expr(i));
        }
        newTexts.put(ctx, temp);
    }


    @Override
    public void enterSwitch_stmt(MiniGoParser.Switch_stmtContext ctx) {

    }

    @Override
    public void exitSwitch_stmt(MiniGoParser.Switch_stmtContext ctx) {
        String ENDSWITCH = "EndSwitch";
        String temp = "";
        String lodThis = space11 + "lod " + currentTable.recursivefindTable(ctx.IDENT().getText()).var.get(ctx.IDENT().getText());
        lodThis += " 1" + lineChange;
        String thisSwitchPointer;
        for(int i=0; i < ctx.CASE().size() - 1; i++){
            thisSwitchPointer = getSwitchPorinter();
            temp += lodThis;
            temp += space11 + "ldc " + ctx.LITERAL(i) + lineChange;
            temp += space11 + "eq" + lineChange;
            temp += space11 + "fjp " + thisSwitchPointer + lineChange;
            temp += newTexts.get(ctx.stmt(i));
            temp += thisSwitchPointer + space(thisSwitchPointer) + "nop" +lineChange;
        }

        temp += lodThis;
        temp += space11 + "ldc " + ctx.LITERAL(ctx.CASE().size() - 1) + lineChange;
        temp += space11 + "eq" + lineChange;
        temp += space11 + "fjp " + ENDSWITCH + lineChange;
        temp += newTexts.get(ctx.stmt(ctx.stmt().size() - 2));
        if(ctx.DEFAULT() != null){
            temp += ENDSWITCH + space(ENDSWITCH) + "nop" + lineChange;
            temp += newTexts.get(ctx.stmt(ctx.stmt().size() - 1));
        }
        else{
            temp += ENDSWITCH + space(ENDSWITCH) + "nop" + lineChange;
        }
        newTexts.put(ctx, temp);
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
