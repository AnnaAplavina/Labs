package commands.commandClasses;

import commands.CommandWorksWithCave;
import commands.CommandWorksWithColl;
import commands.Command;
import dragons.Dragon;
import dragons.DragonCave;
import dragons.DragonCollectionManager;

import java.io.Serializable;

public class CountGreaterThanCaveCommand implements Command, CommandWorksWithColl, CommandWorksWithCave, Serializable {
    private String[] arr;
    private DragonCave cave;

    public CountGreaterThanCaveCommand(String[] arr){
        this.arr = arr;
    }

    @Override
    public void setCave(DragonCave cave) {
        this.cave = cave;
    }

    @Override
    public DragonCave getCave() {
        return cave;
    }

    @Override
    public String execute(DragonCollectionManager coll) {
        if(arr.length != 1){
            return "У данной команды нет аргументов.";
        }
        int result = 0;
        for(Dragon dragon: coll.getEntrySet()){
            if(dragon.getCave() != null && dragon.getCave().compareTo(cave) > 0){
                result+=1;
            }
        }
        return "Количество элементов, поле cave которых больше заданного: " + result;
    }

    @Override
    public String getName() {
        return "count_greater_than_cave";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 1;
    }
}
