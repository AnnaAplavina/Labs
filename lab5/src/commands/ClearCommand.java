package commands;

import dragons.DragonCollectionManager;
/**
 * Класс отвечает за выполнение команды clear.
 * */
public class ClearCommand implements Command {
    private DragonCollectionManager coll;
    private String[] arr;

    /**
     * @param coll объект класса, отвечающего за управление коллекцией
     * @param arr ввод разделённый " ", в виде массива строк
     */
    public ClearCommand(DragonCollectionManager coll, String[] arr){
        this.coll = coll;
        this.arr = arr;
    }


    /**
     *
     * @return название команды
     */
    @Override
    public String getName() {
        return "clear";
    }

    /**
     * Выполняет команду
     * @throws WrongArgumentException ошибка при неправильном вводе аргументов команды
     */
    @Override
    public void execute() throws WrongArgumentException {
        if(arr.length > 1){
            throw new WrongArgumentException("У данной команды нет аргументов.");
        }
        coll.clearCollection();
    }
}
