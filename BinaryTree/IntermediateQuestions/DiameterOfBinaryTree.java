/**
 * Diameter of Binary Tree.
 * Given a Binary Tree, find diameter of it. The diameter of a tree is the number of nodes on the longest 
 * path between two end nodes in the tree.
 * 
 * Example 1:
 *      Input:
 *             1
 *           /  \
 *          2    3
 *      Output: 3
 * Example 2:
 *      Input:
 *            10
 *          /   \
 *        20    30
 *      /   \ 
 *    40   60
 *      Output: 4
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(Height of tree)
 */
package BinaryTree.IntermediateQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class DiameterOfBinaryTree {

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
    static DiameterOfBinaryTree diameter = new DiameterOfBinaryTree();

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the nodes of the tree
        System.out.println("Enter the No of nodes in a tree : ");
        String s = sc.nextLine();

        sc.close();

        // Method call to build a binary tree
        Node root = buildTree(s);

        // Method call to find the diameter of the binary tree
        int diameter = FindDiameter(root);

        // Print the diameter of the tree
        System.out.println("The diameter is : " + diameter);
    }

    // Method to find the diameter of the tree
    private static int FindDiameter(Node root) {

        // Base case
        if (root == null) {
            return 0;
        }

        // Find the sum of the left & right subtree
        int sum = height(root.left) + height(root.right);

        // Recursive call the method to find the diameter of the tree
        return Math.max(sum + 1, Math.max(FindDiameter(root.left), FindDiameter(root.right)));
    }

    // Method to find the height of the tree
    private static int height(Node root) {
        return (root == null) ? 0 : 1 + Math.max(height(root.left), height(root.right));
    }

    // Method to build the tree
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