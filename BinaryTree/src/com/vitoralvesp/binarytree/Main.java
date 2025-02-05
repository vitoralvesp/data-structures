package com.vitoralvesp.binarytree;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		BinaryTree<String> binary_tree_string = null;
		BinaryTree<Integer> binary_tree_integer = null;
		BinaryTree<Float> binary_tree_float = null;
		Scanner scanner = new Scanner(System.in);
		
		int datatype_selection;
		int menu_option;
		
		
		/* BINARY TREE DATATYPE SELECTION */
		
		while (true) {
			
			try {
			
				System.out.print("---\nBINARY TREE SIMULATOR\n[ DATATYPE SELECTION ] Before moving forward, select one of the datatypes\nbelow to create a binary tree:\n[ 1 ] String\n[ 2 ] Integer\n[ 3 ] Float\nSelect one of the options: ");
				datatype_selection = scanner.nextInt();
				
				while (datatype_selection < 1 || datatype_selection > 3) {
					System.out.print("---\n[ INVALID DATATYPE ] Select only one of the options above, from 1 to 3. Try again: ");
					datatype_selection = scanner.nextInt();
				}
				scanner.nextLine();
				
				break;
				
			}
			catch(InputMismatchException e) {
				
				System.out.println("---\n[ INPUT MISMATCH EXCEPTION ] Type only positive integer numbers from 1 to 3\nto select one of the options shown.");
				
				scanner.nextLine();
				
			}
			
		}
		
		switch(datatype_selection) {
		case 1 -> binary_tree_string = new BinaryTree<>();
		case 2 -> binary_tree_integer = new BinaryTree<>();
		case 3 -> binary_tree_float = new BinaryTree<>();
		}
		
		System.out.println("[ BINARY TREE CREATED ] Binary Tree was created succesfully!!");
		
		
		/* BINARY TREE SIMULATION */
		
		while (true) {
			
			while (true) {
				
				try {
					
					System.out.print("---\nMENU\n[ 1 ] Insert\n[ 2 ] Show Binary Tree\n[ 3 ] Tree Height\n[ 4 ] Exit\n\nChoose an option: ");
					menu_option = scanner.nextInt();
					
					while (menu_option <= 0 || menu_option > 4) {
						
						System.out.print("---\n[ INVALID MENU OPTION ] To select one of the menu options shown,\ntype only positive integer number from 1 to 3. Try again: ");
						menu_option = scanner.nextInt();
						scanner.nextLine();
						
					}
					
					break;
					
				}
				catch(InputMismatchException e) {
					
					System.out.println("---\n[ INPUT MISMATCH EXCEPTION ] Type only positive integer numbers from 1 to 3\nto select one of the options shown.");
					
					scanner.nextLine();
					
				}
				
			}
			
			if (menu_option == 4) {
				System.out.println("---\nEXITING\nClosing scanner...\n---");
				scanner.close();
				break;
			}
			
			scanner.nextLine();
			
			switch (menu_option) {
			
			case 1:
				
				while(true) {
					
					try {
						
						if (binary_tree_string != null || binary_tree_integer != null || binary_tree_float != null) {
							
							System.out.print("---\nINSERTING NEW ELEMENT\nEnter the value to be inserted: ");
							
							switch(datatype_selection) {
							case 1:
								String new_string_element = scanner.nextLine();
								binary_tree_string.insert(new_string_element);
								break;
							case 2:
								Integer new_integer_element = scanner.nextInt();
								binary_tree_integer.insert(new_integer_element);
								break;
							case 3:
								Float new_float_element = scanner.nextFloat();
								binary_tree_float.insert(new_float_element);
								break;
							}
							
							System.out.println("New element inserted succesfully!");
							break;
							
						}
						
					}
					catch(InputMismatchException e) {
						
						System.out.println("---\n[ WRONG DATATYPE INPUT ] It is not possible to insert this element into\nthe binary tree due to the tree datatype selected previously. Please, check the\ndatatype both from; tree and element to push and try again...");
						
						scanner.nextLine();
						
					}
					
				}
				
				break;
				
			case 2:
				
				System.out.print("---\nBINARY TREE TRAVERSALS\n");
				
				switch	(datatype_selection) {
				case 1:
					
					System.out.print("Pre-Order Traversal: ");
					binary_tree_string.preOrderTraversal();
					
					System.out.print("\nIn-Order Traversal: ");
					binary_tree_string.inOrderTraversal();
					
					System.out.print("\nPost-Order Traversal: ");
					binary_tree_string.postOrderTraversal();
					
					System.out.print("\nLevel-Order Traversal: ");
					binary_tree_string.levelOrderTraversal();
					
					break;
				
				case 2:
					
					System.out.print("Pre-Order Traversal: ");
					binary_tree_integer.preOrderTraversal();
					
					System.out.print("\nIn-Order Traversal: ");
					binary_tree_integer.inOrderTraversal();
					
					System.out.print("\nPost-Order Traversal: ");
					binary_tree_integer.postOrderTraversal();
					
					System.out.print("\nLevel-Order Traversal: ");
					binary_tree_integer.levelOrderTraversal();
					
					break;
								
			
				case 3:
				
					System.out.print("---\nBINARY TREE HEIGHT: " + 
							switch(datatype_selection) {
							case 1 -> binary_tree_string.getHeight();
							case 2 -> binary_tree_integer.getHeight();
							case 3 -> binary_tree_float.getHeight();
							default -> "undefined";
							});
				
					break;
					
				}
				
				System.out.print("\n");

			}
			
		}

	}

}
