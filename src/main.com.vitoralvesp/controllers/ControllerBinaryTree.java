package main.com.vitoralvesp.controllers;

import main.com.vitoralvesp.model.binarytree.BinaryTree;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ControllerBinaryTree {

    final static int QUIT = 6;
    final static char NOT = 'N';
    final static char YES = 'Y';

    public static void main(String[] args) {

//		Por que não podem ser variáveis da classe ?
        BinaryTree<Integer> binary_tree_int_type = null;
        BinaryTree<String> binary_tree_str_type = null;

        Scanner scanner = new Scanner(System.in);

        int menu_option = -1;
        int datatype_option = -1;

        // Esse while poderia facilmente ser um metodo chamado runMenu ou algo assim
        while (menu_option != QUIT) {

            menu_option = getInputDataType(scanner);

            try {
                switch (Menu.values()[menu_option - 1]) {
                    case CREATE:
                        System.out.println("---\nCREATING BINARY TREE");
                        executeOptionValidation(binary_tree_int_type, binary_tree_str_type, scanner, datatype_option);
                        break;

                    case INSERT:
                        System.out.print("---\nINSERTING NEW ELEMENT\nEnter a element: ");
                        executeInsertElement(binary_tree_int_type, binary_tree_str_type, scanner, datatype_option);
                        break;

                    case REMOVE:
                        System.out.print("---\nREMOVING AN ELEMENT\nEnter the element to be removed: ");
                        executeRemoveElement(binary_tree_int_type, binary_tree_str_type, scanner, datatype_option);
                        break;

                    case TRAVERSE:
                        System.out.println("---\nBINARY TREE TRAVERSALS");
                        executeTraverseElement(datatype_option, binary_tree_str_type, binary_tree_int_type);
                        break;

                    case GET_PROPERTIES:
                        System.out.println("---\nGETTING PROPERTIES");
                        executeGetProperties(datatype_option, binary_tree_str_type, binary_tree_int_type);
                        break;

                    default:
                        System.out.println("---\nDESCONHECIDO");
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("[ INVALID OPTION ] Select only positive integers from 1 to 6 to access one of the options available. Try again...");
            } catch (Exception e) {
                System.out.println("Falha não capturada");
            }
        }

        System.out.println("---\nEXITING\nClosing Scanner...\nDestroying Binary Trees...");
        scanner.close();
        binary_tree_str_type = null;
        binary_tree_int_type = null;

    }

    private static void executeGetProperties(int datatype_option, BinaryTree<String> binary_tree_str_type, BinaryTree<Integer> binary_tree_int_type) {
        try {
            switch (Datatype.values()[datatype_option - 1]) {
                case STRING:
                    System.out.println("Root: " + binary_tree_str_type.getRoot().getData());
                    System.out.println("Height: " + binary_tree_str_type.getHeight());
                    System.out.println("Empty: " + (binary_tree_str_type.isEmpty() ? "Yes" : "No"));
                    System.out.println("Full: " + (binary_tree_str_type.isFull() ? "Yes" : "No"));
                    break;

                case INTEGER:
                    System.out.println("Root: " + binary_tree_int_type.getRoot().getData());
                    System.out.println("Height: " + binary_tree_int_type.getHeight());
                    System.out.println("Empty: " + (binary_tree_int_type.isEmpty() ? "Yes" : "No"));
                    System.out.println("Full: " + (binary_tree_int_type.isFull() ? "Yes" : "No"));
                    System.out.println("Status:");
                    binary_tree_int_type.status();

                    break;

                default:
                    System.out.println("---\nDESCONHECIDO");
                    break;
            }
        } catch (NullPointerException e) {
            System.out.print("Binary Tree is NULL.\n");
        } catch (Exception e) {
            System.out.println("Falha não capturada");
        }
    }

    private static void executeTraverseElement(int datatype_option, BinaryTree<String> binary_tree_str_type, BinaryTree<Integer> binary_tree_int_type) {
        switch (Datatype.values()[datatype_option - 1]) {
            case STRING:
                System.out.print("Pre-Order Traversal: ");
                binary_tree_str_type.preOrderTraversal();

                System.out.print("\nIn-Order Traversal: ");
                binary_tree_str_type.inOrderTraversal();

                System.out.print("\nPost-Order Traversal: ");
                binary_tree_str_type.postOrderTraversal();

                System.out.print("\nLevel-Order Traversal:\n");
                binary_tree_str_type.levelOrderTraversal();

                System.out.printf("%n");
                break;

            case INTEGER:
                System.out.print("Pre-Order Traversal: ");
                binary_tree_int_type.preOrderTraversal();

                System.out.print("\nIn-Order Traversal: ");
                binary_tree_int_type.inOrderTraversal();

                System.out.print("\nPost-Order Traversal: ");
                binary_tree_int_type.postOrderTraversal();

                System.out.print("\nLevel-Order Traversal:\n");
                binary_tree_int_type.levelOrderTraversal();

                System.out.printf("%n");
                break;

            default:
                System.out.println("---\nDESCONHECIDO");
                break;

        }
    }

    /**
     * @param scanner
     * @return
     */
    private static int getInputDataType(Scanner scanner) {
        int menu_option;
        while (true) {
            try {
                System.out.print("---\nBINARY TREE SIMULATOR\nSelect one of the options below to interact with the binary tree.\n[ 1 ] CREATE\n[ 2 ] INSERT\n[ 3 ] REMOVE\n[ 4 ] TRAVERSE\n[ 5 ] GET PROPERTIES\n[ 6 ] EXIT\nChoose on of the options: ");
                menu_option = scanner.nextInt();
                break;
            } catch (InputMismatchException e) {
                System.out.println("[ INVALID INPUT ] Enter only integers to select one of the options. Try again...");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Falha não capturada");
            }
        }
        return menu_option;
    }

    /**
     * @param binary_tree_int_type
     * @param binary_tree_str_type
     * @param datatype_option
     * @param scanner
     * @return
     */
    private static boolean getDataTypeOption(BinaryTree<Integer> binary_tree_int_type, BinaryTree<String> binary_tree_str_type, int datatype_option, Scanner scanner) {
//		System.out.println("getDataTypeOption(): BEGIN");
        while (true) {
            try {
                System.out.print("Select one of the datatypes below to create a binary tree.\n[ 1 ] STRING\n[ 2 ] INTEGER\nEnter the datatype selected here: ");
                datatype_option = scanner.nextInt();
                break;

            } catch (InputMismatchException e) {
                System.out.println("[ INVALID INPUT ] Enter only integers to select one of the options. Try again...");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Falha não capturada");
            }
        }

        try {
            switch (Datatype.values()[datatype_option - 1]) {
                case STRING:
                    binary_tree_str_type = new BinaryTree<>();
                    break;

                case INTEGER:
                    binary_tree_int_type = new BinaryTree<>();
                    break;

                default:
                    System.out.println("---\nDESCONHECIDO");
                    break;
            }
            System.out.println("[ SUCCESS ] New binary tree created succesfully.");
            return true;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("[ INVALID OPTION ] Select only positive integers from 1 to 6 to access one of the options available. Try again...");
        } catch (InputMismatchException e) {
            System.out.println("[ INVALID INPUT ] Enter only integers to select one of the options. Try again...");
        } catch (Exception e) {
            System.out.println("Falha não capturada");
        }
//		System.out.println("getDataTypeOption(): END");
        return false;
    }

    /**
     * @param binary_tree_int_type
     * @param binary_tree_str_type
     * @param scanner
     * @return
     */
    private static boolean getContinueOperation(BinaryTree<Integer> binary_tree_int_type, BinaryTree<String> binary_tree_str_type, Scanner scanner) {
        char continue_operation;
        System.out.print("[ CONFIRMATION ] You are already using a binary tree. If you choose to proceed by creating a new one, the one you are currently running will be discarded. Do you want to continue [Y/N]: ");
        continue_operation = scanner.next().toUpperCase().charAt(0);

        while (continue_operation != NOT && continue_operation != YES) {
            System.out.print("[ INVALID OPTION ] Select only N or Y to confirm the operation. Try again...\nDo you want to continue [Y/N]: ");
            continue_operation = scanner.next().toUpperCase().charAt(0);
        }

        if (continue_operation == NOT) return false;

        binary_tree_int_type = null;
        binary_tree_str_type = null;
        return true;
    }

    /**
     * @param binary_tree_int_type
     * @param binary_tree_str_type
     * @param scanner
     * @param datatype_option
     */
    private static void executeOptionValidation(BinaryTree<Integer> binary_tree_int_type, BinaryTree<String> binary_tree_str_type, Scanner scanner, int datatype_option) {
        boolean isValidOption = false;
        while (true) {

            if (binary_tree_str_type == null && binary_tree_int_type == null) {
                isValidOption = getDataTypeOption(binary_tree_int_type, binary_tree_str_type, datatype_option, scanner);
            } else {
                isValidOption = getContinueOperation(binary_tree_int_type, binary_tree_str_type, scanner);
            }

            if (!isValidOption) break;
        }
    }

    /**
     * @param binary_tree_int_type
     * @param binary_tree_str_type
     * @param scanner
     * @param datatype_option
     */
    private static void executeInsertElement(BinaryTree<Integer> binary_tree_int_type, BinaryTree<String> binary_tree_str_type, Scanner scanner, int datatype_option) {
        switch (Datatype.values()[datatype_option - 1]) {
            case STRING:
                String new_str_element = scanner.next();
                binary_tree_str_type.insert(new_str_element);
                break;

            case INTEGER:
                Integer new_int_element = scanner.nextInt();
                binary_tree_int_type.insert(new_int_element);
                break;

            default:
                System.out.println("---\nDESCONHECIDO");
                break;
        }
        System.out.println("[ SUCCESS ] New element inserted succesfully.");
    }

    /**
     * @param binary_tree_int_type
     * @param binary_tree_str_type
     * @param scanner
     * @param datatype_option
     */
    private static void executeRemoveElement(BinaryTree<Integer> binary_tree_int_type, BinaryTree<String> binary_tree_str_type, Scanner scanner, int datatype_option) {
        switch (Datatype.values()[datatype_option - 1]) {
            case STRING:
                String remove_str_element = scanner.next();
                binary_tree_str_type.remove(remove_str_element);
                break;

            case INTEGER:
                Integer remove_int_element = scanner.nextInt();
                binary_tree_int_type.remove(remove_int_element);
                break;

            default:
                System.out.println("---\nDESCONHECIDO");
                break;
        }
        System.out.println("[ SUCCESS ] Element removed succesfully.");
    }

    private enum Menu {

        CREATE(1), INSERT(2), REMOVE(3), TRAVERSE(4), GET_PROPERTIES(5), EXIT(6);
        final int menu_option_selected;

        Menu(int menu_option_chosen) {
            this.menu_option_selected = menu_option_chosen;
        }

    }

    private enum Datatype {

        STRING(1), INTEGER(2);
        final int datatype_option_selected;

        Datatype(int datatype_option_chosen) {
            this.datatype_option_selected = datatype_option_chosen;
        }

    }

}
