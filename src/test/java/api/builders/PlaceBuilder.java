package api.builders;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import core.api.GetAPITestDataJson;

public class PlaceBuilder extends GetAPITestDataJson
{
	JSONObject testData;
	JSONObject testDataParams;
	JSONObject testDataPayload;
	public JSONObject getParams(String scenario)
	{
		testData=GetAPITestDataJson.getAPITestData("Place", scenario);
		testDataParams=(JSONObject) testData.get("parameters");
		return testDataParams;		
	}
	
	public Map getHeaders()
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("key", "qaclick123");
		return map;		
	}

	public JSONObject getPayload(String scenario)
	{
		testData=GetAPITestDataJson.getAPITestData("Place", scenario);
		testDataPayload=(JSONObject) testData.get("payload");
		return testDataPayload;
	}
}
