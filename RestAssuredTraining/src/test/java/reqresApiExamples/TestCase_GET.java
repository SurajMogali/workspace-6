package reqresApiExamples;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;

public class TestCase_GET {

    String getURL = "https://reqres.in/api/users?page=2";

    @Test
    public void getMethod_TC01() {
        Response response = RestAssured.get(getURL);

        System.out.println(response.asString());
        System.out.println(response.getBody().asString());
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());
        System.out.println(response.getHeader("content-type"));
        System.out.println(response.getTime());

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
    }

    @Test
    public void getMethod_TC02() {
        RestAssured
                .get(getURL)
                .then()
                .statusCode(200)
                .body("data.id[2]", equalTo(9) ).statusLine("HTTP/1.1 200 OK");
    }
}
