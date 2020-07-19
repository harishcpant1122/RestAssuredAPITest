package core.api;


import java.io.FileReader;
import java.util.Properties;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import core.common.GetEnvDetails;

public class GetAPITestDataJson extends GetEnvDetails  
{
	static Properties env=GetEnvDetails.getEnvDetails();
	static JSONObject testData;
	//static JSONObject testDataPayload;
	public static JSONObject getAPITestData(String fileName,String ScenaioName)
	{
		try {
			 Object obj = new JSONParser().parse(new FileReader("src/test/resources/TestData/API/"+env.getProperty("environment")+"/request/"+fileName+".json")); 
		     JSONObject jo = (JSONObject) obj; 
		     testData = (JSONObject) jo.get(ScenaioName); 
		     //testDataPayload=(JSONObject) testData.get("payload"); 
		     //System.out.println("firstName--->"+testData.get("Firstname"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testData;		
	}

}
