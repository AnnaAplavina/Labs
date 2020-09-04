package commands;

import dragons.DragonCollectionManager;
import inputOutput.InputOutputManager;
import inputOutput.NoScannerInputException;

import java.util.*;
/**
 * Класс отвечает за выполнение команд.
 * */
public class CommandManager {
    private InputOutputManager inputOutputManager = new InputOutputManager();
    private String[] commands = new String[] {"help", "info", "show", "insert", "update", "remove_key", "clear", "save", "execute_script", "exit", "history", "replace_if_lower", "remove_lower_key","average_of_age", "count_greater_than_cave", "filter_less_than_type"};
    private DragonCollectionManager coll;
    private String file;
    private LinkedList<String> history = new LinkedList<String>();
    private boolean exit = false;

    /**
     *
     * @param coll объект класса, управляющий колекцией
     * @param file файл, из которого заполняется коллекция при запуске
     */
    public CommandManager(DragonCollectionManager coll, String file){
        this.coll = coll;
        this.file = file;
    }

    /**
     * Начинает чтение и исполнение комманд, пока не будет исполнена команда exit.
     */
    public void start(){
        Command currentCommand;
        while(exit==false){
            try {
                currentCommand = nextCommand();
                currentCommand.execute();
                if(currentCommand.getName().equals("exit")){
                    exit = true;
                }
                history.add(currentCommand.getName());
                if(history.size() > 10){
                    history.pop();
                }
            }
            catch (NoScannerInputException ex){
                System.out.println(ex.getMessage());
                System.out.println("Работа программы завершена.");
                exit = true;
            }
            catch (Exception ex){
                System.out.println(ex.getMessage());
            }
        }
    }

    /**
     *
     * @return команда, введённая пользователем или прочитаная из скрипта
     * @throws NoSuchCommandException ошибка, возникающая в случае, если команда не найдена
     * @throws NoScannerInputException ошибка из-за закрытого потока вода из консоли
     */
    private Command nextCommand() throws NoSuchCommandException, NoScannerInputException {
        boolean correctCommand = false;
        String command = inputOutputManager.nextLine();
        String[] inputArr = command.split(" ");
        for(String com:commands){
            if(inputArr[0].equals(com)){
                correctCommand = true;
                break;
            }
        }
        if(correctCommand == false){
            throw new NoSuchCommandException();
        }
        return findCommand(inputArr);
    }


    /**
     * Метод осуществляет определение полученной на ввод команды
     * @param commandArr ввод разделённый " ", в виде массива строк
     * @return определяемая команда, null если команда не найдена
     */
    private Command findCommand(String[] commandArr) {
        switch(commandArr[0]){
            case("help"):
                return new Command(){
                    String[] array = commandArr;
                    public void execute()throws WrongArgumentException{
                        if(array.length>1){
                            throw new WrongArgumentException("У данной команды нет аргументов.");
                        }
                        System.out.println("help : вывести справку по доступным командам\n" +
                                "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                                "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                                "insert null {element} : добавить новый элемент с заданным ключом\n" +
                                "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                                "remove_key null : удалить элемент из коллекции по его ключу\n" +
                                "clear : очистить коллекцию\n" +
                                "save : сохранить коллекцию в файл\n" +
                                "execute_script file_name : считать и исполнить скрипт из указанного файла. \n" +
                                "exit : завершить программу (без сохранения в файл)\n" +
                                "history : вывести последние 10 команд (без их аргументов)\n" +
                                "replace_if_lowe null {element} : заменить значение по ключу, если новое значение меньше старого\n" +
                                "remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный\n" +
                                "average_of_age : вывести среднее значение поля age для всех элементов коллекции\n" +
                                "count_greater_than_cave cave : вывести количество элементов, значение поля cave которых больше заданного\n" +
                                "filter_less_than_type type : вывести элементы, значение поля type которых меньше заданного");
                    }
                    public String getName(){
                        return "help";
                    }
            };

            case("info"):
                return new InfoCommand(coll, commandArr);
            case("show"):
                return new ShowCommand(coll, commandArr);
            case("insert"):
                return new InsertCommand(coll, commandArr, inputOutputManager);
            case("update"):
                return new UpdateCommand(coll, commandArr, inputOutputManager);
            case("remove_key"):
                return new RemoveKeyCommand(coll,commandArr);
            case("clear"):
                return new ClearCommand(coll,commandArr);
            case("exit"):
                return new ExitCommand(commandArr);
            case("save"):
                return new SaveCommand(coll, commandArr, file);
            case("execute_script"):
                return new ExecuteScriptCommand(commandArr, inputOutputManager);
            case("history"):
                return new HistoryCommand(history, commandArr);
            case("replace_if_lower"):
                return new ReplaceIfLowerCommand(coll, commandArr, inputOutputManager);
            case("remove_lower_key"):
                return new RemoveLowerKeyCommand(coll, commandArr);
            case("average_of_age"):
                return new AverageOfAgeCommand(coll, commandArr);
            case ("count_greater_than_clave"):
                return new CountGreaterThanCaveCommand(coll, commandArr, inputOutputManager);
            case("filter_less_than_type"):
                return new FilterLessThanTypeCommand(coll, commandArr);
            default: return null;
        }
    }
    }