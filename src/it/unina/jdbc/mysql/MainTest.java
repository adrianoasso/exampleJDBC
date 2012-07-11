package it.unina.jdbc.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainTest {
	
	
	public static void main (String args[]){
	String connectionURL = "jdbc:oracle:thin:@151.12.35.243:1521:orcl";
	Connection connection = null;
	Statement statement = null;
	ResultSet rs = null;



	try {
		    Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
	
		connection = DriverManager.getConnection(connectionURL, "hibernate", "hibernate");
		
		statement = connection.createStatement();
		
		
		// Create a Statement
	   //Statement stmt = conn.createStatement ();

	    // Select the USER column from the dual table
	    ResultSet rset = statement.executeQuery ("select USER from dual");

	    // Iterate through the result and print the USER
	    while (rset.next ())
	      System.out.println ("User name is " + rset.getString (1));

	    // Close the RseultSet
	    rset.close();
	    rset =  null;

	    // Close the Statement
	    statement.close();
	  
		/*rs = statement.executeQuery("SELECT * FROM duale");

		while (rs.next()) {
		System.out.println(rs.getString("at1"));
		System.out.println(rs.getString("at2"));
		System.out.println(rs.getString("at3"));
		}

		rs.close();*/
		

	} catch (InstantiationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IllegalAccessException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

}
}
