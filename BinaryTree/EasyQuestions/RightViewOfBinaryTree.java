/**
 * Right View of Binary Tree.
 * 
 * Given a Binary Tree, find Right view of it. Right view of a Binary Tree 
 * is set of nodes visible when tree is viewed from right side.
 * 
 * Example 1:
 *  Input:
 *             1
 *          /    \
 *         3      2
 *  Output: 1 2
 *  
 * Example 2:
 *  Input:
 *           10
 *          /   \
 *        20     30
 *       /   \
 *      40  60 
 *  Output: 10 30 60
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(Height of the tree)
 */

package BinaryTree.EasyQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RightViewOfBinaryTree {

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

    static RightViewOfBinaryTree rightView = new RightViewOfBinaryTree();

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the elements of the binary tree
        System.out.println("Enter the elements of the binary tree : ");
        String str = sc.nextLine();

        sc.close();

        // Method call to build the binary tree
        Node root = buildTree(str);

        // Method call to print the left view of the tree
        System.out.println("The right view of the tree is : ");
        rightViewTree(root);
    }

    // Method to print the right view of the tree
    private static void rightViewTree(Node root) {

        // base case
        if (root == null) {
            return;
        }

        // Create an empty queue and enque the root node
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // To store the current node
        Node curr;

        // Loop till queue is not empty
        while (!queue.isEmpty()) {

            // calculate the total number of nodes at the current level
            int n = queue.size();

            /**
             * process every node of the current level and enqueue their non-empty left and
             * right child
             */
            for (int i = 1; i <= n; i++) {

                curr = queue.poll();

                // Print the right most element at the level
                if (i == n) {
                    System.out.print(curr.data + " ");
                }

                // Add left node to queue
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                // Add right node to queue
                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
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
        Node root = rightView.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = rightView.new Node(Integer.parseInt(currval));
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
                currNode.right = rightView.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}