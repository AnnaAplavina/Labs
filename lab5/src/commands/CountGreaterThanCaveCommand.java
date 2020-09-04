package commands;

import dragons.CaveMaker;
import dragons.Dragon;
import dragons.DragonCave;
import dragons.DragonCollectionManager;
import inputOutput.InputOutputManager;
import inputOutput.NoScannerInputException;
/**
 * Класс отвечает за выполнение команды count_greater_than_cave.
 * */
public class CountGreaterThanCaveCommand implements Command {
    private String[] arr;
    private DragonCollectionManager coll;
    private InputOutputManager inputOutputManager;

    /**
     *
     * @param coll объект класса, отвечающего за управление коллекцией
     * @param arr ввод разделённый " ", в виде массива строк
     * @param inputOutputManager объект класса, ответственного за управление коллекцией
     */
    public CountGreaterThanCaveCommand(DragonCollectionManager coll, String[] arr, InputOutputManager inputOutputManager){
        this.arr = arr;
        this.coll = coll;
        this.inputOutputManager = inputOutputManager;
    }
    /**
     * Выполняет команду
     * @throws WrongArgumentException ошибка при неправильном вводе аргументов команды
     * @throws NoScannerInputException ошибка из-за закрытого потока вода из консоли
     */
    @Override
    public void execute() throws WrongArgumentException, NoScannerInputException {
        if(arr.length != 1){
            throw new WrongArgumentException("У данной команды нет аргументов.");
        }
        DragonCave cave = CaveMaker.makeCave(inputOutputManager);
        int result = 0;
        for(Dragon dragon: coll.getEntrySet()){
            if(dragon.getCave() != null && dragon.getCave().compareTo(cave) > 0){
                result+=1;
            }
        }
        System.out.println("Количество элементов, поле cave которых больше заданного: " + result);
    }
    /**
     *
     * @return название команды
     */
    @Override
    public String getName() {
        return "count_greater_than_cave";
    }
}
