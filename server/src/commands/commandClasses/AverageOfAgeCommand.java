package commands.commandClasses;

import commands.CommandWorksWithColl;
import commands.Command;
import dragons.DragonCollectionManager;

import java.io.Serializable;

public class AverageOfAgeCommand implements Command, CommandWorksWithColl, Serializable {
    private String[] arr;

    public AverageOfAgeCommand(String[] arr){
        this.arr = arr;
    }


    @Override
    public String execute(DragonCollectionManager coll) {
        int result;
        if(arr.length != 1){
            return "У данной команды нет аргументов.";
        }
        result = coll.getAvaregreAge();
        if(result==-1){
            return "У всех объектов в коллекции значение поля age равно null.";
        }
        else if(result == -2){
            return "В коллекции отсутствуют эллементы.";
        }
        else {
            return "Среднее значение поля age: " + result;
        }
    }

    @Override
    public String getName() {
        return "average_of_age";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 1;
    }
}
