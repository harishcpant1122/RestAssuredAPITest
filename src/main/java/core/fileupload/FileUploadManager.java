//package core.fileupload;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.util.Properties;
//
//import core.common.ConfigurationManager;
//import core.common.GetEnvDetails;
//import core.common.GetLogger;
//
//public class FileUploadManager extends GetEnvDetails 
//{
//	static Properties envPropterties = null;
//	public static Connection getRequestFilePath() throws Exception
//	{
//		envPropterties=GetEnvDetails.getEnvDetails();
//		
//
//		GetLogger.logger.info("DataBase Name : "+envPropterties.getProperty("database"));
//		GetLogger.logger.info("Database URL : "+databaseProperties.getProperty("databaseUrl"));
//
//		Class.forName("org.postgresql.Driver");
//		
//		switch (envPropterties.getProperty("database")) {
//		  case "postgre":			  	
//			 c = DriverManager.getConnection(databaseProperties.getProperty("databaseUrl"),
//					 databaseProperties.getProperty("databaseUserName"), 
//					 databaseProperties.getProperty("databasePassword"));
//	         System.out.println("postgre database connected..");
//			 break;
//		  case "mssql":
//	
//				break;
//			}
//		return c;
//	}
//
//}
