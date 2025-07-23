import java.util.Queue;
import java.util.ArrayDeque;

class Node {
	int value;
	Node left;
	Node right;

	public Node(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
}

class Tree {
	Node root;

	public void insert(int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			Node runner = root;
			Node parent = null;

			while (runner != null) {
				parent = runner;
				if (value < runner.value) {
					runner = runner.left;
				} else if (value > runner.value) {
					runner = runner.right;
				}
			}

			if (value < parent.value) {
				parent.left = new Node(value);
			} else if (value > parent.value) {
				parent.right = new Node(value);
			}
		}
	}

	public Node insert(Node root, int value) {
		if (root == null) {
			root = new Node(value);
		} else {
			if (value < root.value) {
				root.left = insert(root.left, value);
			} else if (value > root.value) {
				root.right = insert(root.right, value);
			}
		}

		return root;
	}

	public void insertRecursively(int value) {
		root = insert(root, value);
	}

	public Node deleteNode(Node root, int k) {
		Node nodeToBeDeleted = findNode(root, k);

		if (nodeToBeDeleted == null) {
			return root;
		}

		if (nodeToBeDeleted.left != null && nodeToBeDeleted.right != null) {
			Node successorParent = nodeToBeDeleted;
			Node successor = nodeToBeDeleted.right;

			while (successor.left != null) {
				successorParent = successor;
				successor = successor.left;
			}

			nodeToBeDeleted.value = successor.value;
			successorParent.left = null;
		}
		
		return root;
	}

	public Node findNode(Node root, int key) {
		if (root.value == key) {
			return root;
		}
		if (key < root.value) {
			return findNode(root.left, key);
		} else if (key > root.value) {
			return findNode(root.right, key);
		}

		return null;
	}

	public void print() {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node runner = queue.poll();
			System.out.print(runner.value + "->");
			if (runner.left != null) {
				queue.offer(runner.left);
			} 
			if (runner.right != null) {
				queue.offer(runner.right);
			}
		}
	}

	public void printInOrder(Node root) {
		if (root == null) {
			return;
		}
		printInOrder(root.left);
		System.out.print(root.value + "->");
		printInOrder(root.right);
	}

	public void printPreOrder(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.value + "->");
		printPreOrder(root.left);
		printPreOrder(root.right);
	}

	public int findMinimum(Node root) {
		if (root.left == null) {
			return root.value;
		}

		return findMinimum(root.left);
		
	}

	public Node findMinimumReturnNode(Node root) {
		if (root.left == null) {
			return root;
		}

		return findMinimumReturnNode(root.left);
		
	}

	public int findMaximum(Node root) {
		if (root.right == null) {
			return root.value;
		}

		return findMaximum(root.right);
	}

	public Node deleteNodeIterative(int key) {
		Node runner = root;
		Node parent = null;

		while (runner != null && runner.value != key) {
			parent = runner;
			if (key < runner.value) {
				runner = runner.left;
			} else {
				runner = runner.right;
			}
		}
		// key not found
		if (runner == null) {
			return root;
		}

		// found key node has 2 children
		if (runner.left != null && runner.right != null) {
			Node successorParent = runner;
			Node successor = runner.right;

			while (successor.left != null) {
				successorParent = successor;
				successor = successor.left;
			}

			runner.value = successor.value;
			System.out.println("Runner : " + runner.value + ", Successor: " + successor.value);
			runner = successor;
			System.out.println("Parent : " + parent.value + ", SuccessorParent: " + successorParent.value);
			parent = successorParent;
		}
		
		Node child = (runner.left != null) ? runner.left : runner.right;
		System.out.println("parent: " + parent.value);
		if (parent == null) {
			return child;
		}

		
		if (runner == parent.left) {
			parent.left = child;
		} else {
			parent.right = child;
		}
		
		printInOrder(root);
		return root;
	}


}

public class TreePlayground {
	public static void main(String[] args) {
		Tree tree = new Tree();
		//iterative
		tree.insert(50);
		tree.insert(25);
		tree.insert(15);
		tree.insert(35);
		tree.insert(5);
		tree.insert(20);
		tree.insert(30);
		tree.insert(40);
		tree.print();
		System.out.println();
		//recursive
		tree.insertRecursively(50);
		tree.insertRecursively(25);
		tree.insertRecursively(15);
		tree.insertRecursively(35);
		tree.insertRecursively(5);
		tree.insertRecursively(20);
		tree.insertRecursively(30);
		tree.insertRecursively(40);
		tree.print();
		//tree.deleteNode(tree.root, 25);
		//System.out.println();
		//tree.print();
		System.out.println("\n"+ tree.findMinimum(tree.root));
		System.out.println("\n"+ tree.findMaximum(tree.root));
		tree.deleteNodeIterative(15);
			
	}
}