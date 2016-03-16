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