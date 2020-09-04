package commands;

import dragons.DragonCollectionManager;
/**
 * Класс отвечает за выполнение команды remove_lower_key
 */
public class RemoveLowerKeyCommand implements Command {
    private String[] arr;
    private DragonCollectionManager coll;
    /**
     * @param coll объект класса, отвечающего за управление коллекцией
     * @param arr ввод разделённый " ", в виде массива строк
     */
    public RemoveLowerKeyCommand(DragonCollectionManager coll, String[] arr){
        this.arr = arr;
        this.coll = coll;
    }
    /**
     * Выполняет команду
     * @throws WrongArgumentException ошибка при неправильном вводе аргументов команды
     */
    @Override
    public void execute() throws WrongArgumentException {
        if(arr.length != 2){
            throw new WrongArgumentException("У данной команды один аргумент.");
        }
        coll.removeLowerKey(arr[1]);
    }
    /**
     *
     * @return название команды
     */
    @Override
    public String getName() {
        return "remove_lower_key";
    }
}
