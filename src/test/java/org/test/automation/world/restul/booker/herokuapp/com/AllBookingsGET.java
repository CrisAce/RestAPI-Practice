package org.test.automation.world.restul.booker.herokuapp.com;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AllBookingsGET {

    @Test
    public void getAllBookings(){

        String URI = "https://restful-booker.herokuapp.com/booking" ;


        given().

        when().
                get(URI).

        then().
                assertThat().statusCode(200).header("Server","Cowboy").log().all();
    }
}
