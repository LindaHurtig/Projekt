package leaderboard;

import java.util.ArrayList;

import skier.Skier;

public class Startlist {
	
	private ArrayList <Skier> skierslist;





	public ArrayList<Skier> getSkierslist() {
		return skierslist;
	}





	public void setSkierslist(ArrayList<Skier> skierslist) {
		this.skierslist = skierslist;
	}





	public void addSkiers(Skier skier) {
		skierslist.add(skier);
	
	}
	
	
	
}
