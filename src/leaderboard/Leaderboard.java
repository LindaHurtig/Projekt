package leaderboard;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import skier.Skier;

public class Leaderboard {
	
	private List<Skier> startList;
	
	public Leaderboard(List<Skier> list) {
		this.startList = list;
	}
	
	public void printLeaderBoardResult() {
		// Sorterar orginallistan efter getFinalTime()
		Collections.sort(startList, new SortByTime());
		
		int winnerIndex = 1;
		System.out.println("------------------SLUT RESULTAT-------------------");
		String str = "";
		for(Skier skier : startList) {
			str = "Placering: " + winnerIndex + " | Namn: " + skier.getName() + " | Ålder: " + skier.getAge() + " | Starttid: " + convertTime(skier.getStartTime());
			str += " | Mellantid: " + (skier.getSplitTime() == -1 ? "--" : convertTime(skier.getSplitTime()));
			str += " | Sluttid: " + convertTime(skier.getFinalTime());
			System.out.println(str);
			winnerIndex++;
		}
		System.out.println("--------------------------------------------------");
	}
	
	public void printSkierSplitTime(int skierNumber) {
		if(skierNumber > startList.size()) {
			System.out.println("Kan inte hitta åkare!");
			return;
		}
		Skier skier = startList.get(skierNumber);
		System.out.println("Startnummer: " + skier.getStartNumber() + " | Namn: " + skier.getName() + " | Mellantid: " + convertTime(skier.getSplitTime()));
		System.out.println("");
	}
	
	public String convertTime(long durationInMillis) {
		long millis = durationInMillis % 1000;
		long second = (durationInMillis / 1000) % 60;
		long minute = (durationInMillis / (1000 * 60)) % 60;
		long hour = (durationInMillis / (1000 * 60 * 60)) % 24;

		String time = String.format("%02d:%02d:%02d.%d", hour, minute, second, millis);
		return time;
	}
	
	class SortByTime implements Comparator<Skier> {
		public int compare(Skier a, Skier b) {
			return (int) (a.getFinalTime() - b.getFinalTime());
		}
	}

}
