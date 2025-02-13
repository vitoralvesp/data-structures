package com.vitoralvesp.bst;

public class Menu {
	
	private final int create = 1;
	private final int insert = 2;
	private final int remove = 3;
	private final int traverse = 4;
	private final int get_properties = 5;
	private final int exit = 6;
	
	private int menu_option_selected;
	
	
	/* CONSTRUCTORS */
	
	Menu() {}
	
	Menu(int menu_option_chosen) {
		this.menu_option_selected = menu_option_chosen;
	}
	
	
	/* METHODS */

	private boolean validate_option(int menu_option_chosen) {
		
		if (menu_option_chosen < 1 || menu_option_chosen > 6)
			return false;
		
		return true;
		
	}
	
	
	
	
	public static void show_menu() {
		
		System.out.println("---\\nBINARY TREE SIMULATOR\\nSelect one of the options below to interact with the binary tree.\\n[ 1 ] CREATE\\n[ 2 ] INSERT\\n[ 3 ] REMOVE\\n[ 4 ] TRAVERSE\\n[ 5 ] GET PROPERTIES\\n[ 6 ] EXIT");
		
	}

}
