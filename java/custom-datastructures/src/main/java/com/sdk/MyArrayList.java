package com.sdk;

import java.util.concurrent.atomic.AtomicInteger;

public class MyArrayList<T> {
    private volatile Object[] container = new Object[10];
    private volatile int elementCount = 0;

    public void add(T element) {
        synchronized(this) {
            if (elementCount == container.length) {
                int newCapacity = 2 * container.length;
                Object[] temp = new Object[newCapacity];

                for (int i = 0; i < container.length; i++) {
                    temp[i] = container[i];
                }

                container = temp;
            }

            container[elementCount] = element;
            elementCount++;
        }
    }

    public T get(int index) {
        if (index >= elementCount || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + elementCount);
        }

        return (T) this.container[index];
    }

    public void remove(int index) {

        synchronized(this) {
            if (index >= elementCount || index < 0) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + elementCount);
            }

            for (int i = index; i < elementCount - 1; i++) {
                container[i] = container[i+1];
            }

            container[elementCount - 1] = null;
            elementCount--;
        }
    }

    public void print() {
        for (int i = 0; i < elementCount - 1; i++) {
            System.out.print(container[i] + "->");
        }
        System.out.println(container[elementCount-1]);
    }

    public static void main(String[] args) {
        MyArrayList<Integer> arr = new MyArrayList<>();
        arr.add(3);
        arr.add(8);
        arr.add(10);

        arr.print();
    }
}
