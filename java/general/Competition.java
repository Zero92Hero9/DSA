import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Competition {
	public static void main(String[] args) {
		String logs = """
			1 solve 09:00 50, 2 solve 10:00 60, 1 fail 11:00, 3 solve 13:00 40, 2 fail 14:00, 3 solve 15:00 70
		""";
		Map<Integer, List<Student>> studentMap = parseLogs(logs);
		List<Student> result = new ArrayList<>();

		for(Map.Entry<Integer, List<Student>> entry : studentMap.entrySet()) {
			List<Student> students = entry.getValue();
			int score = students.stream().mapToInt(Student::getScore).sum();
			int successfulAttempts = students.stream().mapToInt(Student::getSuccessfulAttempts).sum();
			int penalties = students.stream().mapToInt(Student::getPenalties).sum();
			result.add(new Student(entry.getKey(), "", score, successfulAttempts, penalties));
		}

		Collections.sort(result, new Comparator<Student>() {
			@Override
			public int compare(Student s1, Student s2) {
				return Integer.compare(s2.getScore(), s1.getScore());
			}	
		});

		System.out.println(result.stream().map(Student::getFieldsAsArray).map(s -> Arrays.toString(s)).collect(Collectors.toList()));

	}

	private static Map<Integer, List<Student>> parseLogs(String logs) {
		String[] items = logs.split(",");
		Map<Integer, List<Student>> studentMap = new HashMap<>();

		for (String item : items) {
			String[] tokens = item.trim().split("\\s");
			int studentId = Integer.valueOf(tokens[0]);
			Student s = null;
			if (tokens[1].equals("solve")) {
				s = new Student(studentId, tokens[1], Integer.valueOf(tokens[3]), 1, 0);
			} else if (tokens[1].equals("fail")) {
				s = new Student(studentId, tokens[1], 0, 0, 1);	
			}
			if (!studentMap.containsKey(studentId)) {
				List<Student> students = new ArrayList<>();
				students.add(s);
				studentMap.put(studentId, students);
			} else {
				List<Student> students = studentMap.get(studentId);
				students.add(s);
				studentMap.put(studentId, students);
			}
		}

		return studentMap;
	}
}

class Student {
	private int studentId;
	private String result;
	private int score;
	private int successfulAttempts;
	private int penalties;

	public Student(int studentId, String result, int score, int successfulAttempts, int penalties) {
		this.studentId = studentId;
		this.result = result;
		this.score = score;
		this.successfulAttempts = successfulAttempts;
		this.penalties = penalties;
	}

	public int getStudentId() {
		return studentId;
	}

	public String getResult() {
		return result;
	}

	public int getScore() {
		return score;
	}

	public int getSuccessfulAttempts() {
		return successfulAttempts;
	}

	public int getPenalties() {
		return penalties;
	}

	public int[] getFieldsAsArray() {
		int[] arr = new int[4];
		arr[0] = studentId;
		arr[1] = score;
		arr[2] = successfulAttempts;
		arr[3] = penalties;

		return arr;
	}

	
}