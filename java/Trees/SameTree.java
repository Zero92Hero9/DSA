class Node {
	int val;
	Node left;
	Node right;

	public Node(int val) {
		this.val = val;
	}

	public Node insert(int val) {
		if (left == null) {
			left = new Node(val);
			return left;
		} else {
			left.insert(val);
			return left;
		}

		if (right == null) {
			right = new Node(val);
			return right;
		} else {
			return left.insert(val);
		}
	}

	public void traverse() {
		if (left != null) {
			left.traverse();
		}
		System.out.println(val);
		if (right != null) {
			right.traverse();
		}
	}
}

public class SameTree {
	public static void main(String[] args) {
		Node root = new Node(1);
		Node left = root.insert(2);
		Node right = root.insert(3);
		root.traverse();
	}
}





