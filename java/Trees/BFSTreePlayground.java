import java.util.stream.IntStream;
import java.util.Deque;
import java.util.ArrayDeque;

class Node {
	int value;
	Node left, right;

	public Node(int value) {
		this.value = value;
	}
}

class BFSTree {
	Node root;
	Deque<Node> queue = new ArrayDeque();

	public Node insert(Integer[] values) {
		if (values == null || values.length == 0) {
			return null;
		}

		Deque<Node> q = new ArrayDeque<>();
		root = new Node(values[0]);
		q.addLast(root);
		int i = 1;
		   
		while (i < values.length && !q.isEmpty()) {
			Node n = q.poll();

			if (i < values.length && values [i] != null) {
				n.left = new Node(values[i]);
				q.addLast(n.left);
			}

			i++;

			if (i < values.length && values[i] != null) {
				n.right = new Node(values[i]);
				q.addLast(n.right);
			}

			i++;			
		}

		return root;			
			
	}

	public void printInOrder(Node n) {
		if (n == null) {
			return;
		}
		printInOrder(n.left);
		System.out.print(n.value + "->");
		printInOrder(n.right);
	}	
}

public class BFSTreePlayground {
	public static void main(String[] args) {
		Integer[] values = {1,2,3,null,4,null,null,5,6,null,7};
		BFSTree tree = new BFSTree();
		Node root = tree.insert(values);
		tree.printInOrder(root);	
	}
}