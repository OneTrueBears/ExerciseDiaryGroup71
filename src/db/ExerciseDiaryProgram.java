package db;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Exercise;
import model.Session;

public class ExerciseDiaryProgram {

	// Fields

	// Database ref?
	// Menu thing ref?
	// input scanner thing ref?
	Scanner in;
	Connection con;
	int menuItem;
	

	// Constructor
	public ExerciseDiaryProgram(Connection con) {
		
		this.con = con;
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
		editSession(new Session(0, 0, 0, LocalDateTime.now(), 0, 0, "0", "0", 0, 0, 0, "0", false));

	}

	private void editSession(Session session) {

		Session currentS = session; //session if editing
		
		String name;
		int personID = currentS.getPERSON_ID();
		LocalDateTime sessionTime = currentS.getDateTime();
		int duration = currentS.getDuration();
		int spectators = currentS.getSpectators();
		int healthCondition = currentS.getHealthCondition();
		int performance= currentS.getPerformance();
		String purposeNote = currentS.getPurposeNote();
		String tips = currentS.getLateTips();
		int airConditions = currentS.getAirCondition();
		int weatherTemperature = currentS.getWeatherTemp();
		boolean outDoor = currentS.isOutdoor();
		boolean submitted = false;
		String weatherType = currentS.getWeatherType();
		ArrayList<Exercise> eList = new ArrayList<Exercise>();

		
		//other
		boolean ok_2 = true;
		int outDoorInt;
		Session sessionSubmit;
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		
		

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
				

				while (ok_2) {
					System.out.println("Add existing exercise: 1");
					System.out.println("Add New exercise: 2");
					System.out.println("OK: 3");

					menuItem = Integer.parseInt(takeInput());
					switch (menuItem) {

					case 1:
						eList.add( searchExercise() );

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
				System.out.println("Using the format \"yyyy-MM-dd HH:mm\",");
				System.out.println("Enter datetime: ");
				sessionTime = LocalDateTime.parse( takeInput() , formatter);
				
				//TODO fix sessionTime
				
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
				airConditions = Integer.parseInt(takeInput());
			case 11:
				weatherTemperature = in.nextInt();
			case 12: // sub stuff here, indoor and fill out
				System.out.println("If outdoor, enter 1: ");
				
				outDoorInt = Integer.parseInt(takeInput());
				if (outDoorInt == 1) {
					outDoor = true;
				} else {
					outDoor = false;
				}
			case 13:
				submitted = true;
				//TODO find some way to generate IDs as appropriate and add them
				sessionSubmit = new Session(personID, personID, duration, sessionTime, healthCondition, performance, purposeNote, tips, spectators, airConditions, weatherTemperature, weatherType, outDoor);
				System.out.println("Form submitted");
			
				//TODO Do the DB upload here using sessionSubmit

			case 14:
				sessionSubmit = new Session(personID, personID, duration, sessionTime, healthCondition, performance, purposeNote, tips, spectators, airConditions, weatherTemperature, weatherType, outDoor);
				//TODO do template submit here
				System.out.println("Template saved");
			case 15:
				//TODO do template submit here. Do like currentS = <- sessionobject here
				System.out.println("Loaded Template");

			case 16:
				boolean ok_3 = true;

				while (ok_3) {
					System.out.println("Swap existing exercise for subsitute: 1");
					System.out.println("Add result for exercise: 2");
					System.out.println("OK: 3");

					menuItem = Integer.parseInt(takeInput());
					switch (menuItem) {

					case 1:
						//TODO select exercise, enable substitution

					case 2:
						//TODO fix adding result for specific exercise in this
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
		String ID;
		int sessionID;
		String group;
		String description;;
		String type;
		int intensity;
  		double wLoad;
  		int nrReps;
  		int nrSets;
  		int duration;
  		int distance;
    
  		Exercise currentE = exercise;
  		
  		boolean  submitted = false;

		while (submitted == false) {
			System.out.println("View of current Exercise being edited:");
			System.out.println("Name Exercise: 1");
			System.out.println("Add to Session: 2");
			System.out.println("Add to Group: 3");
			System.out.println("Add Description: 4");
			System.out.println("Define Type: 5");
			System.out.println("Define Intensity: 6");
			System.out.println("Define Weight Load: 7");
			System.out.println("Define Number of Repetitions: 8");
			System.out.println("Define Number of Sets: 9");
			System.out.println("Define Duration: 10");
			System.out.println("Define Distance: 11");
			System.out.println("Submit Exercise: 12");
			while (in.hasNext()) {
				menuItem = in.nextInt();
			}
			switch (menuItem) {
			case 1:
				ID = in.next();
			case 2:
				sessionID = Integer.parseInt(takeInput());
				currentE.setSESSION_ID(null);
			case 3:
				group = in.next();
				currentE.setGruppeID(group);
			case 4:
				description = takeInput();
				currentE.setDescription(description);
			case 5:
				type = takeInput();
				currentE.setType(type);
			case 6:
				intensity = Integer.parseInt(takeInput());
				currentE.setIntensity(intensity);
			case 7:
				wLoad = Double.parseDouble(takeInput());
				currentE.setwLoad(wLoad);
			case 8:
				nrReps = Integer.parseInt(takeInput());
				currentE.setNrReps(nrReps);
			case 9:
				nrSets =Integer.parseInt(takeInput());
				currentE.setNrSets(nrSets);
			case 10:
				duration = Integer.parseInt(takeInput());
				currentE.setDuration(duration);
			case 11:
				distance =  Integer.parseInt(takeInput());
				currentE.setDistance(distance);
			case 12:
      	DBProxy.uploadExercises();
        System.out.println("Exercise submitted");
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
	
	public Exercise searchExercise (){
		System.out.println("List of exercises in DB:");
		//TODO print that ^
		
		String name = takeInput();
		
		//TODO return the exercise by 'name'
		
		
		
		return null;
	}
	
	public Session searchSession (){
		
		return null;
	}
	
	public Group searchGroup (){
		
		return null;
	}
	
	public Supergroup searchGroup (){
		
		return null;
	}

	// Display method/S?

	// refresh, take input?

}
