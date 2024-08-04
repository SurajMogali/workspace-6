package fakeAPI;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class fakeAPIExamples {
    private static int idReturned;
    @BeforeTest
    public void before() {
        baseURI = "http://localhost:3000/";
    }

    @Test(priority = 0)
    public void test_get01() {

        given().
                get("/users").
                then().
                statusCode(200).
                log().all();
    }

    @Test (priority = 1)
    public void test_get02() {

        given().
                param("name","Automation").
        when().
                get("/subjects").
        then().
                statusCode(200).
                log().all();
    }

    @Test (priority = 2)
    public void test_post01() {

        JSONObject json = new JSONObject();
        json.put("firstName","Sixth");
        json.put("secondName","Six");
        json.put("subjectId","2");

        Response response = given()
                .header("Content-type", "application/json")
                .and()
                .body(json.toJSONString())
                .when()
                .post("/users")
                .then()
                .extract().response();

        idReturned = response.jsonPath().get("id");

    }

    @Test(priority = 3)
    public void test_put01() {

        JSONObject json = new JSONObject();

        json.put("firstName","First");
        json.put("secondName","One");
        json.put("subjectId","1");

        given().
                header("Content-Type", "application/json; charset=utf-8").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(json.toJSONString()).
                when().
                put("/users/30").
                then().statusCode(200).
                log().all();
    }

    @Test(priority = 4)
    public void test_patch01() {

        JSONObject json = new JSONObject();
        json.put("subjectId","3");

        given().
                header("Content-Type", "application/json; charset=utf-8").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(json.toJSONString()).
                when().
                patch("/users/30").
                then().statusCode(200).
                log().all();
    }

    @Test(priority = 5)
    public void test_delete01() {
        System.out.println(idReturned);
        given().
                header("Content-Type", "application/json; charset=utf-8").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                delete("/users/" + idReturned).
                then().statusCode(200).
                log().all();
    }

    String deleteURL = "https://reqres.in/api/users/29";
    @Test(priority = 6)
    public void TCDelete() {

        given().
                header("Content-Type", "application/json; charset=utf-8").
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                when().
                delete(deleteURL).
                then().statusCode(204).
                log().all();
    }
}
