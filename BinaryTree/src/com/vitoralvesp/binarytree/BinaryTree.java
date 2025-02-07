package com.vitoralvesp.binarytree;

public class BinaryTree<T> {
	
	private Node<T> root;
	
	
	/* CONSTRUCTORS */
	
	BinaryTree() {}
	
	BinaryTree(T data) { this.root = new Node<>(data); }
	
	
	/* GETTERS */
	
	public T getRoot() { return root.getData(); }
	
	private int getHeight(Node<T> root) {
		
		if (isEmpty()) return -1;
		
		int left_tree_height = 0;
		int right_tree_height = 0;
		
		if (root.getLeft() != null) left_tree_height = getHeight(root.getLeft()) + 1;
		if (root.getRight() != null) right_tree_height = getHeight(root.getRight()) + 1;
		
		return Math.max(left_tree_height, right_tree_height) + 1;
		
	}
	
	public int getHeight() { return getHeight(root); }
	
	
	/* METHODS */
	
	public boolean isEmpty() { return root == null; }
	
	public boolean isFull() { return false; } 
	
	private Node<T> insert(Node<T> root, T data) {
		
		if (root == null) {
			root = new Node<>(data);
			return root;
		}
		
		if (root.getLeft() == null) root.setLeft(insert(root.getLeft(), data));
		else root.setRight(insert(root.getRight(), data));
		
		return root;
		
	}
	
	public void insert(T data) { insert(root, data); }
	
	private void preOrderTraversal(Node<T> root) {
		
		if (isEmpty()) return;
		
		System.out.print(root.getData() + " ");
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());
		
	}
	
	private void inOrderTraversal(Node<T> root) {
		
		if (isEmpty()) return;
		
		inOrderTraversal(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrderTraversal(root.getRight());
		
	}
	
	private void postOrderTraversal(Node<T> root) {
		
		if (isEmpty()) return;
		
		postOrderTraversal(root.getLeft());
		postOrderTraversal(root.getRight());
		System.out.print(root.getData() + " ");
		
	}
	
	private void levelOrderTraversal(Node<T> root) {}
	
	public void preOrderTraversal() { preOrderTraversal(root); }
	
	public void inOrderTraversal() { inOrderTraversal(root); }
	
	public void postOrderTraversal() { postOrderTraversal(root); }
	
	public void levelOrderTraversal() { levelOrderTraversal(root); }
	
	
}