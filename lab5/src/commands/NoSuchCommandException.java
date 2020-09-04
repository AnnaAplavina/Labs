package commands;

/**
 * Ошибка при неверном вводе команды
 */
public class NoSuchCommandException extends Exception {
    public String getMessage(){
        return new String("Команда введена неверно.");
    }
}
