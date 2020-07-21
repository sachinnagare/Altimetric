/**
 * created test cases class to validate the functionality
 *
 * @author  Sachin Nagare
 * @version 1.0
 * @since   2020-07-21
 */

package testcases;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.RestHelper;
import utility.ExcelUtility;

public class PostmanEchoGetTest {


	//private static final String "excelPath" = null;

	@Parameters({"excelPath","sheetName"})
	@Test
	public void getResponseBodyValidate(String excelPath,String sheetName) {

		ExcelUtility objExcel=new ExcelUtility(excelPath, sheetName);

		String baseURL=	 ExcelUtility.getCellData(1, 0);
		String queryParam=  ExcelUtility.getCellData(1, 1);

		String bodyAsString =  RestHelper.doGet(baseURL,queryParam);

		int statusCode = RestHelper.getResponse(baseURL, queryParam);

		System.out.println("response body : "+bodyAsString);


		Assert.assertEquals(statusCode, 200, "Response code validation for get method");
	}

	@Parameters({"excelPath","sheetName"})
	@Test
	public void validateNotMatchingContent(String excelPath,String sheetName) {

		ExcelUtility objExcel=new ExcelUtility(excelPath, sheetName);

		String baseURL=	 ExcelUtility.getCellData(1, 0);
		String city=  ExcelUtility.getCellData(1, 1);

		String bodyAsString =  RestHelper.doGet(baseURL,city);
		System.out.println("response body : "+bodyAsString);
		// convert the body into lower case and then do a comparison to ignore casing.

		//get("https://reqres.in/api/users?page=2").then().statusCode(200);
		get(baseURL).then().statusCode(200);

		get(baseURL).then().body("headers.x-forwarded-port", equalTo("443"));


	}
}
