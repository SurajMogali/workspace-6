package reqresApiExamples;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TCPutMethod {
    String putURL = "https://reqres.in/api/users";

    @Test
    public void TCPut() {
        JSONObject json = new JSONObject();
        json.put("name","Yatin");
        json.put("job","Quality Engineer");
        System.out.println(json.toJSONString());

        given().
                header("Content-Type", "application/json; charset=utf-8").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(json.toJSONString()).
        when().
                put(putURL).
        then().
                statusCode(200).
                log().
                all();
    }
}
