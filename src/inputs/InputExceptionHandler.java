package inputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputExceptionHandler {

	public Scanner scan = new Scanner(System.in);

	public String inputStringNext() {
		return scan.next();
	}

	public String inputStringNextLine() {
		if (scan.hasNext()) {
			return scan.nextLine();
		}
		return null;
	}

	public int inputInt(String message) {
		int inputInt = 0;
		while (inputInt >= 0) {
			try {
				inputInt = scan.nextInt();
				return inputInt;
			} catch (InputMismatchException e) {
				System.out.println("Skriv " + message);
				scan.nextLine();
			}
		}
		return inputInt;
	}

	public int inputCharToInt(char charNum, String message) {		
		try {
			int number = Integer.parseInt(String.valueOf(charNum));
			return number;
		}catch(InputMismatchException e){
			System.out.println(message);
			return -1;
		}
	}

	public void closeScanner() {
		scan.close();
	}
}
