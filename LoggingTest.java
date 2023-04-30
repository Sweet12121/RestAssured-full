package TestHTTPS;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class LoggingTest {

    @Test
    void loggingTest(){

        given()

                .when()
                .get("https://reqres.in/api/users?page=2&id=5")
           .then()
                .log().headers()
              //  .log().cookies()
              //  .log().body()
                //.log().ifStatusCodeIsEqualTo(200)
                //.log().all()
        ;
    }
}
