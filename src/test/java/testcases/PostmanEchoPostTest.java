package testcases;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.* ;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

public class PostmanEchoPostTest {
	@Test
	public void postValidationTest()
	{
		JSONObject request=new JSONObject();
		request.put("foo1", "bar1");
		request.put("foo2", "bar2");
		System.out.println(request);

		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(request.toJSONString()).
		
		when().
		post("https://postman-echo.com/post").
		then().
		statusCode(200);
	}
	
	
}
