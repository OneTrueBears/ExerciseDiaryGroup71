package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public  class DBQuery {
	
	public static ResultSet Query(Connection con, String query){
		Statement stmt = null;
				
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
		String command = 	"INSERT INTO " + table.toUpperCase() + " " +
							"VALUES (" + query.toUpperCase() + " )";
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(command);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Something went wrong, DBQuery Insert");
		}
	}
	
	public static void Update(Connection con, String table, String query, String idCol, String ID){
		Statement stmt = null;
		String command = 	"UPDATE " 	+ table.toUpperCase() 		+ " " +
							"SET " 		+ query.toUpperCase() 		+ " " +
							"WHERE " 	+ idCol.toUpperCase() + " = " + ID.toUpperCase();
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(command);
		}
		catch(Exception e){
			e.printStackTrace();
			System.out.println("Something went wrong, DBQuery Update");
		}
		
	}
	
}
