package skier.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import leaderboard.Startlist;
import skier.Skier;

public class RaceTag {
	
	public void rndRaceTag(Startlist list) {
		
		// Tempor�r lista som inneh�ller startNumber
		List<Integer> startNumbers = new ArrayList<Integer>();
	
		
		//Skriver ut listan i den ordning anv�ndaren skrivit in
		for (Skier test : list.getSkierslist()) {
			startNumbers.add(test.getStartNumber());
		}
		
		// Kastar om den tempor�ra listans startNumber
		Collections.shuffle(startNumbers);
		
		// L�gger in den slumpade startNumbers i den orginallisten 
		for (int i = 0; i < startNumbers.size(); i++) {
			list.getSkierslist().get(i).setStartNumber(startNumbers.get(i));
		}


		
		// Sorterar orginallistan efter startNumber
		Collections.sort(list.getSkierslist(), new Sortbyroll());
		
		list.printSkiersList();

	}
	
	class Sortbyroll implements Comparator<Skier>
	{
	    public int compare(Skier a, Skier b)
	    {
	        return a.getStartNumber() - b.getStartNumber();
	    }
	}
	
	
	
	
}