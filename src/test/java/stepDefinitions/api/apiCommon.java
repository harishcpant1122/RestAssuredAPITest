package stepDefinitions.api;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import org.apache.logging.log4j.Logger;

import core.api.GetAPIConf;
import core.common.GetLogger;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class apiCommon extends GetLogger {
	static RequestSpecification reqSpec;
	Properties p=GetAPIConf.getAPIConfig();
	public RequestSpecification requestSpecification(String apiName) throws FileNotFoundException,SecurityException
	{
		if (reqSpec==null)
		{
			PrintStream log=new PrintStream(new FileOutputStream("logging.txt"));
			reqSpec=(RequestSpecification) new RequestSpecBuilder().setBaseUri(p.getProperty(apiName))
			.addQueryParam("key","qaclick123")
			.addFilter(RequestLoggingFilter.logRequestTo(log))
			.addFilter(ResponseLoggingFilter.logResponseTo(log))
			.setContentType(ContentType.JSON)
			.build();
		}
		GetLogger.logger.info("Request Specification generated for : "+apiName);
		return reqSpec;
	}
	
	public String getJasonPath(Response response,String key)
	{
		String resp=response.asString();
		JsonPath jp=new JsonPath(resp);
		return jp.get(key).toString();
		
	}
}
