package dragons;
import commands.Command;
import commands.WrongArgumentException;

/**
 * Исходный класс из задания. Объекты хранят данные о координатах объекта типа Dragon.
 */
public class Coordinates implements Comparable {
    private Float x; //Максимальное значение поля: 708, Поле не может быть null
    private double y; //Максимальное значение поля: 36

    /**
     * Конструктор задаёт полям значения по умолчанию 0.
     */
    public Coordinates(){
        x = 0.f;
        y = 0;
    }

    /**
     * Устанавливает значение координаты х
     * @throws WrongArgumentException ошибка при попытке присвоить не удовлетворяющее требованиям значение
     */
    public void setX(String x) throws WrongArgumentException{
        try{
            if(Float.parseFloat(x) > 708){
                throw new WrongArgumentException("Значение координаты x не может быть больше 708.");
            }
            this.x = Float.parseFloat(x);
        }
        catch (NumberFormatException ex){
            throw new WrongArgumentException("Значение координаты x должно быть целым числом.");
        }
    }
    /**
     * Устанавливает значение координаты у
     * @throws WrongArgumentException ошибка при попытке присвоить не удовлетворяющее требованиям значение
     */
    public void setY(String y) throws WrongArgumentException{
        try{
            if(Double.parseDouble(y) > 36){
                throw new WrongArgumentException("Значение координаты y не может быть больше, чем 36.");
            }
            this.y = Double.parseDouble(y);
        }
        catch (NumberFormatException ex){
            throw new WrongArgumentException("Координата y должна быть числом.");
        }
    }

    /**
     *
     * @return значнеие координаты х
     */
    public Float getX(){
        return x;
    }
    /**
     *
     * @return значнеие координаты у
     */
    public double getY(){
        return y;
    }

    @Override
    public String toString(){
        return "x: "+x+" y: "+y;
    }

@Override
public int compareTo(Object o){
    return x.compareTo(((Coordinates) o).getX()) + ((Double)y).compareTo(((Coordinates)o).getY());
}}