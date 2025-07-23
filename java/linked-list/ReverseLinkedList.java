class Node {
	int value;
	Node next;

	public Node(int value) {
		this.value = value;
		this.next = null;
	}
}

class MyLinkedList {
	Node head;
	public Node add(int value) {
		Node newNode = new Node(value);

		if (head == null) {
			head = newNode;
		} else {
			Node runner = head;
			while (runner.next != null) {
				runner = runner.next;
			}
			runner.next = newNode;
		}

		return head;
	}
}

public class ReverseLinkedList {
	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,5};
		Node head = null;
		MyLinkedList ll = new MyLinkedList();
		for (int i : numbers) {
			head = ll.add(i);
		}

		Node blackNode = head;

		while (blackNode.next != null) {
			Node newNode = head;
			head = blackNode;
			head.next = newNode;
			blackNode = blackNode.next;
		}

		blackNode = head;
		while (blackNode != null) {
			System.out.print(blackNode.value + "->");
			blackNode = blackNode.next;
		}

	}
}