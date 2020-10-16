package commands.commandClasses;

import commands.*;
import dragons.Dragon;
import dragons.DragonCollectionManager;

import java.io.Serializable;
import java.util.Map;

public class UpdateCommand implements Command, CommandWorksWithDragon, CommandWorksWithColl, Serializable {
    private String[] arr;
    private Dragon dragon;


    public UpdateCommand(String[] arr){
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
        return "update";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 2;
    }

    @Override
    public String execute(DragonCollectionManager coll) throws WrongArgumentException {
        if(arr.length!=2){
            return "У данной команды один аргумент.";
        }
        Map.Entry<String, Dragon> pair = coll.getCollElementById(arr[1]);
        if(pair == null){
            return "Элемента коллекции с таким id не существует.";
        }
        coll.addDragon(pair.getKey(), dragon);
        return "Элемент коллекции успешно заменён.";
    }
}
