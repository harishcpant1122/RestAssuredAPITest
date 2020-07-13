package cucumber.Options;


import org.testng.annotations.AfterSuite;

import core.common.GenerateTestReport;
import io.cucumber.java.After;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features="src\\test\\resources\\features",
		glue= {"stepDefinitions"},
		//tags={"@UITestPostive"},
		tags={"@APITest"},
		plugin = { "pretty", "html:target/cucumber-html-reports", "json:target/cucumber.json" }		
		)
public class TestRunner extends AbstractTestNGCucumberTests 
{
	@AfterSuite
	public void reportGeneration() {
		try {
			System.out.println("waiting for 10 seconds.....");
			Thread.sleep(10000);	
			GenerateTestReport g=new GenerateTestReport();
			g.generateCucumberReport();			
		} catch (InterruptedException e) {}		
	}
}


