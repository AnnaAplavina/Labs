package commands;
/**
 * Класс отвечает за выполнение команды exit.
 */
public class ExitCommand implements Command {
    private String[] arr;

    /**
     * @param arr ввод разделённый " ", в виде массива строк
     */
    public ExitCommand(String[] arr){
        this.arr = arr;
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
        System.out.println("Работа программы завершена.");
    }
    /**
     *
     * @return название команды
     */
    @Override
    public String getName() {
        return "exit";
    }
}
