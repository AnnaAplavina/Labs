package commands;

import dragons.Dragon;
import dragons.DragonCollectionManager;
import dragons.DragonMaker;
import inputOutput.InputOutputManager;
import inputOutput.NoScannerInputException;

import java.util.Map;
/**
 * Класс отвечает за выполнение команды update
 */
public class UpdateCommand implements Command {

    private DragonCollectionManager coll;
    private String[] arr;
    private InputOutputManager inputOutputManager;
    /**
     * @param coll объект класса, отвечающего за управление коллекцией
     * @param arr ввод разделённый " ", в виде массива строк
     */
    public UpdateCommand(DragonCollectionManager coll, String[] arr, InputOutputManager inputOutputManager){
        this.coll = coll;
        this.arr = arr;
        this.inputOutputManager = inputOutputManager;
    }
    /**
     * Выполняет команду
     * @throws WrongArgumentException ошибка при неправильном вводе аргументов команды
     * @throws NoScannerInputException ошибка из-за закрытого потока вода из консоли
     */
    @Override
    public void execute() throws WrongArgumentException, NoScannerInputException {
        if(arr.length!=2){
            throw new WrongArgumentException("У данной команды один аргумент.");
        }
        Map.Entry<String, Dragon> pair = coll.getCollElementById(arr[1]);
        if(pair == null){
            throw new WrongArgumentException("Элемента коллекции с таким id не существует.");
        }
        Dragon dragon = DragonMaker.makeDragon(inputOutputManager);
        coll.addDragon(pair.getKey(), dragon);
        System.out.println("Элемент коллекции успешно заменён.");
    }
    /**
     *
     * @return название команды
     */
    @Override
    public String getName() {
        return "update";
    }
}
