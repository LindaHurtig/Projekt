package time;

public class Time {
	int hours;
	int minutes;
	int seconds;


int [] receiveCurrentTime(){
	
	int[] currentTime = new int[2];
	
	currentTime[0] = hours;
	currentTime[1] = minutes;
	currentTime[2] = seconds;
	
	System.out.println(currentTime);
	
	return currentTime;
}
}
