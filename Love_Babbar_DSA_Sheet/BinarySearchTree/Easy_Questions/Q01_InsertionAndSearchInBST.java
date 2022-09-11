/**
 * @author Pradip Sahoo
 * Created on 11/09/2022
 * -----------------------
 * Write a program to insert and search elements in binary search tree
 * 
 * Time Complexity : O(h)
 * Space Complexity : O(h)
 */
package Love_Babbar_DSA_Sheet.BinarySearchTree.Easy_Questions;

import java.util.Scanner;

public class Q01_InsertionAndSearchInBST {

    // Node class for create new nodes in tree
    public class Node {
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
    static Q01_InsertionAndSearchInBST insertionAndSearch = new Q01_InsertionAndSearchInBST();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the total no of elements in the tree : ");
        int size = sc.nextInt();

        System.out.println("Enter the elements of the tree : ");

        // Enter the root element of the tree
        int firstElement = sc.nextInt();
        Node root = insertionAndSearch.new Node(firstElement);

        // Enter other elements of the tree
        for (int i = 1; i < size; i++) {
            int otherElements = sc.nextInt();
            insertNodes(root, otherElements);
        }

        System.out.print("Enter the element which you want to search : ");
        int val = sc.nextInt();

        sc.close();

        System.out.print("Output : ");
        if (searchNode(root, val)) {
            System.out.println(val + " is present in the tree");
        } else {
            System.out.println(val + " is not present in the tree");
        }
    }

    /**
     * Method to insert new nodes in the tree
     * 
     * @param root
     * @param keyData
     */
    private static void insertNodes(Node root, int keyData) {

        /**
         * If new node data is less than root then move to the left side of the tree,
         * else move right side of the tree
         */
        if (keyData < root.data) {
            if (root.left != null) {
                insertNodes(root.left, keyData);
            } else {
                root.left = insertionAndSearch.new Node(keyData);
            }
        } else {
            if (root.right != null) {
                insertNodes(root.right, keyData);
            } else {
                root.right = insertionAndSearch.new Node(keyData);
            }
        }
    }

    /**
     * Method to search the node into the tree
     * 
     * @param root
     * @param val
     * @return true or false
     */
    private static boolean searchNode(Node root, int val) {

        // Base case
        if (root == null) {
            return false;
        }

        // If elements are matched then return true
        if (root.data == val) {
            return true;
        }

        /**
         * If the searching element is less than root then move to the left side of
         * root, else move right side of root
         */
        if (root.data > val) {
            return searchNode(root.left, val);
        } else {
            return searchNode(root.right, val);
        }
    }
}