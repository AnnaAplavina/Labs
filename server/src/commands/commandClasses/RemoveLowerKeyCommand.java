package commands.commandClasses;

import commands.CommandWorksWithColl;
import commands.Command;
import commands.WrongArgumentException;
import dragons.DragonCollectionManager;

import java.io.Serializable;

public class RemoveLowerKeyCommand implements CommandWorksWithColl, Command, Serializable {
    private String[] arr;

    public RemoveLowerKeyCommand(String[] arr){
        this.arr = arr;
    }

    @Override
    public String execute(DragonCollectionManager coll) {
        if(arr.length != 2){
            return "У данной команды один аргумент.";
        }
        coll.removeLowerKey(arr[1]);
        return "Команда успешно выполнена.";
    }

    @Override
    public String getName() {
        return "remove_lower_key";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 2;
    }
}
