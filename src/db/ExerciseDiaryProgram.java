package db;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import model.Exercise;
import model.Group;
import model.Session;
import model.SuperGroup;

public class ExerciseDiaryProgram {

	// Fields

	// Database ref?
	// Menu thing ref?
	// input scanner thing ref?
	Scanner in;
	Connection con;
	int menuItem;
	DBProxy proxy;

	// Constructor
	public ExerciseDiaryProgram(Connection con, DBProxy proxy) {
		
		this.con = con;
		in = new Scanner(System.in);
		this.proxy = proxy;

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
		editSession(new Session(0, 0, 0, LocalDateTime.now(), 0, 0, "0", "0", 0, 0, 0, "0", false, null));

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
				break;
			case 2:
				// Handle display of list of exercises in Sesssion tostring
				

				while (ok_2) {
					System.out.println("Add existing exercise: 1");
					System.out.println("Add New exercise: 2");
					System.out.println("OK: 3");

					menuItem = Integer.parseInt(takeInput());
					switch (menuItem) {

					case 1:
						for(Exercise exercise: proxy.getExercises()){
							System.out.print(exercise.getID());							
						}
						break;

					case 2:
						
						break;

					case 3:
						System.out.println("done");
						ok_2 = false;
						break;
					}
				}
			case 3:
				System.out.println("Using the format \"yyyy-MM-dd HH:mm\",");
				System.out.println("Enter datetime: ");
				sessionTime = LocalDateTime.parse( takeInput() , formatter);
				currentS.setDateTime(sessionTime);
				//TODO fix sessionTime
				break;
				
			case 4:
				duration = Integer.parseInt(takeInput());
				currentS.setDuration(duration);
				break;
			case 5:
				healthCondition = Integer.parseInt(takeInput());
				break;
			case 6:
				performance = Integer.parseInt(takeInput());
				currentS.setPerformance(performance);
				break;
			case 7:
				// Change to take long input
				purposeNote = in.next();
				break;
			case 8:
				// change to take long input
				tips = in.next();
				break;
			case 9:
				spectators = Integer.parseInt(takeInput());
				break;
			case 10:
				airConditions = Integer.parseInt(takeInput());
				break;
			case 11:
				weatherTemperature = in.nextInt();
				break;
			case 12: // sub stuff here, indoor and fill out
				System.out.println("If outdoor, enter 1: ");
				
				outDoorInt = Integer.parseInt(takeInput());
				if (outDoorInt == 1) {
					outDoor = true;
				} else {
					outDoor = false;
				}
				break;
			case 13:
				submitted = true;
				//TODO find some way to generate IDs as appropriate and add them
				DBProxy.uploadSession(currentS);
				System.out.println("Form submitted");
			
				//TODO Do the DB upload here using sessionSubmit
				break;

			case 14:
				Session templateS = new Session(personID, personID, duration, sessionTime, healthCondition, performance, purposeNote, tips, spectators, airConditions, weatherTemperature, weatherType, outDoor, eList);
				//TODO do template submit here
				System.out.println("Template saved");
				break;
			case 15:
				//TODO do template submit here. Do like currentS = <- sessionobject here
				System.out.println("Loaded Template");
				break;

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
						break;
					case 2:
						//TODO fix adding result for specific exercise in this
						// training session
						break;
					case 3:
						System.out.println("done");
						ok_3 = false;
						break;
					}
				}
			case 17:
				weatherType = takeInput();
				currentS.setWeatherType(weatherType);
				break;
			default:
				System.out.println("Invalid choice.");
				break;
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
				ID = takeInput();
				break;
			case 2:
				sessionID = Integer.parseInt(takeInput());
				currentE.setSESSION_ID(null);
				break;
			case 3:
				group = takeInput();
				currentE.setGruppeID(group);
				break;
			case 4:
				description = takeInput();
				currentE.setDescription(description);
				break;
			case 5:
				type = takeInput();
				currentE.setType(type);
				break;
			case 6:
				intensity = Integer.parseInt(takeInput());
				currentE.setIntensity(intensity);
				break;
			case 7:
				wLoad = Double.parseDouble(takeInput());
				currentE.setwLoad(wLoad);
				break;
			case 8:
				nrReps = Integer.parseInt(takeInput());
				currentE.setNrReps(nrReps);
				break;
			case 9:
				nrSets =Integer.parseInt(takeInput());
				currentE.setNrSets(nrSets);
				break;
			case 10:
				duration = Integer.parseInt(takeInput());
				currentE.setDuration(duration);
				break;
			case 11:
				distance =  Integer.parseInt(takeInput());
				currentE.setDistance(distance);
				break;
			case 12:
				DBProxy.uploadExercises(currentE);
				System.out.println("Exercise submitted");
				submitted = true;
				break;
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
	
	public SuperGroup searchSuperGroup (){
		
		return null;
	}

	// Display method/S?

	// refresh, take input?

}
