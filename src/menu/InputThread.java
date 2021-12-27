package menu;

import java.util.List;
import java.util.Scanner;

import com.google.common.base.Stopwatch;

import skier.Skier;

public class InputThread implements Runnable {

	private List<Skier> skierList;
	public Thread inputThread;
	private Stopwatch stopWatch;
	
	private Scanner inputReader = new Scanner(System.in);
	
	public InputThread(List<Skier> list, Stopwatch stopWatch) {
		this.skierList = list;
		this.stopWatch = stopWatch;
		System.out.println("För att ta mellantid på åkare skriv 'mellantid + åkarens nummer'");
		System.out.println("För att ta sluttid på åkare skriv 'sluttid + åkarens nummer'");
	}
	
	@Override
	public void run() {
		while(inputThread.isAlive()) {
			
			String optionInput = "";
	        if(inputReader.hasNext()) {
	        	optionInput = inputReader.nextLine();
	        	if(optionInput.contains("mellantid")) { // MELLAN TID
	        		String filterNumber = optionInput.replace("mellantid ", "");
	        		int skier = Integer.parseInt(filterNumber);
	        		
	        		Skier selectedSkier = skierList.get(skier);
					selectedSkier.setSplitTime(stopWatch.elapsed().toSeconds());
					System.out.println("Mellantid: " + selectedSkier.toString() + " " + selectedSkier.getSplitTime());
					System.out.println("Sparad mellantid '" + selectedSkier.getName() + "': " + stopWatch.toString());
	        	} 
	        	else if(optionInput.contains("sluttid")) { // SLUT TID
	        		String filterNumber = optionInput.replace("sluttid ", "");
	        		int skier = Integer.parseInt(filterNumber);
	        		
	        		Skier selectedSkier = skierList.get(skier);
	        		if(selectedSkier.getFinalTime() == -1) {
						selectedSkier.setFinalTime(stopWatch.elapsed().toSeconds());
						System.out.println("Sluttid: " + selectedSkier.toString() + " " + selectedSkier.getFinalTime());
						System.out.println("Sparad sluttid '" + selectedSkier.getName() + "': " + stopWatch.toString());
	        		} else {
	        			System.out.println(selectedSkier.getName() + " har redan åkt i mål!");
	        		}
	        	}
	        }
	        try {
				inputThread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    }
	}

}
