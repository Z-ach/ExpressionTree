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
import java.util.Stack;

public class BinaryTree<T> implements BinaryTreeInterface<T> {

	private BinaryNode<T> root;

	public BinaryTree() {
		root = null;
	}

	public BinaryTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}

	public BinaryTree(T rootData, BinaryTree<T> leftTree, BinaryTree<T> rightTree) {
		privateSetTree(rootData, leftTree, rightTree);
	}

	public void setTree(T rootData) {
		root = new BinaryNode<T>(rootData);
	}

	public void setTree(T rootData, BinaryTree<T> left, BinaryTree<T> right) {
		privateSetTree(rootData, left, right);
	}

	private void privateSetTree(T rootData, BinaryTree<T> left, BinaryTree<T> right) {
		root = new BinaryNode<>(rootData);

		if ((left != null) && (!left.isEmpty())) {
			root.setLeftChild(left.root.copy());
		}
		if ((right != null) && (!right.isEmpty())) {
			root.setRightChild(right.root.copy());
		}
	}

	public T getRootData() {
		return root.getData();
	}

	public int getHeight() {
		return root.getHeight();
	}

	public int getNumberOfNodes() {
		return root.getNumberOfNodes();
	}

	public boolean isEmpty() {
		return root == null;
	}

	public void clear() {
		root = null;
	}

	protected BinaryNode<T> getRootNode() {
		return root;
	}

	public Iterator<T> getPreorderIterator() {
		throw new UnsupportedOperationException("Preorder not supported.");
	}

	public Iterator<T> getInorderIterator() {
		throw new UnsupportedOperationException("Inorder not supported.");
	}

	public Iterator<T> getPostorderIterator() {
		return new PostorderIterator();
	}

	public Iterator<T> getLevelorderIterator() {
		throw new UnsupportedOperationException("Level Order not supported.");
	}

	private class PostorderIterator implements Iterator<T> {

		private Stack<BinaryNode<T>> nodeStack;
		private BinaryNode<T> current;

		public PostorderIterator() {
			nodeStack = new Stack<>();
			current = root;
			populateStack(current);
		}
		
		private void populateStack(BinaryNode<T> node){
			nodeStack.add(node);
			if(node.hasRightChild()){
				populateStack(node.getRightChild());
			}
			if(node.hasLeftChild()){
				populateStack(node.getLeftChild());
			}
		}

		public boolean hasNext() {
			return !nodeStack.isEmpty();
		}

		public T next() {
			return nodeStack.pop().getData();
		}

	}

}
