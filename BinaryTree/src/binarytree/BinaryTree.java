package binarytree;

public class BinaryTree<T> {
	
	private Node<T> root;
	
	/* CONSTRUCTORS */
	
	BinaryTree() {}
	
	BinaryTree(Node<T> root) { this.root = root; }
	
	/* GETTER */
	
	public Node<T> getRoot() { return root; }
	
	
	/* METHODS */
	
	public boolean isEmpty() { return root == null; }
	
	public boolean isFull() { return false; }
	
	private void insertNode(Node<T> current, Node<T> node) {
		
		if (current.getLeft() == null) current.setLeft(node);
		else if (current.getRight() == null) current.setRight(node);
		else insertNode(current.getLeft(), node);
		
	}
	
	public void insert(T data) {
		
		Node<T> node = new Node<>(data);
		
		if (isEmpty()) root = node;
		else insertNode(root, node);
		
	}
	
	public void preOrderTraversal(Node<T> node) {
		
		if (node == null) return;
		
		System.out.print(node.getData() + " ");
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
		
	}
	
	public void inOrderTraversal(Node<T> node) {
		
		if (node == null) return;
		
		inOrderTraversal(node.getLeft());
		System.out.print(node.getData() + " ");
		inOrderTraversal(node.getRight());
		
	}
	
	public void postOrderTraversal(Node<T> node) {
		
		if (node == null) return;
		
		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		System.out.print(node.getData() + " ");
		
	}
	
	public void preOrderTraversal() { preOrderTraversal(root); }
	
	public void inOrderTraversal() { inOrderTraversal(root); }
	
	public void postOrderTraversal() { postOrderTraversal(root); }
	
	
	
}
