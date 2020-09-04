package commands;

import dragons.DragonCollectionManager;
import inputOutput.InputOutputManager;
import inputOutput.JsonProcessor;
import java.io.FileNotFoundException;


/**
 * Класс отвечает за выполнение команды save
 */
public class SaveCommand implements Command {
    private DragonCollectionManager coll;
    private String[] arr;
    private String file;
    /**
     * @param coll объект класса, отвечающего за управление коллекцией
     * @param arr ввод разделённый " ", в виде массива строк
     */
    public SaveCommand(DragonCollectionManager coll, String[] arr, String file){
        this.coll = coll;
        this. arr = arr;
        this.file = file;
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
        try {
            InputOutputManager.writeToFile(file,JsonProcessor.writeDragonCollection(coll.getColl()));
            System.out.println("Данные успешно сохранены.");
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось сохранить данные. Ошибка при записи в файл.");
        }
    }
    /**
     *
     * @return название команды
     */
    @Override
    public String getName() {
        return "save";
    }
}
