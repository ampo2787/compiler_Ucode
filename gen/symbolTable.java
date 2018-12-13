import java.util.ArrayList;
import java.util.HashMap;

public class symbolTable {
    HashMap<String, Integer> var;
    ArrayList<String> type_spec;
    ArrayList<String> funcVarArg;
    ArrayList<String> arg;
    HashMap<String, Integer> varSize;
    int blockLevel;
    int offset;

    symbolTable parent;
    HashMap<String, symbolTable> childTable;

    public symbolTable(){
        var = new HashMap<>();
        type_spec = new ArrayList<>();
        funcVarArg = new ArrayList<>();
        varSize = new HashMap<>();
        childTable = new HashMap<>();
        arg = new ArrayList<>();
        this.parent = null;
        blockLevel = 1;
        offset = 0;
    }


    public void setChild(String s){
        symbolTable temp = new symbolTable();
        temp.blockLevel = this.blockLevel+1;
        temp.parent = this;
        childTable.put(s, temp);
    }

    public symbolTable recursivefindTable(String s){
        if(var.containsKey(s)){
            return this;
        }
        if(parent == null){
            return null;
        }

        symbolTable tempTable;
        if(parent != null) {
            if((tempTable = findparent(s)) == null){

            }
            else{
                return tempTable;
            }
        }
        return null;

    }

    public symbolTable findparent(String s) {
        if(parent == null){
            return null;
        }
        else if(parent.var.containsKey(s)){
            return parent;
        }
        else{
            return parent.findparent(s);
        }
    }



}
