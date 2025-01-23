package dinamicstack;

public class DinamicStack<T> {
	
		private T[] stack;
		
		/* CONSTRUCTORS */
		@SuppressWarnings("unchecked")
		DinamicStack() {
			this.stack = (T[]) new Object[10];
		}
		
		/* METHODS */
		public boolean isEmpty() {
			return stack[0] == null;		
		}
		
		public int count() {
			int i = 0;
			while (stack[i] != null) i++;
			return i++;
		}
		
		@SuppressWarnings("unchecked")
		public void push(T new_element) {
			if (isEmpty())
				stack[0] = new_element;
			else if(stack.length < count()){
				int i = 1;
				while (stack[i] != null) i++;
				stack[i] = new_element;			
			} else {
				T[] new_stack = (T[]) new Object[stack.length * 2];
				int i;
				for (i = 0; i < stack.length; i++)
					new_stack[i] = stack[i];
				new_stack[i] = new_element;
				this.stack = new_stack;				
			}
		}
		
		public void pop() {
			if (isEmpty()) 
				return;
			else {
				int i = stack.length-1;
				while (stack[i] == null) i--;
				stack[i] = null;
			}
		}
		
		public T top() {
			int i = stack.length-1;
			while (stack[i] == null) i--;
			return stack[i];
		}
		
		
		@Override
		public String toString() {
			String stack_str = "";
			for(int i = stack.length-1; i > 0; i--)
				if (stack[i] != null) stack_str += stack[i] + " -> ";
			stack_str += stack[0];
			return stack_str;
		}

}
