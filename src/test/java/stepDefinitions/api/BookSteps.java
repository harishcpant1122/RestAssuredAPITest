package stepDefinitions.api;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.util.Random;

import org.json.simple.JSONObject;
import api.builders.APIBuilder;
import core.common.GetLogger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BookSteps extends APICommon  {

	RequestSpecification request;
	Response apiResponse;

	APIBuilder apiBuilder=new APIBuilder("Book");
	String baseUrl=APICommon.getBaseUrl("BookAPIBaseURL");
	
	JSONObject testDataParameters;
	JSONObject testDataHeaders;
	JSONObject testDataPayload;
	
	String bookId=null;
		
	@Given("Create an add book request with {string}")
	public void create_an_add_book_request_with(String scenario) {	
		
		Random random = new Random(System.nanoTime());
		int randomInt = random.nextInt(10000);
		testDataPayload=apiBuilder.getPayload(scenario);
		testDataPayload.replace("aisle", "111", randomInt);
		
		request=given()
				.relaxedHTTPSValidation()
				.baseUri(baseUrl)
				.body(testDataPayload);
	}
	
	@When("I call Book {string} with {string} http request")
	public void i_call_Book_with_http_request(String infoUrl, String httpMethod) {
		apiResponse=callAPI(request,infoUrl,httpMethod);
	}
	
	@Then("Book API call got success with status code {string}")
	public void book_API_call_got_success_with_status_code(String statusCode) {
		assertEquals(apiResponse.getStatusCode(),Integer.parseInt(statusCode));	
	}

	@Then("Book API {string} in response body is {string}")
	public void book_API_in_response_body_is(String key, String value) {
		bookId=getJasonPath(apiResponse,"ID");
		GetLogger.logger.info("bookId is : "+ bookId);
		assertEqualsCustom(value,getJasonPath(apiResponse,key));
	}
}
