package main.com.vitoralvesp.model.queue;

public class StaticQueue<T> {

	private T[] queue;
	private int size;
	private int first;
	private int last;
	private int count;
	
	/* CONSTRUCTORS */
	
	public StaticQueue() {}
	
	public StaticQueue(int size) {
		this.first = 0;
		this.last = 0;
		this.count = 0;
		this.size = size;
		this.queue = (T[]) new Object[size];
	}
	
	
	/* METHODS */
	
	public boolean isEmpty() {
		return count == 0;
	}
	
	public boolean isFull() {
		return count == size;
	}
	
	public T front() {
		return queue[first];
	}
	
	public int size() {
		return size;
	}
	
	public int count() {
		return count;
	}
	
	public boolean contains(T element) {
		
		if (queue == null || isEmpty()) return false;
		
		if (last <= first) {
			
			for (int i = first; i < size; i++)
				if (queue[i] == element) return true;
			
			for (int j = 0; j < last; j++)
				if (queue[j] == element) return true;
				
		} else {
			
			for (int k = first; k < last; k++)
				if (queue[k] == element) return true;
			
		}
		
		return false;		
		
	}
	
	public void enqueue(T new_element) {
		
		if (queue == null || isFull()) return;
		
		queue[last] = new_element;
		last = (last + 1) % size;
		count++;
		
	}
	
	public void dequeue() {
		
		if (queue == null || isEmpty()) return;
		
		queue[first] = null;
		first = (first + 1) % size;
		count--;
	}	
	
}
