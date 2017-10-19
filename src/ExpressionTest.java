//
// Name: Kaufman, Zach
// Project: #1
// Due: 10/20/2017
// Course: cs-241-02-f17
//
// Description:
// This is a project from the text book, from chapter 24 project #3. This project is the implementation of an expression tree.
// The program must take in a postfix expression, convert it to an expression tree, evaluate the expression tree, then display the
// postfix expression using a postfix tree traversal. All exceptions must be handled properly.
//

import TreePackage.*;

public class ExpressionTest {
	public static void main(String[] args) {
		System.out.println("Z. Kaufman's Expression Tree");
		//ExpressionTree exp = new ExpressionTree(new String[]{"a", "b", "2", "/","+"});
		ExpressionTree exp = new ExpressionTree(new String[]{"a", "2", "+", "3", "b", "7", "a", "*", "+", "*", "-"});
		
		exp.setVariable("", 1.5);
		exp.setVariable("b", 2);
		exp.setVariable("a", 2);
		
		//exp.clear();
		System.out.println(exp.evaluate());
		exp.displayPostfix();
		System.out.println("Height: " + exp.getHeight());
		System.out.println("Number of nodes: " + exp.getNumberOfNodes());
		
		
	}
}
