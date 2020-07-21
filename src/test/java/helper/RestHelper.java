/**
 * created helper class which will have functions which are called repetitively  - e.g getMethod
 *
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-07-21
 */

package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public  class RestHelper {


	public static String doGet(String baseURL, String queryParam)

	{

		RestAssured.baseURI=baseURL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get();

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();

		// To check for sub string presence get the Response body as a String.
		String bodyAsString = body.asString();
		int statusCode = response.getStatusCode();
		return bodyAsString; 
	}

	public static int getResponse(String baseURL, String queryParam)

	{
		RestAssured.baseURI=baseURL;
		RequestSpecification httpRequest = RestAssured.given();
		Response response = httpRequest.get(queryParam);

		// Retrieve the body of the Response
		ResponseBody body = response.getBody();	
		int statusCode = response.getStatusCode();
		return statusCode; 
	}

}
