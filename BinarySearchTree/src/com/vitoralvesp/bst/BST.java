package com.vitoralvesp.bst;

public class BST<T extends Comparable<T>> {
	
	private Node<T> root;
	
	
	/* CONSTRUCTORS */
	
	BST() {}
	
	BST(T data) { this.root = new Node<>(data); }
	
	
	/* METHODS */
	
	private Node<T> insert(Node<T> root, T data) {
		
		if (root == null)
			return new Node<>(data);
		
		if (root.getData().compareTo(data) < 0)
			root.setLeft(insert(root.getLeft(), data));
		else root.setRight(insert(root.getRight(), data));
		
		return root;
	
	}
	
	public void insert(T data) { insert(root, data); }
	
	

}
