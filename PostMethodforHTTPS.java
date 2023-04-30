package TestHTTPS;

import data.Pojo_POSTRequest;
import io.restassured.response.ValidatableResponse;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.JSONObject;
import org.json.JSONTokener;
import  org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matcher.*;
import static org.hamcrest.Matchers.equalTo;

public class PostMethodforHTTPS {

    private java.lang.String String;
    Pojo_POSTRequest data;

   @Test

    public void testPostMehodusingHashMap(){

        HashMap data = new HashMap();
        data.put("name","Scoopy");
        data.put("job","leader");

        /*String courseArr[] = {"Java","Python"};
        data.put("course", "courseArr[]");*/
        given()
                .contentType("application/json")
                .body(data)
                .when()
                .post("https://reqres.in/api/users/")
                .then()
                .statusCode(201)
                .body("name",equalTo("Scoopy"))
                .header("Content-Type","application/json; charset=utf-8")
                .assertThat()
                .log().all();

    }

    @Test
    void testPOSTMethodusingJSONlibrary(){

        JSONObject data = new JSONObject();
         data.put("name","SIVA");
         data.put("job","Sr.SoftwareEngineer");


        given()
                .contentType("application/json")
                .body(data.toString())
         .when()
                .post("https://reqres.in/api/users/")
            .then()
                .statusCode(201)
                .body("name",equalTo("SIVA"))
                .body("job",equalTo("Sr.SoftwareEngineer"))
                .header("Content-Type","application/json; charset=utf-8")
                .assertThat()
                .log().all();
    }

       // 3. POST request using the external JSON file from the package - Data Driven API testing
  @Test
    void POSTUsingJsonFile() throws FileNotFoundException {

        // Data from the central loaction or from the class path
      // Data Driven API testing

      File f = new File(".\\body.json");
      FileReader fileReader = new FileReader(f);

      JSONTokener jsonTokener = new JSONTokener(fileReader);

      JSONObject data = new JSONObject(jsonTokener);

      given()
              .contentType("application/json")
              .body(data.toString())
              .when()
              .post("https://reqres.in/api/users/")
              .then()
              .statusCode(201)
              .body("name",equalTo("SIVA"))
              .body("job",equalTo("Sr.SoftwareEngineer"))
              .header("Content-Type","application/json; charset=utf-8")
              .assertThat()
              .log().all();
  }
  }

