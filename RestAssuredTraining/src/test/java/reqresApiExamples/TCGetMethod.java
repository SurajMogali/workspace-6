package reqresApiExamples;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class TCGetMethod {
    String getURL = "https://reqres.in/api/users?page=2";

    @Test
    void getMethod_TC01() {
         RestAssured.
                get(getURL).
                then().
                header("Content-Type", "application/json; charset=utf-8").
                statusCode(200).
                body("data.id[1]", equalTo(8)).
                body("data.first_name", hasItems("Michael","Lindsay","Tobias","Byron","George","Rachel")).
                log().all();
    }
}
