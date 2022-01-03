package inputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputExceptionHandler {
	
	public Scanner scan = new Scanner(System.in);

	public String inputStringNext() {
		return scan.next();
	}
	
	public String inputStringNextLine() {
		if(scan.hasNext()) {
			return scan.nextLine();
		}
		return null;
	}

	public int inputInt(String str) {
		int inputInt = 0;
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
	
	public void closeScanner() {
		scan.close();
	}
}
