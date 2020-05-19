package org.test.automation.world.restul.booker.herokuapp.com;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class BookingByNameGET {

    @Test
    public void getBookingByName(){

      String URL ="https://restful-booker.herokuapp.com/booking";
      String resp=
         given().
              queryParam("firstname","Catalina").queryParam("lastname","Ion").

         when().
              get(URL).
         then().
                 assertThat().
                 statusCode(200).

                 header("Server","Cowboy").log().all().extract().response().toString();
      System.out.println(resp);
    }
}
