package menu;

import java.util.List;
import java.util.Scanner;

import com.google.common.base.Stopwatch;

import inputs.AllInputs;
import leaderboard.Leaderboard;
import skier.Skier;

public class InputThread implements Runnable {

	private List<Skier> skierList;
	public Thread inputThread;
	private Stopwatch stopWatch;
	private Leaderboard leaderBoard;
	private boolean threadRunning;
	private Scanner inputReader = new Scanner(System.in);

	public InputThread(List<Skier> list, Stopwatch stopWatch, Leaderboard leaderBoard) {
		this.threadRunning = true;
		this.skierList = list;
		this.stopWatch = stopWatch;
		this.leaderBoard = leaderBoard;
		System.out.println("F�r att ta mellantid p� �kare skriv 'mellantid + �karens nummer'");
		System.out.println("F�r att ta sluttid p� �kare skriv 'sluttid + �karens nummer'");
	}

	@Override
	public void run() {
		AllInputs inputs = new AllInputs();
		
		while(threadRunning) {
			String optionInput = "";
			if(inputReader.hasNext()) {
				optionInput = inputs.inputString();
				if(optionInput.contains("mellantid")) { // MELLAN TID
					String filterNumber = optionInput.replace("mellantid ", "");
					
					int skier = inputs.inputStringToInt("med �karens nummer", filterNumber);
					
//					int skier = Integer.parseInt(filterNumber);

					Skier selectedSkier = skierList.get(skier);
					selectedSkier.setSplitTime(selectedSkier.getStartTime() + stopWatch.elapsed().toMillis());
					leaderBoard.printSkierSplitTime(skier);
				} 
				else if(optionInput.contains("sluttid")) { // SLUT TID
					String filterNumber = optionInput.replace("sluttid ", "");
					int skier = Integer.parseInt(filterNumber);

					Skier selectedSkier = skierList.get(skier);
					if(selectedSkier.getFinalTime() == -1) {
						selectedSkier.setFinalTime(selectedSkier.getStartTime() + stopWatch.elapsed().toMillis());
						System.out.println("Sparad sluttid '" + selectedSkier.getName() + "': " + stopWatch.toString());
					} else {
						System.out.println(selectedSkier.getName() + " har redan �kt i m�l!");
					}
				}
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void stopThread() {
		threadRunning = false;
		inputThread.stop();
		inputReader.close();
	}
}
