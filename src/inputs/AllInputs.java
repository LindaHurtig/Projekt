package inputs;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AllInputs {
	private Scanner scan = new Scanner(System.in);

	public String inputString() {
		if(scan.hasNext())
			scan.nextLine();

		return scan.nextLine();
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
	
	public int inputStringToInt(String str, String strNum) {
		int intNum = 0;

			try {
				intNum = Integer.parseInt(strNum);
				
			} catch (InputMismatchException e) {
				System.out.println("Skriv " + str);
				scan.nextLine();
			}
		return intNum;
	}
}
