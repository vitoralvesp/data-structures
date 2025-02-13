package com.vitoralvesp.binarytree;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class BinaryTree<T> {
	
	private Node<T> root;
	
	
	/* CONSTRUCTORS */
	
	BinaryTree() {}
	
	BinaryTree(T data) { this.root = new Node<>(data); }
	
	
	/* GETTERS */
	
	public Node<T> getRoot() { return root; }
	
	private int getHeight(Node<T> root) {
		
		if (root == null) return -1;
		
		int left_tree_height = getHeight(root.getLeft());
		int right_tree_height = getHeight(root.getRight());
		
		return Math.max(left_tree_height, right_tree_height) + 1;
		
	}
	
	public int getHeight() { return getHeight(root); }
	
	
	/* METHODS */
	
	public boolean isEmpty() { return root == null; }
	
	public boolean isFull() { return false; }
	
	// ----
	
	private boolean isLevelComplete(Node<T> node) {
		
		if (node == null || node.getLeft() == null || node.getRight() == null)
			return false;
		
		return true;
		
	}
	
	private Node<T> insert(Node<T> root, T data) {
		
		if (root == null)
			return new Node<>(data);
		
		if (root.getLeft() == null)
			root.setLeft(new Node<>(data));
		
		else if (root.getRight() == null)
			root.setRight(new Node<>(data));
		
		else {
			
			if (!isLevelComplete(root.getLeft()))
				root.setLeft(insert(root.getLeft(), data));
			else
				root.setRight(insert(root.getRight(), data));
		}
		
		return root;
		
	}
	
	public void insert(T data) { root = insert(root, data); }
	
	// ----
	
	private Node<T> remove(Node<T> root, T data) {
		
		if (root == null) return null;
		
		if (root.getData().equals(data)) {
			
			// Case 1
			if (root.getLeft() == null && root.getRight() == null)
				return null;
			
			// Case 2
			else if (root.getLeft() == null)
				return root.getRight();
			else if (root.getRight() == null)
				return root.getLeft();
			
			// Case 3
			else {
				
				Node<T> successor = root.getLeft();
				while (successor.getRight() != null)
					successor = successor.getRight();
				
				root.setData(successor.getData());
				root.setLeft(remove(root.getLeft(), successor.getData()));
			
			}
			
		} else {
			
			root.setLeft(remove(root.getLeft(), data));
			root.setRight(remove(root.getRight(), data));
			
		}
		
		return root;
		
	}
	
	public void remove(T data) { root = remove(root, data); }
	
	// ----
	
	private void preOrderTraversal(Node<T> root) {
		
		if (root == null) return;
		
		System.out.print(root.getData() + " ");
		preOrderTraversal(root.getLeft());
		preOrderTraversal(root.getRight());
		
	}
	
	private void inOrderTraversal(Node<T> root) {
		
		if (root == null) return;
		
		inOrderTraversal(root.getLeft());
		System.out.print(root.getData() + " ");
		inOrderTraversal(root.getRight());
		
	}
	
	private void postOrderTraversal(Node<T> root) {
		
		if (root == null) return;
		
		postOrderTraversal(root.getLeft());
		postOrderTraversal(root.getRight());
		System.out.print(root.getData() + " ");
		
	}
	
	private void levelOrderTraversal(Node<T> root) {
		
		List<List<T>> ans = new ArrayList<>();
        
		if (root == null) {
            return;
        }

        Queue<Node<T>> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

        	int size = q.size();
            List<T> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                
            	Node<T> node = q.poll();
                
                level.add(node.getData());

                if (node.getLeft() != null) {
                    q.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    q.add(node.getRight());
                }
            }
            
            ans.add(level);
        }
       
        
        for (List<T> level : ans) {
        	
        	for (T data : level) {
        		
        		System.out.print(data + " ");
        		
        	}
        	
        	System.out.printf("%n");
        	
        }
		
	}
	
	public void preOrderTraversal() { preOrderTraversal(root); }
	
	public void inOrderTraversal() { inOrderTraversal(root); }
	
	public void postOrderTraversal() { postOrderTraversal(root); }
	
	public void levelOrderTraversal() { levelOrderTraversal(root); }
	
	private void status(Node<T> root) {
		
		if (root == null) return;
		
		System.out.println(root.show());
		status(root.getLeft());
		status(root.getRight());
		
	}
	
	public void status() { status(root); }
	
	
	
	
}