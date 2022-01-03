package inputs;

import java.util.List;

import com.google.common.base.Stopwatch;

import leaderboard.Leaderboard;
import skier.Skier;

public class InputThread implements Runnable {

	private List<Skier> skierList;
	public Thread inputThread;
	private Stopwatch stopWatch;
	private Leaderboard leaderBoard;
	private boolean threadRunning;
	private InputExceptionHandler inputs = new InputExceptionHandler();

	public InputThread(List<Skier> list, Stopwatch stopWatch, Leaderboard leaderBoard) {
		this.threadRunning = true;
		this.skierList = list;
		this.stopWatch = stopWatch;
		this.leaderBoard = leaderBoard;
	}

	@Override
	public void run() {
		while(threadRunning) {
			String optionInput = inputs.inputStringNextLine().trim();
			if(optionInput.contains("mellantid")) {
				String filterNumber = optionInput.replace("mellantid ", "");
				Skier selectedSkier = findSkier(filterNumber);
				if(selectedSkier != null) {
					selectedSkier.setSplitTime(selectedSkier.getStartTime() + stopWatch.elapsed().toMillis());
					leaderBoard.printSkierSplitTime(selectedSkier.getStartNumber() - 1);
				}
			} 
			else if(optionInput.contains("sluttid")) {
				String filterNumber = optionInput.replace("sluttid ", "");
				Skier selectedSkier = findSkier(filterNumber);
				if(selectedSkier != null) {
					if(selectedSkier.getFinalTime() == -1) {
						selectedSkier.setFinalTime(selectedSkier.getStartTime() + stopWatch.elapsed().toMillis());
						System.out.println("Sparad sluttid '" + selectedSkier.getName() + "': " + stopWatch.toString());
						System.out.println("");
					} else {
						System.out.println(selectedSkier.getName() + " har redan åkt i mål!");
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
	}
	
	private Skier findSkier(String filterNumber) {
		int skier = inputs.inputStringToInt(filterNumber, "Du måste mata in åkarens startnummer efter 'mellantid/sluttid'");
		if(skier == -1) { // ta hand om input felhantering.
			return null;
		}
		else if(skier <= 0 || skier > skierList.size()) { // tar hand om att hitta åkaren i skier listan #skierList.
			System.out.println("Kan inte hitta åkaren!");
			return null;
		}
		return skierList.get(skier - 1);
	}
}
