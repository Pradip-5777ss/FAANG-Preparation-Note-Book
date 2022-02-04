/**
 * Search a node in BST.
 * Given a Binary Search Tree and a node value X, find if the node with value X is present in the BST or not.
 * 
 * Example 1:
 *  Input:         
 *                 2
 *                 \
 *                  81 
 *                /    \ 
 *              42      87 
 *               \       \ 
 *                66      90 
 *               / 
 *             45
 *      X = 87
 *  Output: 1
 * Explanation: As 87 is present in the given nodes , so the output will be 1.
 * 
 * Example 2:
 *  Input:      
 *              6
 *              \ 
 *               7 
 *              / \ 
 *             8   9
 *      X = 11
 *  Output: 0
 * Explanation: As 11 is not present in the given nodes , so the output will be 0.
 * 
 * Time Complexity : O(Height of the BST)
 * Auxiliary Space : O(1).
 */
package BinarySearchTree.EasyQuestions;

import java.util.Scanner;

public class InsertionAndSearch {

    // Class for creating nodes of the tree
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Create object of the class
    static InsertionAndSearch insertionAndSearch = new InsertionAndSearch();

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the number of elements of the tree
        System.out.println("Enter the nuber of elements of the tree : ");
        int n = sc.nextInt();

        // Ask user to enter the elements of the tree
        System.out.println("Enter the elements of the tree : ");

        // Declare 'firstNode' variable to store the root node of the tree
        int firstNode = sc.nextInt();
        Node root = insertionAndSearch.new Node(firstNode);

        // Run a loop to take other node elements from user and insert it into the tree
        for (int i = 1; i < n; i++) {
            int ohterNodes = sc.nextInt();
            insertNodes(root, ohterNodes);
        }

        // Ask user to enter the element which we want to search in the tree
        System.out.println("Enter the value which you want to search : ");
        int searchValue = sc.nextInt();

        // If the search element is present in the tree then print the required asnwer
        if (searchNodes(root, searchValue) == true) {
            System.out.println("The value is present in the tree");
        } else {
            System.out.println("The value is not present in the tree");
        }
        sc.close();
    }

    // Method to insert the nodes into the tree
    private static void insertNodes(Node root, int keyData) {

        /**
         * If the node data is less than the current root then insert it in the left
         * side of the root.
         * 
         * If the left node of the root is null then put that node at the left side of
         * the root. And if it is not null then recursively call the method for the left
         * node of the root.
         */
        if (keyData < root.data) {
            if (root.left != null) {
                insertNodes(root.left, keyData);
            } else {
                root.left = insertionAndSearch.new Node(keyData);
            }
        }

        /**
         * If the node data is greater than the current root then insert it in the right
         * side of the root.
         * 
         * If the right node of the root is null then put that node at the right side of
         * the root. And if it is not null then recursively call the method for the
         * right node of the root.
         */
        else {
            if (root.right != null) {
                insertNodes(root.right, keyData);
            } else {
                root.right = insertionAndSearch.new Node(keyData);
            }
        }
    }

    // Method to search the element into the tree
    private static boolean searchNodes(Node root, int searchValue) {

        // If the root is null then return false
        if (root == null) {
            return false;
        }

        // If the search value is equal to the value of root then return true
        if (root.data == searchValue) {
            return true;
        }

        /**
         * If the search value is greater than the root then recursively call the method
         * and find the value at the right side of the root.
         * 
         * If the search value is less than the root then recursively call the method
         * and find the value at the left side of the root.
         */
        if (searchValue > root.data) {
            return searchNodes(root.right, searchValue);
        } else {
            return searchNodes(root.left, searchValue);
        }
    }
}