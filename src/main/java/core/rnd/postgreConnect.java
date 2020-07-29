package core.rnd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import core.database.DatabaseDriverManager;

public class postgreConnect extends DatabaseDriverManager
{
	public static void main(String[] args) {
		System.out.println("Hello World..");
		Connection c = null;
	      try {
	    	  	c = DatabaseDriverManager.getDatabaseConnection();
	         	System.out.println("Opened database successfully");
	         
	         	Statement stmt = null;
	         	stmt = c.createStatement();
	         	ResultSet rs = stmt.executeQuery( "SELECT * FROM test;" );
	         	
	            while ( rs.next() ) {
	                int id = rs.getInt("id");
	                String  name = rs.getString("name");
	                System.out.println( "ID = " + id );
	                System.out.println( "NAME = " + name );
	             }
	             rs.close();
	             stmt.close();
	             c.close();
		      
	      } catch (Exception e) {
	         e.printStackTrace();
	         System.err.println(e.getClass().getName()+": "+e.getMessage());
	         System.exit(0);
	      }
	}
}
