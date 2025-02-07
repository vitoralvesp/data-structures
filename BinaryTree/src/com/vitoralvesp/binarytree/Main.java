package com.vitoralvesp.binarytree;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	private enum Menu {
		
		CREATE(1), INSERT(2), REMOVE(3), TRAVERSE(4), GET_PROPERTIES(5), EXIT(6);
		final int menu_option_selected;
		
		Menu(int menu_option_chosen) { this.menu_option_selected = menu_option_chosen;	}
		
	}
	
	private enum Datatype {
		
		STRING(1), INTEGER(2);
		final int datatype_option_selected;
		
		Datatype(int datatype_option_chosen) { this.datatype_option_selected = datatype_option_chosen; }
		
	}

	public static void main(String[] args) {

		BinaryTree<Integer> binary_tree_int_type = null;
		BinaryTree<String> binary_tree_str_type = null;
		
		Scanner scanner = new Scanner(System.in);
		
		int menu_option = -1;
		int datatype_option = -1;
		
		while (menu_option != 6) {

			System.out.print("---\nBINARY TREE SIMULATOR\nSelect one of the options below to interact with the binary tree.\n[ 1 ] CREATE\n[ 2 ] INSERT\n[ 3 ] REMOVE\n[ 4 ] TRAVERSE\n[ 5 ] GET PROPERTIES\n[ 6 ] EXIT\nChoose on of the options: ");
			
			try {
				
				menu_option = scanner.nextInt();
				
				switch (Menu.values()[menu_option - 1]) {
				
				case CREATE:
					
					System.out.print("---\nCREATING BINARY TREE\nSelect one of the datatypes below to create a binary tree.\n[ 1 ] STRING\n[ 2 ] INTEGER\nEnter the datatype selected here: ");
					
					try {
						
						datatype_option = scanner.nextInt();
						
						switch (Datatype.values()[datatype_option - 1]) {
						
							case STRING:
								binary_tree_str_type = new BinaryTree<>();
								break;
								
							case INTEGER:
								binary_tree_int_type = new BinaryTree<>();
								break;
								
						}
						
					} catch (ArrayIndexOutOfBoundsException e) {
						
						System.out.println("[ INVALID OPTION ] Select only positive integers from 1 to 6 to access one of the options available. Try again...");
						
					}
					
					break;
					
					
				case INSERT:
					System.out.println("INSERT");
					break;
					
				case REMOVE:
					System.out.println("REMOVE");
					break;
					
				case TRAVERSE:
					System.out.println("TRAVERSE");
					break;
					
				case GET_PROPERTIES:
					
					System.out.println("---\nGETTING PROPERTIES");
					
					switch (Datatype.values()[datatype_option - 1]) {
					
						case STRING:
							System.out.println("Root: " + binary_tree_str_type.getRoot());
							System.out.println("Height: " + binary_tree_str_type.getHeight());
							System.out.println("Empty: " + (binary_tree_str_type.isEmpty() ? "Yes" : "No"));
							System.out.println("Full: " + (binary_tree_str_type.isFull() ? "Yes" : "No"));
							
							break;
							
						
						case INTEGER:
							System.out.println("Root: " + binary_tree_int_type.getRoot());
							System.out.println("Height: " + binary_tree_int_type.getHeight());
							System.out.println("Empty: " + (binary_tree_int_type.isEmpty() ? "Yes" : "No"));
							System.out.println("Full: " + (binary_tree_int_type.isFull() ? "Yes" : "No"));
							
							break;
							
					}
					
					break;			
					
				}
				
			} catch (ArrayIndexOutOfBoundsException e) {
				
				System.out.println("[ INVALID OPTION ] Select only positive integers from 1 to 6 to access one of the options available. Try again...");
				
			}
			
		}
		
		System.out.println("---\nEXITING\nClosing Scanner...\nDestroying Binary Trees...");
		scanner.close();
		binary_tree_str_type = null;
		binary_tree_int_type = null;
			
	}

}
