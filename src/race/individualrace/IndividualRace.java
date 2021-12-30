package race.individualrace;

import java.util.List;

import com.google.common.base.Stopwatch;

import leaderboard.Leaderboard;
import menu.InputThread;
import skier.Skier;

public class IndividualRace implements Runnable {

	private Thread thread;
	private Stopwatch stopWatch;
	private List<Skier> skierList;
	private InputThread inputThread;
	private Leaderboard leaderBoard;
	private boolean threadRunning;

	//Variabler och metoder som gäller både individuell start
	public void startIndividualRace(List<Skier> list) {
		if(list.size() == 0) {
			System.out.println("Det finns inga åkare registrerad!");
			return;
		}
		skierList = list;
		leaderBoard = new Leaderboard(list);
		stopWatch = Stopwatch.createStarted();

		thread = new Thread(this);
		threadRunning = true;
		thread.start();

		inputThread = new InputThread(skierList, stopWatch, leaderBoard);
		inputThread.inputThread = new Thread(inputThread);
		inputThread.inputThread.start(); // startar scanner input tråden.
	}

	@Override
	public void run() {
		while(threadRunning) {
			if(isRaceFinished()) {
				leaderBoard.printLeaderBoardResult();
				stopThread();
				inputThread.stopThread();
			}
			
			long hours = stopWatch.elapsed().toHoursPart();
			long minutes = stopWatch.elapsed().toMinutesPart();
			long seconds = stopWatch.elapsed().toSecondsPart();
			long millis = stopWatch.elapsed().toMillisPart();

			/**
			 * Eclipse: Window -> Preferences -> Run/Debug -> Console -> "Enable Interpret ASCII control characters".
			 */
			System.out.print("\r");
			System.out.print("Klocka - timmar:" + hours + " minuter:" + minutes + " sekunder:" + seconds + " millisekunder: " + millis + " \t");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void stopThread() {
		threadRunning = false;
		thread.stop();
	}
	
	private boolean isRaceFinished() {
		for(Skier list : skierList) {
			if(list.getFinalTime() == -1) {
				return false;
			}
		}
		return true;
	}
	
}
