package db;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Scanner;

import model.Exercise;
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
		menuItem = Integer.parseInt(takeInput());
		switch (menuItem) {
		case 1:
			// sql injection
			System.out.println("Choice 1 selected");
			editSession();
		case 2:
			// sql injection
			editExercise();
		default:
			System.out.println("Invalid choice.");
		}
	}

	private void editSession() { // black redirect
		editSession(new Session(0, 0, 0, new Date(), 0, menuItem, null, null, menuItem, menuItem, menuItem, null, false));

	}

	private void editSession(Session session) {

		String name;
		int personID = 1;
		String sessionTimeString;
		LocalDateTime sessionTime;
		int duration;
		int spectators;
		int healthCondition;
		int performance;
		String purposeNote;
		String tips;
		String airConditions;
		int weatherTemperature;
		boolean outDoor;
		boolean submitted = false;
		String weatherType;

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
			System.out.println("Add dateTime: 3");
			System.out.println("Add duration: 4");
			System.out.println("Add Health Condition: 5");
			System.out.println("Add Performance: 6");
			System.out.println("Add Purpose Note: 7");
			System.out.println("Add Tips: 8");
			System.out.println("Add Spectators: 9");
			System.out.println("Add Air Conditions: 10");
			System.out.println("Add Weather Temperature: 11");
			System.out.println("Is it outdoor?: 12");
			System.out.println("Submit form: 13");
			System.out.println("Save to Template: 14");
			System.out.println("Load from Template: 15");
			System.out.println("Select exercise for Swap/Result actions: 16");
			System.out.println("Add Weather type: 17");

			menuItem = Integer.parseInt(takeInput());

			switch (menuItem) {
			case 1:
				name = takeInput();
			case 2:
				// Handle display of list of exercises in Sesssion tostring
				boolean ok_2 = true;

				while (ok_2) {
					System.out.println("Add existing exercise: 1");
					System.out.println("Add New exercise: 2");
					System.out.println("OK: 3");

					menuItem = Integer.parseInt(takeInput());
					switch (menuItem) {

					case 1:
						// System.out.println("Type name of the exercise you
						// want to add");
						// call find exercise dialouge and return it here to be
						// added

					case 2:
						// do something like session.addExercise( editExercise()
						// ) // call make new exercise and return into a method
						// that adds this to session

					case 3:
						System.out.println("done");
						ok_2 = false;
					}
				}
			case 3:
				
			case 4:
				duration = Integer.parseInt(takeInput());
			case 5:
				healthCondition = Integer.parseInt(takeInput());
			case 6:
				performance = Integer.parseInt(takeInput());
				currentS.setPerformance(performance);
			case 7:
				// Change to take long input
				purposeNote = in.next();
			case 8:
				// change to take long input
				tips = in.next();
			case 9:
				spectators = Integer.parseInt(takeInput());
			case 10:
				airConditions = (takeInput());
			case 11:
				weatherTemperature = in.nextInt();
			case 12: // sub stuff here, indoor and fill out
				int outDoorInt = in.nextInt();
				if (outDoorInt == 1) {
					outDoor = true;
				} else {
					outDoor = false;
				}
			case 13:
				System.out.println("Form submitted");
				// Do the DB stuff here
				submitted = true;

			case 14:
				// do template submit here
				System.out.println("Template saved");
			case 15:
				// do template submit here
				System.out.println("Loaded Template");

			case 16:
				// do swap here.
				boolean ok_3 = true;

				while (ok_3) {
					System.out.println("Swap existing exercise for subsitute: 1");
					System.out.println("Add result for exercise: 2");
					System.out.println("OK: 3");

					menuItem = Integer.parseInt(takeInput());
					switch (menuItem) {

					case 1:
						// select exercise, enable substitution

					case 2:
						// fix adding result for specific exercise in this
						// training session

					case 3:
						System.out.println("done");
						ok_3 = false;
					}
				}
			case 17:
				weatherType = takeInput();
				currentS.setWeatherType(weatherType);
			default:
				System.out.println("Invalid choice.");
			} // RESULTS HOW
		}
	}

	private void login() {
		Boolean ok = true;
		while (ok) {
			System.out.println("Login: 1");
			menuItem = Integer.parseInt(takeInput());
			switch (menuItem) {
			case 1:
				System.out.println("Enter username: ");
				String username = takeInput();
				int personID = 1;
				// sql injection
				ok = false;
				mainMenu();
			default:
				System.out.println("Invalid choice.");
			}
		}
	}

	// DUD for now
	private void editExercise() { // black redirect
		editExercise(new Exercise(null, menuItem, null, null, null, menuItem, menuItem, menuItem, menuItem, menuItem,
				menuItem));

	}

	private void editExercise(Exercise exercise) {
		String name;
		String sessionTimeString;
		// progress
		LocalDateTime sessionTime;
		int spectators;
		int healthCondition;
		int performance;
		String purposeNote;
		String tips;
		int airConditions;
		int weatherTemperature;
		boolean outDoor;
		boolean submitted = true;

		while (submitted == false) {
			System.out.println("View of current Session being edited:");
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

	// Helper methods ---------------------

	public String takeInput() {
		while (in.hasNext()) {
			return in.next();
		}
		return null;
	}

	// Display method/S?

	// refresh, take input?

}
