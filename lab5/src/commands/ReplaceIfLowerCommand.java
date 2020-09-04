package commands;

import dragons.Dragon;
import dragons.DragonCollectionManager;
import dragons.DragonMaker;
import inputOutput.InputOutputManager;
import inputOutput.NoScannerInputException;
/**
 * Класс отвечает за выполнение команды replace_lower
 */
public class ReplaceIfLowerCommand implements Command{
        private DragonCollectionManager coll;
        private String[] arr;
        private InputOutputManager inputOutputManager;
    /**
     * @param coll объект класса, отвечающего за управление коллекцией
     * @param arr ввод разделённый " ", в виде массива строк
     */
        public ReplaceIfLowerCommand(DragonCollectionManager coll, String[] arr, InputOutputManager inputOutputManager){
            this.coll = coll;
            this.arr = arr;
            this.inputOutputManager = inputOutputManager;
        }
    /**
     *
     * @return название команды
     */
        @Override
        public String getName() {
            return "replace_if_lower";
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
            if(!coll.checkKey(arr[1])){
                throw new WrongArgumentException("Элемент с данным ключом отсутствует в коллекции.");
            }
            Dragon dragon = DragonMaker.makeDragon(inputOutputManager);
            if(dragon.compareTo(coll.getDragon(arr[1])) < 0){
            coll.addDragon(arr[1], dragon);
                System.out.println("Объект успешно заменён.");}
            else {
                System.out.println("Новое значение больше старого.");
            }
        }
}
