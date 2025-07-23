import java.util.Arrays;

public class Sort {
	public static void main(String[] args) {
		int[] arr = {92,15,53,34,1};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	/*
		bubble up to correct positions
		Bubbles float up one by one.
	*/
	private static void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[i] > arr[j]) {
					swap(arr, i, j);
				}
			}
		}
	}

	/*
		Select the minimum, put it first, repeat
		Compares adjacent elements and swaps them repeatedly
	*/
	private static void selectionSort(int[] arr) {
		for (int i = 0 ; i < arr.length - 2; i++) {
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[minIndex]) {
					minIndex = j;
				}
			}
			swap(arr, i, minIndex);
		}
		
	}

	/*
		Sorting playing cards
		Inserts each element into correct place in a sorted sublist
	*/
	private static void insertionSort(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			int temp = arr[i];			
			int j = i - 1;
			while (j >= 0 && arr[j] > temp ) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = temp;
		}

	}

	/*
		Organizing messy room by dividing into sections
		Pick a pivot,partition, conquer left and right
	*/
	private static void quickSort(int[] arr, int begin, int end) {
		if (begin < end) {
			int partitionIdx = partition(arr, begin, end);
		
			quickSort(arr, begin, partitionIdx - 1);
			quickSort(arr, partitionIdx + 1, end);		
		}
	}

	/*
		Merging 2 sorted stacks of paper into one
	*/
	private static void mergeSort(int[] arr, int n) {
		if (n < 2) {
			return;
		}

		int mid = n/2;
		int[] leftArray = new int[mid];
		int[] rightArray = new int[n - mid];

		

	}

	private static int partition(int[] arr, int begin, int end) {
		int pivot = arr[end];
		int i = begin - 1;

		for (int j = begin; j < end; j++) {
			if (arr[j] <= pivot) {
				i++;
				swap(arr, i, j);
			}
		}

		swap(arr, i+1, end);
		System.out.println(Arrays.toString(arr));

		return i + 1;
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}