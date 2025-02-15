package main.com.vitoralvesp.model.binarytree;

public class Node<T> {
	
	private T data;
	private Node<T> left;
	private Node<T> right;
	
	
	/* CONSTRUCTORS */
	
	Node() {}
	
	public Node(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public Node(T data, Node<T> left, Node<T> right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	
	
	/* SETTERS */
	
	public void setData(T data) { this.data = data; }
	
	public void setLeft(Node<T> left) { this.left = left; }
	
	public void setRight(Node<T> right) { this.right = right; }
	
	public void setChildren(Node<T> left, Node<T> right) {
		this.left = left;
		this.right = right;
	}
	
	
	/* GETTERS */
	
	public T getData() { return data; }
	
	public Node<T> getLeft() { return left; }
	
	public Node<T> getRight() { return right; }
	
	
	/* METHODS */
	
	public String show() { return "data: " + data + ", left: " + (left == null ? "null" : left.data) + ", right: " + (right == null ? "null" : right.data); }

}
