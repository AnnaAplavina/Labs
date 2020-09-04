package commands;
import dragons.DragonCollectionManager;
/**
 * Класс отвечает за выполнение команды remove_key
 */
public class RemoveKeyCommand implements Command {

    String[] arr;
    DragonCollectionManager coll;
    /**
     * @param coll объект класса, отвечающего за управление коллекцией
     * @param arr ввод разделённый " ", в виде массива строк
     */
    public RemoveKeyCommand(DragonCollectionManager coll, String[] arr){
        this.arr = arr;
        this.coll = coll;
    }
    /**
     * Выполняет команду
     * @throws WrongArgumentException ошибка при неправильном вводе аргументов команды
     */
    @Override
    public void execute() throws WrongArgumentException {
        if(arr.length > 2){
            throw new WrongArgumentException("У данной команды один агрумент.");
        }
        if(coll.checkKey(arr[1])){
            coll.deleteDragon(arr[1]);
            System.out.println("Элемент успешно удалён.");
        }
        else {
            throw new WrongArgumentException("Элемент с данным ключом отсутствует.");
        }
    }
    /**
     *
     * @return название команды
     */
    @Override
    public String getName() {
        return "remove_key";
    }
}
