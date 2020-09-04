package dragons;

import commands.WrongArgumentException;
import inputOutput.InputOutputManager;
import inputOutput.NoScannerInputException;

/**
 * Позволяет создавать объекты Dragon при чтении значнеия полей из потока ввода
 */
public class DragonMaker {
    /**
     * @param inputOutputManager объект класса, управляющего коллекцией
     * @return объект типа Dragon
     * @throws NoScannerInputException ошибка при закрытом потоке ввода из консоли
     */
    public static Dragon makeDragon(InputOutputManager inputOutputManager) throws NoScannerInputException {
        boolean rightArgument;
        Dragon dragon = new Dragon();
        do{
            rightArgument = false;
            System.out.printf("Введите имя: ");
            try {
                dragon.setName(inputOutputManager.nextLine());
                rightArgument = true;
            }
            catch(WrongArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        while (rightArgument == false);

        do{
            rightArgument = false;
            Coordinates coordinates = dragon.getCoordinates();
            System.out.printf("Введите значение координаты x: ");
            try{
                coordinates.setX(inputOutputManager.nextLine());
                do{
                    try {
                        System.out.printf("Введите значение координаты y: ");
                        coordinates.setY(inputOutputManager.nextLine());
                        rightArgument = true;
                    }
                    catch (WrongArgumentException ex){
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

        do{
            rightArgument = false;
            System.out.printf("Введите значние возраста: ");
            try{
                dragon.setAge(inputOutputManager.nextLine());
                rightArgument = true;
            }
            catch (WrongArgumentException ex){
                System.out.println(ex.getMessage());
            };
        }
        while (rightArgument == false);

        do{
            rightArgument = false;
            System.out.print("Введите описание: ");
            try {
                dragon.setDescription(inputOutputManager.nextLine());
                rightArgument = true;
            }
            catch (WrongArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        while (rightArgument == false);

        do{
            rightArgument = false;
            System.out.print("Введите значение для размаха крыльев : ");
            try {
                dragon.setWingspan(inputOutputManager.nextLine());
                rightArgument = true;
            }
            catch (WrongArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        while (rightArgument == false);


        do{
            rightArgument = false;
            System.out.print("Выберите тип дракона(WATER, FIRE, UNDERGROUND, AIR) : ");
            try {
                dragon.setType(inputOutputManager.nextLine());
                rightArgument = true;
            }
            catch (WrongArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
        while (rightArgument == false);


        do{
            rightArgument = false;
            System.out.print("Введите 1, если желаете задать значение поля cave, или пустую строку, если желаете, чтобы поле было null: ");

            String line = inputOutputManager.nextLine();
            try{
                if(line.equals("1")){
                    DragonCave cave = CaveMaker.makeCave(inputOutputManager);
                    dragon.setCave(cave);
                }
                else if(line.equals("")){
                    rightArgument = true;
                }
                else {throw new WrongArgumentException("Введите 1 или пустую строку.");}
            }
            catch (WrongArgumentException ex){
                System.out.println(ex.getMessage()); }
            rightArgument = true;
        }
        while (rightArgument == false);
        dragon.newDate();
        return dragon;
    }
}

