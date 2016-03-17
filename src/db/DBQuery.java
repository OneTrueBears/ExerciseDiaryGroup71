package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class DBQuery {
	
	public static ResultSet QueryExercises(Connection con){
		Statement stmt = null;
		String query = "SELECT * from EXERCISE";
				
		ResultSet rs;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public static void InsertInto(Connection con, String table, String query){
		Statement stmt = null;
		String command = "INSERT INTO " + table.toUpperCase() + " VALUES (" + query.toUpperCase() + " )";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(command);
		}
		catch(Exception e){
			System.out.println("Something went wrong, DBQuery Insert");
		}
		
		
	}
	
}
