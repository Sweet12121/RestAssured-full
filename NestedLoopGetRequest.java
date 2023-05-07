package TestHTTPS;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class NestedLoopGetRequest {

    @Test
    public void getRequest() {

        //base URL
        RestAssured.baseURI = "https://run.mocky.io/v3";
        RestAssured.basePath =
                "/23ab8486-7d8d-41e4-be27-d603c767d745";

        //response from GET request
        given()
                .when().get().prettyPrint();

        //extract values from Response
        String name = given().contentType(ContentType.JSON).get()
                .then().extract().path("name");
        System.out.println(name);
        String age = given().contentType(ContentType.JSON).get()
                .then().extract().path("age");
        System.out.println(age);

        //extract values from a nested list in Response
        ArrayList<String> s = given().contentType(ContentType.JSON).get()
                .then().extract().path("subjects");
        for(String subject: s) {
            System.out.println(subject);
        }
    }
}
