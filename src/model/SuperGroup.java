package model;

import java.util.ArrayList;

public class SuperGroup {

	private final String SUPERGROUP_ID;
	private ArrayList<Group> subGroupList;
	public SuperGroup(String sUPERGROUP_ID, ArrayList<Group> subGroupList) {
		super();
		SUPERGROUP_ID = sUPERGROUP_ID;
		this.subGroupList = subGroupList;
	}
	public ArrayList<Group> getSubGroupList() {
		return subGroupList;
	}
	public void setSubGroupList(ArrayList<Group> subGroupList) {
		this.subGroupList = subGroupList;
	}
	public String getSUPERGROUP_ID() {
		return SUPERGROUP_ID;
	}
	
	
}

/*
CREATE TABLE SUPERGROUP(
SUPERGROUP_ID VARCHAR(50) NOT NULL,
PRIMARY KEY(SUPERGROUP_ID));

CREATE TABLE PART_OF_SUPERGROUP(
    PARENT_SUPERGROUP VARCHAR(50) NOT NULL,
    CHILD_SUPERGROUP VARCHAR(50) NOT NULL,
    PRIMARY KEY(PARENT_SUPERGROUP, CHILD_SUPERGROUP),
    FOREIGN KEY(PARENT_SUPERGROUP)
        REFERENCES SUPERGROUP(SUPERGROUP_ID)
        ON UPDATE CASCADE,
    FOREIGN KEY(CHILD_SUPERGROUP)
        REFERENCES SUPERGROUP(SUPERGROUP_ID)
        ON UPDATE CASCADE);
*/