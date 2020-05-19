package org.test.automation.world.restul.booker.herokuapp.com;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingByIdGET {

    @Test
    public void getBookingById(){
        int i =11;
        String URI = "https://restful-booker.herokuapp.com/booking/"+ i;

        String response=
                given().

                        when().
                        get(URI).
                        then().
                        assertThat().log().all().statusCode(200).
                        header("Server","Cowboy").extract().response().asString();

        System.out.println(response);
    }
}
