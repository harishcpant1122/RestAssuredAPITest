package stepDefinitions.api;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import org.json.simple.JSONObject;
import api.builders.PlaceBuilder;
import core.common.GetLogger;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class PlaceSteps extends apiCommon  
{
		RequestSpecification request;
		Response apiResponse;
		String placeId=null;
		
		
		PlaceBuilder placebuilder=new PlaceBuilder();
		JSONObject testDataParams;
		JSONObject testDataHeaders;
		JSONObject testDataPayload;
		String baseUrl=apiCommon.getBaseUrl();
		//------------------Post API Calls -------------------
		
		@Given("Create an add place request with {string}")
		public void create_an_add_place_request_with(String scenario) {
			testDataPayload=placebuilder.getPayload(scenario);
			request=given()
					.baseUri(baseUrl)
					.body(testDataPayload);
		}

		// ------------------Get API calls -------------------
		
		@When("Verify the {string} field value as {string} when user calls the {string} for {string}")
		public void verify_the_field_value_as_when_user_calls_the_for(String key, String value, String infoUrl, String scenario) {
			testDataParams= placebuilder.getParams(scenario);
			request=given()
					.baseUri(baseUrl)
					.params(testDataParams)
					.queryParam("place_id", placeId);					
			user_calls_with_http_request(infoUrl,"GET");	
			assertEqualsCustom(value,getJasonPath(apiResponse,key));			
		}
		
		// ------------------Update API calls -------------------
		
		@When("Create an update place request with {string}")
		public void create_an_update_place_request_with(String scenario) {
			testDataPayload=placebuilder.getPayload(scenario);			
			testDataPayload.replace("place_id", "a4eb0c8e2acf1509887cc53dcf595bda", placeId);
			System.out.println("**************--->"+testDataPayload.get("place_id"));
			request=given()
					.baseUri(baseUrl)
					.body(testDataPayload);
		}
		
		//------------------Common--------------------------
		
		@When("User calls {string} with {string} http request")
		public void user_calls_with_http_request(String infoUrl, String httpMethod) {
			apiResponse=callAPI(request,infoUrl,httpMethod);
		}
		
		@Then("{string} in response body is {string}")		
		public void in_response_body_is(String key, String value) {
			if (placeId == null)
			{
				placeId=getJasonPath(apiResponse,"place_id");
				GetLogger.logger.info("placeId is : "+ placeId);
			}
			assertEqualsCustom(value,getJasonPath(apiResponse,key));		
		}
		
		@Then("API call got success with status code {int}")
		public void api_call_got_success_with_status_code(Integer statusCode) {
			assertEquals(apiResponse.getStatusCode(),200);
			//assertEqualsCustom(statusCode,apiResponse.getStatusCode());	
		}
		


}
