import java.util.Queue;
import java.util.ArrayDeque;
import java.util.stream.IntStream;
import java.util.Arrays;

class Node {
	int data;
	Node left;
	Node right;

	public Node(int data) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}

class Heap {
	int capacity;
	int size;
	Node[] heapArray;

	public Heap(int capacity) {
		this.capacity = capacity;
		this.size = 0;
		this.heapArray = new Node[capacity];
	}

	public boolean isFull() {
		return size == capacity;
	}

	public Node[] extend(int additionalCapacity) {
		return Arrays.copyOf(heapArray, capacity + additionalCapacity);
	}

	public void insert(int key) {
		Node newNode = new Node(key);
		if (size == 0) {
			heapArray[size] = newNode;
			size ++;
		} else {
			heapifyUp(size, key);
			size++;
		}
	}

	public void heapifyUp(int currentIndex, int key) {
		if (currentIndex == 0) {
			return;
		}
		int parentIdx = (currentIndex - 1)/2;
		Node parent = heapArray[parentIdx];
		heapArray[currentIndex] = new Node(key);

		if (key > parent.data) {
			int temp = parent.data;
			parent.data = heapArray[currentIndex].data;
			heapArray[currentIndex].data = temp;
		}
		heapifyUp(parentIdx, parent.data);
	}

	public void print() {
		IntStream.range(0,size).forEach(i -> System.out.print(heapArray[i].data + ","));
	}
}

public class HeapPlayground {
	public static void main(String[] args) {
		Heap heap = new Heap(10);
		int[] elements = {100,90,110,30};
		IntStream.range(0, elements.length).forEach(i -> heap.insert(elements[i]));
		heap.print();
	}
}