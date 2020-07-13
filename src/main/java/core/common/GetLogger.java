package core.common;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;

public class GetLogger  {
	
	public Logger log;
	
	public Logger getLogger() 
	{
		//ITestContext itx=null;
		//String testName=itx.
		log=LogManager.getLogger(ITestContext.class);
		return log;
	}
	


}
