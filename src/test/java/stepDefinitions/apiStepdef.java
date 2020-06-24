package stepDefinitions;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiStepdef {
	
	RequestSpecification requestBasic;
	RequestSpecification request;
	Response apiResponse;
	JsonPath jsonPath;
	String placeId;
	
	@Given("Add a place payload")
	public void add_a_place_payload() {
		
		String postPayload="{\r\n" + 
				"  \"location\": {\r\n" + 
				"    \"lat\": -38.383494,\r\n" + 
				"    \"lng\": 33.427362\r\n" + 
				"  },\r\n" + 
				"  \"accuracy\": 50,\r\n" + 
				"  \"name\": \"Frontline house\",\r\n" + 
				"  \"phone_number\": \"(+91) 983 893 3937\",\r\n" + 
				"  \"address\": \"29, side layout, cohen 09\",\r\n" + 
				"  \"types\": [\r\n" + 
				"    \"shoe park\",\r\n" + 
				"    \"shop\"\r\n" + 
				"  ],\r\n" + 
				"  \"website\": \"http://google.com\",\r\n" + 
				"  \"language\": \"French-IN\"\r\n" + 
				"}";
		
		requestBasic=(RequestSpecification) new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("key","qaclick123")
				.setContentType(ContentType.JSON)
				.build();
		request=given().spec(requestBasic).body(postPayload);
	}

	@When("user calls AddPlaceAPI with post http request")
	public void user_calls_AddPlaceAPI_with_post_http_request() {
		apiResponse=request.when().post("maps/api/place/add/json").then().extract().response();
	}

	@Then("Status in response body is OK")
	public void status_in_response_body_is_OK() {
		jsonPath=new JsonPath(apiResponse.asString());
		placeId=jsonPath.getString("place_id");		
		assertEquals(jsonPath.getString("status"),"OK");
	}
	
	// ------------------Put API calls -------------------
	
		@When("user calls updatePlaceAPI with put http request")
		public void user_calls_updatePlaceAPI_with_put_http_request() {
			String putPayload="{\r\n" + 
					"\"place_id\":\""+placeId+"\",\r\n" + 
					"\"address\":\"900 winter walk, USA\",\r\n" + 
					"\"key\":\"qaclick123\"\r\n" + 
					"}";
			requestBasic=(RequestSpecification) new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					.addQueryParam("key","qaclick123")
					.setContentType(ContentType.JSON)
					.build();
		    request=given().spec(requestBasic).body(putPayload);
			apiResponse=request.when().put("maps/api/place/update/json").then().extract().response();
			jsonPath=new JsonPath(apiResponse.asString());
			System.out.println("Put output-->"+jsonPath.getString("msg"));			
		}
		
		@Then("Status in response body is Address successfully updated")
		public void status_in_response_body_is_Address_successfully_updated() {
			assertEquals(jsonPath.getString("msg"),"Address successfully updated");
		}
		
		// ------------------Get API calls -------------------
		
		@When("user calls getPlaceAPI with get http request")
		public void user_calls_getPlaceAPI_with_get_http_request() {
			requestBasic=(RequestSpecification) new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
					.addQueryParam("key","qaclick123")
					.addQueryParam("place_id",placeId)
					.setContentType(ContentType.JSON)
					.build();
			request=given().spec(requestBasic);
			apiResponse=request.when().get("maps/api/place/get/json").then().extract().response();
			jsonPath=new JsonPath(apiResponse.asString());				
		}

		@Then("Status in get response body should be correct")
		public void status_in_get_response_body_should_be_correct() {
			assertEquals(jsonPath.getString("name"),"Frontline house");
		}
		
		//------------------Common--------------------------
		
		@Then("API call got success with status code {int}")
		public void api_call_got_success_with_status_code(Integer int1) {
			assertEquals(apiResponse.getStatusCode(),200);
		}


}
