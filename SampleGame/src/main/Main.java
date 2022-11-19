package main;

public class Main {

	public static void main(String[] args) {
		GameRoutine routine = GameRoutine.getInstance();
		while(true) {
			routine.run();
		}
	}

}
