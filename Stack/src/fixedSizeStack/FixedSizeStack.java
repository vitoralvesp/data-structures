package fixedSizeStack;

public class FixedSizeStack<T> {
	
	private T[] stack;
	private int size;
	
	/* CONSTRUCTORS */
	FixedSizeStack() {}
	
	@SuppressWarnings("unchecked")
	FixedSizeStack(int size) {
		this.size = size;
		this.stack = (T[]) new Object[size];
	}
	
	/* SETTERS */
	public void setSize(int size) { this.size = size; }
	
	/* GETTERS */
	public int getSize() { return size; }
	
	/* METHODS */
	public boolean isEmpty() {
		return stack[0] == null;		
		
	}
	
	public boolean isFull() {
		return stack[size-1] != null;
	}
	
	public void push(T new_element) {
		if (isEmpty()) 
			stack[0] = new_element;
		else {
			int i = 1;
			while (stack[i] != null) i++;
			stack[i] = new_element;			
		}
	}
	
	public void pop() {
		if (isFull()) 
			stack[size-1] = null;
		else {
			int i = size-1;
			while (stack[i] == null) i--;
			stack[i] = null;
		}
	}
	
	public T top() {
		if (isFull())
			return stack[size-1];
		else {
			int i = size-1;
			while (stack[i] == null) i--;
			return stack[i];
		}
	}
	
	public int size() { return size; }
	
	public int count() {
		int i = 0;
		while (stack[i] != null) i++;
		return i++;		
	}
	
	@Override
	public String toString() {
		String stack_str = "";
		for(int i = size-1; i >= 0; i--)
			if (stack[i] != null) stack_str += stack[i] + " -> ";
		
		return stack_str;
	}
	
	
}
