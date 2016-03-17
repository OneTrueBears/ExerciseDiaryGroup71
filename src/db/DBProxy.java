package db;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Exercise;
import model.ExerciseStatistics;
import model.Session;
import model.SessionView;

public class DBProxy {
	static Connection con;
	
	public DBProxy(Connection con){
		this.con = con;
	}
	
	
	public List<Exercise> getExercises(){
		List<Exercise> exList = new ArrayList<Exercise>();
		//Query for exercises "rs" is the ResultSet
		String query = "SELECT * from EXERCISE";
		ResultSet rs = DBQuery.Query(con, query);
		try{
			while (rs.next()){
				 
				//Parse the Results
				String name = rs.getString("EXERCISE_ID");
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
				exList.add(new Exercise(name, null, gruppeId, description, type, intensity, load, reps, sets, duration, distance));
				
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
	public ArrayList<SessionView> getSessionView(){
		ArrayList<SessionView> sessionViews = new ArrayList<>();
		String query = "SELECT SESSION_ID, DATETIME" + " " +
						"FROM TRAINING_SESSION";
		ResultSet rs = DBQuery.Query(con, query);
		try{
			while (rs.next()){
				//Parse the Results
				Integer sessionId = rs.getInt("SESSION_ID");
				String dateTime = rs.getString("DATE_TIME");
				
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime date = LocalDateTime.parse(dateTime, formatter);
				//Add sessionView object to list
				sessionViews.add(new SessionView(sessionId, date));
				}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		return sessionViews;
	}
	
	
	 public void uploadSession(Session es){
		  String table = "TRAINING_SESSION";
		  Integer bol;
		  if (es.isOutdoor()==true){
		   bol = 1;
		  }
		  else{
		   bol = 0;
		  }
		  String values = 
		    es.getID()     + ", " + 
		    Integer.toString(es.getPERSON_ID()) + ", " +
		    es.getDuration().toString()   + ", " +
		    "\'" + es.getDateTime().toString() + "\'" + ", " +
		    es.getHealthCondition().toString()  + ", " +
		    es.getPerformance().toString()   + ", " +
		    "\'" + es.getPurposeNote() + "\'"     + ", " +
		    "\'" + es.getLateTips() + "\'"     + ", " +
		    es.getSpectators().toString()  + ", " +
		    "\'" + es.getAirCondition().toString() + "\'"  + ", " +
		    es.getWeatherTemp().toString()  + ", " +
		    "\'" + es.getWeatherType().toString() + "\'" + ", " +
		    bol.toString();
		  	DBQuery.InsertInto(con, table, values);

		  for (Exercise ex : es.getExerciseList()){
			System.out.println("Exercise Session ID: " + es.getID());
			if (!es.getExerciseList().isEmpty()){
				DBQuery.InsertInto(con, "SESSION_EXERCISE", es.getID() + ", " + "\'" + ex.getID() + "\'");				
			}
		  }
		  
		  
	 }
	 
	 public void uploadExercises(Exercise exe){
		  String table = "EXERCISE";
		  String values = "\'" + exe.getID() + "\'"  + ", " + 
		      exe.getSESSION_ID().toString()  + ", " +
		      "\'" + exe.getGruppeID() + "\'"    + ", " +
		      "\'" + exe.getDescription() + "\'"    + ", " +
		      "\'" + exe.getType() + "\'"  + ", " +
		      exe.getIntensity().toString()     + ", " +
		      exe.getNrReps().toString()  + ", " +
		      exe.getNrSets().toString() + ", " +
		      Double.toString(exe.getwLoad()) + ", " +
		      exe.getDuration().toString()    + ", " +
		      Double.toString(exe.getDistance());
		  DBQuery.InsertInto(con, table, values);
	}
	
	public Session getSession(int sessionId){
		//Gets and makes exercise list
		ArrayList<Exercise> exList = new ArrayList<Exercise>();
		//Query for exercises "rs" is the ResultSet
		String query = 	"SELECT *"														+" "+
						"FROM EXERCISE, SESSION_EXERCISE"								+" "+
						"WHERE EXERCISE.EXERCISE_ID = SESSION_EXERCISE.EXERCISE_ID"		+" "+
						"AND SESSION_EXERCISE.SESSION_ID = " + sessionId;
		ResultSet rs = DBQuery.Query(con, query);
		try{
			while (rs.next()){
				 
				//Parse the Results
				String name = rs.getString("EXERCISE_ID");
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
				exList.add(new Exercise(name, null, gruppeId, description, type, intensity, load, reps, sets, duration, distance));
				
				System.out.println("Got one!");
				}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		
		
		
		//Gets and makes session
		Session session = null;
		String sessionQuery = 	"SELECT *" 						+" "+
								"FROM TRAINING_SESSION"			+" "+
								"WHERE SESSION_ID = " + sessionId;
		ResultSet rs1 = DBQuery.Query(con, sessionQuery);
		try{
			while (rs1.next()){
				 
				//Parse the Results
				String name = rs1.getString("EXERCISE_ID");
				int pERSON_ID = rs1.getInt("PERSON_ID");
				Integer duration = rs1.getInt("DURATION");
				String dateTime = rs1.getString("DATE_TIME");
				Integer healthCondition = rs1.getInt("HEALTH_CONDITION");
				Integer performance = rs1.getInt("PERFORMANCE");
				String purposeNote = rs1.getString("PURPOSE_NOTE");
				String lateTips = rs1.getString("LATE_TIPS");
				Integer spectators = rs1.getInt("SPECTATORS");
				Integer airCondition = rs1.getInt("AIR_CONDITIONS");
				Integer weatherTemp = rs1.getInt("WEATHER_TEMP");
				String weatherType = rs1.getString("WEATHER_TYPE");
				boolean isOutdoor = rs1.getBoolean("IS_OUTDOOR");
				
				
				
				Integer distance = rs1.getInt("DISTANCE"); 
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
				LocalDateTime date = LocalDateTime.parse(dateTime, formatter);
				
				//Add Exercise object to list
				session = new Session(sessionId, pERSON_ID, duration, date, healthCondition, performance, purposeNote, lateTips, spectators, airCondition, weatherTemp, weatherType, isOutdoor, exList);
				
				System.out.println("Got one!");
				}
		}
		catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return session;
		
	}

	public static void uploadStatistic(ExerciseStatistics es){
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
	
	public void updateStatistics(ExerciseStatistics es){
		String table = "exercise_statistics";
		String idCol = "stat_id";
		String ID = es.getStat_id().toString();
		String values = "EX_NAME" + " = " + es.getEx_name() 				+ ", " +
						"DATETIME" + " = " + es.getDatetime() 				+ ", " +
						"IS_GOAL" + " = " + es.isIs_goal() 					+ ", " +
						"IS_COMPLETED" + " = " + es.isIs_completed() 		+ ", " +
						"TYPE" + " = " + es.getType() 						+ ", " +
						"INTENSITY " + " = " + es.getIntensity().toString() + ", " +
						"W_LOAD" + " = " + es.getW_load()					+ ", " +
						"NR_REPS" + " = " + es.getNr_reps() 				+ ", " +
						"NR_SETS" + " = " + es.getNr_sets() 				+ ", " +
						"DURATION" + " = " + es.getDuration() 				+ ", " +
						"DISTANCE" + " = " + es.getDistance() 				+ ", " +
						"SESSION_ID" + " = " + es.getSessionID() 			+ ", " +
						"PERSON_ID" + " = " + es.getPersonID();
		DBQuery.Update(con, table, values, idCol, ID);
	}

	public List<ExerciseStatistics> getStatistics(){
		List<ExerciseStatistics> statList = new ArrayList<ExerciseStatistics>();
		//Query for exercises "rs" is the ResultSet
		String query = "SELECT * from EXERCISE_STATISTICS";
		ResultSet rs = DBQuery.Query(con, query);
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
