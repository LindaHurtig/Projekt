package menu;

import java.util.Scanner;

import race.Race;
import race.individualrace.*;
import race.massrace.*;
import race.pursuitrace.*;

public class Menu {

	public static void main(String[] args) {

		System.out.println("Hej och välkommen till dagens skidtävling från grupp 4A");

		Scanner input = new Scanner(System.in);
		int choice;

		do {
			System.out.println("[1] Individuellstart");
			System.out.println("[2] Masstart");
			System.out.println("[3] Jaktstart");
			System.out.println("[4] Läggtill åkare");
			System.out.println("[5] Avsluta");

			choice = input.nextInt();

			switch (choice) {

			case 1 -> IndividualRace.startIndividualRace();
			case 2 -> MassRace.startMassRace();
			case 3 -> PursuitRace.startPursuitRace();
			case 4 -> Race.addSkier();
			case 5 -> System.out.println("Programmet avslutas");
			default -> System.out.println("Ogiltigt val\n");

			}

		} while (choice != 5);
		input.close();
	}
}
