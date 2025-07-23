import java.util.Arrays;

class HeapAgain {
	int[] heap;
	int size;
	int index;

	public HeapAgain(int size) {
		heap = new int[size];
		this.size = size;
		this.index = 0;
	}

	public int parent(int index) {
		return (index-1)/2;
	}

	public int leftChild(int index) {
		return (2 * index) + 1;
	}

	public int rightChild(int index) {
		return (2 * index) + 2;
	}

	public boolean isLeaf(int i) {
		if (rightChild(i) >= size || leftChild(i) >= size) {
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
		
		if (heap[current] < heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
		index++;
	}

	public void heapify(int index) {
		if (!isLeaf(index)) {
			if (heap[index] > heap[rightChild(index)] ||
				heap[index] > heap[leftChild(index)]) {
					if (heap[leftChild(index)] < heap[rightChild(index)]) {
						swap(index, leftChild(index));
						heapify(leftChild(index));
					} else {
						swap(index, rightChild(index));
						heapify(rightChild(index));
					}
				}
		}
	}

	public int remove() {
		int popped = heap[0];
		heap[0] = heap[--index];
		heapify(0);

		return popped;
	}

	public void swap(int currentIndex, int parentIndex) {
		int temp = heap[currentIndex];
		heap[currentIndex] = heap[parentIndex];
		heap[parentIndex] = temp;
	}

	public void printHeap() {
		System.out.println(Arrays.toString(heap));
	}

	public static void main(String[] args) {
		HeapAgain ha = new HeapAgain(7);
		ha.insert(9);
		ha.insert(12);
		ha.insert(21);		
		ha.insert(16);
		ha.insert(7);
		ha.insert(13);
		ha.insert(3);
		ha.printHeap();
		ha.heapify(0);
		ha.printHeap();
		ha.remove();
		ha.printHeap();
	}
}