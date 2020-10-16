package connection;

import commands.WrongArgumentException;
import commands.commandClasses.*;
import dragons.Dragon;
import dragons.DragonCave;
import dragons.DragonCollectionManager;
import inputOutput.InputOutputManager;
import inputOutput.JsonProcessor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommandReader {
    private ServerChannel channel;
    private DragonCollectionManager coll;
    private boolean exit = false;
    private String file;
    private ArrayList<String> history = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);

    public CommandReader(ServerChannel channel, DragonCollectionManager coll, String file){
        this.channel = channel;
        this.coll = coll;
        this.file = file;
    }

    public void work() throws InterruptedException, IOException, ClassNotFoundException {
        while (!exit){
            processCommandFromClient();
        }
    }


    private void processCommandFromClient() throws InterruptedException, IOException, ClassNotFoundException {
        checkServerCommand();
        String result;
        Message message = null;
        boolean recieved = false;
        while (!recieved){
            message = channel.recieveMessage();
            if(message.getCommand()!=null){
                recieved = true;
            }
        }
        switch (message.getCommand().getName()) {
            case ("exit"):
                exit = true;
                saveCollection();
                break;
            case ("average_of_age"):
                result = ((AverageOfAgeCommand)(message.getCommand())).execute(coll);
                message.setMessage(result);
                channel.sendMessage(message);
                addToHistory("average_of_age");
                break;
            case("clear"):
                result = ((ClearCommand)(message.getCommand())).execute(coll);
                message.setMessage(result);
                channel.sendMessage(message);
                addToHistory("clear");
                break;
            case("count_greater_than_cave"):
                result = ((CountGreaterThanCaveCommand)(message.getCommand())).execute(coll);
                message.setMessage(result);
                channel.sendMessage(message);
                addToHistory("count_greater_than_cave");
                break;
            case ("filter_less_than_type"):
                result = ((FilterLessThanTypeCommand)(message.getCommand())).execute(coll);
                message.setMessage(result);
                sortArrayList(((FilterLessThanTypeCommand)(message.getCommand())).getArrayList());
                channel.sendMessage(message);
                addToHistory("filter_less_than_type");
                break;
            case("help"):
                result = ((HelpCommand)(message.getCommand())).execute();
                message.setMessage(result);
                channel.sendMessage(message);
                addToHistory("help");
                break;
            case ("history"):
                ((HistoryCommand)(message.getCommand())).setHistory(getHistoryString());
                result = ((HistoryCommand)(message.getCommand())).execute();
                message.setMessage(result);
                channel.sendMessage(message);
                addToHistory("history");
                break;
            case ("info"):
                result = ((InfoCommand)(message.getCommand())).execute(coll);
                message.setMessage(result);
                channel.sendMessage(message);
                addToHistory("help");
                break;
            case ("insert"):
                Dragon dragon = ((InsertCommand)(message.getCommand())).getDragon();
                System.out.println("1");
                try{
                    generateDragonId(dragon);
                    System.out.println("2");
                }
                catch (WrongArgumentException ex){
                    System.out.println("Problems with id generation");
                }
                result = ((InsertCommand)(message.getCommand())).execute(coll);
                System.out.println("3");
                message.setMessage(result);
                channel.sendMessage(message);
                addToHistory("insert");
                break;
            case ("remove_key"):
                result = ((RemoveKeyCommand)(message.getCommand())).execute(coll);
                message.setMessage(result);
                channel.sendMessage(message);
                addToHistory("remove_key");
                break;
            case("remove_lower_key"):
                result = ((RemoveLowerKeyCommand)(message.getCommand())).execute(coll);
                message.setMessage(result);
                channel.sendMessage(message);
                addToHistory("remove_lower_key");
                break;
            case("replace_if_lower"):
                result = ((ReplaceIfLowerCommand)(message.getCommand())).execute(coll);
                message.setMessage(result);
                channel.sendMessage(message);
                addToHistory("replace_if_lower");
                break;
            case("show"):
                System.out.println("Show command is being executed");
                result = ((ShowCommand)(message.getCommand())).execute(coll);
                message.setMessage(result);
                sortArrayList(((ShowCommand)(message.getCommand())).getArrayList());
                channel.sendMessage(message);
                addToHistory("show");
                break;
            case("update"):
                try {
                    result = ((UpdateCommand)(message.getCommand())).execute(coll);
                }
                catch (WrongArgumentException ex){
                    message.setMessage("Элемента с данным id не существует.");
                    channel.sendMessage(message);
                    addToHistory("update");
                    break;
                }
                message.setMessage(result);
                channel.sendMessage(message);
                addToHistory("update");
                break;
            default:
                message.setMessage("Неправильно введена команда");
                channel.sendMessage(message);
        }
    }


    private void sortArrayList(ArrayList<Dragon> array){
        array = array.stream().sorted((Dragon::compareTo)).collect(Collectors.toCollection(ArrayList::new));
    }

    private void addToHistory(String command){
        if(history.size()==10){
            history.remove(9);
        }
        history.add(command);
    }

    private String getHistoryString(){
        String result = "";
        for(String command: history){
            result = result + " " + command;
        }
        return result;
    }

    private void generateDragonId(Dragon dragon) throws WrongArgumentException {
        ArrayList<Integer> ids = dragon.getExistingIds();
        while(true){
            int newId = (int)(Math.random()*10000);
            if(!ids.contains(newId)){
                dragon.setId(newId);
                break;
            }
        }
    }

    private void saveCollection() throws FileNotFoundException {
        InputOutputManager.writeToFile(file, JsonProcessor.writeDragonCollection(coll.getColl()));
        System.out.println("Collection saved");
    }

    private void checkServerCommand() throws IOException {
        StringBuilder console_line = new StringBuilder();
        if (System.in.available() > 0) {
            int ch = 0;
            while (true) {
                ch = System.in.read();
                if (ch == 10) {
                    break;
                } else {
                    console_line.append((char) ch);
                }
            }
            if(console_line.toString().equals("save")){
                saveCollection();
            }
        }
    }
}
