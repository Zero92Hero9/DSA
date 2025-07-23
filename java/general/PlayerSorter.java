import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Player {
	private int ranking;
	private String name;

	public Player(String name, int ranking) {
		this.name = name;
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public int getRanking() {
		return ranking;
	}

}

class PlayerComparator implements Comparator<Player> {
	public int compare(Player p1, Player p2) {
		return Integer.compare(p1.getRanking(),p2.getRanking());
	}
}

public class PlayerSorter {
	public static void main(String[] args) {
		List<Player> playerList = new ArrayList<>();
		playerList.add(new Player("Brady", 1));
		playerList.add(new Player("James", 2));
		playerList.add(new Player("Bryant", 3));

		Collections.sort(playerList, new PlayerComparator());
		playerList.stream().forEach(p -> System.out.print(p.getName() + "->"));
	}	
}