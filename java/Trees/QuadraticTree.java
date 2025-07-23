import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;

class Node {
	char data;
	Node left;
	Node right;

	public Node(char data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class QuadraticTree {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter an equation: ");
		String equation = scan.next();
		Node root = buildTreeFromEquation(equation);
		print(root);
	}

	public static void print(Node root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data);
		print(root.left);		
		print(root.right);
	}

	public static Node buildTreeFromEquation(String equation) {
		char[] equationArray = equation.toCharArray();
		Stack<Node> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();

		for (char ch : equationArray) {
			if (ch == '(') {
				operators.push(ch);
			} else if (ch == ')') {				
				while (!operators.isEmpty() && operators.peek() != '(') {					
					createSubTree(operands, operators);		
				}
			} else if (ch == '+' || ch == '-' || ch == '/' || ch == '*' || ch == '%') {
				while (!operators.isEmpty() && precedence(ch) <= precedence(operators.peek())) {
					createSubTree(operands, operators);
				}
				operators.push(ch);
			} else if (Character.isLetter(ch)) {
				operands.push(new Node(ch));
			}
		}

		while (!operators.isEmpty()) {
			if (operators.peek() == '(') {
				operators.pop();
			}
			createSubTree(operands, operators);
		}

		return operands.pop();

	}
	private static void createSubTree(Stack<Node> operands, Stack<Character> operators) {

		Node right = operands.pop();
		Node left = operands.pop();
		Node n = new Node(operators.pop());
		n.right = right;
		n.left = left;
		operands.push(n);
	}

	private static int precedence(char op) {
		switch(op) {
			case '+':
			case '-':
				return 1;
			case '/':
			case '*':
				return 2;
			case '%':
				return 3;
			default:
				return -1;
		}
	
	}
}