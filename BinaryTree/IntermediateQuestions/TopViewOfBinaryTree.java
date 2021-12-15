/**
 * Top View of Binary Tree.
 * 
 * Given below is a binary tree. The task is to print the top view of binary tree. Top view of a binary tree is the set of nodes visible when the tree is viewed from the top.
 * 
 * Example 1:
 *  Input:
 *            1
 *         /    \
 *        2      3
 *  Output: 2 1 3
 *  
 * Example 2:
 *  Input:
 *          10
 *       /      \
 *     20        30
 *    /   \    /    \
 *   40   60  90    100
 *  Output: 40 20 10 30 100
 * 
 * Time Complexity: O(N)
 * Auxiliary Space: O(N).
 */
package BinaryTree.IntermediateQuestions;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class TopViewOfBinaryTree {

    // Node class for create the Nodes of the Binary Tree
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

    // Create a Pair for tracking the steps and root
    class Pair {
        Node root;
        int steps;

        public Pair(Node root, int steps) {
            this.root = root;
            this.steps = steps;
        }
    }

    static TopViewOfBinaryTree topView = new TopViewOfBinaryTree();

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the elements of the binary tree
        System.out.println("Enter the elements of Binary tree : ");
        String str = sc.nextLine();

        sc.close();

        // Method call to build the tree
        Node root = buildTree(str);

        // Method call to print the top view of a binary tree
        topViewTree(root);
    }

    // Method to print the top view of binary tree
    private static void topViewTree(Node root) {

        // Declare a queue and a TreeMap for Tracking the elements
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Node> topviewmap = new TreeMap<>();

        // Base case
        if (root == null) {
            return;
        }

        else {
            // Add the root element to the queue
            queue.add(topView.new Pair(root, 0));
        }

        System.out.println("The top view of the tree is ");

        while (!queue.isEmpty()) {

            // Remove the top element from the queue and store it into temp
            Pair temp = queue.poll();

            // Store the root element and keyValue of the particular node
            Node nodeValue = temp.root;
            int keyValue = temp.steps;

            // If the Map does not contain the keyValue then out the current node into the
            // map
            if (!topviewmap.containsKey(keyValue)) {
                topviewmap.put(keyValue, nodeValue);
            }

            // If the left node of a particular node is not null then add it into the queue
            if (nodeValue.left != null) {
                queue.add(topView.new Pair(nodeValue.left, keyValue - 1));
            }

            // If the right node of a particular node is not null then add it into the queue
            if (nodeValue.right != null) {
                queue.add(topView.new Pair(nodeValue.right, keyValue + 1));
            }
        }

        // Print the values of the Map
        for (Map.Entry<Integer, Node> entry : topviewmap.entrySet()) {
            System.out.print(entry.getValue().data + " ");
        }
    }

    // Method to build the binary tree
    private static Node buildTree(String str) {

        // base case
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        // Split the string into an array
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = topView.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = topView.new Node(Integer.parseInt(currval));
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
                currNode.right = topView.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}