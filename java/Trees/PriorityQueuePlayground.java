import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

class PriorityQueue {
	List<Integer> queueArray;
	int numberOfItems;

	public PriorityQueue() {
		this.queueArray = new ArrayList<>();
		this.numberOfItems = 0;
	}

	public void insert(int item) {
		if (numberOfItems == 0) {
			queueArray.add(numberOfItems++, item); 
		} else {
			int j;

			for (j = numberOfItems - 1; j >= 0; j-- ) {
				if (item > queueArray.get(j)) {
					queueArray.add(j+1, queueArray.get(j));
				} else {
					break;
				}
			}
			System.out.println(j);
			System.out.println(queueArray);	
			queueArray.add(j+1, item);
			numberOfItems++;
		}
	}

	public int remove() {
		return !isEmpty() ? queueArray.get(--numberOfItems): -1;
	}

	public int peekMinimum() {
		return !isEmpty() ? queueArray.get(numberOfItems - 1) : -1;
	}

	public boolean isEmpty() {
		return queueArray.isEmpty();
	}

	

}

public class PriorityQueuePlayground {
	public static void main(String[] args) {
		PriorityQueue queue = new PriorityQueue();
		queue.insert(100);
		queue.insert(90);
		queue.insert(30);
		queue.insert(70);
		queue.insert(20);
		
		System.out.println(queue.queueArray);
		System.out.println(queue.remove());
		System.out.println(queue.peekMinimum());
		System.out.println(queue.isEmpty());
	}
}