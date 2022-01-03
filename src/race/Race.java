package race;

import java.util.InputMismatchException;
import java.util.Scanner;

import leaderboard.Startlist;
import skier.Skier;
import skier.random.RaceTag;

public class Race extends Startlist {
	// Variabler och metoder som g�ller b�de individuell start, jaktstart och
	// masstart

	// TODO kvalitetss�kring.
	public void addSkier() {
		Scanner in = new Scanner(System.in);
		System.out.println("Hur m�nga �kare vill du l�gga till?");

		int nrNewSkiers = in.nextInt();

		for (int i = 0; i < nrNewSkiers; i++) {
			System.out.println("Namn: ");
			String name = in.next();

			//Ett s�tt att f� r�tt input
			int age = 0;
			while (age >= 0) {
				System.out.println("�lder:");
				try {
					age = in.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("Skriv en �lder tack...");
					in.nextLine();
				}
			}

			Skier skier = new Skier(i + 1, name, age);

			addSkiers(skier);
		}
		RaceTag raceTag = new RaceTag();
		raceTag.rndRaceTag(this);
	}
}
