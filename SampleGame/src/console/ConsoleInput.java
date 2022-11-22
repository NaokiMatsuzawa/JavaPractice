package console;

import java.util.Scanner;

class ConsoleInput {
	private Scanner scn = new Scanner(System.in);
	
	public int getInputInt() {
		return scn.nextInt();
	}
}
