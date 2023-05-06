package TestHTTPS;

import static io.restassured.RestAssured.given;
import org.junit.jupiter.api.Test;

public class TestHttpRequest {


    @Test
    void getUser(){

        given()
                .contentType("application/json")
                .when()
                .get("https://reqres.in/api/users/2")

                .then()
                .statusCode(200)
                .log().all();

    }
}
