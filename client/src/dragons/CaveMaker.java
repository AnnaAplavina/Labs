package dragons;

import commands.WrongArgumentException;
import inputOutput.InputOutputManager;
import inputOutput.NoScannerInputException;

/**
 * Класс отвечает за создание объектов Cave с параментрами, которые вводит пользователь или которое были прочитаны из скрипта
 */
public class CaveMaker {
    /**
     * Статический метод, создаёт объект типа Cave
     * @param inputOutputManager Объект, класса, отвечающего за получение ввода из консоли или из файла
     * @return Объект типа cave
     * @throws NoScannerInputException Ошибка из-за закрытого потока ввода из консоли
     */
    public static DragonCave makeCave(InputOutputManager inputOutputManager) throws NoScannerInputException {
        DragonCave cave = new DragonCave();
        boolean rightArgument = false;
        do{
            try {
                System.out.print("Введите значение поля depth: ");
                cave.setDepth(inputOutputManager.nextLine());
                do {
                    try {
                        System.out.printf("Введите значение поля numOfTreasures: ");
                        cave.setNumberOfTreasures(inputOutputManager.nextLine());
                        rightArgument = true;
                    } catch (WrongArgumentException ex) {
                        System.out.println(ex.getMessage());
                    }
                }
                while (rightArgument == false);
            }
            catch (WrongArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
           while (rightArgument == false);
           return cave;
}
}
