package TestHTTPS;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import javax.print.attribute.standard.MediaSize;

import static io.restassured.RestAssured.given;
import static java.time.temporal.WeekFields.ISO;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

public class HeaderTest {




    @Test
    void HeaderTest(){
        
        given()
        
                .when()
                .get("https://www.google.com/")
          .then()
                .header("Content-Type","text/html; charset=ISO-8859-1")
                .and()
                .header("Server","gws")
                .log().headers();
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

    }
}

