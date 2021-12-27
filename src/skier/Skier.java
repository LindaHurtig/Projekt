package skier;

import person.Person;
import time.StopWatch;

public class Skier extends Person {
	
	private StopWatch startTime = new StopWatch();
	private long finalTime = -1; 
	private long splitTime = -1;

	public Skier(int startNumber, String name, int age) {
		super(startNumber, name, age);

	}

	public StopWatch getStartTime() {
		return startTime;
	}

	public void setStartTime(StopWatch startTime) {
		this.startTime = startTime;
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
