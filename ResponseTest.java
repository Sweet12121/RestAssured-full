package TestHTTPS;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;

public class ResponseTest {

    @Test
    void getResponse(){

        Response response = given()
                .when().get("https://reqres.in/api/users/2");


        response.getHeaders();
        response.getCookies();
        response.getBody();
        response.getTimeIn(TimeUnit.SECONDS);

        System.out.println("The Response >>>>>>>>>: "+response.getHeaders());
        System.out.println("The ResponseBODY >>>>>>>>>: "+response.getBody());
        System.out.println("The Response COOKIES >>>>>>>>>: "+response.getCookies());
        System.out.println("The Response >>>>>>>>>: "+response.getTimeIn(TimeUnit.SECONDS));

    }

    @Test(priority = 2)
    void getHeaders(){

        Response response = given()
                .when()
                .get("https://www.google.com/");

        //Get single header info

        String headerValue = response.getHeader("Content-Type");
        System.out.println("The value of the Content Type is : "+headerValue);

        // get all headers info

        Headers myheaders = response.getHeaders();

        for(Header hd:myheaders){
            System.out.println(hd.getName()+"       "+hd.getValue());
        }

    }}
