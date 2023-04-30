package TestHTTPS;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ParsingJSONResponseData {

    @Test
    void testJSONResponse() {

        given()
                .contentType("application/json; charset=utf-8")


                .when()
                .get("https://reqres.in/api/users?page=2&id=5")
                .then()
                .statusCode(200)
                .header("Content-Type", "application/json; charset=utf-8")
                //.body("name",equalTo("Eswari"))
                .body("data.first_name", equalTo("Charles"))
                .body("data.last_name", equalTo("Morris"))
        //.log().all()
        ;
    }

    @Test(priority = 2)
    void getJSONResponse() {

        Response response = given()
                .contentType("application/json; charset=utf-8")
             .when()
                .get("https://reqres.in/api/users?page=2&id=5");

        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.header("Content-Type"), "application/json; charset=utf-8");

        String firstName = response.jsonPath().get("data.first_name").toString();
        Assert.assertEquals(firstName, "Charles");
        System.out.println(firstName);

    }
  // @Test(priority = 2)
    void getJSONArrayRespose() {

        Response response = given()
                .contentType(ContentType.JSON)

                .when()
                   .get("https://reqres.in/api/users?page=2&id=5");
        //JSONObject class

       // JSONObject jsonObject = new JSONObject(response.toString());  // converting response to JSON object type

      //  Assert.assertEquals(response.getBody().equals());
       /* //for (int i=0;i< jsonObject.length();i++)
        for (int i = 0; i < jsonObject.getJSONArray("users").length(); i++) {
            String firstName = jsonObject.getJSONArray("users").getJSONObject(i).get("first_name").toString();
            System.out.println(firstName);
            // jsonObject.get("name").equals("Charles");
        }*/
    }

}
