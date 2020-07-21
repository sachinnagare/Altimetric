package testcases;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Trial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		 // Specify the base URL to the RESTful web service
		 RestAssured.baseURI = "https://postman-echo.com/get?foo1=bar1&foo2=bar2";
		 
		 // Get the RequestSpecification of the request that you want to sent
		 // to the server. The server is specified by the BaseURI that we have
		 // specified in the above step.
		 RequestSpecification httpRequest = RestAssured.given();
		 
		 // Make a GET request call directly by using RequestSpecification.get() method.
		 // Make sure you specify the resource name.
		 Response response = httpRequest.get();
		 
		 // Response.asString method will directly return the content of the body
		 // as String.
		 System.out.println("Response Body is =>  " + response.asString());
		 
	
		 
		 // Get the status code from the Response. In case of 
		 // a successfull interaction with the web service, we
		 // should get a status code of 200.
		 int statusCode = response.getStatusCode();
		 System.out.println("status code: "+statusCode);
		 
		 // Assert that correct status code is returned.
		 Assert.assertEquals(statusCode /*actual value*/, 200 /*expected value*/, "Correct status code returned");

	}

}
