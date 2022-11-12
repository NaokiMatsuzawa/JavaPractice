package system_in;

import java.util.Scanner;

public class SystemIn {
	Scanner scanner = null;
	
	private SystemIn() {
		scanner = new Scanner(System.in);
	}
	
	public static Scanner getScanner() {
		return SystemInInstanceHolder.instance.scanner;
	}
	
	public static class SystemInInstanceHolder{
		private static final SystemIn instance = new SystemIn();
	}
}
