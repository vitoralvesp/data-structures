package com.vitoralvesp.binarytree;
import java.util.Queue;
import java.util.Collections;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class BinaryTree<T> {
	
	private Node<T> root;
	
	/* CONSTRUCTORS */
	
	BinaryTree() { this.root = null; }
	
	BinaryTree(Node<T> root) { this.root = root; }
	
	/* GETTERS */
	
	public Node<T> getRoot() { return root; }
	
	private int getHeight(Node<T> node) {
		
		if (node == null) return -1;
		
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
		
		if (isEmpty()) this.root = node;
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
	
	private void levelOrderTraversal(Node<T> root) {
		
		if (isEmpty()) return;
		
		Queue<List<Node<T>>> queue = new LinkedList<>();
		queue.add(Collections.singletonList(root));
		
		while (!queue.isEmpty()) {
			
			List<Node<T>> current_level = queue.remove();
			List<Node<T>> next_level = new ArrayList<>();
			
			System.out.print("[");
			
			for (int i = 0; i < current_level.size(); i++) {
				
				Node<T> node = current_level.get(i);
				System.out.print(node.getData());
				
				if (i < current_level.size() - 1) System.out.print(",");
				
				if (node.getLeft() != null) next_level.add(node.getLeft());
				if (node.getRight() != null) next_level.add(node.getRight());
				
			}
			
			System.out.print("]");
			
			if (!next_level.isEmpty()) queue.add(next_level);
			
		}
		
	}
	
	public void preOrderTraversal() { preOrderTraversal(root); }
	
	public void inOrderTraversal() { inOrderTraversal(root); }
	
	public void postOrderTraversal() { postOrderTraversal(root); }
	
	public void levelOrderTraversal() { levelOrderTraversal(root); }
	
	// search method will use level order traversal
	
}
