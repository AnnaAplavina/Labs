package commands;

import dragons.Dragon;
import dragons.DragonCollectionManager;
import dragons.DragonMaker;
import inputOutput.InputOutputManager;
import inputOutput.NoScannerInputException;
/**
 * Класс отвечает за выполнение команды insert
 */
public class InsertCommand implements Command {
    private DragonCollectionManager coll;
    private String[] arr;
    private InputOutputManager inputOutputManager;
    /**
     * @param coll объект класса, отвечающего за управление коллекцией
     * @param arr ввод разделённый " ", в виде массива строк
     */
    public InsertCommand(DragonCollectionManager coll, String[] arr, InputOutputManager inputOutputManager){
        this.arr = arr;
        this.coll = coll;
        this.inputOutputManager = inputOutputManager;
    }
    /**
     *
     * @return название команды
     */
    @Override
    public String getName() {
        return "insert";
    }
    /**
     * Выполняет команду
     * @throws WrongArgumentException ошибка при неправильном вводе аргументов команды
     * @throws NoScannerInputException ошибка из-за закрытого потока вода из консоли
     */
    @Override
    public void execute() throws WrongArgumentException, NoScannerInputException {
        if(arr.length != 2){
            throw  new WrongArgumentException("У данной команды один аргумент.");
        }
        if(coll.checkKey(arr[1])){
            throw new WrongArgumentException("Данный ключ уже занят.");
        }
        Dragon dragon = DragonMaker.makeDragon(inputOutputManager);
        coll.addDragon(arr[1], dragon);
        System.out.println("Объект успешно добавлен в коллекцию.");
        }
    }
