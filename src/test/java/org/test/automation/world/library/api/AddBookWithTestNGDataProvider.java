package org.test.automation.world.library.api;

import Utils.PayLoads;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;

public class AddBookWithTestNGDataProvider {


    @Test(dataProvider = "AddBookFeed")
    public void addBook(String isbn, String aisle) throws IOException {
        RestAssured.baseURI = "http://216.10.245.166";
        given().
                contentType(ContentType.JSON).
                body(PayLoads.addBookPayLoad(isbn,aisle)).
                when().
                post("/Library/Addbook.php").
                then().
                assertThat().statusCode(200).log().all().extract().response();


    }

    @DataProvider(name = "AddBookFeed")
    public static Object[][] getData() {

        return new Object[][]{{"piti", "6753"}, {"ffer", "0003"}, {"qwep", "1121"}};

    }
}