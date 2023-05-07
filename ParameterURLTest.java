package TestHTTPS;

import com.beust.jcommander.Parameter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.URI;

import static io.restassured.RestAssured.given;

public class ParameterURLTest {



    @Parameters({"Url"})

@Test
    public void parameterUrl(String Url){

        given()
                .contentType("application/json")
                .when()
                .get(Url)
                .then().log().all();
    }
}
