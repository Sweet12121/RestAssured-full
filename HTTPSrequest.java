package TestHTTPS;

import io.restassured.specification.Argument;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class HTTPSrequest {

    Object id = null;

    @Test(priority = 1)
    void getUser() {
        given()

                .when()
                .get("https://reqres.in/api/users/2")

                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    void getUserswithpage2(){

        given()
                .param("page",'2')

                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200)
                .body("page", equalTo(2))
                .log().all();
    }



    @Test(priority = 2)
    void createUser() {
        HashMap data = new HashMap<>();
        data.put("name", "Eswari");
        data.put("Job", "looking for ");
        Object id;
        id = given()
                .contentType("application/json")
                .body(data)

                .when()
                .post("https://reqres.in/api/users/")

                .then()
                .statusCode(201)
                .log().all();
    }

    @Test(priority = 3, dependsOnMethods = {"createUser"})
    void updateUser() {

        HashMap data = new HashMap<>();
        data.put("name", "Eswari");
        data.put("Job", "Sucess");
        Object id = null;
        given()
                .contentType("application/json")
                .body(data)
                .when()
                .put("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test(priority = 4, dependsOnMethods = {"createUser"})
    void deleteUser() {
        given()
                .when()
                .delete("https://reqres.in/api/users/" + id)
                .then()
                .statusCode(204)
           //     .statusCode(200)
                .assertThat()
                .log().all();
    }
}