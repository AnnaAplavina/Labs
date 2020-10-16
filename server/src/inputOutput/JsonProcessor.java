package inputOutput;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


import commands.WrongArgumentException;
import dragons.Dragon;

import java.io.IOException;
import java.util.Hashtable;

/**
 * Класс отвечает за перевод данных в json и обратно
 */
public class JsonProcessor {
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     *
     * @param jsonDragons данные о коллекции в формате json
     * @return Десериализованная коллекция
     * @throws IOException
     * @throws WrongArgumentException ошибки при неверных значениях для полей объектов
     */
    public static Hashtable<String, Dragon> readDragonCollection(String jsonDragons) throws IOException, WrongArgumentException {
        Hashtable<String, Dragon> coll;
        System.out.println(jsonDragons);
        try{
            TypeReference<Hashtable<String, Dragon>> typeReference = new TypeReference<Hashtable<String, Dragon>>() {};
            coll = mapper.readValue(jsonDragons, typeReference);
        }
        catch(JsonMappingException ex){
            ex.printStackTrace();
            throw new WrongArgumentException("Ошибка при переводе из формата json.");
        }
        return coll;
    }

    /**
     * @param coll коллеция, которую необходимо перевестти в формат json
     * @return json в виде строки
     */
    public static String writeDragonCollection(Hashtable<String, Dragon> coll){
        String result = "";
        try{
        result = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(coll);}
        catch (JsonProcessingException ex){
            System.out.println("Не удалось перевести коллекцию в Json.");
            ex.printStackTrace();
        }
        return result;
    }
}
