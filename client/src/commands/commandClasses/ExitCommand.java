package commands.commandClasses;

import commands.Command;

import java.io.Serializable;

public class ExitCommand implements Command, Serializable {
    String[] arr;

    public ExitCommand(String[] arr){
        this.arr = arr;
    }


    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 1;
    }
}
