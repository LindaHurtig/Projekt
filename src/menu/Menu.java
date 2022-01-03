package menu;

import inputs.InputExceptionHandler;
import race.Race;
import race.individualrace.*;

public class Menu {

	public static void main(String[] args) {
		System.out.println("Hej och välkommen till dagens skidtävling från grupp 4A");

		boolean running = true;
		int choice;
		
		InputExceptionHandler inputs = new InputExceptionHandler();

		while(running) {
			System.out.println("[1] Starta race");
			System.out.println("[2] Avsluta");

			choice = inputs.inputInt("ett val ur menyn");

			switch (choice) {
			case 1: 
				Race race = new Race();
				race.addSkier(); 

				IndividualRace iRace = new IndividualRace();
				iRace.startIndividualRace(race.getSkierslist());
				running = false;
				break;
			case 2:  
				System.out.println("Programmet avslutas"); 
				running = false;
				break;
			default: 
				System.out.println("Ogiltigt val\n"); 
				break;
			}

		}
	}
}
