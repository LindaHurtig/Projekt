package race;

import inputs.InputExceptionHandler;
import leaderboard.Startlist;
import skier.Skier;
import skier.random.RaceTag;

public class Race extends Startlist {
	// Variabler och metoder som g�ller individuell start.
	
	public void addSkier() {
		InputExceptionHandler inputs = new InputExceptionHandler();
		System.out.println("Hur m�nga �kare vill du l�gga till?");

		int nrNewSkiers = inputs.inputInt("antal �kare");

		for (int i = 0; i < nrNewSkiers; i++) {
			System.out.println("Namn: ");
			String name = inputs.inputStringNext();

			System.out.println("�lder:");
			int age = inputs.inputInt("en �lder");


			Skier skier = new Skier(i + 1, name, age);

			addSkiers(skier);
		}
		RaceTag raceTag = new RaceTag();
		raceTag.rndRaceTag(this);
	}
}
