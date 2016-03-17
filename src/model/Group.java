package model;

public class Group {
	private final int GRUPPE_ID;
	private String name;
	private SuperGroup superGroup;
	public Group(int gRUPPE_ID, String name, SuperGroup superGroup) {
		super();
		GRUPPE_ID = gRUPPE_ID;
		this.name = name;
		this.superGroup = superGroup;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SuperGroup getSuperGroup() {
		return superGroup;
	}
	public void setSuperGroup(SuperGroup superGroup) {
		this.superGroup = superGroup;
	}
	public int getGRUPPE_ID() {
		return GRUPPE_ID;
	}
	
	
	
}
/*
CREATE TABLE GRUPPE(
GRUPPE_ID VARCHAR(50) NOT NULL,
SUPERGROUP_NAME VARCHAR(50),
PRIMARY KEY(GRUPPE_ID),
FOREIGN KEY(SUPERGROUP_NAME) 
REFERENCES SUPERGROUP(SUPERGROUP_ID)
ON UPDATE CASCADE
ON DELETE NO ACTION);
*/