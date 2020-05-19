package org.test.automation.world.jira.api;

import io.restassured.RestAssured;
import io.restassured.filter.session.SessionFilter;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.RestAssured.given;

public class JiraTestsApi {
    SessionFilter session = new SessionFilter();

    @Test(priority = 0)
    public void login(){

        String response=
        given().
                header("Content-Type","application/json").log().all().
                body("{ \"username\": \"cristi.ion21\", \"password\": \"12341234\" }").
        filter(session).
        when().
                post("http://localhost:8080/rest/auth/1/session").
        then().
                log().all().extract().response().asString();
    }



    @Test(priority = 1)
    public void addComment(){
        RestAssured.baseURI="http://localhost:8080";

        given().
                pathParam("id","10100").
                header("Content-Type","application/json")
                .body("{\n" +
                        "    \"body\": \"Adding comment from Restful API the last one\",\n" +
                        "    \"visibility\": {\n" +
                        "        \"type\": \"role\",\n" +
                        "        \"value\": \"Administrators\"\n" +
                        "    }\n" +
                        "}").filter(session).
        when().
                post("/rest/api/2/issue/{id}/comment").
        then().assertThat().statusCode(201);
    }

    @Test(priority = 2)
    public void addAttachement(){

        given().
                header("X-Atlassian-Token","no-check").
                filter(session).
                pathParam("id","10100").
                header("Content-type","multipart/form-data").
                multiPart("file",new File("C:\\Test_Automation\\src\\test\\java\\__Files\\Jira.txt")).
        when().
                post("/rest/api/2/issue/{id}/attachments").
        then().
                log().all().assertThat().statusCode(200);

    }


}
