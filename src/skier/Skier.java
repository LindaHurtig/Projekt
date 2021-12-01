package skier;

public class Skier {
	
	private int startNumber;
	private Time startTime = new Time();
	private int finalPosition;
	private int[] finalTime = new int [numOfSkiers]; 
	private SplitTime splitTimes[] = new SplitTime[9];
	
	
	public int getStartNumber() {
		return startNumber;
	}
	public void setStartNumber(int startNumber) {
		this.startNumber = startNumber;
	}
	public Time getStartTime() {
		return startTime;
	}
	public void setStartTime(Time startTime) {
		this.startTime = startTime;
	}
	public int getFinalPosition() {
		return finalPosition;
	}
	public void setFinalPosition(int finalPosition) {
		this.finalPosition = finalPosition;
	}
	public int[] getFinalTime() {
		return finalTime;
	}
	public void setFinalTime(int[] finalTime) {
		this.finalTime = finalTime;
	}
	public SplitTime[] getSplitTimes() {
		return splitTimes;
	}
	public void setSplitTimes(SplitTime[] splitTimes) {
		this.splitTimes = splitTimes;
	}

}
