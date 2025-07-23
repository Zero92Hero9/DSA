import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

class Node {
	char ch;
	Node left;
	Node right;

	public Node(char ch) {
		this.ch = ch;
		this.left = left;
		this.right = right;
	}
}

class Tree {
	
	public Stack<Node> makeNodes(String str) {
		Stack<Node> stackOfNodes = new Stack<>();
		for (char ch : str.toCharArray()) {
			stackOfNodes.push(new Node(ch));
		}

		return stackOfNodes;
	}

	public Node createTree(Stack<Node> nodes) {
		Node root = new Node('+');
		Node runner = root;
		int numberOfElements = nodes.size() - 1;
		while (numberOfElements > 0) {
			Node n = nodes.pop();
			runner.left = new Node('+');
			runner.right = n;
			runner = runner.left;
			numberOfElements--;
		}
		runner.left = nodes.pop();

		return root;
	}

	public void print(Node root) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node n = queue.poll();
			System.out.print(n.ch + "->");
			if (n.left != null) {
				queue.offer(n.left);
			}
			if (n.right != null) {
				queue.offer(n.right);
			}	
		}

	}
}

public class BinaryStringTree {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String str = scan.next();
		Tree t = new Tree();
		Stack<Node> nodes = t.makeNodes(str);
		Node root = t.createTree(nodes);
		t.print(root);

	}
}