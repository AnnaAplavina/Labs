package commands.commandClasses;

import commands.CommandReturnsCollection;
import commands.CommandWorksWithColl;
import commands.Command;
import commands.WrongArgumentException;
import dragons.Dragon;
import dragons.DragonCollectionManager;
import dragons.DragonType;

import java.io.Serializable;
import java.util.ArrayList;

public class FilterLessThanTypeCommand implements Command, CommandWorksWithColl, CommandReturnsCollection, Serializable {
    private String[] arr;
    private ArrayList<Dragon> dragons = new ArrayList<>();

    public FilterLessThanTypeCommand(String[] arr){
        this.arr = arr;
    }

    @Override
    public String execute(DragonCollectionManager coll){
        String result = "";
        DragonType type;
        if(arr.length != 2){
            return "У данной команды один аргумент.";
        }
        if(arr[1].equalsIgnoreCase("water")){
            type = DragonType.WATER;
        }
        else if(arr[1].equalsIgnoreCase("underground")){
            type = DragonType.UNDERGROUND;
        }
        else if(arr[1].equalsIgnoreCase("fire")){
            type = DragonType.FIRE;
        }
        else if(arr[1].equalsIgnoreCase("air")){
            type = DragonType.AIR;
        }
        else{
            return "Значение типа дракона введено неверно.";
        }
        for(Dragon dragon: coll.getEntrySet()){
            if(dragon.getType().compareTo(type) < 0){
                result += dragon;
                dragons.add(dragon);
            }
        }
        return result;
    }

    @Override
    public String getName() {
        return "filter_less_than_type";
    }

    @Override
    public boolean checkArguments() {
        if(arr.length != 2){
            return false;
        }
        if(arr[1].equalsIgnoreCase("water") || arr[1].equalsIgnoreCase("underground") || arr[1].equalsIgnoreCase("fire") || arr[1].equalsIgnoreCase("air")){
            return true;
        }
        return false;
    }

    @Override
    public ArrayList<Dragon> getArrayList() {
        return dragons;
    }
}
