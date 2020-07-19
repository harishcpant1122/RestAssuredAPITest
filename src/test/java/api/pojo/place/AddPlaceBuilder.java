package api.pojo.place;

import java.util.HashMap;
import java.util.Map;
import org.json.simple.JSONObject;
import core.api.GetAPITestDataJson;

public class AddPlaceBuilder extends GetAPITestDataJson
{
	JSONObject testData;
	JSONObject testDataPayload;
	public Map getPlaceParams()
	{
		Map<String,String> map=new HashMap<String,String>();
		map.put("key", "qaclick123");
		return map;
		
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


