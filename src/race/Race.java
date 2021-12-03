package race;

import java.util.Scanner;

import leaderboard.Startlist;
import skier.Skier;
import skier.random.RaceTag;


public class Race {
	//Variabler och metoder som g�ller b�de individuell start, jaktstart och masstart
	
	public static void addSkier() {
		Scanner in = new Scanner(System.in);
		System.out.println("Hur m�nga �kare vill du l�gga till?");
		
		int nrNewSkiers = in.nextInt();
		
		Startlist startlist = new Startlist();
		
		for (int i = 0; i < nrNewSkiers;i++) {
		System.out.println("Namn: ");
		String name = in.next();
		
		System.out.println("�lder:");
		int age = in.nextInt();
		
		Skier skier = new Skier(i+1, name, age);
		
		startlist.addSkiers(skier);	
		}
		
		RaceTag raceTag = new RaceTag();
		raceTag.rndRaceTag(startlist);
	}
	

}
