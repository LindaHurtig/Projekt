package race;

import inputs.AllInputs;
import leaderboard.Startlist;
import skier.Skier;
import skier.random.RaceTag;

public class Race extends Startlist {
	// Variabler och metoder som g�ller b�de individuell start, jaktstart och
	// masstart

	// TODO kvalitetss�kring.
	public void addSkier() {
		AllInputs inputs = new AllInputs();
		System.out.println("Hur m�nga �kare vill du l�gga till?");

		int nrNewSkiers = inputs.inputInt("antal �kare");

		for (int i = 0; i < nrNewSkiers; i++) {
			System.out.println("Namn: ");
			String name = inputs.inputString();

			System.out.println("�lder:");
			int age = inputs.inputInt("en �lder");


			Skier skier = new Skier(i + 1, name, age);

			addSkiers(skier);
		}
		RaceTag raceTag = new RaceTag();
		raceTag.rndRaceTag(this);
	}
}
