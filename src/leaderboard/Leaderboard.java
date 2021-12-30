package leaderboard;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import skier.Skier;
import skier.random.RaceTag;

public class Leaderboard {
	
	private List<Skier> startList;
	
	public Leaderboard(List<Skier> list) {
		this.startList = list;
	}
	
	
	public void printLeaderBoardResult() {
		// Sorterar orginallistan efter getFinalTime()
		Collections.sort(startList, new SortByTime());
		
		System.out.println("-----SLUT RESULTAT-----");
		String str = "";
		for(Skier skier : startList) {
			str = "Startnr: " + skier.getStartNumber() + " | Namn: " + skier.getName() + " | Ålder: " + skier.getAge() + " | Starttid: " + convertTime(skier.getStartTime());
			if(skier.getSplitTime() == -1) {
				str += " | Mellantid: --";
			} else {
				str += " | Mellantid: " + convertTime(skier.getSplitTime());
			}
			str += " | Sluttid: " + convertTime(skier.getFinalTime());
			System.out.println(str);
		}
	}
	
	public void printSkierSplitTime(int skierNumber) {
		Skier skier = startList.get(skierNumber);
		if(skier == null) {
			System.out.println("Kan inte hitta åkare!");
			return;
		}
		System.out.println("Startnummer: " + skier.getStartNumber() + " | Namn: " + skier.getName() + " | Mellantid: " + convertTime(skier.getSplitTime()));
		
	}
	
	public String convertTime(long durationInMillis) {
		long millis = durationInMillis % 1000;
		long second = (durationInMillis / 1000) % 60;
		long minute = (durationInMillis / (1000 * 60)) % 60;
		long hour = (durationInMillis / (1000 * 60 * 60)) % 24;

		String time = String.format("%02d:%02d:%02d.%d", hour, minute, second, millis);
		return time;
	}
	
	private class SortByTime implements Comparator<Skier> {
		public int compare(Skier a, Skier b) {
			return (int) (a.getFinalTime() - b.getFinalTime());
		}
	}

}
