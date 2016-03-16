package model;

public class Exercise {
	private final String ID;
	private int SESSION_ID;
	private int gruppeID;
	private String description;
	private String type;
	private int intensity;
	private double wLoad;
	private int nrReps;
	private int nrSets;
	private int duration;
	private int distance;
	public Exercise(String iD, int sESSION_ID, int gruppeID, String description, String type, int intensity,
			double wLoad, int nrReps, int nrSets, int duration, int distance) {
		super();
		ID = iD;
		SESSION_ID = sESSION_ID;
		this.gruppeID = gruppeID;
		this.description = description;
		this.type = type;
		this.intensity = intensity;
		this.wLoad = wLoad;
		this.nrReps = nrReps;
		this.nrSets = nrSets;
		this.duration = duration;
		this.distance = distance;
	}
	public int getSESSION_ID() {
		return SESSION_ID;
	}
	public void setSESSION_ID(int sESSION_ID) {
		SESSION_ID = sESSION_ID;
	}
	public int getGruppeID() {
		return gruppeID;
	}
	public void setGruppeID(int gruppeID) {
		this.gruppeID = gruppeID;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getIntensity() {
		return intensity;
	}
	public void setIntensity(int intensity) {
		this.intensity = intensity;
	}
	public double getwLoad() {
		return wLoad;
	}
	public void setwLoad(double wLoad) {
		this.wLoad = wLoad;
	}
	public int getNrReps() {
		return nrReps;
	}
	public void setNrReps(int nrReps) {
		this.nrReps = nrReps;
	}
	public int getNrSets() {
		return nrSets;
	}
	public void setNrSets(int nrSets) {
		this.nrSets = nrSets;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public String getID() {
		return ID;
	}
	
	
}

/*
CREATE TABLE EXERCISE(
EXERCISE_ID VARCHAR(200) NOT NULL,
SESSION_ID INT,
GRUPPE_ID VARCHAR(50),
DESCRIPTION VARCHAR(1000),
TYPE VARCHAR(50) NOT NULL,

INTENSITY INT,
W_LOAD DOUBLE,
NR_REPS  INT,
NR_SETS  INT,
DURATION  INT,
DISTANCE DOUBLE,
PRIMARY KEY(EXERCISE_ID),
FOREIGN KEY(GRUPPE_ID)
REFERENCES GRUPPE(GRUPPE_ID)
ON UPDATE CASCADE);
*/