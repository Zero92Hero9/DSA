import java.util.Arrays;
import java.util.PriorityQueue;

abstract class MyHeap {
	int[] heap;
	int size;
	int index;

	public MyHeap(int size) {
		heap = new int[size];
		this.size = size;
		this.index = 0;
	}

	public int parent(int i) {
		return (i - 1)/2;
	}

	public int leftChild(int i) {
		return (2 * i) + 1;		
	}

	public int rightChild(int i) {
		return (2 * i) + 2;
	}

	public boolean isLeaf(int i) {
		if (leftChild(i) >= size || rightChild(i) >= size) {
			return true;
		}

		return false;
	}

	public void insert(int element) {
		if (index >= size) {
			return;
		}

		heap[index] = element;
		int current = index;

		if (heap[current] > heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);	
		}

		index++;
	}

	public void swap(int current, int parent) {
		int temp = heap[parent];
		heap[parent] = heap[current];
		heap[current] = temp;
	}

	public void printHeap() {
		System.out.println(Arrays.toString(heap));
	}

	public int remove() {
		int popped = heap[0];
		heap[0] = heap[--index];
		heapify(0);

		return popped;
	}
	abstract public void heapify(int i);
	
}

class MinHeap extends MyHeap {

	public MinHeap(int size) {
		super(size);
	}
	
	public void heapify(int i) {
		if (!isLeaf(i)) {
			if (heap[i] > heap[leftChild(i)] || heap[i] > heap[rightChild(i)]) {
				if (heap[leftChild(i)] < heap[rightChild(i)]) {
					swap(i, leftChild(i));
					heapify(leftChild(i));
				} else {
					swap(i, rightChild(i));
					heapify(rightChild(i));
				}
			}
		}
	}
}

class MaxHeap extends MyHeap {
	public MaxHeap(int size) {
		super(size);
	}

	public void heapify(int i) {
		if (!isLeaf(i)) {
			if (heap[i] < heap[leftChild(i)] || heap[i] < heap[rightChild(i)]) {
				if (heap[leftChild(i)] > heap[rightChild(i)]) {
					swap(i, leftChild(i));
					heapify(leftChild(i));
				} else {
					swap(i, rightChild(i));
					heapify(rightChild(i));
				}
			}
		}
	} 
}

class MinMax {
	public static void main(String[] args) {
		MaxHeap mh = new MaxHeap(7);
		mh.insert(9);
		mh.insert(13);
		mh.insert(7);
		mh.insert(16);
		mh.insert(21);
		mh.insert(12);
		mh.insert(3);
		mh.printHeap();
		mh.heapify(0);
		mh.printHeap();	

		int[] elements = {8, 2, 19, 9, 21, 14, 45};
		PriorityQueue q = new PriorityQueue();
		for (int e : elements) {
			q.add(e);
		}
		System.out.println("Min element is " + q.poll());
		q.remove(2);
		System.out.println("Min element is " + q.poll());

	}
}