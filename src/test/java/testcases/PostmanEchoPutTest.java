package testcases;

import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class PostmanEchoPutTest {
	@Test
	public void putValidationTest()
	{
		JSONObject request=new JSONObject();
		request.put("foo1", "bar1");
		request.put("foo2", "bar2");
		request.put("foo3", "bar3");
		System.out.println(request);

		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		
		when().
		put("https://postman-echo.com/put").
		then().
		statusCode(200);
	}

}
