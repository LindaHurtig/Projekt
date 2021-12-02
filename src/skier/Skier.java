package skier;

import person.Person;
import time.StopWatch;

public class Skier extends Person{
	

	private int startNumber;
	private StopWatch startTime = new StopWatch();
	private int[] finalTime = new int [3]; 
	private int [] splitTimes = new int [3];
	
	



	public Skier(String name, int age) {
		super(name, age);

	}


	public int getStartNumber() {
		return startNumber;
	}


	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}


	public StopWatch getStartTime() {
		return startTime;
	}


	public void setStartTime(StopWatch startTime) {
		this.startTime = startTime;
	}


	public int[] getFinalTime() {
		return finalTime;
	}


	public void setFinalTime(int[] finalTime) {
		this.finalTime = finalTime;
	}


	public int[] getSplitTimes() {
		return splitTimes;
	}


	public void setSplitTimes(int[] splitTimes) {
		this.splitTimes = splitTimes;
	}
	
	


}
