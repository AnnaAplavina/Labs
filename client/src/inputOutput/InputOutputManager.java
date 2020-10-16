package inputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Класс отвечает за чтение данных из файла и из консоли, запись данных в файл
 */
public class InputOutputManager {
    private String[] script;
    private int currentLine;
    private Scanner scanner = new Scanner(System.in);
    private ArrayList<String> currentScripts = new ArrayList<>();
    private String currentScriptFile;

    /**
     * При создании объекта ввод автоматически будет осуществляться из кнсоли
     */
    public InputOutputManager(){
        script = null;
    }

    /**
     * Позволяет задать скрипт
     * @param file имя файла,, содержащего скрипт
     */
    public void setScript(String file){
        if(currentScripts.contains(file)){
            System.out.println("Ошибка, данный скрипт уже исполняется.");
        }
        else{String scriptFromFile = readFile(file);
            if(scriptFromFile == ""){
            script = null;
        }
        else{
            currentScriptFile = file;
            currentScripts.add(file);
            script = scriptFromFile.split("\\r?\\n");
            currentLine = 0;
        }}
    }

    /**
     * возвращает новую строку из потока ввода(если установлен скрипт, то из скрипта, если нет, то из консоли)
     * @throws NoScannerInputException ошибка при закрытом потоке ввода из консоли
     */
    public String nextLine() throws NoScannerInputException{
        if(script!=null && currentLine < script.length){
            if(currentLine == script.length-1){
                currentScripts.remove(currentScriptFile);
            }
            currentLine+=1;
            return script[currentLine-1];
        }
        if(scanner.hasNextLine()){
            return scanner.nextLine();}
        else{
            throw new NoScannerInputException();
        }
    }

    /**
     * @param file имя файла
     * @return содержимое файла в виде строки
     */
    public static String readFile(String file) {
        BufferedInputStream inputStream = null;
        FileInputStream fileInputStream = null;
        String result = "";
        try {
            int bytesRead = 0;
            byte[] inputInBytes = new byte[1024];
            fileInputStream = new FileInputStream(file);
            inputStream = new BufferedInputStream(fileInputStream);
            while((bytesRead = inputStream.read(inputInBytes))!= -1){
                result += new String(inputInBytes, 0, bytesRead);}
        } catch (FileNotFoundException ex) {
            System.out.println("Ошибка при чтении файла.");
        }
        catch (IOException ex){
            System.out.println("Ошибка при чтении файла.");
        }
        finally{
            try{
                if(fileInputStream != null){
                    fileInputStream.close();
                }
            }
            catch (IOException ex){
                System.out.println("Ошибка при закрытии файла.");
            }
            try{
                if(inputStream != null){
                    inputStream.close();
                }
            }
            catch (IOException ex){
                System.out.println("Ошибка при закрытии файла.");
            }
        }
        return result;
    }

    /**
     *
     * @param sFile имя файла, в который нужно записать
     * @param contents содержимое, которое нужно записать в файл
     * @throws FileNotFoundException ошибка при отсутствии файла/прав доступа к нему
     */
    public static void writeToFile(String sFile, String contents) throws FileNotFoundException {
        File file = new File(sFile);
        PrintWriter writer = new PrintWriter(file);
        writer.print(contents);
        writer.close();
    }
}