//package core.api;
//
//import java.io.FileReader;
//import java.util.Properties;
//import org.json.simple.parser.JSONParser;
//import core.common.GetEnvDetails;
//import core.common.GetLogger;
//
//public class GetAPITestData extends GetEnvDetails  
//{
//	static Properties env=GetEnvDetails.getEnvDetails();
//	static FileReader reader;
//	static Properties p;
//	public static Properties getAPITestData(String feature)
//	{
//		try {
//			reader=new FileReader("src/test/resources/TestData/API/"+env.getProperty("environment")+"/request/"+feature+".properties");
//			p=new Properties();			
//			p.load(reader);	
//			//GetLogger.logger.info("Test Environement : "+env.getProperty("environment"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return p;		
//	}
//
//}
