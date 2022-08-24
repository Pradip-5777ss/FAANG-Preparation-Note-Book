/**
 * @author Pradip Sahoo
 * Created on 25/08/2022
 * --------------------------
 * Check for Balanced Tree
 * Given a binary tree, find if it is height balanced or not.
 * A tree is height balanced if difference between heights of left and right
 * subtrees is not more than one for all nodes of tree.
 * 
 * Example 1:
 *  Input:
 *          1
 *         /
 *        2
 *         \
 *          3
 *  Output: 0
 *  Explanation: The max difference in height of left subtree and right subtree
 *  is 2, which is greater than 1. Hence unbalanced
 * 
 * Example 2:
 *  Input:
 *          10
 *         /  \
 *       20   30
 *      / \
 *    40  60
 *  Output: 1
 *  Explanation: The max difference in height of left subtree and right subtree
 *  is 1. Hence balanced.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Easy_Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q11_CheckBalanceTree {
    // Node class for create the nodes of the tree
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
    static Q11_CheckBalanceTree balanceTree = new Q11_CheckBalanceTree();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the nodes of the tree : ");
        String s = sc.nextLine();

        // Method call to build the tree
        Node root = buildTree(s);

        sc.close();

        if (isBalance(root) > 0) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }

    /**
     * Method to check the binary tree is balanced or not
     * 
     * @param root
     * @return
     */
    private static int isBalance(Node root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Recursively call the method for left subtree
        int lh = isBalance(root.left);

        // If anytime lh is -1 then return -1
        if (lh == -1) {
            return -1;
        }

        // Recursively call the method for right subtree
        int rh = isBalance(root.right);

        // If anytime rh is -1 then return -1
        if (rh == -1) {
            return -1;
        }

        // If anytime the difference of lh and rh is greater than 1 then return -1
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }

        // Else, return the maximum height
        else {
            return Math.max(lh, rh) + 1;
        }
    }

    /**
     * Method to build the tree
     * 
     * @param str
     * @return the root of the tree
     */
    private static Node buildTree(String str) {

        // base case
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        // Split the string into an array
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = balanceTree.new Node(Integer.parseInt(ip[0]));

        // Declare a queue and push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get the front element of the queue and remove it from the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currval = ip[i];

            // If the left child is not null
            if (!currval.equals("N")) {
                // Create the left child for the current node
                currNode.left = balanceTree.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) {
                break;
            }
            currval = ip[i];

            // If the right child is not null
            if (!currval.equals("N")) {

                // Create the right child for the current node
                currNode.right = balanceTree.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}