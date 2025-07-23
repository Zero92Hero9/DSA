import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.List;
import java.util.ArrayList;

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
	
	public List<Node> makeNodes(String str) {
		List<Node> nodes = new ArrayList<>();
		nodes.add(new Node('+'));
		for (char c : str.toCharArray()) {
			nodes.add(new Node(c));
		}

		return nodes;
	}

	public Node createTree(Node left, Node right) {
		Node root = new Node('+');
		root.left = left;
		root.right = right;

		return root;
	}

	public void print(Node root) {
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(root);

		while (!queue.isEmpty()) {
			Node node = queue.poll();
			System.out.print(node.ch + "->");
			if (node.left != null) {
				queue.offer(node.left);
			}

			if (node.right != null) {
				queue.offer(node.right);
			}
		}
	}

}

public class BalTree {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String s = scan.next();
		Tree tree = new Tree();
		List<Node> nodes = tree.makeNodes(s);		
		Queue<Node> queue = new ArrayDeque<>();
		queue.offer(nodes.get(0));
		for (int i = 0; 2*i + 2 < nodes.size(); i++) {
			queue.offer(tree.createTree(nodes.get(2*i+1), nodes.get(2*i+2)));
		}
		Node root = queue.poll();
		while (!queue.isEmpty()) {
			root.left = queue.poll();
			root.right = queue.poll();
		}

		tree.print(root);
	}
}

