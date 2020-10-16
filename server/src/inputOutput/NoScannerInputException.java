package inputOutput;

/**
 * Ошибки возникающие при закрытом потоке ввода из консоли
 */
public class NoScannerInputException extends Exception{
    @Override
    public String getMessage(){
        return "Отсутствует ввод с консоли.";
    }
}
