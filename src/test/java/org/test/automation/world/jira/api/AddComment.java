package org.test.automation.world.jira.api;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.given;

public class AddComment {
    public static void main(String[] args) {
        RestAssured.baseURI="http://localhost:8080";

        given().
                pathParam("id","10010").
                header("Content-Type","application/json").header("Cookie","JSESSIONID=AC5843DDEFE8CE405AC44DE17E0EF54A")
                .body("{\n" +
                        "    \"body\": \"Adding comment from Restful API\",\n" +
                        "    \"visibility\": {\n" +
                        "        \"type\": \"role\",\n" +
                        "        \"value\": \"Administrators\"\n" +
                        "    }\n" +
                        "}").
        when().
                post("/rest/api/2/issue/{id}}/comment").
        then().assertThat().statusCode(201);
    }
}
