package it.unina.jdbc.oracle;

import java.sql.*;
public class oracleConnection1 {
	
	  public static void main (String args []) throws SQLException
	  {
	       try {
	             Class.forName ("oracle.jdbc.driver.OracleDriver");
	       } catch (ClassNotFoundException e) {
	             e.printStackTrace();
	       }

	        Connection conn = DriverManager.getConnection
	            ("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
	                            // @machineName:port:SID,   userid,  password

	        Statement stmt = conn.createStatement();
	        ResultSet rset = stmt.executeQuery("select* from belli");
	        while (rset.next())
	              System.out.println (rset.getString(1));   // Print col 1
	        stmt.close();
	        conn.close();
	  }
	}

