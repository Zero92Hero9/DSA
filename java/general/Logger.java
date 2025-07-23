import java.util.Map;
import java.util.HashMap;

public class Logger {
	Map<String,Integer> visited;
	public Logger() {
	 visited = new HashMap<>();
	}

	public boolean shouldPrintLogMessage(int timestamp, String message) {
		
		int timeValue = visited.getOrDefault(message, 0);
		System.out.println(timeValue);

		if (timeValue != 0) {
			if (timestamp < timeValue + 10) {
				return false;
			}
		}
		visited.put(message, timestamp);
		
		return true;
	}

	public static void main(String[] args) {
		Logger logger = new Logger();
		System.out.println(logger.shouldPrintLogMessage(1, "foo"));
		System.out.println(logger.shouldPrintLogMessage(2, "bar"));
		System.out.println(logger.shouldPrintLogMessage(3, "foo"));

	}

}