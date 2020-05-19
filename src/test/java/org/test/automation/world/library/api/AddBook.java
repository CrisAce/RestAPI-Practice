package org.test.automation.world.library.api;

import Utils.GenerateStringFromResource;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AddBook {


    @Test
    public void addBook() throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";
        given().
                contentType(ContentType.JSON).
                body(GenerateStringFromResource.generateStringFromResource("C:\\Test_Automation\\src\\test\\java\\__Files\\AddBookDetails.json")).
                when().
                post("/Library/Addbook.php").
                then().
                    assertThat().statusCode(200).log().all().extract().response();


    }
}
