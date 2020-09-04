package commands;

import inputOutput.InputOutputManager;

/**
 * Класс отвечает за выполнение команды execute_script
 */
public class ExecuteScriptCommand implements Command {
   private String[] arr;
   private InputOutputManager inputOutputManager;

    /**
     * @param inputOutputManager объект класса, отвечающего за получение ввода
     * @param arr ввод разделённый " ", в виде массива строк
     */
   public ExecuteScriptCommand(String[] arr, InputOutputManager inputOutputManager){
       this.arr = arr;
       this.inputOutputManager = inputOutputManager;
   }
    /**
     *
     * @return название команды
     */
   @Override
    public String getName(){
       return "execute_script";
   }
    /**
     * Выполняет команду
     * @throws WrongArgumentException ошибка при неправильном вводе аргументов команды
     */
   @Override
    public void execute() throws WrongArgumentException{

       if(arr.length != 2){
           throw new WrongArgumentException("У данной команды один аргумент.");
       }
       System.out.println("Начало выполнения скрипта.");
       inputOutputManager.setScript(arr[1]);
   }
}
