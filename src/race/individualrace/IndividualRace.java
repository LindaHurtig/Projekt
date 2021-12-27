package race.individualrace;

import java.util.List;
import java.util.Scanner;

import com.google.common.base.Stopwatch;

import menu.InputThread;
import skier.Skier;

public class IndividualRace implements Runnable {
	
	private Thread thread;
	private Stopwatch stopWatch;
	private List<Skier> skierList;
	private InputThread inputThread;
	
	//Variabler och metoder som gäller både individuell start
	public void startIndividualRace(List<Skier> list) {
		if(list.size() == 0) {
			System.out.println("Det finns inga åkare registrerad!");
			return;
		}
		skierList = list;
		stopWatch = Stopwatch.createStarted();
		
		thread = new Thread(this);
		thread.start();
		
		inputThread = new InputThread(skierList, stopWatch);
		inputThread.inputThread = new Thread(inputThread);
		inputThread.inputThread.start(); // startar scanner input tråden.
	}

	@Override
	public void run() {
		while(thread.isAlive()) {
			long hours = stopWatch.elapsed().toHoursPart();
			long minutes = stopWatch.elapsed().toMinutesPart();
			long seconds = stopWatch.elapsed().toSecondsPart();
			long millis = stopWatch.elapsed().toMillisPart();
			
			/**
			 * Eclipse: Window -> Preferences -> Run/Debug -> Console -> "Enable Interpret ASCII control characters".
			 */
			System.out.print("\r");
			System.out.print("Klocka - timmar:" + hours + " minuter:" + minutes + " sekunder:" + seconds + " millisekunder: " + millis);
			// (30 * (startNumber - 1))
			
			try {
				thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
