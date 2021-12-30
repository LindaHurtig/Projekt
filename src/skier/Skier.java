package skier;

import person.Person;

public class Skier extends Person {

	private long finalTime = -1; 
	private long splitTime = -1;

	public Skier(int startNumber, String name, int age) {
		super(startNumber, name, age);
	}

	public long getFinalTime() {
		return finalTime;
	}

	public void setFinalTime(long finalTime) {
		this.finalTime = finalTime;
	}

	public long getSplitTime() {
		return splitTime;
	}

	public void setSplitTime(long l) {
		this.splitTime = l;
	}
}
