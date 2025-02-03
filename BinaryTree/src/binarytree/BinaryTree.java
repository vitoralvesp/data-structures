package binarytree;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree<T> {
	
	private Node<T> root;
	
	/* CONSTRUCTORS */
	
	BinaryTree() {}
	
	BinaryTree(Node<T> root) { this.root = root; }
	
	/* GETTERS */
	
	public Node<T> getRoot() { return root; }
	
	private int getHeight(Node<T> node) {
		
		if (root == null) return -1;
		
		int left_tree_height = getHeight(node.getLeft());
		int right_tree_height = getHeight(node.getRight());
		
		return Math.max(left_tree_height, right_tree_height) + 1;
		
	}
	
	public int getHeight() { return getHeight(root); }
	
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
	
	private void preOrderTraversal(Node<T> node) {
		
		if (node == null) return;
		
		System.out.print(node.getData() + " ");
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
		
	}
	
	private void inOrderTraversal(Node<T> node) {
		
		if (node == null) return;
		
		inOrderTraversal(node.getLeft());
		System.out.print(node.getData() + " ");
		inOrderTraversal(node.getRight());
		
	}
	
	private void postOrderTraversal(Node<T> node) {
		
		if (node == null) return;
		
		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		System.out.print(node.getData() + " ");
		
	}
	
	public void preOrderTraversal() { preOrderTraversal(root); }
	
	public void inOrderTraversal() { inOrderTraversal(root); }
	
	public void postOrderTraversal() { postOrderTraversal(root); }
	
	// search method will use level order traversal
	
}
