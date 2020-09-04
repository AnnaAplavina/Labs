package commands;

import dragons.DragonCollectionManager;
/**
 * Класс отвечает за выполнение команды average_of_age.
 * */
public class AverageOfAgeCommand implements Command {
    private DragonCollectionManager coll;
    private String[] arr;

    /**
     * @param coll объект класса, отвечающего за управление коллекцией
     * @param arr ввод разделённый " ", в виде массива строк
     */
    public AverageOfAgeCommand(DragonCollectionManager coll, String[] arr) {
        this.coll = coll;
        this.arr = arr;
    }

    /**
     * Выполняет команду
     * @throws WrongArgumentException ошибка при неправильном вводе аргументов команды
     */
    @Override
    public void execute() throws WrongArgumentException {
        int result;
        if(arr.length != 1){
            throw new WrongArgumentException("У данной команды нет аргументов.");
        }
        result = coll.getAvaregreAge();
        if(result==-1){
            System.out.println("У всех объектов в коллекции значение поля age равно null.");
        }
        else if(result == -2){
            System.out.println("В коллекции отсутствуют эллементы.");
        }
        else {
            System.out.println("Среднее значение поля age: " + result);
        }
    }

    /**
     *
     * @return название команды
     */
    @Override
    public String getName() {
        return "average_of_age";
    }
}
