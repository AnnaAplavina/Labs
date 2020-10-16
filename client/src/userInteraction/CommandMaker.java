package userInteraction;

import commands.*;
import commands.commandClasses.*;
import inputOutput.InputOutputManager;
import dragons.CaveMaker;
import dragons.DragonMaker;
import inputOutput.NoScannerInputException;


public class CommandMaker {
    public static Command makeCommand(String[] arr, InputOutputManager inp) throws NoSuchCommandException, WrongArgumentException, NoScannerInputException {
        Command command;
        switch(arr[0]){
            case ("exit"):
                command = new ExitCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                return command;
            case("help"):
                command = new HelpCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                return command;
            case("info"):
                command = new InfoCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                return command;
            case("show"):
                System.out.println("here");
                command = new ShowCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                return command;
            case("insert"):
                command = new InsertCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                ((InsertCommand)command).setDragon(DragonMaker.makeDragon(inp));
                return command;
            case("update"):
                command = new UpdateCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                ((UpdateCommand)command).setDragon(DragonMaker.makeDragon(inp));
                return command;
            case("remove_key"):
                command = new RemoveKeyCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                return command;
            case("clear"):
                command = new ClearCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                return command;
            case("history"):
                command = new HistoryCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                return command;
            case("replace_if_lower"):
                command = new ReplaceIfLowerCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                ((ReplaceIfLowerCommand)command).setDragon(DragonMaker.makeDragon(inp));
                return command;
            case("remove_lower_key"):
                command = new RemoveLowerKeyCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                return command;
            case("average_of_age"):
                command = new AverageOfAgeCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                return command;
            case ("count_greater_than_cave"):
                System.out.println("here");
                command = new CountGreaterThanCaveCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                ((CountGreaterThanCaveCommand)command).setCave(CaveMaker.makeCave(inp));
                return command;
            case("filter_less_than_type"):
                command = new FilterLessThanTypeCommand(arr);
                if(!command.checkArguments()){
                    throw new WrongArgumentException("Не правильно введены аргумент/аргументы команды.");
                }
                return command;
            default: throw new NoSuchCommandException();
        }
    }
}
