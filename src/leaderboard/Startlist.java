package leaderboard;

import java.util.ArrayList;
import java.util.List;

import skier.Skier;

public class Startlist {

	public Startlist() {
		super();
		skierslist = new ArrayList<>();
	}

	private List<Skier> skierslist;

	public List<Skier> getSkierslist() {
		return skierslist;
	}

	public void setSkierslist(ArrayList<Skier> skierslist) {
		this.skierslist = skierslist;
	}

	public void addSkiers(Skier skier) {
		skierslist.add(skier);

	}
	
	public void printSkiersList() {
		for(Skier skier : skierslist) {
			System.out.println(skier.getName() + ": " + skier.getAge());
//			System.out.println(skier.getName() + ": " + skier.getAge() + ": " skier.getStartNumber());
		}
	}
	
	public void sortByStartNuumber() {
		
	}
	
}
