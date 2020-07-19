package stepDefinitions.api;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;

import org.json.simple.JSONObject;

import api.pojo.place.AddPlaceBuilder;
import api.pojo.place.GetPlaceBuilder;
import api.pojo.place.UpdatePlaceBuilder;
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
		
		AddPlaceBuilder addPlaceBuilder=new AddPlaceBuilder(); 
		UpdatePlaceBuilder updatePlaceBuilder=new UpdatePlaceBuilder(); 
		GetPlaceBuilder getPlaceBuilder=new GetPlaceBuilder(); 
		JSONObject testDataParams;
		JSONObject testDataHeaders;
		JSONObject testDataPayload;
	
		//------------------Post API Calls -------------------
		@Given("Add a place with {string}")
		public void add_a_place_with(String scenario) throws FileNotFoundException, SecurityException {
			testDataPayload=addPlaceBuilder.getPlacePayload(scenario);
			System.out.println("**************--->"+testDataPayload.get("phone_number"));
			request=given()
					.baseUri("https://rahulshettyacademy.com")
					.body(testDataPayload);
		}
	
		// ------------------Get API calls -------------------
		
		@When("Verify the {string} field value as {string} when user calls the {string} for {string}")
		public void verify_the_field_value_as_when_user_calls_the_for(String key, String value, String infoUrl, String scenario) {
			testDataParams= getPlaceBuilder.getPlaceParams(scenario);
			request=given()
					.baseUri("https://rahulshettyacademy.com")
					.params(testDataParams)
					.queryParam("place_id", placeId);					
			user_calls_with_http_request(infoUrl,"GET");	
			System.out.println("Get response-->"+apiResponse.asString());
			assertEqualsCustom(value,getJasonPath(apiResponse,key));
			
		}
		
//		@When("Verify the {string} field value as {string} when user calls the {string}")
//		public void verify_the_field_value_as_when_user_calls_the(String field,String key, String infoUrl) throws FileNotFoundException, SecurityException {
//			testDataParams=addPlaceBuilder.getPlacePayload(scenario);
//			request=given()
//					.baseUri("https://rahulshettyacademy.com")
//					.params(testDataParams);
//			user_calls_with_http_request(infoUrl,"GET");
//			request=given().spec(requestSpecification("PlaceAPIBaseURL"))
//					.queryParam("place_id", placeId);
//					user_calls_with_http_request(infoUrl,"GET");
//					assertEqualsCustom(getPlaceBuilder.GetData(key),getJasonPath(apiResponse,field));
			//assertEqualsCustom(getPlaceBuilder.GetData(key),getJasonPath(apiResponse,field));
//		}
		
		// ------------------Update API calls -------------------
//		@When("Update a place payload with {string} and {string}")
//		public void update_a_place_payload_with_and(String updatedAddress, String key) throws FileNotFoundException, SecurityException {
//			request=given()
//			.spec(requestSpecification("PlaceAPIBaseURL"))
//			.body(updatePlaceBuilder.UpdatePlacePayload(placeId,updatedAddress, key));
//		}
		
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
