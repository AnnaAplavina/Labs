package commands;

/**
 * Ошибки при неверном вводе аргементов команды
 */
public class WrongArgumentException extends Exception {
    public WrongArgumentException(String message){
        super(message);
    }
}
