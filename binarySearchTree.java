/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ashin
 */
public class binarySearchTree {

    /**
     * @param args the command line arguments
     */
    
    // Node class represents each node in the BST
    static class Node {
        int value;
        Node left, right;

        // Constructor
        Node(int item) {
            value = item;
            left = right = null;
        }
    }

    // Root of the BST
    Node root;

    // Constructor
    binarySearchTree() {
        root = null;
    }

    // Method to insert a new value in the BST
    void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive function to insert a new value
    Node insertRec(Node root, int value) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(value);
            return root;
        }

        // Otherwise, recur down the tree
        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        // Return the (unchanged) node pointer
        return root;
    }

    // Method to perform an in-order traversal of the BST
    void inorder() {
        inorderRec(root);
    }

    // Recursive function to perform in-order traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Method to search a value in the BST
    boolean search(int value) {
        return searchRec(root, value);
    }

    // Recursive function to search for a value
    boolean searchRec(Node root, int value) {
        // Base Cases: root is null or value is present at root
        if (root == null) {
            return false;
        }
        if (root.value == value) {
            return true;
        }

        // Value is greater than root's value
        if (root.value < value) {
            return searchRec(root.right, value);
        }

        // Value is smaller than root's value
        return searchRec(root.left, value);
    }

    public static void main(String[] args) {
        // TODO code application logic here
  
        binarySearchTree bst = new binarySearchTree();

        // Inserting values into the BST
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);

        // Performing in-order traversal
        System.out.println("In-order traversal of the BST:");
        bst.inorder(); // Output will be sorted values

        // Searching for a value
        System.out.println("\n\nSearching for 40 in the BST:");
        System.out.println(bst.search(40) ? "Found" : "Not Found");

        System.out.println("Searching for 90 in the BST:");
        System.out.println(bst.search(90) ? "Found" : "Not Found");
    }
}
