package model;

import java.util.Date;

public class ExerciseStatistics {
	
	Integer stat_id;
	String ex_name;
	Date datetime;
	boolean is_goal;
	boolean is_completed;
	String type;
	Integer intensity;
	double w_load;
	Integer nr_reps;
	Integer nr_sets;
	Integer duration;
	double distance;
	
	public ExerciseStatistics(Integer stat_id, String ex_name, Date datetime, boolean is_goal, boolean is_completed,
			String type, Integer intensity, double w_load, Integer nr_reps, Integer nr_sets, Integer duration,
			double distance) {
		super();
		this.stat_id = stat_id;
		this.ex_name = ex_name;
		this.datetime = datetime;
		this.is_goal = is_goal;
		this.is_completed = is_completed;
		this.type = type;
		this.intensity = intensity;
		this.w_load = w_load;
		this.nr_reps = nr_reps;
		this.nr_sets = nr_sets;
		this.duration = duration;
		this.distance = distance;
	}
	
	public Integer getStat_id() {
		return stat_id;
	}
	public void setStat_id(Integer stat_id) {
		this.stat_id = stat_id;
	}
	public String getEx_name() {
		return ex_name;
	}
	public void setEx_name(String ex_name) {
		this.ex_name = ex_name;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public boolean isIs_goal() {
		return is_goal;
	}
	public void setIs_goal(boolean is_goal) {
		this.is_goal = is_goal;
	}
	public boolean isIs_completed() {
		return is_completed;
	}
	public void setIs_completed(boolean is_completed) {
		this.is_completed = is_completed;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Integer getIntensity() {
		return intensity;
	}
	public void setIntensity(Integer intensity) {
		this.intensity = intensity;
	}
	public double getW_load() {
		return w_load;
	}
	public void setW_load(double w_load) {
		this.w_load = w_load;
	}
	public Integer getNr_reps() {
		return nr_reps;
	}
	public void setNr_reps(Integer nr_reps) {
		this.nr_reps = nr_reps;
	}
	public Integer getNr_sets() {
		return nr_sets;
	}
	public void setNr_sets(Integer nr_sets) {
		this.nr_sets = nr_sets;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	
	
	


}
/**CREATE TABLE EXERCISE_STATISTICS(
STAT_ID INT NOT NULL AUTO_INCREMENT,
EX_NAME VARCHAR(200) NOT NULL,
DATETIME DATETIME NOT NULL,
IS_GOAL BOOLEAN,
IS_COMPLETED
TYPE VARCHAR(50) NOT NULL,
INTENSITY  INT,
W_LOAD DOUBLE,
NR_REPS  INT,
NR_SETS  INT,
DURATION  INT,
DISTANCE DOUBLE,
SESSION_ID  INT NOT NULL,
PERSON_ID  INT NOT NULL,
PRIMARY KEY(STAT_ID),
	 
FOREIGN KEY(EX_NAME) 
REFERENCES EXERCISE(EXERCISE_ID)
ON UPDATE CASCADE,
FOREIGN KEY(SESSION_ID) 
REFERENCES TRAINING_SESSION(SESSION_ID)
ON UPDATE CASCADE,
FOREIGN KEY(PERSON_ID) 
REFERENCES PERSON(PERSON_ID)
ON UPDATE CASCADE);
**/