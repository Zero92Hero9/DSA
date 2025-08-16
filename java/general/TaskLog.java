import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Collections;
import java.util.Arrays;
import java.util.Comparator;
import java.lang.Math;

class Task {
	int groupId;
	String action;
	String duration;

	public Task(int groupId, String action, String duration) {
		this.groupId = groupId;
		this.action = action;
		this.duration = duration;
	}

	public int getGroupId() {
		return groupId;
	}

	public String getAction() {
		return action;
	}

	public String getDuration() {
		return duration;
	}
}


public class TaskLog {
	public static void main(String[] args) {
		String logString = "4 create 15:00, 3 create 09:00,  4 delete 20:00, 2 create 10:00, 3 delete 12:00, 1 create 13:00, 2 delete 15:00, 1 delete 16:00";
		List<Map.Entry<Integer, Integer>> logs = analyzeLogs(logString);

		for (Map.Entry<Integer, Integer> e : logs) {
			System.out.println("Group " + e.getKey() + ", lifetime: " + e.getValue());
		}

	}

	private static List<Map.Entry<Integer, Integer>> analyzeLogs(String logString) {
		List<Task> tasks = logToTasks(logString);
		Map<Integer, List<Task>> mapTasks = new HashMap<>();

		for (Task task : tasks) {
			List<Task> tasksForGroupId = mapTasks.get(task.getGroupId());

			if (tasksForGroupId == null) {
				tasksForGroupId = new ArrayList<>();
				tasksForGroupId.add(task);
				mapTasks.put(task.getGroupId(), tasksForGroupId);
			} else {
				tasksForGroupId.add(task);
			}
		}

		Map<Integer, Integer> groupLifetime = new HashMap<>();

		for (Map.Entry<Integer, List<Task>> entry : mapTasks.entrySet()) {
			int groupId = entry.getKey();
			List<Task> tasksInMap = entry.getValue();
			int d = 0;
			for (Task t : tasksInMap) {
				int duration = parseDuration(t.getDuration());
				if (isCreate(t)) {
					d += duration;
				} else if (isDelete(t)) {
					d -= duration;
				}
			}
			groupLifetime.put(groupId, Math.abs(d));
		}
		
		List<Map.Entry<Integer, Integer>> entries = new ArrayList<>();
		int max = Integer.MIN_VALUE;

		for (Map.Entry<Integer, Integer> e : groupLifetime.entrySet()) {
			if (e.getValue() > max) {
				entries.clear();
				max = e.getValue();				
				entries.add(e);
			} else if (e.getValue() == max) {
				entries.add(e);
			}
		}

		return entries;
		
	}

	private static boolean isCreate(Task task) {
		return task.getAction().equals("create");
	}


	private static boolean isDelete(Task task) {
		return task.getAction().equals("delete");
	}

	private static int parseDuration(String duration) {		
		String[] s = duration.split(":");		
		return Integer.valueOf(s[0]);
	}

	private static List<Task> logToTasks(String logString) {
		String[] log = logString.split(",");
		List<Task> tasks = new ArrayList<>();

		for (String task : log) {
			String[] logStmts = task.trim().split("\\s");
			Task t = new Task(Integer.valueOf(logStmts[0]), logStmts[1], logStmts[2]);
			tasks.add(t);
		}

		return tasks;
	}
}