package TreePackage;

public class BinaryNode<T> {
	
	
	private T data;
	private BinaryNode<T> leftChild, rightChild;
	
	public BinaryNode() {
		this(null);
	}
	
	public BinaryNode(T data) {
		this(data, null, null);
	}
	
	public BinaryNode(T data, BinaryNode<T> left, BinaryNode<T> right) {
		this.data = data;
		leftChild = left;
		setRightChild(right);
	}
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public BinaryNode<T> getLeftChild(){
		return leftChild;
	}
	
	public void setLeftChild(BinaryNode<T> left) {
		leftChild = left;
	}

	public BinaryNode<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(BinaryNode<T> right) {
		this.rightChild = right;
	}
	
	public boolean hasLeftChild() {
		return leftChild != null;
	}
	
	public boolean hasRightChild() {
		return rightChild != null;
	}
	
	public boolean isLeaf() {
		return (!hasLeftChild() && !hasRightChild());
	}
	
	public BinaryNode<T> copy(){
		BinaryNode<T> newRoot = new BinaryNode<T>(data);
		if(leftChild != null) {
			newRoot.setLeftChild(leftChild.copy());
		}
		if(rightChild != null) {
			newRoot.setRightChild(rightChild.copy());
		}
		return newRoot;
	}
	
	public int getHeight() {
		return getHeight(this);
	}
	
	private int getHeight(BinaryNode<T> node) {
		int height = 0;
		if(node != null) {
			height = 1 + Math.max(getHeight(node.getLeftChild()), getHeight(node.getRightChild()));
		}
		return height;
	}
	
	public int getNumberOfNodes() {
		return getNumberOfNodes(this);
	}
	
	private int getNumberOfNodes(BinaryNode<T> node) {
		int rightNumber = 0;
		int leftNumber = 0;
		if(leftChild != null) {
			leftNumber = getNumberOfNodes(node.getLeftChild());
		}
		if(rightChild != null) {
			rightNumber = getNumberOfNodes(node.getRightChild());
		}
		return 1 + leftNumber + rightNumber;
	}
	
	
	
}