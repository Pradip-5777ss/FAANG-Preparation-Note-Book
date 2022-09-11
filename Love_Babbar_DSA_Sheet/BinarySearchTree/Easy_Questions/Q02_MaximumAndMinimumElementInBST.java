/**
 * @author Pradip Sahoo
 * Created on 11/09/2022
 * -------------------------
 * Minimum element in BST.
 * Given a Binary Search Tree. The task is to find the minimum and maximum element in this given BST.
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
 *          7
 * 
 * Example 2:
 *  Input:
 *              9
 *               \
 *                10
 *                 \
 *                  11
 *  Output: 9
 *          11
 * 
 * Time Complexity: O(Height of the BST)
 * Auxiliary Space: O(Height of the BST).
 */
package Love_Babbar_DSA_Sheet.BinarySearchTree.Easy_Questions;

import java.util.Scanner;

public class Q02_MaximumAndMinimumElementInBST {

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
    static Q02_MaximumAndMinimumElementInBST minElement = new Q02_MaximumAndMinimumElementInBST();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of the elements of the tree : ");
        int n = sc.nextInt();

        System.out.println("Enter the elements of the tree : ");

        int firstNode = sc.nextInt();
        Node root = minElement.new Node(firstNode);

        // Take other elements of the tree from user
        for (int i = 1; i < n; i++) {
            int ohterNodes = sc.nextInt();
            insertNodes(root, ohterNodes);
        }

        sc.close();

        // Method call to find the minimum value of the binary tree
        int res = minValue(root);

        // Print the minimum value
        System.out.println("The minimum value of the BST is : " + res);

        // Method call to find the maximum value of the binary tree
        int ans = maxValue(root);

        // Print the maximum value
        System.out.println("The maximum value of the BST is : " + ans);
    }

    // Method to find the maximum value of the tree
    private static int maxValue(Node root) {

        // Base case
        if (root == null) {
            return -1;
        }

        // Run a loop until the right child of the tree is not null
        while (root.right != null) {
            root = root.right;
        }

        // Return the maximum node data
        return root.data;
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

        // Return the minimum node data
        return root.data;
    }

    // Method to insert the nodes into the tree
    private static void insertNodes(Node root, int keyData) {

        /**
         * If new node data is less than root then move to the left side of the tree,
         * else move right side of the tree
         */
        if (keyData < root.data) {
            if (root.left != null) {
                insertNodes(root.left, keyData);
            } else {
                root.left = minElement.new Node(keyData);
            }
        } else {
            if (root.right != null) {
                insertNodes(root.right, keyData);
            } else {
                root.right = minElement.new Node(keyData);
            }
        }
    }
}