package fixedSizeStack;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);		
		int datatype_selection;
		int menu_option;
		FixedSizeStack<String> string_stack = null;
		FixedSizeStack<Integer> integer_stack = null;
		FixedSizeStack<Boolean> boolean_stack = null;
		FixedSizeStack<Float> float_stack = null;
		
		/* STACK DATATYPE SELECTION */
		
		System.out.print("---\nFIXED SIZE STACK SIMULATOR\n[ DATATYPE SELECTION ] Before moving forward, select one of the datatypes below to create a stack:\n[ 1 ] String\n[ 2 ] Integer\n[ 3 ] Boolean\n[ 4 ] Float\nSelect one of the options: ");
		datatype_selection = scanner.nextInt();
		
		while (datatype_selection < 1 || datatype_selection > 4) {
			System.out.print("---\n[ INVALID DATATYPE ] Select only one of the options above, from 1 to 4.\nSelect one of the options: ");
			datatype_selection = scanner.nextInt();
		}
		scanner.nextLine();
		
		switch(datatype_selection) {
		case 1 -> string_stack = new FixedSizeStack<>(5);
		case 2 -> integer_stack = new FixedSizeStack<>(5);
		case 3 -> boolean_stack = new FixedSizeStack<>(5);
		case 4 -> float_stack = new FixedSizeStack<>(5);	
		}
		
		/* STACK SIMULATION */
		
		menu_option = 0;
		
		while (menu_option != 5) {
			
			menu_option = 0;
			
			while (menu_option <= 0 || menu_option > 5) {
				System.out.print("---\nMENU\n[ 1 ] Push: insert new element\n[ 2 ] Pop: remove element on top\n[ 3 ] Top: check top element\n[ 4 ] Show Stack\n[ 5 ] Exit\n\nChoose an option: ");
				menu_option = scanner.nextInt();
				scanner.nextLine();
			}
			
			switch(menu_option) {
			
			case 1:
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
				System.out.println("New element inserted succesfully!\n");
				break;
			
				
			case 2:
				System.out.println("---\nREMOVING ELEMENT ON TOP");
				
				switch(datatype_selection) {
				case 1 -> string_stack.pop();
				case 2 -> integer_stack.pop();
				case 3 -> boolean_stack.pop();
				case 4 -> float_stack.pop();
				}
				System.out.println("Element on to removed succesfully!\n");
				break;
			
			case 3:
				System.out.println("---\nCHECKING ELEMENT ON TOP\n[ TOP ELEMENT ] The element on top is: " + 
						switch(datatype_selection) {
						case 1 -> string_stack.top();
						case 2 -> integer_stack.top();
						case 3 -> boolean_stack.top();
						case 4 -> float_stack.top();
						default -> "none";
				});
				break;
			
			case 4:
				System.out.println("---\nSHOWING STACK\nStack: " + 
						switch(datatype_selection) {
						case 1 -> string_stack.toString();
						case 2 -> integer_stack.toString();
						case 3 -> boolean_stack.toString();
						case 4 -> float_stack.toString();
						default -> "none";
				});
				break;
				
			}
			
			if (menu_option == 5) {
				System.out.println("---\nEXITING\nClosing scanner...\n---");
				scanner.close();
				break;
			}
			
		}	
		
	}

}
