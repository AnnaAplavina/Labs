package commands;

import inputOutput.NoScannerInputException;

/**
 * Интерфейс для всех команд.
 */
public interface Command {
    /**
     *
     * @throws WrongArgumentException ошибки, возникающие при неправильном вводе аргументов
     * @throws NoScannerInputException ошибки, возникающие при закрытие потока ввода с консоли
     */
    void execute() throws WrongArgumentException, NoScannerInputException;
    String getName();
}
