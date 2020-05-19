package org.test.automation.world.restul.booker.herokuapp.com;

import org.testng.annotations.Test;
import Utils.PayLoads;

import static io.restassured.RestAssured.given;

public class UpdateBookingPUT {

    @Test
    public void updateBookingPUT(){
        String URI ="https://restful-booker.herokuapp.com/booking/1";
        given().
                header("Content-Type","application/json").
                header("Accept","application/json").
                header("Cookie","token=dd3cf98042712cc").
                body(PayLoads.updateBookingPUTPayLoad()).
        when().
                put(URI).
        then().
                statusCode(200).log().all();

    }


}
