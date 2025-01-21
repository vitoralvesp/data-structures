package staticstack;
import java.util.Scanner;
import java.util.InputMismatchException;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);		
		int datatype_selection;
		int stack_size;
		int menu_option;
		StaticStack<String> string_stack = null;
		StaticStack<Integer> integer_stack = null;
		StaticStack<Boolean> boolean_stack = null;
		StaticStack<Float> float_stack = null;
		
		/* STACK DATATYPE SELECTION */
		
		while(true) {
			
			try {
				
				System.out.print("---\nFIXED SIZE STACK SIMULATOR\n[ DATATYPE SELECTION ] Before moving forward, select one of the datatypes\nbelow to create a stack:\n[ 1 ] String\n[ 2 ] Integer\n[ 3 ] Boolean\n[ 4 ] Float\nSelect one of the options: ");
				datatype_selection = scanner.nextInt();
				
				while (datatype_selection < 1 || datatype_selection > 4) {
					System.out.print("---\n[ INVALID DATATYPE ] Select only one of the options above, from 1 to 4. Try again: ");
					datatype_selection = scanner.nextInt();
				}
				scanner.nextLine();
				
				break;
				
			}
			catch(InputMismatchException e) {
				
				System.out.println("---\n[ INPUT MISMATCH EXCEPTION ] Type only positive integer numbers from 1 to 4\nto select one of the options shown.");
				
				scanner.nextLine();
				
			}
			
		}
		
		while (true) {
			
			try {
				
				System.out.print("Now, enter the stack size limit: ");
				stack_size = scanner.nextInt();
				break;
				
			}
			catch(InputMismatchException e) {
				
				System.out.println("---\n[ INPUT MISMATCH EXCEPTION ] Type only positive integer numbers to set the stack size limit.");
				
				scanner.nextLine();
				
			}
			
		}
		
		
		switch(datatype_selection) {
		case 1 -> string_stack = new StaticStack<>(stack_size);
		case 2 -> integer_stack = new StaticStack<>(stack_size);
		case 3 -> boolean_stack = new StaticStack<>(stack_size);
		case 4 -> float_stack = new StaticStack<>(stack_size);	
		}
		
		System.out.println("[ STACK CREATED ] Stack was created succesfully!!");
		
		/* STACK SIMULATION */
				
		while (true) {
			
			while(true) {
				
				try {
					
					System.out.print("---\nMENU\n[ 1 ] Push: insert new element\n[ 2 ] Pop: remove element on top\n[ 3 ] Top: check top element\n[ 4 ] Show Stack\n[ 5 ] Exit\n\nChoose an option: ");
					menu_option = scanner.nextInt();
					
					while (menu_option <= 0 || menu_option > 5) {
						
						System.out.print("---\n[ INVALID MENU OPTION ] To select one of the menu options shown,\ntype only positive integer number from 1 to 5. Try again: ");
						menu_option = scanner.nextInt();
						scanner.nextLine();
						
					}
					
					break;
					
				} 
				catch(InputMismatchException e) {
					
					System.out.println("---\n[ INPUT MISMATCH EXCEPTION ] Type only positive integer numbers from 1 to 5\nto select one of the options shown.");
					
					scanner.nextLine();
					
				}
				
			}
			
			if (menu_option == 5) {
				System.out.println("---\nEXITING\nClosing scanner...\n---");
				scanner.close();
				break;
			}
			
			scanner.nextLine();
			
			switch(menu_option) {
			
			case 1:
				
				while(true) {
					
					try {
						
						if (string_stack != null && !string_stack.isFull() || integer_stack != null && !integer_stack.isFull() || boolean_stack != null && !boolean_stack.isFull() || float_stack != null && !float_stack.isFull()) {
							
							System.out.print("---\nINSERTING NEW ELEMENT\nEnter the value to be inserted: ");
							
							switch(datatype_selection) {
							case 1:
								String new_string_element = scanner.nextLine();
								string_stack.push(new_string_element);
								break;
							case 2:
								Integer new_integer_element = scanner.nextInt();
								integer_stack.push(new_integer_element);
								break;
							case 3:
								Boolean new_boolean_element = scanner.nextBoolean();
								boolean_stack.push(new_boolean_element);
								break;
							case 4:
								Float new_float_element = scanner.nextFloat();
								float_stack.push(new_float_element);
								break;
							}
							
							System.out.println("New element inserted succesfully!");
							break;
							
						} else {
							
							System.out.println("---\n[ STACK IS FULL ] Stack is already full!");
							break;
							
						}
						
					}
					catch(InputMismatchException e) {
						
						System.out.println("---\n[ WRONG DATATYPE INPUT ] It is not possible to insert this element into\nthe stack due to the stack datatype selected previously. Please, check the\ndatatype both from; stack and element to push and try again...");
						
						scanner.nextLine();
						
					}
					
				}
				
				break;
			
				
			case 2:
				
				if (string_stack != null && !string_stack.isEmpty() || integer_stack != null && !integer_stack.isEmpty() || boolean_stack != null && !boolean_stack.isEmpty() || float_stack != null && !float_stack.isEmpty()) {
					
					System.out.println("---\nREMOVING ELEMENT ON TOP");
					
					switch(datatype_selection) {
					case 1 -> string_stack.pop();
					case 2 -> integer_stack.pop();
					case 3 -> boolean_stack.pop();
					case 4 -> float_stack.pop();
					}
					System.out.println("Element removed succesfully!");
					
				} else {
				
					System.out.println("---\n[ STACK IS EMPTY ] Stack is already empty, nothing to remove.");
					
				}
				
				break;
			
			case 3:
				System.out.println("---\nCHECKING ELEMENT ON TOP\n[ TOP ELEMENT ] The element on top is: " + 
						switch(datatype_selection) {
						case 1 -> string_stack.top();
						case 2 -> integer_stack.top();
						case 3 -> boolean_stack.top();
						case 4 -> float_stack.top();
						default -> "null";
				});
				break;
			
			case 4:
				System.out.println("---\nSHOWING STACK");
				
				if (string_stack != null && !string_stack.isEmpty() || integer_stack != null && !integer_stack.isEmpty() || boolean_stack != null && !boolean_stack.isEmpty() || float_stack != null && !float_stack.isEmpty()) {
					
					switch(datatype_selection) {
					
					case 1 -> System.out.println("Top: " + string_stack.top() + "\nStack: " + string_stack.toString());
					
					case 2 -> System.out.println("Top: " + integer_stack.top() + "\nStack: " + integer_stack.toString());
					
					case 3 -> System.out.println("Top: " + boolean_stack.top() + "\nStack: " + boolean_stack.toString());
					
					case 4 -> System.out.println("Top: " + float_stack.top() + "\nStack: " + float_stack.toString());
				
					}
				} else {
					
					System.out.println("Stack is empty.");
					
				}
				
				break;
				
			}
			
		}	
		
	}

}
