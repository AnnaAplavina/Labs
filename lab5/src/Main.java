import commands.CommandManager;
import commands.WrongArgumentException;
import dragons.DragonCollectionManager;
import java.io.IOException;

/**
 * Основной класс программы
 */
public class Main {
    public static void main(String[] args) {
        if(args.length != 1){
            System.out.println("Неверное имя файла.");
            System.exit(0);
        }
        DragonCollectionManager collectionManager = null;
        try {
            collectionManager = new DragonCollectionManager(args[0]);
        CommandManager manager = new CommandManager(collectionManager, args[0]);
        manager.start();}
        catch (IOException e) {
            e.printStackTrace();
        } catch (WrongArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}