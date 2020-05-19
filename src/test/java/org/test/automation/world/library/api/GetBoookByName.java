package org.test.automation.world.library.api;

import Utils.JsonParser;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBoookByName {

    @Test
    public void getBookUsingID(){
        String name ="Cristian Ion";

        String URI ="http://216.10.245.166/Library/GetBook.php?AuthorName="+name;
        String respose=
                given().
                        when().
                        get(URI).
                        then().assertThat().statusCode(200).log().all().extract().asString();


        JsonPath jp =  JsonParser.rawToJson(respose);
        String BookName= jp.get("[0].book_name");


        System.out.println(BookName);

    }
}
