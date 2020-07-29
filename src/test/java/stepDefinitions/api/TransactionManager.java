package stepDefinitions.api;

import org.json.simple.JSONObject;

import api.builders.APIBuilder;
import core.database.DatabaseUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

import java.sql.ResultSet;

public class TransactionManager extends APICommon {
	
	RequestSpecification request;
	Response apiResponse;
			
	APIBuilder apiBuilder=new APIBuilder("TransactionManager");
	String baseUrl=APICommon.getBaseUrl("TransactionManagerAPIBaseURL");

	JSONObject testDataParameters;
	JSONObject testDataHeaders;
	JSONObject testDataPayload;
	
	DatabaseUtils dbUtils=new DatabaseUtils();

	@Given("Create an add transaction request with {string}")
	public void create_an_add_transaction_request_with(String scenario) {
		testDataPayload=apiBuilder.getPayload(scenario);
		testDataHeaders=apiBuilder.getHeaders(scenario);
		request=given()
				.baseUri(baseUrl)
				.headers(testDataHeaders)
				.body(testDataPayload);

	}

	@When("I call transaction {string} with {string} http request")
	public void i_call_transaction_with_http_request(String infoUrl, String httpMethod) {
		apiResponse=callAPI(request,infoUrl,httpMethod);
	}

	@Then("Transaction API call got success with status code {string}")
	public void transaction_API_call_got_success_with_status_code(String statusCode) {
		assertEquals(apiResponse.getStatusCode(),Integer.parseInt(statusCode));
	}

//	@Then("Transaction API {string} in response body is {string}")
//	public void transaction_API_in_response_body_is(String status, String value) throws Exception {
//		assertEqualsCustom(value,getJasonPath(apiResponse,status));
//	}
	
	@Then("Transaction API {string} in response body is matching with database")
	public void transaction_API_in_response_body_is_matching_with_database(String status) throws Exception {
		int expectedCode;
		String  expectedStatus = null;
		String expectedTraceId = null;
		String actualTraceId="2020-07-22-8d191d27-0cec-47d2-9a76-5811d03e2715";
		
		ResultSet rs=dbUtils.getDBData("transactionManager");
		
        while ( rs.next() ) {
            expectedCode = rs.getInt("code");
            expectedStatus = rs.getString("status");
            expectedTraceId = rs.getString("traceId");
            System.out.println("actualTraceId = "+actualTraceId);
            System.out.println( "expectedTraceId = " + expectedTraceId);
            if(expectedTraceId.equalsIgnoreCase(actualTraceId))
            {
            	System.out.println("expectedStatus  : "+expectedStatus);
            	break;
            }
         }
         assertEqualsCustom(expectedStatus,getJasonPath(apiResponse,status));
	}
}
