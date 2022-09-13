/**
 * @author Pradip Sahoo
 * Created on 13/09/2022
 * -------------------------------
 * Given the root of a binary tree. Check whether it is a BST or not.
 * Note: We are considering that BSTs can not contain duplicate Nodes.
 * A BST is defined as follows:
 *  The left subtree of a node contains only nodes with keys less than the node's
 *  key.
 *  The right subtree of a node contains only nodes with keys greater than the
 *  node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * Example 1:
 *  Input:
 *           2
 *          / \
 *         1   3
 *  Output: 1
 *  Explanation: The left subtree of root node contains node with key lesser than
 *  the root nodes key and the right subtree of root node contains node with key
 *  greater than the root nodes key. Hence, the tree is a BST.
 * Example 2:
 *  Input:
 *          2
 *           \
 *            7
 *             \
 *              6
 *               \
 *                5
 *                 \
 *                  9
 *                   \
 *                    2
 *                     \
 *                      6
 *  Output: 0
 *  Explanation: Since the node with value 7 has right subtree nodes with keys
 *  less than 7, this is not a BST.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(H)
 */
package Love_Babbar_DSA_Sheet.BinarySearchTree.Easy_Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q04_CheckBST {

    // Node class for create new nodes
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
    static Q04_CheckBST isBst = new Q04_CheckBST();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the tree : ");
        String s = sc.nextLine();

        // Method call to build the binary tree
        Node root = buildTree(s);

        sc.close();

        if (checkIsBst(root)) {
            System.out.println("The tree is BST");
        } else {
            System.out.println("The tree is not a BST");
        }
    }

    private static Boolean checkIsBst(Node root) {
        return isBstUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static Boolean isBstUtil(Node root, int minValue, int maxValue) {

        // Base case
        if (root == null) {
            return true;
        }

        // check the min/max constraints for every node recursively
        if (root.data >= minValue || root.data <= maxValue) {
            boolean left = isBstUtil(root.left, minValue, root.data);
            boolean right = isBstUtil(root.right, root.data, maxValue);

            return left && right;
        } else {
            return false;
        }
    }

    /**
     * Method to build the tree
     * 
     * @param str
     * @return the root node of the tree
     */
    private static Node buildTree(String str) {

        // base case
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        // Split the string into an array
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = isBst.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = isBst.new Node(Integer.parseInt(currval));
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
                currNode.right = isBst.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}