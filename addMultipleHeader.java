package TestHTTPS;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class addMultipleHeader {

    @Test
    public void addMultipleHeader() {
        String baseUrl =
                "https://api.reverb.com/api/articles?page=1&per_page=24";

        //input details with multiple headers
        RequestSpecification r = RestAssured.given()
                .header("Accept", "application/hal+json")
                .header("Content-Type", "application/json")
                .header("Accept-Version", "3.0");

        //obtain get Response
        Response res = r.get(baseUrl);

        //get status code
        int c = res.getStatusCode();
        System.out.println(c);
    }
}
