
package time;

import java.util.concurrent.TimeUnit;

public class StopWatch {


	public static boolean stopWatchRunning;

	public static long startTime;
	public static long stopTime;

	public static long stopWatchStart() {

		startTime = System.currentTimeMillis();
		stopWatchRunning = true;

		return startTime;

	}

	public static long stopWatchStop()  {

		stopTime = System.currentTimeMillis();
		stopWatchRunning = false;

		return stopTime;

	}

	public static String timePast() {

		long timeP = stopTime - startTime;

		long hours = TimeUnit.MILLISECONDS.toHours(timeP);
		timeP -= TimeUnit.HOURS.toMillis(hours);
		long min = TimeUnit.MILLISECONDS.toMinutes(timeP);
		timeP -= TimeUnit.MINUTES.toMillis(min);
		long sek = TimeUnit.MILLISECONDS.toSeconds(timeP);
		timeP -= TimeUnit.SECONDS.toMillis(sek);

		String timeConverted = (hours + ":" + min + ":" + sek + ":" + timeP);

		return timeConverted;

	}

}
