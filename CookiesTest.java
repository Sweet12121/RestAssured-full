package TestHTTPS;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class CookiesTest {

    @Test
    void  testCookies(){

        given()

                .when()
                .get("https://www.google.com/")
                .then()
                .statusCode(200)
                .log().cookies()
                .log().all();

    }

    @Test
    void getCookiesInfo(){

        Response response = given()
                .when()
                .get("https://www.google.com/");

        // Single cookie info
        /*String cookie_value = response.getCookie("AEC");
        System.out.println("Value of the cookies  :" +cookie_value);
*/
        // get all cookies info

        Map<String,String> cookies_values = response.getCookies();
       // System.out.println(cookies_values.keySet());
       // System.out.println(cookies_values.containsKey("AEC"));
   // to get the cookie name and value in the map

        for (String k:cookies_values.keySet())
        {
            String cookie_value = response.getCookie(k);
            System.out.println(k+"           "+cookie_value);
        }

    }

}
