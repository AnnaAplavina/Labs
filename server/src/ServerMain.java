import commands.WrongArgumentException;
import connection.CommandReader;
import connection.ServerChannel;
import dragons.DragonCollectionManager;

import java.io.IOException;

public class ServerMain {
    public static void main(String[] args) {
        try {
            DragonCollectionManager coll = new DragonCollectionManager("D:\\labs\\programming\\6\\lab6\\server\\test.txt");
            ServerChannel channel = new ServerChannel(9033);
            CommandReader reader = new CommandReader(channel,coll, "D:\\labs\\programming\\6\\lab6\\server\\test.txt");
            reader.work();
        } catch (IOException e) {
            System.out.println("Ошибка при попытке получить сообщение от клиента.");
            e.printStackTrace();
        } catch (WrongArgumentException e) {
            e.printStackTrace();} catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
