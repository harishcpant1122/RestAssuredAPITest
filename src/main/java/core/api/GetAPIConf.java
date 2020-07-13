package core.api;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import core.common.GetEnvDetails;

public class GetAPIConf extends GetEnvDetails {
	public static Properties getAPIConfig()
	{
		FileReader reader;
		Properties p = null;
		try {
			reader=new FileReader("src/test/resources/Properties/apiConf"+getEnvDetails().getProperty("environment")+".properties");
			p=new Properties();			
			p.load(reader);		
			
		} catch (IOException e) {
			
		}
		
		return p;			
	}


}
