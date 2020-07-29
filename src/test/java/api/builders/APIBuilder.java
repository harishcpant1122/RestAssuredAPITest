package api.builders;

import org.json.simple.JSONObject;

import core.api.GetAPITestDataJson;

public class APIBuilder extends GetAPITestDataJson
{
	
	JSONObject testData;
	JSONObject testDataParameters;
	JSONObject testDataHeaders;
	JSONObject testDataPayload;
	
	String apiName;
	
	public APIBuilder(String apiName)
	{
		this.apiName=apiName;
		
	}
	public JSONObject getParams(String scenario)
	{
		testData=GetAPITestDataJson.getAPITestData(apiName, scenario);
		testDataParameters=(JSONObject) testData.get("parameters");
		return testDataParameters;		
	}
	
	public JSONObject getHeaders(String scenario)
	{
		testData=GetAPITestDataJson.getAPITestData(apiName, scenario);
		testDataHeaders=(JSONObject) testData.get("headers");
		return testDataHeaders;			
	}

	public JSONObject getPayload(String scenario)
	{
		testData=GetAPITestDataJson.getAPITestData(apiName, scenario);
		testDataPayload=(JSONObject) testData.get("payload");
		return testDataPayload;
	}
}
