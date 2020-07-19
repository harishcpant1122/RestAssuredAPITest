package api.pojo.place;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.json.simple.JSONObject;

import core.api.GetAPITestDataJson;

public class GetPlaceBuilder extends GetAPITestDataJson {

	JSONObject testData;
	JSONObject testDataParams;
	JSONObject testDataPayload;
	public JSONObject getPlaceParams(String scenario)
	{
		testData=GetAPITestDataJson.getAPITestData("Place", scenario);
		testDataParams=(JSONObject) testData.get("params");
		return testDataParams;		
	}
	
	public Map getPlaceHeaders()
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("key", "qaclick123");
		return map;		
	}

	public JSONObject getPlacePayload(String scenario)
	{
		testData=GetAPITestDataJson.getAPITestData("Place", scenario);
		testDataPayload=(JSONObject) testData.get("payload");
		return testDataPayload;
	}

}
