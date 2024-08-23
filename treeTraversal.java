/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author ashin
 */
public class treeTraversal {

    /**
     * @param args the command line arguments
     */
   
    // Node class represents each node in the binary tree
    static class Node {
        int value;
        Node left, right;

        // Constructor
        Node(int item) {
            value = item;
            left = right = null;
        }
    }

    // Root of the binary tree
    Node root;

    // Constructor
    treeTraversal() {
        root = null;
    }

    // Method to insert a new value in the binary tree
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

    // Method for in-order traversal (left, root, right)
    void inorder() {
        inorderRec(root);
    }

    // Recursive function for in-order traversal
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.value + " ");
            inorderRec(root.right);
        }
    }

    // Method for pre-order traversal (root, left, right)
    void preorder() {
        preorderRec(root);
    }

    // Recursive function for pre-order traversal
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.value + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // Method for post-order traversal (left, right, root)
    void postorder() {
        postorderRec(root);
    }

    // Recursive function for post-order traversal
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.value + " ");
        }
    }

    public static void main(String[] args) {
        treeTraversal tree = new treeTraversal();

        // Inserting values into the binary tree
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        // Performing traversals
        System.out.println("In-order traversal of the binary tree:");
        tree.inorder(); // Output: 20 30 40 50 60 70 80
        System.out.println();

        System.out.println("Pre-order traversal of the binary tree:");
        tree.preorder(); // Output: 50 30 20 40 70 60 80
        System.out.println();

        System.out.println("Post-order traversal of the binary tree:");
        tree.postorder(); // Output: 20 40 30 60 80 70 50
        System.out.println();
    }
}
