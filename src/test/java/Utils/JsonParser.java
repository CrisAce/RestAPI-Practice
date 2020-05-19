package Utils;

import io.restassured.path.json.JsonPath;

public class JsonParser {

    public static JsonPath rawToJson(String text){
        JsonPath jp = new JsonPath(text);

        return  jp;


    }
}
