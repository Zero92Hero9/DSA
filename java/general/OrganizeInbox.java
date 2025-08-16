import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class OrganizeInbox {
	public static void main(String[] args) {
		String inboxString = "Bot@gmail.com, Subject1, 09:00; JohnDoe@gmail.com, Subject2, 10:00; Bot@gmail.com, Subject3, 12:00; JohnDoe@gmail.com, Subject1, 1:00; JaneDoe@gmail.com, Subject1, 8:00";

		Map<String, Integer> m = emailMap(inboxString);
		List<String> result = new ArrayList<>();

		System.out.println(m.entrySet().stream().sorted(Map.Entry.<String,Integer>comparingByValue().reversed()).map(e -> e.getKey()+" "+e.getValue()).collect(Collectors.toList()));
	}

	private static Map<String, Integer> emailMap(String inboxString) {
		Map<String, Integer> emailCountMap = new HashMap<>();
		String[] lineItems = inboxString.split(";");

		for (String lineItem : lineItems) {
			String emailAddress = lineItem.split(",")[0];
		
			emailCountMap.put(emailAddress.trim(), emailCountMap.getOrDefault(emailAddress.trim(), 0) + 1);
		}

		return emailCountMap;
	}
}