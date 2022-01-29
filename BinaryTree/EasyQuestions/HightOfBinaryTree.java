/**
 * Height of Binary Tree.
 * Given a binary tree, find its height.
 * 
 * Example 1:
 *      Input:
 *           1
 *         /  \
 *        2    3
 *      Output: 2
 * Example 2:
 *      Input:
 *           2
 *           \
 *            1
 *           /
 *          3
 *      Output: 3
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package BinaryTree.EasyQuestions;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class HightOfBinaryTree {

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
    static HightOfBinaryTree hight = new HightOfBinaryTree();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Enter the nodes of the tree
        System.out.print("Enter the nodes of the tree : ");
        String s = br.readLine();

        // Method call to build the tree
        Node root = buildTree(s);

        // Method call to print the height of the binary tree
        System.out.println("The height of the tree is : " + heightOfTree(root));
    }

    // Method to find the height of a binary tree.
    private static int heightOfTree(Node root) {

        // if node is null, we return 0.
        if (root == null) {
            return 0;
        }

        /**
         * else we call the recursive function, height for left and right subtree and
         * choose their maximum. we also add 1 to the result which indicates height of
         * root of the tree.
         */
        else {
            return 1 + Math.max(heightOfTree(root.left), heightOfTree(root.right));
        }
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
        Node root = hight.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = hight.new Node(Integer.parseInt(currval));
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
                currNode.right = hight.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}