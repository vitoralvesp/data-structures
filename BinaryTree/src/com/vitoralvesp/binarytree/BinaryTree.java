package com.vitoralvesp.binarytree;

public class BinaryTree<T> {
	
	private Node<T> root;
	
	
	/* CONSTRUCTORS */
	
	BinaryTree() {}
	
	BinaryTree(T data) { this.root = new Node<>(data); }
	
	
	/* SETTERS */
	
	
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
	
	
	
	
	
	
	
}