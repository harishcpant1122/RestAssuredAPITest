package core.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import core.common.ConfigurationManager;
import core.common.GetEnvDetails;
import core.common.GetLogger;

public class DatabaseDriverManager extends GetEnvDetails 
{
		static Properties envPropterties = null;
		static Properties databaseProperties = null;
		static Connection c = null;
		public static Connection getDatabaseConnection() throws Exception
		{
			envPropterties=GetEnvDetails.getEnvDetails();
			databaseProperties=ConfigurationManager.getConfig();

			GetLogger.logger.info("DataBase Name : "+envPropterties.getProperty("database"));
			GetLogger.logger.info("Database URL : "+databaseProperties.getProperty("databaseUrl"));

			Class.forName("org.postgresql.Driver");
			
			switch (envPropterties.getProperty("database")) {
			  case "postgre":			  	
				 c = DriverManager.getConnection(databaseProperties.getProperty("databaseUrl"),
						 databaseProperties.getProperty("databaseUserName"), 
						 databaseProperties.getProperty("databasePassword"));
		         System.out.println("postgre database connected..");
				 break;
			  case "mssql":
		
					break;
				}
			return c;
		}

}
