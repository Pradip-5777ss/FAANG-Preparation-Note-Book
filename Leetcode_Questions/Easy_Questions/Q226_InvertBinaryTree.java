/**
 * @author Pradip Sahoo
 * Created on 14/07/2022
 * ----------------------------
 * 226. Invert Binary Tree
 * Given the root of a binary tree, invert the tree, and return its root.
 *  
 * Example 1:
 *  Input: root = [4,2,7,1,3,6,9]
 *  Output: [4,7,2,9,6,3,1]
 * 
 * Example 2:
 *  Input: root = [2,1,3]
 *  Output: [2,3,1]
 * 
 * Example 3:
 *  Input: root = []
 *  Output: []
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(Height of the tree)
 */
package Leetcode_Questions.Easy_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q226_InvertBinaryTree {

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

    static Q226_InvertBinaryTree invert = new Q226_InvertBinaryTree();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Elements of the tree : ");
        String s = sc.nextLine();

        Node root = buildTree(s);

        Node result = invertTree(root);

        sc.close();

        ArrayList<Integer> output = levelOrderTraversal(result);

        System.out.print("The inverted tree is : ");
        for (Integer i : output) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Method for level order traversal of the inverted tree
     * 
     * @param root
     * @return the arraylist of level order traversal
     */
    private static ArrayList<Integer> levelOrderTraversal(Node root) {

        // Declare a Arraylist to store the result
        ArrayList<Integer> res = new ArrayList<>();

        // base case
        if (root == null) {
            return res;
        }

        // Creating an empty queue for level order traversal
        Queue<Node> q = new LinkedList<>();

        // Add the root of the tree into the queue
        q.add(root);

        while (!q.isEmpty()) {
            // Storing the front element of the queue in List and removing it from queue
            Node currRoot = q.peek();
            res.add(currRoot.data);
            q.poll();

            // Storing the left child of the parent node in queue
            if (currRoot.left != null) {
                q.add(currRoot.left);
            }

            // Storing the right child of the parent node in queue
            if (currRoot.right != null) {
                q.add(currRoot.right);
            }
        }
        // Return the list
        return res;
    }

    /**
     * Method to invert the tree
     * 
     * @param root
     * @return the root of the tree
     */
    private static Node invertTree(Node root) {

        // If the root is null then return null
        if (root == null) {
            return null;
        }

        // Recursively call the method to store the left and right node of the tree
        Node leftNode = invertTree(root.left);
        Node rightNode = invertTree(root.right);

        // Invert the left and right node
        root.left = rightNode;
        root.right = leftNode;

        // Finally return the root
        return root;
    }

    /**
     * Method for build the tree
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
        Node root = invert.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = invert.new Node(Integer.parseInt(currval));
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
                currNode.right = invert.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}
