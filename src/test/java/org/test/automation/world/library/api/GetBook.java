package org.test.automation.world.library.api;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetBook {

    @Test
    public void getBookUsingID(){
        String ID="cris187";

        String URI ="http://216.10.245.166/Library/GetBook.php?ID="+ID;
        String respose=
        given().
        when().
                get(URI).
        then().assertThat().statusCode(200).log().all().extract().asString();

        System.out.println(respose);
    }
}
