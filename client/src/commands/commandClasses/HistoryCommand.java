package commands.commandClasses;

import commands.CommandWorksWithStringFromServer;
import commands.Command;
import commands.SimpleCommand;

import java.io.Serializable;

public class HistoryCommand implements Command, CommandWorksWithStringFromServer, SimpleCommand, Serializable {
    private String[] arr;
    private String history;

    public HistoryCommand(String[] arr){
        this.arr = arr;
    }


    @Override
    public void setServerString(String serverString) {
        history = serverString;
    }

    @Override
    public String getName() {
        return "history";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 1;
    }

    public void setHistory(String history){
        this.history = history;
    }

    @Override
    public String execute() {
        if (arr.length!=1){
            return "У данной команды нет аргументов.";
        }
        return history;
    }
}
