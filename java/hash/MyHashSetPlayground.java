import java.util.stream.IntStream;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;		
	}
}

class Bucket {
	Node head;

	public Node add(int key) {
		if (head == null) {
			head = new Node(key);
		} else {
			if (lookup(key) == null) {
				Node node = new Node(key);
				node.next = head.next;
				head = node;
			}
		}

		return head;
	}

	public Node lookup(int key) {
		Node runner = head;
		while (runner.next != null) {
			if (runner.next.data == key) {
				return runner;
			} 
			runner = runner.next;
		}
		return null;
	}

	public void remove(int key) {
		Node node = lookup(key);
		if (node != null) {
			node.next = node.next.next;
		}
	}

	public void print() {
		Node runner = head;
		while (runner != null) {
			System.out.print(runner.data + "->");
			runner = runner.next;
		}
	}
}

class MyHashSet {
	private Bucket[] buckets;
	int capacity;

	public MyHashSet(int capacity) {
		this.capacity = capacity;
		buckets = new Bucket[capacity];
		IntStream.range(0,capacity).forEach(i -> buckets[i] = new Bucket());
	}

	private int hash(int key) {
		return key % capacity;
	}

	public void add(int data) {
		int index = hash(data);
		buckets[index].add(data);
	}

	public void remove(int data) {
		int index = hash(data);
		buckets[index].remove(data);
	}

	public boolean contains(int data) {
		int index = hash(data);
		if (buckets[index].lookup(data) != null) {
			return true;
		}
		return false;
	}

	public void print() {
		for (Bucket b : buckets) {
			b.print();
		}
	}
}

public class MyHashSetPlayground {
	public static void main(String[] args) {
		MyHashSet mh = new MyHashSet(769);
		mh.add(2);
		mh.add(10);
		mh.add(70);
		mh.add(90);
		mh.add(100);
		mh.print();

	}
}