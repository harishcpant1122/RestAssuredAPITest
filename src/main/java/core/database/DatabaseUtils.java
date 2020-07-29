package core.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseUtils {
	public ResultSet getDBData(String tableName) throws Exception
	{
		Connection c = null;
		c = DatabaseDriverManager.getDatabaseConnection();     	
     	Statement stmt = null;
     	stmt = c.createStatement();
     	ResultSet rs = stmt.executeQuery( "SELECT * FROM "+tableName+";");
		return rs;
	}

}
