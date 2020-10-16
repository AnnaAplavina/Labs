package commands.commandClasses;

import commands.CommandWorksWithColl;
import commands.Command;
import commands.WrongArgumentException;
import dragons.DragonCollectionManager;

import java.io.Serializable;

public class InfoCommand implements Command, CommandWorksWithColl, Serializable {
    private String[] arr;

    public InfoCommand(String[] arr){
        this.arr = arr;
    }

    @Override
    public String execute(DragonCollectionManager coll) {
        if(arr.length!=1){
            return "У данной команды нет аргументов.";
        }
        return "Время создания: "+coll.getIniTime()+" Колличество элементов: "+ coll.getNumOfElements()+ " Тип: "+coll.getType();
    }

    @Override
    public String getName() {
        return "info";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 1;
    }
}
