package model;
import java.util.*;

public class Template {

	private final Integer ID;
	private final int PERSON_ID;
	private Integer duration;
	private Date dateTime;
	private Integer healthCondition;
	private Integer performance;
	private String purposeNote;
	private String lateTips;
	private Integer spectators;
	private Integer airCondition;
	private Integer weatherTemp;
	private String weatherType;
	private boolean isOutdoor;
	
	public Template(Integer iD, int pERSON_ID, Integer duration, Date dateTime, Integer healthCondition,
			Integer performance, String purposeNote, String lateTips, Integer spectators, Integer airCondition,
			Integer weatherTemp, String weatherType, boolean isOutdoor) {
		super();
		ID = iD;
		PERSON_ID = pERSON_ID;
		this.duration = duration;
		this.dateTime = dateTime;
		this.healthCondition = healthCondition;
		this.performance = performance;
		this.purposeNote = purposeNote;
		this.lateTips = lateTips;
		this.spectators = spectators;
		this.airCondition = airCondition;
		this.weatherTemp = weatherTemp;
		this.weatherType = weatherType;
		this.isOutdoor = isOutdoor;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	public Integer getHealthCondition() {
		return healthCondition;
	}
	public void setHealthCondition(Integer healthCondition) {
		this.healthCondition = healthCondition;
	}
	public Integer getPerformance() {
		return performance;
	}
	public void setPerformance(Integer performance) {
		this.performance = performance;
	}
	public String getPurposeNote() {
		return purposeNote;
	}
	public void setPurposeNote(String purposeNote) {
		this.purposeNote = purposeNote;
	}
	public String getLateTips() {
		return lateTips;
	}
	public void setLateTips(String lateTips) {
		this.lateTips = lateTips;
	}
	public Integer getSpectators() {
		return spectators;
	}
	public void setSpectators(Integer spectators) {
		this.spectators = spectators;
	}
	public Integer getAirCondition() {
		return airCondition;
	}
	public void setAirCondition(Integer airCondition) {
		this.airCondition = airCondition;
	}
	public Integer getWeatherTemp() {
		return weatherTemp;
	}
	public void setWeatherTemp(Integer weatherTemp) {
		this.weatherTemp = weatherTemp;
	}
	public String getWeatherType() {
		return weatherType;
	}
	public void setWeatherType(String weatherType) {
		this.weatherType = weatherType;
	}
	public boolean isOutdoor() {
		return isOutdoor;
	}
	public void setOutdoor(boolean isOutdoor) {
		this.isOutdoor = isOutdoor;
	}
	public Integer getID() {
		return ID;
	}
	public int getPERSON_ID() {
		return PERSON_ID;
	}
	
}
/*
CREATE TABLE TRAINING_SESSION(
SESSION_ID INT NOT NULL AUTO_INCREMENT,
PERSON_ID INT NOT NULL,
DURATION_MIN INT,
DATE_TIME DATETIME NOT NULL,
HEALTH_CONDITION INT ,
PERFORMANCE INT,
PURPOSE_NOTE VARCHAR(500),
LATE_TIPS VARCHAR(500),
SPECTATORS INT,
AIR_CONDITIONS INT,
WEATHER_TEMP INT,
WEATHER_TYPE VARCHAR(20),
IS_OUTDOOR BOOLEAN,
    PRIMARY KEY(SESSION_ID),
    FOREIGN KEY(PERSON_ID) 
REFERENCES PERSON(PERSON_ID)
ON UPDATE CASCADE
ON DELETE NO ACTION);
*/