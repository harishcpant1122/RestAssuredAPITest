package stepDefinitions.api;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import core.api.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.api.AddPlace;
import pojo.api.AddPlace_location;


public class apiStepdef extends apiCommon  {
	//RequestSpecification requestBasic;
	RequestSpecification request;
	Response apiResponse;
	JsonPath jsonPath;
	String placeId;
	
	
	@Given("Add a place payload with {string} {string} and {string}")
	public void add_a_place_payload_with_and(String name, String language, String address) throws FileNotFoundException, SecurityException {
		AddPlace postPayload=new AddPlace();
		AddPlace_location l=new AddPlace_location();
			l.setLat(-38.383494);
			l.setLng(33.427362);
		postPayload.setLocation(l);
		postPayload.setAccuracy(50);
		postPayload.setName(name);
		postPayload.setPhone_number("(+91) 983 893 3937");
		postPayload.setAddress(address);
		List<String> myList=new ArrayList<String>();
			myList.add("shoe park");
			myList.add("shop");
		postPayload.setTypes(myList);
		postPayload.setWebsite("http://google.com");
		postPayload.setLanguage(language);
		
		System.out.println(p.getProperty("PlaceAPIBaseURL"));
		request=given()
				.spec(requestSpecification("PlaceAPIBaseURL"))
				.body(postPayload);
	}	
	
	
	@When("User calls {string} with {string} http request")
	public void user_calls_with_http_request(String infoUrl, String httpMethod) {
		if (httpMethod.equalsIgnoreCase("POST"))
		{			
			apiResponse=request.when().post(p.getProperty(infoUrl));
		}
		else if (httpMethod.equalsIgnoreCase("GET"))
		{
			apiResponse=request.when().get(p.getProperty(infoUrl));
		}
		if (httpMethod.equalsIgnoreCase("PUT"))
		{
			apiResponse=request.when().put(p.getProperty(infoUrl));
		}		
	}
	
	@Then("{string} in response body is {string}")		
	public void in_response_body_is(String key, String value) {
		apiResponse=apiResponse.then().extract().response();
		placeId=getJasonPath(apiResponse,"place_id");
		assertEquals(value,getJasonPath(apiResponse,key));
	}
	
		// ------------------Get API calls -------------------
		
		@When("Verify the {string} when user calls the {string}")
		public void verify_the_when_user_calls_the(String value, String infoUrl) throws FileNotFoundException, SecurityException  {
			request=given().spec(requestSpecification("PlaceAPIBaseURL"))
					.queryParam("place_id", placeId);
			user_calls_with_http_request(infoUrl,"GET");
			assertEquals(value,getJasonPath(apiResponse,"name"));
		}
		

		//------------------Common--------------------------
		
		@Then("API call got success with status code {int}")
		public void api_call_got_success_with_status_code(Integer int1) {
			assertEquals(apiResponse.getStatusCode(),200);
		}
		
		// ------------------Put API calls -------------------
		
//		@When("user calls updatePlaceAPI with put http request")
//		public void user_calls_updatePlaceAPI_with_put_http_request() {
//			String putPayloadFromFile=GetAPITestData.getAPITestData("placeValidationPutAPI");
//			String putPayload=putPayloadFromFile.replace("aaaaaaaa", placeId);
//			System.out.println("putPayload-->"+putPayload);
//			requestBasic=(RequestSpecification) new RequestSpecBuilder().setBaseUri(p.getProperty("placeValidationBaseURL"))
//					.addQueryParam("key","qaclick123")
//					.setContentType(ContentType.JSON)
//					.build();
//		    request=given().spec(requestBasic).body(putPayload);
//			apiResponse=request.when().put(p.getProperty("placeValidationInfoUrlPut")).then().extract().response();
//			jsonPath=new JsonPath(apiResponse.asString());
//			System.out.println("Put output-->"+jsonPath.getString("msg"));			
//		}
//		
//		@Then("Status in response body is Address successfully updated")
//		public void status_in_response_body_is_Address_successfully_updated() {
//			assertEquals(jsonPath.getString("msg"),"Address successfully updated");
//		}


}
