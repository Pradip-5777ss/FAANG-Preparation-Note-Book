/**
 * Minimum element in BST.
 * 
 * Given a Binary Search Tree. The task is to find the minimum element in this given BST.
 * 
 * Example 1:
 *  Input:
 *             5
 *           /    \
 *          4      6
 *         /        \
 *        3          7
 *       /
 *      1
 *  Output: 1
 * 
 * Example 2:
 *  Input:
 *              9
 *               \
 *                10
 *                 \
 *                  11
 *  Output: 9
 * 
 * Time Complexity: O(Height of the BST)
 * Auxiliary Space: O(Height of the BST).
 */
package BinarySearchTree.EasyQuestions;

import java.util.Scanner;

public class MinimumElementInBST {

    // Class for creating nodes of the tree
    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Create object of the class
    static MinimumElementInBST minElement = new MinimumElementInBST();

    public static void main(String[] args) {

        // Create scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the number of elements of the tree
        System.out.println("Enter the number of the elements of the tree : ");
        int n = sc.nextInt();

        // Ask user to enter the elements of the tree
        System.out.println("Enter the elements of the tree : ");

        // Declare a variable 'firstNode' to store the first element of the tree
        int firstNode = sc.nextInt();

        // Make the first element as root of the tree
        Node root = minElement.new Node(firstNode);

        // Take other elements of the tree from user
        for (int i = 1; i < n; i++) {
            int ohterNodes = sc.nextInt();
            insertNodes(root, ohterNodes);
        }

        sc.close();

        // Call the method to find the minimum value of the binary tree
        int res = minValue(root);

        // Print the minimum value
        System.out.println("The minimum value of the BST is : " + res);
    }

    // Method to find the minimum value of the tree
    private static int minValue(Node root) {

        // Base case
        if (root == null) {
            return -1;
        }

        // Run a loop until the left child of the tree is not null
        while (root.left != null) {
            root = root.left;
        }

        // Return the minimum root element data
        return root.data;
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
                root.left = minElement.new Node(keyData);
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
                root.right = minElement.new Node(keyData);
            }
        }
    }
}