package org.test.automation.world.library.api;

import Utils.JsonParser;
import Utils.PayLoads;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DeleteBook {

    @Test
    public void deleteBook(){

        RestAssured.baseURI="http://216.10.245.166";
        String respone=
                given().
                        queryParam("Content-Type","application/json").
                        body(PayLoads.deleteBookPayLoad()).
                when().
                        post("/Library/DeleteBook.php").
                then().
                        assertThat().statusCode(200).log().all().extract().response().toString();

        JsonPath jp = JsonParser.rawToJson(respone);
        String id =jp.get("msg");
        System.out.println(id);

    }
}
