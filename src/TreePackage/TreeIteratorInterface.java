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
package TreePackage;

import java.util.Iterator;

public interface TreeIteratorInterface<T> {
	
	public Iterator<T> getPreorderIterator();
	public Iterator<T> getInorderIterator();
	public Iterator<T> getPostorderIterator();
	public Iterator<T> getLevelorderIterator();
	
}
