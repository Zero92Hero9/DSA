package com.sdk;

public class UndoRedoEngine<T> {
    private static class Node<T> {
        T state;
        Node<T> next;
        Node<T> prev;

        Node (T state) {
            this.state = state;
        }
    }
    
    private Node<T> head = null;
    private Node<T> tail = null;
    private Node<T> current = null;

    public void saveState(T state) {
        Node<T> newNode = new Node<>(state);
        if (head == null) {
            head = newNode;
            tail = head;
            current = head;

            return;
        }
        
        if (current != tail) {
            tail = current;
            tail.next = null;
        }
        
        newNode.prev = tail;
        tail.next = newNode;

        tail = newNode;
        current = newNode;
    }

    public T undo() {
        if (current == null || current.prev == null) {
            return null;
        }

        current = current.prev;
        return current.state;
    }

    public T redo() {
        if (current == null || current.next == null) {
            return null;
        }

        current = current.next;

        return current.state;

    }

    public void print() {
        Node<T> runner = head;

        while (runner != null) {
            System.out.print(runner.state + " ");
            runner = runner.next;
        }

        System.out.println();
        
    }

    public static void main(String[] args) {
        UndoRedoEngine<String> engine = new UndoRedoEngine<>();
        engine.saveState("Type hello");
        engine.saveState("Type World");
        engine.saveState("Add emoji");

        engine.undo();
        engine.undo();

        engine.saveState("Insert image");

        engine.print();
    }
}
