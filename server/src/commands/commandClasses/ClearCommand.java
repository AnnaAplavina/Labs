package commands.commandClasses;

import commands.CommandWorksWithColl;
import commands.Command;
import dragons.DragonCollectionManager;

import java.io.Serializable;

public class ClearCommand implements Command, CommandWorksWithColl, Serializable {

    private String[] arr;

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 1;
    }

    public ClearCommand(String[] arr){
        this.arr = arr;
    }


    @Override
    public String execute(DragonCollectionManager coll) {
        if(arr.length > 1){
            return "У данной команды нет аргументов.";
        }
        coll.clearCollection();
        return "Коллекция успешно очищена";
    }
}
