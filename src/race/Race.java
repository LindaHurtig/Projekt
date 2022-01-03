package race;

import inputs.AllInputs;
import leaderboard.Startlist;
import skier.Skier;
import skier.random.RaceTag;

public class Race extends Startlist {
	// Variabler och metoder som gäller både individuell start, jaktstart och
	// masstart

	// TODO kvalitetssäkring.
	public void addSkier() {
		AllInputs inputs = new AllInputs();
		System.out.println("Hur många åkare vill du lägga till?");

		int nrNewSkiers = inputs.inputInt("antal åkare");

		for (int i = 0; i < nrNewSkiers; i++) {
			System.out.println("Namn: ");
			String name = inputs.inputString();

			System.out.println("Ålder:");
			int age = inputs.inputInt("en ålder");


			Skier skier = new Skier(i + 1, name, age);

			addSkiers(skier);
		}
		RaceTag raceTag = new RaceTag();
		raceTag.rndRaceTag(this);
	}
}
