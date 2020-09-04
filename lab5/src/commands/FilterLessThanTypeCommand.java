package commands;

import dragons.Dragon;
import dragons.DragonCollectionManager;
import dragons.DragonType;
/**
 * Класс отвечает за выполнение команды filter_less_than_type
 */
public class FilterLessThanTypeCommand implements Command {
    private String[] arr;
    private DragonCollectionManager coll;

    /**
     * @param coll объект класса, отвечающего за управление коллекцией
     * @param arr ввод разделённый " ", в виде массива строк
     */
    public FilterLessThanTypeCommand(DragonCollectionManager coll, String[] arr){
        this.coll = coll;
        this.arr = arr;
    }
    /**
     * Выполняет команду
     * @throws WrongArgumentException ошибка при неправильном вводе аргументов команды
     */
    @Override
    public void execute() throws WrongArgumentException {
        DragonType type;
        if(arr.length != 2){
            throw new WrongArgumentException("У данной команды один аргумент.");
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
            throw new WrongArgumentException("Значение типа дракона введено неверно.");
        }
        for(Dragon dragon: coll.getEntrySet()){
            if(dragon.getType().compareTo(type) < 0){
                System.out.println(dragon);
            }
        }
    }
    /**
     *
     * @return название команды
     */
    @Override
    public String getName() {
        return "filter_less_tan_type";
    }
}
