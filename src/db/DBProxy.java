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

	public void uploadStatistic(Connection con, ExerciseStatistics es){
		String table = "exercise_statistics";
		String values = es.getStat_id().toString() 		+ ", " + 
						es.getEx_name() 				+ ", " +
						es.getDatetime() 				+ ", " +
						es.isIs_goal() 					+ ", " +
						es.isIs_completed() 			+ ", " +
						es.getType() 					+ ", " +
						es.getIntensity().toString() 	+ ", " +
						es.getW_load()					+ ", " +
						es.getNr_reps() 				+ ", " +
						es.getNr_sets() 				+ ", " +
						es.getDuration() 				+ ", " +
						es.getDistance() 				+ ", " +
						es.getSessionID() 				+ ", " +
						es.getPersonID();
		DBQuery.InsertInto(con, table, values);
	}

	public List<ExerciseStatistics> getStatistics(Connection con){
		List<ExerciseStatistics> statList = new ArrayList<ExerciseStatistics>();
		//Query for exercises "rs" is the ResultSet
		ResultSet rs = DBQuery.QueryExercises(con);
		try{
			while (rs.next()){
				 
				//Parse the Results
				Integer stat_id = rs.getInt("STAT_ID");
				String ex_name = rs.getString("EX_NAME");
				String datetime = rs.getString("DATETIME");
				boolean is_goal = rs.getBoolean("IS_GOAL");
				boolean is_completed = rs.getBoolean("IS_COMPLETED");
				String type = rs.getString("TYPE");
				int intensity = rs.getInt("INTENSITY");
				double w_load = rs.getDouble("W_LOAD");
				int nr_reps = rs.getInt("NR_REPS");
				int nr_sets = rs.getInt("NR_SETS");
				int duration = rs.getInt("DURATION");
				double distance = rs.getDouble("DISTANCE");
				int sessionID = rs.getInt("SESSION_ID");
				int personID = rs.getInt("PERSON_ID");
				
				//Add ExerciseStatistics object to list
				statList.add(new ExerciseStatistics(stat_id, ex_name, datetime, is_goal, is_completed, type, intensity, w_load, nr_reps, nr_sets, duration, distance, sessionID, personID));
				
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
