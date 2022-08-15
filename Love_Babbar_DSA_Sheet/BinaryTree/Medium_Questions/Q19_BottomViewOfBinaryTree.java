/**
 * Bottom view of a tree
 * Given a binary tree, print the bottom view from left to right.
 * A node is included in bottom view if it can be seen when we look at the
 * tree from bottom.
 * If there are multiple bottom-most nodes for a horizontal distance from
 * root, then print the later one in level traversal. For example, in the below
 * diagram, 3 and 4 are both the bottommost nodes at horizontal distance 0, we
 * need to print 4.
 * 
 * Example 1:
 *  Input:
 * 				   20
 *               /    \
 *             8       22
 *            / \     /  \
 *           5   3   4   25
 *               /    \      
 *              10    14
 *  Output:5 10 4 14 25.
 * Example 2:
 *  Input:
 *          10
 *        /    \
 *       20    30
 *      /  \
 *     40   60
 *  Output:40 20 60 30
 * 
 * ### Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Medium_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

public class Q19_BottomViewOfBinaryTree {

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
    static Q19_BottomViewOfBinaryTree bottomView = new Q19_BottomViewOfBinaryTree();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the tree : ");
        String str = sc.nextLine();

        sc.close();

        // Call the method to build the tree
        Node root = buildTree(str);

        // Call the method to print the bottom view of the tree
        System.out.print("The bottom view of the tree is : ");
        ArrayList<Integer> ans = bottomTreeView(root);

        for (Integer i : ans) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Method to print the bottom view of the tree
     * 
     * @param root
     * @return the ArrayList with bottom view
     */
    private static ArrayList<Integer> bottomTreeView(Node root) {

        // Declare an ArrayList to store the answer
        ArrayList<Integer> ans = new ArrayList<>();

        // Declare a queue and a TreeMap for Tracking the elements
        Queue<Pair> queue = new LinkedList<>();
        TreeMap<Integer, Integer> bottomviewmap = new TreeMap<>();

        // Base case
        if (root == null) {
            return ans;
        } else {
            // Add the root element to the queue
            queue.add(bottomView.new Pair(root, 0));
        }

        // Traverse the queue until it is not empty
        while (!queue.isEmpty()) {

            // Remove the top element from the queue and store it into currentNode
            Pair currentNode = queue.poll();

            // Store the root element and keyValue of the particular node
            Node nodeValue = currentNode.node;
            int keyValue = currentNode.horizontal_distance;

            // put the current node into map and update values
            bottomviewmap.put(keyValue, nodeValue.data);

            // If the left node of a particular node is not null then add it into the queue
            if (nodeValue.left != null) {
                queue.add(bottomView.new Pair(nodeValue.left, keyValue - 1));
            }

            // If the right node of a particular node is not null then add it into the queue
            if (nodeValue.right != null) {
                queue.add(bottomView.new Pair(nodeValue.right, keyValue + 1));
            }
        }

        // Print the values of the Map
        for (Entry<Integer, Integer> entry : bottomviewmap.entrySet()) {
            ans.add(entry.getValue());
        }

        // Return the list
        return ans;
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
        Node root = bottomView.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = bottomView.new Node(Integer.parseInt(currval));
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
                currNode.right = bottomView.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}