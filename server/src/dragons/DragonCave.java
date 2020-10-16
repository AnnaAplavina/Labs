package dragons;

import commands.WrongArgumentException;

import java.io.Serializable;

/**
 * Исходный класс из задания
 */
public class DragonCave implements Comparable, Serializable {
    private long depth;
    private Long numberOfTreasures; //Поле может быть null, Значение поля должно быть больше 0

    /**
     * Конструкто устанавливает значения полей по умолчанию
     */
    public DragonCave(){
        numberOfTreasures = 1L;
    }

    /**
     * устанавливает значение поля depth
     */
    public void setDepth(String depth) throws WrongArgumentException
    {
        if(depth == ""){
            this.depth = 0;
        }
        else{
        try{
        this.depth = Long.parseLong(depth);}
        catch (NumberFormatException ex){
            throw new WrongArgumentException("Значение этого поля должно быть числом.");
        }}
    }

    /**
     * устанавливает значение поля numberOfTreasures
     */
    public void setNumberOfTreasures(String numberOfTreasures) throws WrongArgumentException{
        try{
            this.numberOfTreasures = Long.parseLong(numberOfTreasures);
        }
        catch (NumberFormatException ex){
            throw new WrongArgumentException("Значение этого поля должно быть числом.");
        }
    }

    /**
     * метод нужен для сриализации поля depth
     */
    public long getDepth(){
        return depth;
    }

    /**
     * метод нужен для серализации поля numberOfTreasures
     */
    public Long getNumberOfTreasures(){
        return numberOfTreasures;
    }

    @Override
    public String toString(){
        return "количество сокровищ: "+numberOfTreasures+" глубина: "+depth;
    }

    @Override
    public int compareTo(Object o) {
        int result =(int)(Math.abs(depth) - Math.abs(((DragonCave)o).getDepth()));
        if(numberOfTreasures != null){
            if(((DragonCave)o).getNumberOfTreasures() != null){
                result+=numberOfTreasures.compareTo(((DragonCave)o).getNumberOfTreasures());
            }
            if(((DragonCave)o).getNumberOfTreasures() == null){
                result+=numberOfTreasures;
            }
        }
        if(numberOfTreasures == null){
            if(((DragonCave)o).getNumberOfTreasures() != null){
                result -= ((DragonCave)o).getNumberOfTreasures();
            }
        }
        return result;
    }
}
