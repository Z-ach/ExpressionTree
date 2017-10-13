package TreePackage;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

public class ExpressionTree extends BinaryTree<String> implements ExpressionTreeInterface<String>{
	
	private HashMap<String, Variable> variables;
	private String[] postfix;
	
	public ExpressionTree(String[] args) {
		variables = new HashMap<String, Variable>();
		postfix = args;
	}
	
	public double evaluate() {
		return evaluate(postfixToExpressionTree(postfix).getRootNode());
	}
	
	public void setVariable(String str, double d){
		variables.put(str, new Variable(str, d));
	}
	
	private double evaluate(BinaryNode<String> rootNode) {
		double result;
		if(rootNode == null) {
			result = 0;
		}else if(rootNode.isLeaf()) {
			String root = rootNode.getData();
			if(isVariable(root))
				result = variables.get(root).getValue();
			else
				result = Double.parseDouble(root);
		}else {
			double firstOp = evaluate(rootNode.getLeftChild());
			double secondOp = evaluate(rootNode.getRightChild());
			String operator = rootNode.getData();
			result = compute(operator, firstOp, secondOp);
		}
		return result;
	}
	
	private double compute(String operator, double first, double second){
		switch(operator) {
		case "+":
			return first + second;
		case "-":
			return first - second;
		case "*":
			return first * second;
		case "/":
			return first / second;
		default:
			//PUT EXCEPTION HERE, THIS SHOULD NOT BE REACHED
		}
		return 0;
	}
	
	private BinaryTree<String> postfixToExpressionTree(String[] postfix){
		Stack<BinaryTree<String>> stack = new Stack<BinaryTree<String>>();
		for(String token : postfix) {
			if(isVariable(token) || isDouble(token)) {
				stack.push(new BinaryTree<String>(token));
				continue;
			}else if(isOperator(token)) {
				BinaryTree<String> right = stack.pop();
				BinaryTree<String> left = stack.pop();
				stack.push(new BinaryTree<String>(token, left, right));
			}
		}
		return stack.pop();
	}
	
	private boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
	
	private boolean isVariable(String str) {
		return variables.containsKey(str);
	}
	
	private boolean isOperator(String str) {
		switch(str) {
		case "+": case "-": case "*": case "/":
			return true;
		}
		return false;
	}
	
	public void displayPostfix() {
		String post = "";
		Iterator<String> it = postfixToExpressionTree(postfix).getPostorderIterator();
		while(it.hasNext())
			post += it.next() + " ";
		System.out.println(post);
	}
}
