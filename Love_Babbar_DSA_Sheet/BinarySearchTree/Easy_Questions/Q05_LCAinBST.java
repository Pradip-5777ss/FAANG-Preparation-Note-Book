/**
 * @author Pradip Sahoo
 * Created on 14/09/2022
 * --------------------------
 * Given a Binary Search Tree (with all values unique) and two node values. Find
 * the Lowest Common Ancestors of the two nodes in the BST.
 * 
 * Example 1:
 *  Input:
 *          5
 *         / \
 *        4   6
 *       /     \
 *      3       7
 *               \
 *                8
 *  n1 = 7, n2 = 8
 *  Output: 7
 * 
 * Example 2:
 *  Input:
 *          2
 *        /  \
 *       1   3
 *  n1 = 1, n2 = 3
 *  Output: 2
 * 
 * Time Complexity : O(Height Of the BST)
 * Space Complexity : O(Height Of the BST)
 */
package Love_Babbar_DSA_Sheet.BinarySearchTree.Easy_Questions;

import java.util.Scanner;

public class Q05_LCAinBST {

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

    static Q05_LCAinBST lcAinBST = new Q05_LCAinBST();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no of elements in binary search tree : ");
        int size = sc.nextInt();

        System.out.println("Enter the elements of the tree : ");
        int firstElement = sc.nextInt();
        Node root = lcAinBST.new Node(firstElement);

        for (int i = 1; i < size; i++) {
            int otherElements = sc.nextInt();
            insertElements(root, otherElements);
        }

        System.out.println("Enter the two nodes to find the LCA :");
        System.out.print("FirstNode : ");
        int firstNode = sc.nextInt();

        System.out.print("SecondNode : ");
        int secondNode = sc.nextInt();

        Node ans = checkLCA(root, firstNode, secondNode);

        sc.close();

        System.out.println("Output : " + ans.data);
    }

    /**
     * Method to find the lowest common ancestor of a Binary Search Tree
     * 
     * @param root
     * @param firstNode
     * @param secondNode
     * @return the LCA node
     */
    private static Node checkLCA(Node root, int firstNode, int secondNode) {

        // Base case
        if (root == null) {
            return null;
        }

        // Find the current node value
        int currVal = root.data;

        /**
         * If both firstNode and secondNode are smaller than at current node, then call
         * the method recursively for finding LCA in the left subtree
         */
        if (currVal > firstNode && currVal > secondNode) {
            return checkLCA(root.left, firstNode, secondNode);
        }
        /**
         * If both firstNode and secondNode are greater than at current node, then call
         * the method recursively for finding LCA in the right subtree
         */
        if (currVal < firstNode && currVal < secondNode) {
            return checkLCA(root.right, firstNode, secondNode);
        }

        // Returning the lowest common ancestor
        return root;
    }

    /**
     * Method to Insert new nodes in the tree
     * 
     * @param root
     * @param keyData
     */
    private static void insertElements(Node root, int keyData) {

        /**
         * If new node data is less than root then move to the left side of the tree,
         * else move right side of the tree
         */
        if (keyData < root.data) {
            if (root.left != null) {
                insertElements(root.left, keyData);
            } else {
                root.left = lcAinBST.new Node(keyData);
            }
        } else {
            if (root.right != null) {
                insertElements(root.right, keyData);
            } else {
                root.right = lcAinBST.new Node(keyData);
            }
        }
    }
}