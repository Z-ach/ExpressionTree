
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
		ExpressionTree expr = new ExpressionTree(new String[] { "a", "b", "2", "/", "+" });
		expr.setVariable("a", 1.5);
		expr.setVariable("b", 2);
		System.out.println(expr.evaluate());
		expr.displayPostfix();
	}
}
