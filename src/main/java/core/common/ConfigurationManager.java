package core.common;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import core.common.GetEnvDetails;
import core.common.GetLogger;

public class ConfigurationManager extends GetEnvDetails {
	public static Properties getConfig()
	{
		FileReader reader;
		Properties p = null;
		try {
			reader=new FileReader("src/test/resources/Properties/conf"+getEnvDetails().getProperty("environment")+".properties");
			p=new Properties();			
			p.load(reader);	
			GetLogger.logger.info("Test Environement : "+getEnvDetails().getProperty("environment"));
			
		} catch (IOException e) {}		
		return p;			
	}
}
