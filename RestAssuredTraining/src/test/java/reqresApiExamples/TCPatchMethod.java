package reqresApiExamples;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TCPatchMethod {
    String patchURL = "https://reqres.in/api/users";
    @Test
    public void TCPatch() {

        JSONObject json = new JSONObject();
        json.put("name","Yatin");
        json.put("job","Employee");
        System.out.println(json.toJSONString());

        given().
                header("Content-Type", "application/json; charset=utf-8").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(json.toJSONString()).
                when().
                patch(patchURL).
                then().statusCode(200).
                log().all();
    }
}
