/**
 * @author Pradip Sahoo
 * Created on 14/08/2022
 * -------------------------
 * Diameter of Binary Tree.
 * Given a Binary Tree, find diameter of it. The diameter of a tree is the
 * number of nodes on the longest path between two end nodes in the tree.
 * 
 * Example 1:
 *  Input:
 *             1
 *           /  \
 *          2    3
 *  Output: 3
 * Example 2:
 *  Input:
 *            10
 *          /   \
 *        20    30
 *      /   \ 
 *    40   60
 *  Output: 4
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(Height of tree)
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Easy_Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q03_DiameterOfBinaryTree {

    // Node class for create the Nodes of the tree
    class Node {

        int data;
        Node right;
        Node left;

        public Node(int data) {
            this.data = data;
            right = null;
            left = null;
        }
    }

    // Create object of the class
    static Q03_DiameterOfBinaryTree diameter = new Q03_DiameterOfBinaryTree();
    static int dia = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the tree : ");
        String s = sc.nextLine();

        sc.close();

        // Method call to build a binary tree
        Node root = buildTree(s);

        // Method call to find the diameter of the binary tree
        int diameter = FindDiameter(root);

        // Print the diameter of the tree
        System.out.println("The diameter is : " + diameter);
    }

    /**
     * Method to find the diameter of the tree
     * 
     * @param root
     * @return the diameter of the a tree
     */
    private static int FindDiameter(Node root) {

        // Method call to find the height of the binary tree
        height(root);

        // Return the diameter of the tree
        return dia;
    }

    /**
     * Method to find the height of the tree
     * 
     * @param root
     * @return the height
     */
    private static int height(Node root) {

        // Base case
        if (root == null) {
            return 0;
        }

        /**
         * Calling the height function recursively to find the height of left and right
         * subtree
         */
        int lh = height(root.left);
        int rh = height(root.right);

        // Storing the maximum possible value of lh+rh+1 in diameter
        if (lh + rh + 1 > dia) {
            dia = lh + rh + 1;
        }

        // Return the height of subtree
        return 1 + Math.max(lh, rh);
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
        Node root = diameter.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = diameter.new Node(Integer.parseInt(currval));
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
                currNode.right = diameter.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}