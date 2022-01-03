package inputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AllInputs {
	public Scanner scan = new Scanner(System.in);

	public String inputString() {
		if(scan.hasNext()) {
			scan.nextLine();
		}
		return scan.nextLine();
	}

	public int inputInt(String str) {
		int inputInt = 0;
		//if(scan.hasNext()) {
		//	scan.nextLine();
		//}
		while (inputInt >= 0) {
			try {
				inputInt = scan.nextInt();
				return inputInt;

			} catch (InputMismatchException e) {
				System.out.println("Skriv " + str);
				scan.nextLine();
			}
		}
		return inputInt;
	}
	
	public int inputStringToInt(String strToInt, String message) {
		int number = 0;
		try {
			number = Integer.parseInt(strToInt);
	    } catch (NumberFormatException nfe) {
	    	System.out.println(message);
	    	return -1;
	    }
		return number;
	}
	
	/*public int inputStringToInt(String strToInt, String message) {
		boolean run = true;
		int number = 0;
		while(run) {
			try {
				number = Integer.parseInt(strToInt);
				run = false;
			} catch (NumberFormatException e) {
				System.out.println(message);
				run = false;
			}
		}
		return number;
	}*/
}
