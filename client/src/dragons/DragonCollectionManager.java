package dragons;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import commands.WrongArgumentException;
import inputOutput.InputOutputManager;
import inputOutput.JsonProcessor;

/**
 * Класс управляет коллекция Hastable<String, Dragon>
 */
public class DragonCollectionManager{
    private Hashtable<String, Dragon> coll;
    private String iniTime;
    private String type = "Hashtable";

    /**
     * Конструктор создаёт коллекцию и заполняет её значениями из файла
     * @param file имя файла, с данными, которые нужно загрузить в коллекцию
     * @throws IOException ошибки ввода/вывода
     * @throws WrongArgumentException ошибки при вводе неверных значений
     */
    public DragonCollectionManager(String file) throws IOException, WrongArgumentException {
        coll = JsonProcessor.readDragonCollection(InputOutputManager.readFile(file));
        LocalDateTime time = LocalDateTime.now();
        iniTime = time.getDayOfMonth()+ "" + time.getMonth().getValue()+ "." + time.getYear() + " " + time.getHour() + ":" + time.getMinute();
        System.out.println("Данные из файла загружены в коллекцию.");
    }

    /**
     * метод нужен для реализации команды show
     * @return элементы поллекции в строковом представлении или строчка "Коллекция пустая", если коллекция пустая
     */
    public String showDragons(){
        if(coll.size()!=0){
            String info = "";
            for(Map.Entry<String,Dragon> pair: coll.entrySet()){
                info+=pair.getValue().toString()+"\n";
            }
            return info;}
        else{
            return "Коллекция пустая.";
        }
    }

    /**
     *проверяет занят ли данный ключ
     */
    public boolean checkKey(String key){
        Set<String> keySet = coll.keySet();
        if(keySet.contains(key)){
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * возвращает ссыку на коллекцию, которой управляет
     */
    public Hashtable<String, Dragon> getColl() {
        return coll;
    }

    /**
     * Очищает коллекцию
     */
    public void clearCollection(){
        coll = new Hashtable<String, Dragon>();
    }

    /**
     * Добавляет в коллекцию новую пару ключ значение
     */
    public void addDragon(String key, Dragon dragon){
        coll.put(key,dragon);
    }

    /**
     *
     * удаляет значение из коллекции по ключу
     */
    public void deleteDragon(String key){
        coll.remove(key);
    }

    /**
     * возвращает значение из коллекции по ключу
     */
    public Dragon getDragon(String key){
        return coll.get(key);
    }

    /**
     * возвращает пару ключ значение по ключу
     */
    public Map.Entry<String,Dragon> getCollElementById(String id) throws WrongArgumentException{
        int inputId;
        try{
            inputId = Integer.parseInt(id);
        }
        catch (NumberFormatException ex){
            throw new WrongArgumentException("Id должен быть целым числом.");
        }
        for(Map.Entry<String,Dragon> pair: coll.entrySet()){
            if(pair.getValue().getId() == inputId){
                return pair;
            }
        }
        return null;
    }

    /**
     * удаляет из коллекции элементы, ключ которых меньше заданного
     */
    public void removeLowerKey(String key){
        for(Map.Entry<String,Dragon> pair: coll.entrySet()){
            if(pair.getKey().compareTo(key)<0){
                coll.remove(key);
            }
        }
    }

    /**
     *
     * @return коллеция значение
     */
    public Collection<Dragon> getEntrySet(){
        return coll.values();
    }

    /**
     *
     * @return среднее значение поля age у значений в коллекции
     */
    public int getAvaregreAge(){
        int result = 0;
        if(coll.size() == 0){
            return -2;
        }
        ArrayList<Integer> ages = new ArrayList<>();
        for(Map.Entry<String,Dragon> pair: coll.entrySet()){
            if(pair.getValue().getAge()!=null){
                ages.add(pair.getValue().getAge());
            }
        }
        if(ages.size()!=0){
            for(int age: ages){
                result += age;
            }
            result = result/ages.size();
        }
        else {
            result = -1;
        }
        return result;
    }

    /**
     * @return время инициализации в виде строки
     */
    public String getIniTime(){
        return iniTime;
    }

    /**
     *
     * @return поле type
     */
    public String getType(){
        return type;
    }

    /**
     *
     * @return количество элементов  в коллеции
     */
    public int getNumOfElements(){
        return coll.size();
    }
}

