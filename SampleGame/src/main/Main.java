package main;

public class Main {

	public static void main(String[] args) {
		GameRoutine routine = GameRoutine.getInstance();
		//routine.run();
		while(!routine.isClosed()) {
			routine.run();
		}
	}

}
