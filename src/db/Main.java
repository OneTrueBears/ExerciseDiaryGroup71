package db;

import java.sql.Connection;

public class Main {
	public static void main(String[] args){
//		connector.connect();
		Connection con = DBConnect.quickConnect();
		DBProxy proxy = new DBProxy();
		proxy.getExercises(con);
		ExerciseDiaryProgram program = new ExerciseDiaryProgram();
		program.run();
	}
}
