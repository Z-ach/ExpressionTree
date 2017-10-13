package TreePackage;

public interface BinaryTreeInterface<T> extends TreeInterface<T>, TreeIteratorInterface<T>{
	
	public void setTree(T rootData);
	public void setTree(T rootData, BinaryTree<T> left, BinaryTree<T> right);
	
}
