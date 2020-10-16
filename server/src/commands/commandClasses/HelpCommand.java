package commands.commandClasses;

import commands.Command;
import commands.SimpleCommand;

import java.io.Serializable;

public class HelpCommand implements Command, SimpleCommand, Serializable {
    private String[] arr;

    public HelpCommand(String[] arr){
        this.arr = arr;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public boolean checkArguments() {
        return arr.length == 1;
    }

    @Override
    public String execute() {
        return "help : вывести справку по доступным командам\n" +
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
                "filter_less_than_type type : вывести элементы, значение поля type которых меньше заданного";
    }
}
