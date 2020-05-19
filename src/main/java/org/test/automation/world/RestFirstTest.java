package org.test.automation.world;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestFirstTest {

    @Test
    public void createBooking(){
        RestAssured.baseURI="https://restful-booker.herokuapp.com";
        given().header("Content-Type","application/json").
                log().all().
                body("{\n" +
                        "    \"firstname\" : \"Cristi\",\n" +
                        "    \"lastname\" : \"Ion\",\n" +
                        "    \"totalprice\" : 120,\n" +
                        "    \"depositpaid\" : true,\n" +
                        "    \"bookingdates\" : {\n" +
                        "        \"checkin\" : \"2020-05-30\",\n" +
                        "        \"checkout\" : \"2020-06-08\"\n" +
                        "    },\n" +
                        "    \"additionalneeds\" : \"Breakfast\"\n" +
                        "}").
                when().post("/booking").
                then().log().all().assertThat().statusCode(200)./*body("bookingid" ,equalTo("16")).*/
        header("Server","Cowboy");
    }
}
