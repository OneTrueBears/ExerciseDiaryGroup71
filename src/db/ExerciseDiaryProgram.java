package db;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import model.Session;

public class ExerciseDiaryProgram {

	// Fields

	// Database ref?
	// Menu thing ref?
	// input scanner thing ref?
	Scanner in;
	int menuItem;

	// Constructor
	public ExerciseDiaryProgram() {

		in = new Scanner(System.in);

	}

	// Run main logic loop
	public void run() {
		login();
		// display home menu

	}

	// General actions : '-x' : instructions '-x' : Back/Cancel ||| Current
	// actions:

	// The MEAT - Methods ------------------

	// undecided - return object(s?) or simply redirect n all such

	private void mainMenu() {
		System.out.println("New Session: 1");
		System.out.println("New Exercise: 2");
		while (in.hasNext()) {
			menuItem = in.nextInt();
		}
		switch (menuItem) {
		case 1:
			// sql injection
			editSession();
		case 2:
			// sql injection
			//editExercise();
		default:
			System.out.println("Invalid choice.");
		}
	}

	private void editSession() { // black redirect
		editSession(new Session(0,0,0,new Date(),0, 0,"", "", 0, 0 , 0, "", false));

	}

	private void editSession(Session session) {
		// Populate PotentialActions
		// -x : Back/Cancel -x : Import template -x Name: Enter name of exercise
		// session

		// take input

		// Input Field
		String name;
		int personID = 1;
		String sessionTimeString;
		LocalDateTime sessionTime;
		int spectators;
		int healthCondition;
		int performance;
		String purposeNote;
		String tips;
		int airConditions;
		int weatherTemperature;
		boolean outDoor;
		boolean submitted = false;

		Session currentS = session;

		while (submitted == false) {
			System.out.println("View of current Session being edited:");
			System.out.println(currentS.toString()); // New session objects are
														// created black so this
														// should show the empty
														// default first
														// timearound
			System.out.println("Name Session: 1");
			System.out.println("Add Exercise: 2");
			System.out.println("Add date: 3");
			System.out.println("Add Health Condition: 4");
			System.out.println("Add Performance: 5");
			System.out.println("Add Purpose Note: 6");
			System.out.println("Add Tips: 7");
			System.out.println("Add Spectators: 8");
			System.out.println("Add Air Conditions: 9");
			System.out.println("Add Weather Temperature: 10");
			System.out.println("Is it outdoor?: 11");
			System.out.println("Submit form: 12");
			while (in.hasNext()) {
				menuItem = in.nextInt();
			}
			switch (menuItem) {
			case 1:
				name = in.next();
			case 2:
				// sql injection
			case 3:
				sessionTimeString = in.next();
			case 4:
				healthCondition = in.nextInt();
			case 5:
				performance = in.nextInt();
			case 6:
				purposeNote = in.next();
			case 7:
				tips = in.next();
			case 8:
				spectators = in.nextInt();
			case 9:
				airConditions = in.nextInt();
			case 10:
				weatherTemperature = in.nextInt();
			case 11:
				int outDoorInt = in.nextInt();
				if (outDoorInt == 1) {
					outDoor = true;
				} else {
					outDoor = false;
				}
			case 12:
				System.out.println("Form submitted");
				// Do the DB stuff here
				submitted = true;
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	private void login () {
    	    Boolean ok = false;
    	    while (ok) {
    	      System.out.println("Login: 1");
    	      while (in.hasNext()){
    	        menuItem = in.nextInt();
    	      }

    	      switch (menuItem){
    	      case 1:
    	        String username = in.next();
    	        int personID = 1;
    	        //sql injection
    	        ok = true;
    	        mainMenu();
    	      default:
    	        System.out.println("Invalid choice.");
    	    }
    }
	
	
	
	
	
	
	
	
	// Helper methods ---------------------
	
	
	//Display method/S?
	
	//refresh, take input?
	
	

}
}
