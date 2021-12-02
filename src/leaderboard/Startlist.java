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
		
		String skierslista = skierslist.toString();
	System.out.println(skierslista);

	}
	
}
