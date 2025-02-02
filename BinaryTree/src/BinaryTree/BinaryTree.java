package BinaryTree;

public class BinaryTree<T> {
	
	private Node<T> root;
	
	/* CONSTRUCTORS */
	
	BinaryTree() {}
	
	BinaryTree(Node<T> root) { this.root = root; }
	
	
	/* METHODS */
	
	public boolean isEmpty() { return root == null; }
	
	public boolean isFull() { return false; }
	
	private Node<T> insert_node(Node<T> node) {
		
		if (isEmpty()) root = node;
		else if (node.getLeft() == null) node.setLeft(node);
		else if (node.getRight() ==  null) node.setRight(node);
		else insert_node(node);
		
		return node;
		
	}
	
	public void insert(T data) {
		
		Node<T> new_node = new Node<>(data);
		insert_node(new_node);
		
	}
	
	public void preOrderTraversal(Node<T> node) {
		
		if (node == null) return;
		
		System.out.println(node.getData() + " ");
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
		
	}
	
	public void inOrderTraversal(Node<T> node) {
		
		if (node == null) return;
		
		inOrderTraversal(node.getLeft());
		System.out.println(node.getData() + " ");
		inOrderTraversal(node.getRight());
		
	}
	
	public void postOrderTraversal(Node<T> node) {
		
		if (node == null) return;
		
		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		System.out.println(node.getData() + " ");
		
	}
	
	
	
}
