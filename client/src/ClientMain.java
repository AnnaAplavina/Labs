import commands.NoSuchCommandException;
import commands.WrongArgumentException;
import inputOutput.NoScannerInputException;
import userInteraction.ClientInputProcessor;

import java.io.IOException;
import java.net.SocketException;
import java.net.UnknownHostException;

public class ClientMain {
    public static void main(String[] args) throws SocketException, UnknownHostException {
        ClientInputProcessor clientInputProcessor = new ClientInputProcessor(args);
        try {
            clientInputProcessor.readCommands();
        } catch (NoScannerInputException e) {
            System.out.println("Отсутвует ввод из консоли. Работа программы завершена.");
        } catch (IOException e) {
            System.out.println("Ошибка при взаимодействии с сервером. Работа программы завершена.");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
