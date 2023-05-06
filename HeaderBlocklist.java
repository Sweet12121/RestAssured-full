package TestHTTPS;

import io.restassured.RestAssured;
import io.restassured.config.LogConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class HeaderBlocklist {

 @Test
   void headerBlocklist() {

     given().config(RestAssured.config().logConfig(LogConfig.logConfig().blacklistHeader("Accept", "set-cookie")))
             .log().headers()
             .when().get("https://reqres.in/api/users/")
             .then().log().headers();


 }
              @Test
                      void headersBlocklist2()
              {
     ArrayList<String> headers = new ArrayList<String>();
       headers.add("Accept");
       headers.add("set-cookie");

               given().config(RestAssured.config().logConfig(LogConfig.logConfig().blacklistHeader("Accept","set-cookie")))

                      .log().headers()
                       .when().get("https://reqres.in/api/users/")
                      .then().log().headers();


}
}