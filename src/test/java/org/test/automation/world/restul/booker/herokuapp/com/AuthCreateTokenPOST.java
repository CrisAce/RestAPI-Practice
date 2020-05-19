package org.test.automation.world.restul.booker.herokuapp.com;

import Utils.JsonParser;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.Test;
import Utils.PayLoads;

import static io.restassured.RestAssured.given;

public class AuthCreateTokenPOST {
   static String tokenID;
    @Test
    public  void createToken(){
        String URI="https://restful-booker.herokuapp.com";

        RestAssured.baseURI=URI;
        String response =
        given().
                header("Content-Type","application/json").
                body(PayLoads.authCreateTokenPOSTPayLoad()).
        when().
                post("/auth").
        then().
                assertThat().statusCode(200).
                extract().response().asString();

        System.out.println(response);
        JsonPath js = JsonParser.rawToJson(response);
        tokenID =js.get("token");
        System.out.println(tokenID);


        //de768b404bbfa6d
        //237b444272694ca
    }

    public static String getToken(){
        return tokenID;
    }


}
