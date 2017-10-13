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
		return null;
	}

	public Iterator<T> getInorderIterator() {
		return null;
	}

	public Iterator<T> getPostorderIterator() {
		return new PostorderIterator();
	}

	public Iterator<T> getLevelorderIterator() {
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.err.println("Level Order not supported.");
		}
		return null;
	}

	private class PostorderIterator implements Iterator<T> {

		private Stack<BinaryNode<T>> nodeStack;
		private BinaryNode<T> current;

		public PostorderIterator() {
			nodeStack = new Stack<>();
			current = root;
		}

		public boolean hasNext() {
			return (current != null) || !nodeStack.isEmpty();
		}

		public T next() {
			BinaryNode<T> next = null;

			while (current != null) {
				nodeStack.push(current);
				current = current.getLeftChild();
			}
			return null;
		}

	}

}
