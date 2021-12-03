package skier.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import leaderboard.Startlist;
import skier.Skier;

public class RaceTag {
	
	public void rndRaceTag(Startlist list) {
		
		// Temporär lista som innehåller startNumber
		List<Integer> startNumbers = new ArrayList<Integer>();
		System.out.println("-- old start numbers --");
		
		//Skriver ut listan i den ordning användaren skrivit in
		for (Skier test : list.getSkierslist()) {
			System.out.println(test.getStartNumber() + ", " + test.getName() + ", " + test.getAge());
			startNumbers.add(test.getStartNumber());
		}
		
		// Kastar om den temporära listans startNumber
		Collections.shuffle(startNumbers);
		
		// Lägger in den slumpade startNumbers i den orginallisten 
		for (int i = 0; i < startNumbers.size(); i++) {
			list.getSkierslist().get(i).setStartNumber(startNumbers.get(i));
		}

		System.out.println("-- new start numbers --"); // ta bort sen, bara för utskrivnings test.
		for (Skier test : list.getSkierslist()) {
			System.out.println(test.getStartNumber() + ", " + test.getName() + ", " + test.getAge());
		}
		
		// Sorterar orginallistan efter startNumber
		Collections.sort(list.getSkierslist(), new Sortbyroll());
		
		System.out.println("-- new start numbers --"); // ta bort sen, bara för utskrivnings test.
		for (Skier test : list.getSkierslist()) {
			System.out.println(test.getStartNumber() + ", " + test.getName() + ", " + test.getAge());
		}
	}
	
	class Sortbyroll implements Comparator<Skier>
	{
	    public int compare(Skier a, Skier b)
	    {
	        return a.getStartNumber() - b.getStartNumber();
	    }
	}
	
	
	
	
}