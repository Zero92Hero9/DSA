package com.sdk;

public class MyMinHeap {
    private int[] heap = new int[16];
    int size = 0;

    private int getParentIndex(int i) {
        if (i > 0) {
            return (i - 1) / 2;
        }
        
        return 0;
    }

    private int getLeftIndex(int i) {
        return 2 * i + 1;
    }

    private int getRightIndex(int i) {
        return 2 * i + 2;
    }

    private void swap (int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    public void insert(int value) {
        heap[size] = value;
        bubbleUp(size);
        size++;
    }

    private void bubbleUp(int index) {
        while (index > 0 && heap[index] < heap[getParentIndex(index)]) {
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }
    }
}
