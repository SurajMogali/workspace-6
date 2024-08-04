package reqresApi2;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Exercise1 {
	String getURL = "https://reqres.in/api/unknown";
	@Test
	public void getNumberOfId() {
		
		Response response = RestAssured.get(getURL).then().statusCode(200).body("data.id.size", equalTo(6)).extract()
				.response();
		System.out.println(response.jsonPath().getString("data.id.size"));
		
	}

	@Test
	public void getPantOneValue_TC03() {
		
		Response response = RestAssured.get(getURL).then().statusCode(200)
				.body("data.pantone_value", hasItems("15-4020", "17-2031", "19-1664", "14-4811", "17-1456", "15-5217"))
				.extract().response();
		System.out.println(response.jsonPath().getString("data.pantone_value"));
		
	}

	

//    2.Get the name attribute  where the corresponding “color” is matching to #BF1932

	@Test
	public void getColorValue_TC03() {
		
		Response response = RestAssured.get(getURL).then().statusCode(200)
				.body("data.find{it.color=='#BF1932'}.name", equalTo("true red")).extract().response();
		System.out.println(response.jsonPath().getString("data.find{it.color=='#BF1932'}.name"));
		
	}
}