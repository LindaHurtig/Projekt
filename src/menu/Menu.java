package menu;

import java.util.Scanner;

import race.Race;
import race.individualrace.*;

public class Menu {

	public static void main(String[] args) {
		System.out.println("Hej och välkommen till dagens skidtävling från grupp 4A");

		boolean running = true;
		Scanner input = new Scanner(System.in);
		int choice;

		while(running) {
			System.out.println("[1] Individuellstart");
			System.out.println("[2] Läggtill åkare");
			System.out.println("[3] Testa klocka");
			System.out.println("[4] Avsluta");

			choice = input.nextInt();

			switch (choice) {
			case 1: 
				//...
				break;
			case 2:  
				Race race = new Race();
				race.addSkier(); 

				System.out.println("Inviduella loppet har startat!");
				IndividualRace iRace = new IndividualRace();
				iRace.startIndividualRace(race.getSkierslist());
				running = false;
				break;
			case 5: 
				System.out.println("Programmet avslutas"); 
				running = false;
				input.close();
				break;
			default: 
				System.out.println("Ogiltigt val\n"); 
				break;
			}

		}
	}
}
