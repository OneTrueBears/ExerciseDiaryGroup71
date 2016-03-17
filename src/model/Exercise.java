package model;

public class Exercise {
	private final String ID;
	private Integer SESSION_ID;
	private String gruppeID;
	private String description;
	private String type;
	private Integer intensity;
	private double wLoad;
	private Integer nrReps;
	private Integer nrSets;
	private Integer duration;
	private Integer distance;
	
	//TODO: List of substitute exercises.
	

	public Exercise(String iD, Integer sESSION_ID, String gruppeID, String description, String type, Integer intensity,
			double wLoad, Integer nrReps, Integer nrSets, Integer duration, Integer distance) {
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


	public Integer getSESSION_ID() {
		return SESSION_ID;
	}


	public void setSESSION_ID(Integer sESSION_ID) {
		SESSION_ID = sESSION_ID;
	}


	public String getGruppeID() {
		return gruppeID;
	}


	public void setGruppeID(String gruppeID) {
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


	public Integer getIntensity() {
		return intensity;
	}


	public void setIntensity(Integer intensity) {
		this.intensity = intensity;
	}


	public double getwLoad() {
		return wLoad;
	}


	public void setwLoad(double wLoad) {
		this.wLoad = wLoad;
	}


	public Integer getNrReps() {
		return nrReps;
	}


	public void setNrReps(Integer nrReps) {
		this.nrReps = nrReps;
	}


	public Integer getNrSets() {
		return nrSets;
	}


	public void setNrSets(Integer nrSets) {
		this.nrSets = nrSets;
	}


	public Integer getDuration() {
		return duration;
	}


	public void setDuration(Integer duration) {
		this.duration = duration;
	}


	public Integer getDistance() {
		return distance;
	}


	public void setDistance(Integer distance) {
		this.distance = distance;
	}


	public String getID() {
		return ID;
	}


	@Override
	public String toString() {
		return "Exercise [ID=" + ID + ", SESSION_ID=" + SESSION_ID + ", gruppeID=" + gruppeID + ", description="
				+ description + ", type=" + type + ", intensity=" + intensity + ", wLoad=" + wLoad + ", nrReps="
				+ nrReps + ", nrSets=" + nrSets + ", duration=" + duration + ", distance=" + distance + "]";
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