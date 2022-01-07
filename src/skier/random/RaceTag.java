package skier.random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import leaderboard.Startlist;
import skier.Skier;

public class RaceTag {
	private static int interval;
	
	public static void setInterval(int interval) {
		RaceTag.interval = interval;
	}
	
	public void rndRaceTag(Startlist list) {
		// Temporär lista som innehåller startNumber
		List<Integer> startNumbers = new ArrayList<Integer>();

		//Skriver ut listan i den ordning användaren skrivit in
		for (Skier test : list.getSkierslist()) {
			startNumbers.add(test.getStartNumber());
		}

		// Kastar om den temporära listans startNumber
		Collections.shuffle(startNumbers);

		// Lägger in de slumpade startNumbers i orginal listan igen.
		for (int i = 0; i < startNumbers.size(); i++) {
			list.getSkierslist().get(i).setStartNumber(startNumbers.get(i));
		}

		// Sorterar orginallistan efter startNumber
		Collections.sort(list.getSkierslist(), new SortByStartNumber());
		
		//lägg till starttid.
		for(Skier s : list.getSkierslist()) {
			s.setStartTime(((interval*1000) * (s.getStartNumber() - 1)));
		}

		list.printSkiersList(); // utskrift av DELTAGARNAS START LISTA.
	}

	class SortByStartNumber implements Comparator<Skier> {
		public int compare(Skier a, Skier b) {
			return a.getStartNumber() - b.getStartNumber();
		}
	}
	
}