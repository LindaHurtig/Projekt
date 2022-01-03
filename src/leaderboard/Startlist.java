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
		System.out.println("--------------------STARTLISTA--------------------");
		System.out.println("Antal deltagare: " + skierslist.size());
		System.out.println("Startnr:\tNamn:\t�lder");
		for(Skier skier : skierslist) {
			System.out.println(skier.getStartNumber() + "\t\t" + skier.getName() + "\t" + skier.getAge());
		}
		System.out.println("--------------------------------------------------\n");
	}
}
