package db;

//STEP 1. Import required packages
import java.sql.*;

public class DBConnect {

  // JDBC driver name and database URL
  static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  //TODO??
  static final String DB_URL = "jdbc:mysql://mysql.stud.ntnu.no/kimera_venner"; //TODO
  
  //  Database credentials
  static final String USER = "kimera_gruppe15"; // TODO
  static final String PASS = "cdji2005"; // TODO
  static Connection connection = null;
  
  public DBConnect() {
      try{
          Class.forName(JDBC_DRIVER); // Register JDBC Driver
      }
      catch(ClassNotFoundException e){
          System.out.println("Could not load driver");
      }
  }//DBConnect END
  
  public static Connection quickConnect()
//	OBS DO NOT USE BEFORE USERNAME AND PASSWORD HAS BEEN DECIDED UPON BY THE GROUP!
	{
		try
		{	
			Connection con = DriverManager.getConnection("jdbc:mysql://mysql.stud.ntnu.no/kimera_venner","kimera_gruppe15", "cdji2005");
			System.out.println("connection established");
			return con;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
			return null;
		}
	}
  
  public void connect(){

    try{
      // Open connection
      connection = DriverManager.getConnection(DB_URL,USER,PASS);
      System.out.println("Connected to database");
    }
    catch(SQLException e){
        e.printStackTrace();
        System.out.println("Could not connect to database");
    }
    
  }
    // GET-ers and SET-ers
    
    public String getUsername(){
     		return USER;
    }
    
    public String getPassword(){
     		return PASS;
    }
    
    public Connection getConnection(){
      return connection;
    }
}//end DBConnect