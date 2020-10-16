package commands.commandClasses;

import commands.CommandWorksWithColl;
import commands.Command;
import commands.WrongArgumentException;
import dragons.DragonCollectionManager;

import java.io.Serializable;

public class RemoveKeyCommand implements Command, CommandWorksWithColl, Serializable {
    private String[] arr;

    public RemoveKeyCommand(String[] arr){
        this.arr = arr;
    }


    @Override
    public String execute(DragonCollectionManager coll)  {
        if(arr.length > 2){
            return "У данной команды один агрумент.";
        }
        if(coll.checkKey(arr[1])){
            coll.deleteDragon(arr[1]);
            return "Элемент успешно удалён.";
        }
        else {
            return "Элемент с данным ключом отсутствует.";
        }
    }

    @Override
    public String getName() {
        return "remove_key";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 2;
    }

}
