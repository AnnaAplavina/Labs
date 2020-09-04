package dragons;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import commands.WrongArgumentException;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

/**
 * Исходный класс из задания
 */
public class Dragon implements Comparable{
    private Integer id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private java.time.LocalDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0, Поле может быть null
    private String description; //Поле не может быть null
    private int wingspan; //Значение поля должно быть больше 0
    private DragonType type; //Поле не может быть null
    private DragonCave cave; //Поле может быть null


    private String date;

    /**
     * метод позваляет обновить поле creationDate
     */
    public void newDate(){
        creationDate = LocalDateTime.now();
        date = toStringDate(creationDate);
    }

    private String toStringDate(LocalDateTime creationDate){
        return creationDate.getMonthValue()+"."+creationDate.getDayOfMonth()+"."+creationDate.getYear()+" "+creationDate.getHour()+":"+creationDate.getMinute()+":"+creationDate.getSecond();
    }

    private static ArrayList<Integer> existingIds = new ArrayList<Integer>();

    /**
     * Конструктор устанавливает значения полей по умолчанию
     */
    public Dragon(){
        while(id == null){
            int newId = (int)(Math.random()*10000);
            if(!existingIds.contains(newId)){
                id = newId;
                existingIds.add(id);
            }
        }
        name = "default";
        coordinates = new Coordinates();
        creationDate = LocalDateTime.now();
        description = "default";
        wingspan = 1;
        type = DragonType.WATER;
        date = toStringDate(creationDate);
    }

    /**
     *
     * @return id
     */
    public int getId(){
        return id;
    }

    /**
     *
     * @return name
     */
    public String getName(){return name;}

    /**
     *
     * @return description
     */
    public String getDescription(){
        return description;
    }
    /**
     *
     * @return coordinates
     */
    public Coordinates getCoordinates(){
        return coordinates;
    }

    /**
     *
     * @return age
     */
    public Integer getAge(){
        return age;
    }

    /**
     *
     * @return wingspan
     */
    public int getWingspan(){
        return wingspan;
    }

    /**
     *
     * @return type
     */
    public DragonType getType(){
        return type;
    }

    /**
     *
     * @return cave
     */
    public DragonCave getCave(){
        return cave;
    }

    /**
     *
     * @return creationDate
     */
    public LocalDateTime getCreationDate(){
        return creationDate;
    }

    /**
     * Метод необходит для корректной сериализации поля creationDate
     * @return строка со значение поля creationDate в файле json
     */
    @JsonGetter("creationDate")
    public String getJsonCreationDate(){
        return creationDate.getYear()+" "+creationDate.getMonthValue()+" "+creationDate.getDayOfMonth()+" "+creationDate.getHour()+" "+creationDate.getMinute()+" "+creationDate.getSecond()+" "+creationDate.getNano();
    }

    /**
     * Метод нужен для корректной десериализации поля age
     * @throws WrongArgumentException ошибка при попытке установить значение, не подходящее под условия
     */
    @JsonSetter("age")
    public void setAge(Integer inputAge) throws WrongArgumentException {
        if(inputAge == null){
            this.age = null;
        }
        else if(inputAge <= 0 ){
            throw new WrongArgumentException("Значение этого поля должно быть больше 0.");
        }
        else {
            this.age = inputAge;
        }
    }

    /**
     *Метод нужен для корректной десериализации
     */
    public void setCreationDate(Object creationDate){
        try {
            String[] date = ((String)creationDate).split(" ");
            if (date.length != 7){
                throw new Exception("Неверный формат даты");
            }
            int year = Integer.parseInt(date[0]);
            Month month = Month.of(Integer.parseInt(date[1]));
            int dayOfMonth = Integer.parseInt(date[2]);
            int hour = Integer.parseInt(date[3]);
            int minute = Integer.parseInt(date[4]);
            int second = Integer.parseInt(date[5]);
            int nanoOfSecond = Integer.parseInt(date[6]);
            this.creationDate = LocalDateTime.of(year,month,dayOfMonth,hour,minute,second,nanoOfSecond);
            this.date = toStringDate(this.creationDate);}
        catch (Exception ex){
            System.out.println("Не верный фомат даты.");
            System.out.println(ex.getMessage());
        }
    }

    /**
     * метод задаёт значение поля name
     */
    public void setName(String name) throws WrongArgumentException{
        if(name.split(" ").length == 0){
            throw new WrongArgumentException("Это поле не может быть пустым.");
        }
        this.name = name;
    }

