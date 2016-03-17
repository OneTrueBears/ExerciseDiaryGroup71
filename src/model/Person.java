package model;

public class Person {

	private final int PERSON_ID;
	private final String NAME;
	public Person(int pERSON_ID, String nAME) {
		super();
		PERSON_ID = pERSON_ID;
		NAME = nAME;
	}
	public int getPERSON_ID() {
		return PERSON_ID;
	}
	public String getNAME() {
		return NAME;
	}
	
	
}
/*
CREATE TABLE PERSON(
PERSON_ID INT NOT NULL,
NAVN VARCHAR(100),
PRIMARY KEY(PERSON_ID) );
*/