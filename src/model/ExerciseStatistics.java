package model;

public class ExerciseStatistics {
	
	@Override
	public String toString() {
		return "ExerciseStatistics [stat_id=" + stat_id + ", ex_name=" + ex_name + ", datetime=" + datetime
				+ ", is_goal=" + is_goal + ", is_completed=" + is_completed + ", type=" + type + ", intensity="
				+ intensity + ", w_load=" + w_load + ", nr_reps=" + nr_reps + ", nr_sets=" + nr_sets + ", duration="
				+ duration + ", distance=" + distance + "]";
	}
	
	
	private Integer stat_id;
	private String ex_name;
	private String datetime;
	private boolean is_goal;
	private boolean is_completed;
	private String type;
	private Integer intensity;
	private double w_load;
	private Integer nr_reps;
	private Integer nr_sets;
	private Integer duration;
	private double distance;
	private Integer sessionID;
	private Integer personID;
	
	public ExerciseStatistics(Integer stat_id, String ex_name, String datetime, boolean is_goal, boolean is_completed,
			String type, Integer intensity, double w_load, Integer nr_reps, Integer nr_sets, Integer duration,
			double distance, Integer sessionID, Integer personID) {
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
		this.sessionID = sessionID;
		this.personID = personID;
	}
	
	public Integer getSessionID() {
		return sessionID;
	}

	public void setSessionID(Integer sessionID) {
		this.sessionID = sessionID;
	}

	public Integer getPersonID() {
		return personID;
	}

	public void setPersonID(Integer personID) {
		this.personID = personID;
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
	public String getDatetime() {
		return datetime;
	}
	public void setDatetime(String datetime) {
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