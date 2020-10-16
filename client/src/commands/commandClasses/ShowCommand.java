package commands.commandClasses;

import commands.*;
import dragons.Dragon;
import dragons.DragonCollectionManager;

import java.io.Serializable;
import java.util.ArrayList;

public class ShowCommand implements Command, CommandReturnsCollection, CommandWorksWithColl, Serializable {
    private String[] arr;
    private ArrayList<Dragon> dragons = new ArrayList<>();

    public ShowCommand(String[] arr){
        this.arr = arr;
    }

    @Override
    public ArrayList<Dragon> getArrayList() {
        return dragons;
    }

    @Override
    public String execute(DragonCollectionManager coll) {
        if(arr.length>1){
            return "У данной команды отсутствуют аргументы.";
        }
        for(Dragon dragon: coll.getEntrySet()){
            dragons.add(dragon);
        }
        return "Содержимое коллекции:";
    }

    @Override
    public String getName() {
        return "show";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 1;
    }
}
