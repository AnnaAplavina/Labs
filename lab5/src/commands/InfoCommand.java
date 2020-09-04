package commands;

import dragons.DragonCollectionManager;
/**
 * Класс отвечает за выполнение команды info
 */
public class InfoCommand implements Command {
    String[] arr;
    private DragonCollectionManager coll;
    /**
     * @param coll объект класса, отвечающего за управление коллекцией
     * @param arr ввод разделённый " ", в виде массива строк
     */
    public InfoCommand(DragonCollectionManager coll, String[] arr){
        this.arr = arr;
        this.coll = coll;
    }
    /**
     * Выполняет команду
     * @throws WrongArgumentException ошибка при неправильном вводе аргументов команды
     */
    @Override
    public void execute() throws WrongArgumentException{
        if(arr.length>1){
            throw new WrongArgumentException("У данной команды нет аргументов.");
        }
        System.out.println("Время создания: "+coll.getIniTime()+" Колличество элементов: "+ coll.getNumOfElements()+ " Тип: "+coll.getType());
    }
    /**
     *
     * @return название команды
     */
    @Override
    public String getName(){
        return "info";
    }
}
