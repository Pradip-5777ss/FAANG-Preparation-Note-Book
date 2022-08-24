/**
 * @author Pradip Sahoo
 * Created on 24/08/2022
 * -----------------------------
 * Min distance between two given nodes of a Binary Tree
 * Given a binary tree and two node values your task is to find the minimum
 * distance between them.
 * 
 * Example 1:
 *  Input:
 *           1
 *          / \
 *         2   3
 *  a = 2, b = 3
 *  Output: 2
 *  Explanation: The tree formed is:
 *          1
 *         / \
 *        2   3
 * We need the distance between 2 and 3. Being at node 2, we need to take 
 * two steps ahead in order to reach node 3.
 * The path followed will be: 2 -> 1 -> 3. Hence, the result is 2.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(Height of the tree)
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Medium_Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q29_MinDistanceBetweenTwoNode {

    // Node class for create the nodes of the binary tree
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
    static Q29_MinDistanceBetweenTwoNode minDistance = new Q29_MinDistanceBetweenTwoNode();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the tree : ");
        String str = sc.nextLine();

        // Method call to build the tree and store the root
        Node root = buildTree(str);

        // Ask user to enter the two nodes to find the lowest common ancestor
        System.out.println("Enter two nodes to find distance between them");
        System.out.print("FirstNode : ");
        int firstNode = sc.nextInt();
        System.out.print("SecondNode : ");
        int secondNode = sc.nextInt();

        sc.close();

        // Method call to find the distance between two nodes
        int distance = findDistance(root, firstNode, secondNode);

        System.out.println("The distance between two nodes are : " + distance);
    }

    /**
     * Method to find the distance between two nodes
     * 
     * @param root
     * @param firstNode
     * @param secondNode
     * @return the total distance
     */
    private static int findDistance(Node root, int firstNode, int secondNode) {

        // First find the LCA of two nodes.
        Node lca = findLCA(root, firstNode, secondNode);

        // Find the height of the firstNode from LCA node
        int firstNode_Height = findHeight(lca, firstNode, 0);

        // Find the height of the secondNode from LCA node
        int secondNode_Height = findHeight(lca, secondNode, 0);

        // Add both the height of the node
        return firstNode_Height + secondNode_Height;
    }

    /**
     * Method to find the height of the nodes
     * 
     * @param node
     * @param target
     * @param depth
     * @return
     */
    private static int findHeight(Node node, int target, int depth) {

        // Base case
        if (node.data == target) {
            return depth;
        }

        // Declare two variables
        int left_Height = Integer.MIN_VALUE;
        int right_Height = Integer.MIN_VALUE;

        /**
         * If the left child of a node is not null then recursively call the height
         * method and increment the depth by 1
         */
        if (node.left != null) {
            left_Height = findHeight(node.left, target, depth + 1);
        }

        /**
         * If the right child of a node is not null then recursively call the height
         * method and increment the depth by 1
         */
        if (node.right != null) {
            right_Height = findHeight(node.right, target, depth + 1);
        }

        // Return the maximum between left subtree height and right subtree height
        return Math.max(left_Height, right_Height);
    }

    /**
     * Method to find the LCA of two nodes
     * 
     * @param root
     * @param firstNode
     * @param secondNode
     * @return the LCA
     */
    private static Node findLCA(Node root, int firstNode, int secondNode) {

        /**
         * Base case.
         * If the root is null then return root, if the firstNode or secondNode
         * matches with data at current node, then return root.
         * (Note that if a node is ancestor of other, then the ancestor node
         * becomes the lowest common ancestor).
         */
        if (root == null || root.data == firstNode || root.data == secondNode) {
            return root;
        }

        // Calling the findLca method recursively for left and right subtree
        Node leftChild = findLCA(root.left, firstNode, secondNode);
        Node rightChild = findLCA(root.right, firstNode, secondNode);

        // If the leftchild returns null then return the rightchild
        if (leftChild == null) {
            return rightChild;
        }

        // If the rightchild returns null then return the leftchild
        else if (rightChild == null) {
            return leftChild;
        }

        /**
         * If both leftchild and rightchild returns null then return root, which is the
         * answer
         */
        else {
            return root;
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
        Node root = minDistance.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = minDistance.new Node(Integer.parseInt(currval));
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
                currNode.right = minDistance.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}