    /**
     * метод нужен для корректной дескриализации поля coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * метод устанавливает значение поля age
     */
    public void setAge(String inputAge) throws WrongArgumentException{
        Integer age = null;
        try{
            age = Integer.parseInt(inputAge);
            if(age <= 0 ){
                throw new WrongArgumentException("Значение этого поля должно быть больше 0.");
            }
        }
        catch (NumberFormatException ex) {
            if (!inputAge.equals("")) {
                throw new WrongArgumentException("Значение этого поля должно быть целым числом.");
            } else {
                this.age = null;
            }
        }
        this.age = age;
    }

    /**
     * Метод устанавливает значение поля description
     */
    @JsonSetter("description")
    public void setDescription(String description) throws WrongArgumentException{
        if(description.equals("")){
            throw new WrongArgumentException("Значение этого поля не может быть пустым.");
        }
        this.description = description;
    }

    /**
     *Устанавливает значение поля wingspan
     */
    public void setWingspan(String inputWingspan) throws WrongArgumentException {
        int wingspan;
        try{
            wingspan = Integer.parseInt(inputWingspan);
        }
        catch(NumberFormatException ex){
            throw new WrongArgumentException("Значение этого поля должно быть целым числом.");
        }
        if(wingspan < 0){
            throw new WrongArgumentException("Значение этого поля должно быть больше 0.");
        }
        this.wingspan = wingspan;
    }

    /**
     * нужен для десериализации поля wingspan
     */
    public void setWingspan(int wingspan){
        this.wingspan = wingspan;
    }

    /**
     * устанавливает значение поля type
     */
    public void setType(String s) throws WrongArgumentException{
        if(s.equals("")){
            throw new WrongArgumentException("Значение этого поля не может быть пустным");
        }
        if(s.equalsIgnoreCase("water")){
            type = DragonType.WATER;
        }
        else if(s.equalsIgnoreCase("underground")){
            type = DragonType.UNDERGROUND;
        }
        else if(s.equalsIgnoreCase("fire")){
            type = DragonType.FIRE;
        }
        else if(s.equalsIgnoreCase("air")){
            type = DragonType.AIR;
        }
        else{
            throw new WrongArgumentException("Значение введено не верно.");
        }
    }

    /**
     * устанавливает значение поля cave
     */
    public void setCave(DragonCave cave){
        this.cave = cave;
    }

    @JsonSetter("id")
    public void setId(int id) throws WrongArgumentException{
        if(existingIds.contains(id)){
            throw new WrongArgumentException("Данный id уже занят.");
        }
        this.id = id;
        existingIds.add(id);
    }
    @Override
    public int compareTo(Object o) {
        int result = id.compareTo(((Dragon) o).getId()) + name.compareTo(((Dragon) o).getName())
                + coordinates.compareTo(((Dragon) o).getCoordinates()) + creationDate.compareTo(((Dragon)o).getCreationDate())
                + description.compareTo(((Dragon) o).getDescription()) + ((Integer)wingspan).compareTo(((Dragon) o).getWingspan()) + type.compareTo(((Dragon)o).getType());
        if(age == null){
            if(((Dragon)o).getAge() != null){
                result+=((Dragon) o).getAge();
            }
        }
        else if(((Dragon)o).getAge() != null){
            result+=age.compareTo(((Dragon) o).getAge());
        }
        if(cave == null){
            if(((Dragon)o).getCave() != null){
                result+=Math.abs(((Dragon) o).getCave().getDepth());
                if(((Dragon)o).getCave().getNumberOfTreasures() != null){
                    result+=((Dragon)o).getCave().getNumberOfTreasures();
                }
            }
        }
        if(cave!=null){
            if(((Dragon)o).getCave() != null){
                result+=cave.compareTo(((Dragon)o).getCave());
            }
            else{
                result+=Math.abs(cave.getDepth());
                if(cave.getNumberOfTreasures()!=null){
                    result+=cave.getNumberOfTreasures();
                }
            }
        }
        return result;
    }

    @Override
    public String toString(){
        return "Имя: "+ name+" ID:" + id +" Координаты: " + coordinates.toString() + " Время создания: "+date + " Возраст: " + age + " Размах крыльев: "+ wingspan+" Тип: "+ type + " Пещера: "+ cave +" Описание: " + description;
    }
}
