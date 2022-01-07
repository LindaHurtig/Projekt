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
		Collections.sort(startList, new SortByResultTime());
		
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
		Collections.sort(startList, new SortByCurrentTime());
		int skierPosition = findIndex(skierNumber) + 1;
		System.out.println("Placering: " + skierPosition + " | Startnummer: " + skier.getStartNumber() + " | Namn: " + skier.getName() + " | Mellantid: " + convertTime(skier.getSplitTime()));
		System.out.println("");
	}
	
	private int findIndex(int skierNumber) {
		int index = 0;
		for(int i = 0; i < startList.size(); i++)
			if(startList.get(i).getStartNumber() == skierNumber)
				index++;
		
		return index;
	}

	public String convertTime(long durationInMillis) {
		long millis = durationInMillis % 1000;
		long second = (durationInMillis / 1000) % 60;
		long minute = (durationInMillis / (1000 * 60)) % 60;
		long hour = (durationInMillis / (1000 * 60 * 60)) % 24;

		String time = String.format("%02d:%02d:%02d.%d", hour, minute, second, millis);
		return time;
	}
	
	class SortByResultTime implements Comparator<Skier> {
		public int compare(Skier a, Skier b) {
			return (int) (a.getFinalTime() - b.getFinalTime());
		}
	}
	
	class SortByCurrentTime implements Comparator<Skier> {
		@Override
		public int compare(Skier a, Skier b) {
			if(b.getSplitTime() == -1)
				return 1;
			else if(a.getSplitTime() == -1)
				return 1;
			else
				return (int) (a.getSplitTime() - b.getSplitTime());
		}
		
	}

}
