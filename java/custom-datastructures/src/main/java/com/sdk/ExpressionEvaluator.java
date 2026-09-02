package com.sdk;

public class ExpressionEvaluator {

    private static class MyStack<T> {
        private Object[] elements = new Object[50];
        private int top = -1;

        public void push(T element) {
            elements[++top] = element;
        }

        public Object pop() {
            if (top == -1) {
                return null;
            }
            T elementInStack = (T) elements[top];
            elements[top--] = null;

            return elementInStack;
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    public int evaluate(String expression) {
        MyStack<Integer> valueStack = new MyStack<>();
        MyStack<String> operatorStack = new MyStack<>();
        String[] tokens = expression.split(" ");

        for (String token : tokens) {
            if (token.equals("(")) {
                continue;
            }
            if (token.matches("\\d+")) {
                valueStack.push(Integer.parseInt(token));
            }

            if (token.matches("[+\\-*/]")) {
                operatorStack.push(token);
            }

            if (token.equals(")")) {
                int operand1 = (int) valueStack.pop();
                int operand2 = (int) valueStack.pop();
                String operator = (String) operatorStack.pop();

                int result = switch(operator) {
                    case "+" -> operand1+operand2;
                    case "-" -> operand2-operand1;
                    case "*" -> operand1*operand2;
                    case "/" -> operand2/operand1;
                    default -> 0;
                };

                
                valueStack.push(result);
            }
        }

        return (int) valueStack.pop();

    }

    public static void main(String[] args) {
        String exp = "( ( 3 + 5 ) * 8 )";
        ExpressionEvaluator evaluator = new ExpressionEvaluator();
        int value = evaluator.evaluate(exp);

        System.out.println(value);
    }
}
