package db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Exercise;
import model.ExerciseStatistics;

public class DBProxy {
	
	
	
	public List<Exercise> getExercises(Connection con){
		List<Exercise> exList = new ArrayList<Exercise>();
		//Query for exercises "rs" is the ResultSet
		ResultSet rs = DBQuery.QueryExercises(con);
		try{
			while (rs.next()){
				 
				//Parse the Results
				String name = rs.getString("EXERCISE_ID");
				Integer sessionId = rs.getInt("SESSION_ID");
				String gruppeId = rs.getString("GRUPPE_ID");
				String description = rs.getString("DESCRIPTION");
				String type = rs.getString("TYPE");
				Integer intensity = rs.getInt("INTENSITY");
				Integer reps = rs.getInt("NR_REPS");
				Integer sets = rs.getInt("NR_SETS");
				double load = rs.getDouble("W_LOAD");
				Integer duration = rs.getInt("DURATION");
				Integer distance = rs.getInt("DISTANCE"); 
				
				//Add Exercise object to list
				exList.add(new Exercise(name, sessionId, gruppeId, description, type, intensity, load, reps, sets, duration, distance));
				
				System.out.println("Got one!");
				}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		for (Exercise e : exList){
			System.out.println(e);
		}
		System.out.println();
		return exList;
	}


	public List<ExerciseStatistics> getStatistics(Connection con){
		List<ExerciseStatistics> statList = new ArrayList<ExerciseStatistics>();
		//Query for exercises "rs" is the ResultSet
		ResultSet rs = DBQuery.QueryExercises(con);
		try{
			while (rs.next()){
				 
				//Parse the Results
				String name = rs.getString("EXERCISE_ID");
				Integer sessionId = rs.getInt("SESSION_ID");
				String gruppeId = rs.getString("GRUPPE_ID");
				String description = rs.getString("DESCRIPTION");
				String type = rs.getString("TYPE");
				Integer intensity = rs.getInt("INTENSITY");
				Integer reps = rs.getInt("NR_REPS");
				Integer sets = rs.getInt("NR_SETS");
				double load = rs.getDouble("W_LOAD");
				Integer duration = rs.getInt("DURATION");
				Integer distance = rs.getInt("DISTANCE"); 
				
				//Add Exercise object to list
				statList.add(null);
				
				System.out.println("Got one!");
				}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		for (ExerciseStatistics e : statList){
			System.out.println(e);
		}
		System.out.println();
		return statList;
	}
	
}
