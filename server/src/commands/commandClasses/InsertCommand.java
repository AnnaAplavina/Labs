package commands.commandClasses;

import commands.CommandWorksWithColl;
import commands.CommandWorksWithDragon;
import commands.Command;
import commands.WrongArgumentException;
import dragons.Dragon;
import dragons.DragonCollectionManager;

import java.io.Serializable;

public class InsertCommand implements Command, CommandWorksWithDragon, CommandWorksWithColl, Serializable {
    private Dragon dragon;
    private String[] arr;

    public InsertCommand(String[] arr){
        this.arr = arr;
    }

    @Override
    public void setDragon(Dragon dragon) {
        this.dragon = dragon;
    }

    @Override
    public Dragon getDragon() {
        return dragon;
    }


    @Override
    public String getName() {
        return "insert";
    }

    @Override
    public boolean checkArguments() {
        return false;
    }

    @Override
    public String execute(DragonCollectionManager coll) {
        if(arr.length != 2){
            return "У данной команды один аргумент.";
        }
        if(coll.checkKey(arr[1])){
            return "Данный ключ уже занят.";
        }
        coll.addDragon(arr[1], dragon);
        return "Объект успешно добавлен в коллекцию.";
    }
}
