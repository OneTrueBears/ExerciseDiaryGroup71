package model;

import java.time.LocalDateTime;

public class SessionView {

	private final int ID;
	private final LocalDateTime date;
	public SessionView(int iD, LocalDateTime date) {
		super();
		ID = iD;
		this.date = date;
	}
	public int getID() {
		return ID;
	}
	public LocalDateTime getDate() {
		return date;
	}
	
	
}
