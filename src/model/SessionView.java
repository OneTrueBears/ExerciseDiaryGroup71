package model;

public class SessionView {

	private final int ID;
	private final String date;
	public SessionView(int iD, String date) {
		super();
		ID = iD;
		this.date = date;
	}
	public int getID() {
		return ID;
	}
	public String getDate() {
		return date;
	}
	
	
}
