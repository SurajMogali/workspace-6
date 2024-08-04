package dataDriven;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class dataDrivenExamples extends dataForTests{

    @Test(dataProvider = "dataProviderInput1",priority = 0)
    public void test_post01(String firstName, String secondName, int subjectId) {
        baseURI = "http://localhost:3000/";

        JSONObject json = new JSONObject();
        json.put("firstName",firstName);
        json.put("secondName",secondName);
        json.put("subjectId",subjectId);
        System.out.println(json.toJSONString());

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(json.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().
                all();
    }

    @Test(dataProvider = "dataProviderInput2",priority = 1)
    public void test_post02(String firstName, String secondName, int subjectId) {
        baseURI = "http://localhost:3000/";

        JSONObject json = new JSONObject();
        json.put("firstName",firstName);
        json.put("secondName",secondName);
        json.put("subjectId",subjectId);

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(json.toJSONString()).
                when().
                post("/users").
                then().
                statusCode(201).
                log().
                all();
    }

    @Test(dataProvider = "dataProviderDelete",priority = 2)
    public void test_delete01(int userId) {
        baseURI = "http://localhost:3000/";

        given().
                header("Content-Type", "application/json").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                delete("/users/" + userId).
                then().
                statusCode(200).
                log().
                all();
    }
}
