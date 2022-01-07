package race;

import inputs.InputExceptionHandler;
import leaderboard.Startlist;
import skier.Skier;
import skier.random.RaceTag;

public class Race extends Startlist {
	// Variabler och metoder som gäller individuell start.
	
	public void addSkier(InputExceptionHandler inputs) {		
		int interval;
		do {
			System.out.println("Välj tidsintervall");
			System.out.println("[1] 15 sekunder");
			System.out.println("[2] 30 sekunder");
			System.out.println("[3] 60 sekunder");
			interval = inputs.inputInt("Skriv ett nummer...");
			
			switch(interval) {
			case 1 -> RaceTag.setInterval(15);
			case 2 -> RaceTag.setInterval(30);
			case 3 -> RaceTag.setInterval(60);
			default -> System.out.println("Välj ett av valen\n");
			}
		}while(interval <= 0  || interval >= 4);
				
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
