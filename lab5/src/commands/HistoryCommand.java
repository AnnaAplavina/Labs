package commands;

import java.util.LinkedList;
/**
 * Класс отвечает за выполнение команды history
 */
public class HistoryCommand implements Command {
    private String[] arr;
    private LinkedList<String> history;
    /**
     * @param history коллекция, в которой храниться история команд
     * @param arr ввод разделённый " ", в виде массива строк
     */
    public HistoryCommand(LinkedList<String> history, String[] arr){
        this.arr = arr;
        this.history = history;
    }
    /**
     * Выполняет команду
     * @throws WrongArgumentException ошибка при неправильном вводе аргументов команды
     */
    @Override
    public void execute() throws WrongArgumentException {
        if (arr.length!=1){
            throw new WrongArgumentException("У данной команды нет аргументов.");
        }
        Object[] commands = history.toArray();
        System.out.println("История:");
        for(Object command:commands){
            System.out.println((String) command);
        }
    }
    /**
     *
     * @return название команды
     */
    @Override
    public String getName() {
        return "history";
    }
}
