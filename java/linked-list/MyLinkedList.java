class Node {
	int val;
	Node next;
	Node prev;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.prev = null;
	}
}

class CustomLinkedList {
	Node head;

	public CustomLinkedList(Node head) {
		this.head = head;
	}

	public int length() {
		Node runner = head;
		int count = 0;

		while (runner != null) {
			count++;
			runner = runner.next;
		}
	}

	public int get(int index) {
		Node runner = head;
		int length = length();

		if (index < 0 && index > length) {
			return -1;
		}

		int counter = 0;
		while (runner != null) {
			if (counter == index) {
				return runner.val;
			}
			counter++;
		}
	}

	public void addAtHead(int val) {
		Node newNode = new Node(val);
		if (head == null) {
			head = newNode;		
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void addAtTail(int val) {
		Node runner = head;
		while (runner.next != null) {
			runner = runner.next;
		}

		runner.next = new Node(val);

	}

}

public class MyLinkedList {
	public static void main(String[] args) {

	}
}