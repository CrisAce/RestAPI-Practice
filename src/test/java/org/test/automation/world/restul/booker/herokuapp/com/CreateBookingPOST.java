package org.test.automation.world.restul.booker.herokuapp.com;

import Utils.JsonParser;
import Utils.PayLoads;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;


import static io.restassured.RestAssured.given;

public class CreateBookingPOST {

    private static RequestSpecification requestSpecification;
    private static ResponseSpecification responseSpecification;


    @BeforeClass
    public static void createRequestSpecification(){

        requestSpecification = new RequestSpecBuilder().
        setBaseUri("https://restful-booker.herokuapp.com").
                addHeader("Content-Type","application/json").
                build();
    }

    @BeforeClass
    public static void createResponseSpecification(){

        responseSpecification = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();

    }



    @Test(priority = 1)
    public void createBooking(){

        //RestAssured.baseURI="https://restful-booker.herokuapp.com";

        String response=
                given().
                        spec(requestSpecification).
                        body(PayLoads.createBookingPayLoad()).
                when().
                        post("/booking").
                then().
                        spec(responseSpecification).
        assertThat().body("booking.additionalneeds", equalTo("Breakfast")).statusCode(200).log().all()
        .extract().response().asString();

                System.out.println(response);
        JsonPath js =JsonParser.rawToJson(response);
        String checkout = js.get("booking.bookingdates.checkout");
        int bookingid =js.get("bookingid");

        System.out.println(checkout);
        System.out.println(bookingid);

    }


}
