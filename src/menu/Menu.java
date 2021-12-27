package menu;

import java.util.Scanner;

import race.Race;
import race.individualrace.*;

public class Menu {

	public static void main(String[] args) {
		
		System.out.println("Hej och välkommen till dagens skidtävling från grupp 4A");

		Scanner input = new Scanner(System.in);
		int choice;

		do {
			System.out.println("[1] Individuellstart");
			System.out.println("[2] Läggtill åkare");
			System.out.println("[3] Avsluta");

			choice = input.nextInt();

			switch (choice) {

			case 1 -> IndividualRace.startIndividualRace();
			case 2 -> Race.addSkier();
			case 3 -> System.out.println("Programmet avslutas");
			default -> System.out.println("Ogiltigt val\n");

			}

		} while (choice != 3);
		input.close();
	}
}
