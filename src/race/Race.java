package race;


import java.util.Scanner;

import leaderboard.Startlist;
import skier.Skier;
import skier.random.RaceTag;

public class Race extends Startlist {
	//Variabler och metoder som gäller både individuell start, jaktstart och masstart

	public void addSkier() {
		Scanner in = new Scanner(System.in);
		System.out.println("Hur många åkare vill du lägga till?");

		int nrNewSkiers = in.nextInt();

		for (int i = 0; i < nrNewSkiers;i++) {
			System.out.println("Namn: ");
			String name = in.next();

			System.out.println("Ålder:");
			int age = in.nextInt();

			Skier skier = new Skier(i+1, name, age);

			addSkiers(skier);	
		}
		RaceTag raceTag = new RaceTag();
		raceTag.rndRaceTag(this);
	}
}
