package stepDefinitions.api;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import org.json.simple.JSONObject;
import api.builders.APIBuilder;
import core.common.GetLogger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PlaceSteps extends APICommon  
{
		RequestSpecification request;
		Response apiResponse;
				
		APIBuilder apiBuilder=new APIBuilder("Place");
		String baseUrl=APICommon.getBaseUrl("PlaceAPIBaseURL");

		JSONObject testDataParameters;
		JSONObject testDataHeaders;
		JSONObject testDataPayload;
		
		
		String placeId=null;
		//------------------Post API Calls -------------------
		
		@Given("Create an add place request with {string}")
		public void create_an_add_place_request_with(String scenario) {
			testDataPayload=apiBuilder.getPayload(scenario);
			testDataHeaders=apiBuilder.getHeaders(scenario);
			request=given()
					.baseUri(baseUrl)
					.headers(testDataHeaders)
					.body(testDataPayload);
		}

		// ------------------Get API calls -------------------
		
		@When("Verify the {string} field value as {string} when user calls the {string} for {string}")
		public void verify_the_field_value_as_when_user_calls_the_for(String key, String value, String infoUrl, String scenario) {
			testDataParameters= apiBuilder.getParams(scenario);
			request=given()
					.baseUri(baseUrl)
					.params(testDataParameters)
					.queryParam("place_id", placeId);					
			i_call_Place_with_http_request(infoUrl,"GET");	
			assertEqualsCustom(value,getJasonPath(apiResponse,key));			
		}
		
		// ------------------Update API calls -------------------
		
		@When("Create an update place request with {string}")
		public void create_an_update_place_request_with(String scenario) {
			testDataPayload=apiBuilder.getPayload(scenario);			
			testDataPayload.replace("place_id", "a4eb0c8e2acf1509887cc53dcf595bda", placeId);
			request=given()
					.baseUri(baseUrl)
					.body(testDataPayload);
		}
		
		//------------------Common--------------------------
		
		@When("I call Place {string} with {string} http request")
		public void i_call_Place_with_http_request(String infoUrl, String httpMethod) {
			apiResponse=callAPI(request,infoUrl,httpMethod);
		}
		
		@Then("Place API {string} in response body is {string}")
		public void place_API_in_response_body_is(String key, String value) {
			if (placeId == null)
			{
				placeId=getJasonPath(apiResponse,"place_id");
				GetLogger.logger.info("placeId is : "+ placeId);
			}
			assertEqualsCustom(value,getJasonPath(apiResponse,key));
		}
		
		@Then("Place API call got success with status code {string}")
		public void place_API_call_got_success_with_status_code(String statusCode) {
			assertEquals(apiResponse.getStatusCode(),Integer.parseInt(statusCode));	
		}
		




}
