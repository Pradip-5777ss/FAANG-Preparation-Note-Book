/**
 * @author Pradip Sahoo
 * Created on 15/08/2022
 * ---------------------------
 * Top View of Binary Tree.
 * Given below is a binary tree. The task is to print the top view of binary
 * tree. Top view of a binary tree is the set of nodes visible when the tree is
 * viewed from the top.
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
package Love_Babbar_DSA_Sheet.BinaryTree.Medium_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

public class Q18_TopViewOfBinaryTree {

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

    // Create a Pair for tracking the horizontal_distance and root
    class Pair {
        Node node;
        int horizontal_distance;

        public Pair(Node node, int horizontal_distance) {
            this.node = node;
            this.horizontal_distance = horizontal_distance;
        }
    }

    // Create object of the class
    static Q18_TopViewOfBinaryTree topView = new Q18_TopViewOfBinaryTree();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of Binary tree : ");
        String str = sc.nextLine();

        sc.close();

        // Method call to build the tree
        Node root = buildTree(str);

        // Method call to print the top view of a binary tree
        ArrayList<Integer> ans = topViewTree(root);

        System.out.print("The top view of the tree is : ");
        for (Integer i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Method to print the top view of binary tree
     * 
     * @param root
     * @return the List of topview elements
     */
    private static ArrayList<Integer> topViewTree(Node root) {

        // Declare an ArrayList to store the answer
        ArrayList<Integer> ans = new ArrayList<>();

        // Declare a queue and a TreeMap for Tracking the elements
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> topviewmap = new TreeMap<>();

        // Base case
        if (root == null) {
            return ans;
        } else {
            // Add the root element to the queue
            queue.add(topView.new Pair(root, 0));
        }

        // Traverse the queue until it is not empty
        while (!queue.isEmpty()) {

            // Remove the top element from the queue and store it into currentNode
            Pair currentNode = queue.poll();

            // Store the root element and keyValue of the particular node
            Node nodeValue = currentNode.node;
            int keyValue = currentNode.horizontal_distance;

            // If the Map does not contain the keyValue then put the current node into map
            if (!topviewmap.containsKey(keyValue)) {
                topviewmap.put(keyValue, nodeValue.data);
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
        for (Entry<Integer, Integer> entry : topviewmap.entrySet()) {
            ans.add(entry.getValue());
        }

        // Return the list
        return ans;
    }

    /**
     * Method to build the binary tree
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