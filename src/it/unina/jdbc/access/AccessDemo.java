package it.unina.jdbc.access;




import java.net.URL;
import java.sql.*;

public class AccessDemo {

  static Connection theConn;

  public static void main (String args[]) {
    try {
      // connection to an ACCESS MDB
      theConn = MyConnection.getConnection();

      ResultSet rs;
      Statement stmt;
      String sql;

      sql =  "select objet from Email";
      stmt = theConn.createStatement();
      rs = stmt.executeQuery(sql);

      while (rs.next()) {
         System.out.println(rs.getString("objet"));
      }
      rs.close();
      stmt.close();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    finally {
      try {
        if (theConn != null) theConn.close();
      }
      catch (Exception e) {
      }
    }

    }
  }

class MyConnection {
  public static Connection getConnection() throws Exception {
    Driver d = (Driver)Class.forName
     ("sun.jdbc.odbc.JdbcOdbcDriver").newInstance();
    Connection c = DriverManager.getConnection(
     "jdbc:odbc:Driver={Microsoft Access Driver (*.mdb)};DBQ=c:/tech97.mdb"
      );
    return c;
    /*
     To use an already defined ODBC Datasource :    
     
        String URL = "jdbc:odbc:myDSN";
        Connection c = DriverManager.getConnection(URL, "user", "pwd"); 
        
    */     
    }
}