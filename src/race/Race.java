package race;

import inputs.InputExceptionHandler;
import leaderboard.Startlist;
import skier.Skier;
import skier.random.RaceTag;

public class Race extends Startlist {
	// Variabler och metoder som gäller individuell start.
	
	public void addSkier() {
		InputExceptionHandler inputs = new InputExceptionHandler();
		System.out.println("Hur många åkare vill du lägga till?");

		int nrNewSkiers = inputs.inputInt("antal åkare");

		for (int i = 0; i < nrNewSkiers; i++) {
			System.out.println("Namn: ");
			String name = inputs.inputStringNext();

			System.out.println("Ålder:");
			int age = inputs.inputInt("en ålder");


			Skier skier = new Skier(i + 1, name, age);

			addSkiers(skier);
		}
		RaceTag raceTag = new RaceTag();
		raceTag.rndRaceTag(this);
	}
}
