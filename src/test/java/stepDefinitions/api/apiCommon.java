package stepDefinitions.api;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.apache.logging.log4j.Logger;

import core.common.ConfigurationManager;
import core.common.GetLogger;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class APICommon extends GetLogger {
	static RequestSpecification reqSpec;
	//static Properties p=GetAPIConf.getAPIConfig();
	static Properties p=ConfigurationManager.getConfig();
	
	Response apiResponse;
	
	public String getJasonPath(Response response,String key)
	{
		String resp=response.asString();
		JsonPath jp=new JsonPath(resp);
		return jp.get(key).toString();
		
	}

	public Response callAPI(RequestSpecification request,String infoUrl, String httpMethod)
	{
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
		
		GetLogger.logger.info("httpMethod is: "+ httpMethod+ " and infoUrl is: "+ p.getProperty(infoUrl));
		GetLogger.logger.info(infoUrl +" API Call Response : "+ apiResponse.asString());
		
		return apiResponse;
	}
	
	public void assertEqualsCustom(String expected,String actual)
	{
		assertEquals(expected,actual,"Expected is: "+expected+", But Actual is: "+actual+"  /");		
	}
	
	public static String getBaseUrl(String apiName)
	{
		GetLogger.logger.info("Base url is : "+p.getProperty(apiName));
		return p.getProperty(apiName);		
	}
	
}
