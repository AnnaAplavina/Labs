package commands.commandClasses;

import commands.CommandWorksWithColl;
import commands.CommandWorksWithDragon;
import commands.Command;
import commands.WrongArgumentException;
import dragons.Dragon;
import dragons.DragonCollectionManager;

import java.io.Serializable;

public class ReplaceIfLowerCommand implements Command, CommandWorksWithColl, CommandWorksWithDragon, Serializable {
    private String[] arr;
    private Dragon dragon;

    public ReplaceIfLowerCommand(String[] arr){
        this.arr = arr;
    }

    @Override
    public String execute(DragonCollectionManager coll)  {
        if(arr.length != 2){
            return "У данной команды один аргумент.";
        }
        if(!coll.checkKey(arr[1])){
            return "Элемент с данным ключом отсутствует в коллекции.";
        }
        if(dragon.compareTo(coll.getDragon(arr[1])) < 0){
            coll.addDragon(arr[1], dragon);
            return "Объект успешно заменён.";}
        else {
            return "Новое значение больше старого.";
        }
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
        return "replace_if_lower";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 2;
    }
}
