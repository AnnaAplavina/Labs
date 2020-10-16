package userInteraction;

import commands.Command;
import commands.NoSuchCommandException;
import commands.WrongArgumentException;
import commands.commandClasses.FilterLessThanTypeCommand;
import commands.commandClasses.ShowCommand;
import connection.ClientServerConnection;
import connection.Message;
import inputOutput.InputOutputManager;
import inputOutput.NoScannerInputException;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.stream.Stream;

public class ClientInputProcessor {
    private ClientServerConnection connection;
    private InputOutputManager input = new InputOutputManager();
    public ClientInputProcessor(String[] comLineArgs) throws SocketException, UnknownHostException {
        connection = new ClientServerConnection(comLineArgs[0], Integer.parseInt(comLineArgs[1]), input);
    }

    public void readCommands() throws NoScannerInputException, IOException, ClassNotFoundException {
        while(true){
            String[] arr = input.nextLine().split(" ");
            Command command = null;
            try {
                command = CommandMaker.makeCommand(arr, input);
                if(command.getName().equals("exit")){
                    connection.sendMessage(new Message(command));
                    break;
                }
            } catch (WrongArgumentException | NoSuchCommandException e) {
                System.out.println("Ошибка при вводе команды.");
                continue;
            }
            connection.sendMessage(new Message(command));
            processAnswerFromServer(connection.receiveMessege());
            if(command.getName().equals("exit")){
                System.out.println("Работа программы завершена.");
                connection.closeSocket();
                break;
            }
        }
    }

    private void processAnswerFromServer(Message message){
        switch (message.getCommand().getName()){
            case("average_of_age"):
                System.out.println(message.getMessage());
                break;
            case("clear"):
                System.out.println(message.getMessage());
                break;
            case("count_greater_than_cave"):
                System.out.println(message.getMessage());
                break;
            case("filter_less_than_type"):
                System.out.println(message.getMessage());
                Stream.of(((FilterLessThanTypeCommand)(message.getCommand())).getArrayList()).forEachOrdered((d) -> System.out.println(" "+d+"\n\r"));
                break;
            case("help"):
                System.out.println(message.getMessage());
                break;
            case("history"):
                System.out.println(message.getMessage());
                break;
            case("info"):
                System.out.println(message.getMessage());
                break;
            case("insert"):
                System.out.println(message.getMessage());
                break;
            case("remove_key"):
                System.out.println(message.getMessage());
                break;
            case("remove_lower_key"):
                System.out.println(message.getMessage());
                break;
            case("replace_if_lower"):
                System.out.println(message.getMessage());
                break;
            case("show"):
                System.out.println(message.getMessage());
                Stream.of(((ShowCommand)(message.getCommand())).getArrayList()).forEachOrdered((d) -> System.out.println(" "+d+"\n\r"));
                break;
            case("update"):
                if(message.getMessage().equals("Элемента с данным id не существует.")){
                    System.out.println(message.getMessage());
                    break;
                }
                else {
                    System.out.println(message.getMessage());
                    break;
                }
        }
    }
    }

