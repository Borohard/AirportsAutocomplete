package org.example.util;

public class ConfigLoader {

    public int getUserColumn(String[] args){

        if (args.length == 1) {
            int inputNumberColumn = Integer.parseInt(args[0]);
            if (inputNumberColumn > 0 && inputNumberColumn < 14){
                return inputNumberColumn;
            }
        }
        return 1;
    }


}
