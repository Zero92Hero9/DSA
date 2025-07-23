import java.util.PriorityQueue;
import java.util.Comparator;

class QComparator implements Comparator<Integer> {
	public int compare(Integer i1, Integer i2) {
		return Integer.compare(i1, i2);
	}
}

class QPlayground {
	public static void main(String[] args) {
		PriorityQueue q = new PriorityQueue(new QComparator().reversed());
		int[] arr = {9,4,8,6,2,11,56,1};

		for (int a : arr) {
			q.add(a);
		}

		for (int i : arr) {
			System.out.print(q.remove() + ",");
		}
	}
}