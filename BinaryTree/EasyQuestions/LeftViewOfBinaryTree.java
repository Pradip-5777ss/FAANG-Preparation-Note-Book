/**
 * Left View of Binary Tree.
 * 
 * Given a Binary Tree, print Left view of it. Left view of a Binary Tree is 
 * set of nodes visible when tree is visited from Left side.
 * 
 * Example 1:
 *  Input:
 *          1
 *        /  \
 *       3    2
 *  Output: 1 3
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(Height of the Tree)
 */
package BinaryTree.EasyQuestions;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LeftViewOfBinaryTree {

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

    static LeftViewOfBinaryTree leftView = new LeftViewOfBinaryTree();

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
        System.out.println("The left view of the tree is : ");
        leftViewTree(root);
    }

    // Method to print the left view of binary tree
    private static void leftViewTree(Node root) {

        // base case
        if (root == null) {
            return;
        }

        // create an empty queue and enqueue the root node
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        // to store the current node
        Node curr;

        // loop till queue is empty
        while (!queue.isEmpty()) {

            // calculate the total number of nodes at the current level
            int size = queue.size();

            /**
             * process every node of the current level and enqueue their non-empty left and
             * right child
             */
            for (int i = 1; i <= size; i++) {
                curr = queue.poll();

                // if this is the first node of the current level, print it
                if (i == 1) {
                    System.out.print(curr.data + " ");
                }

                // Move to the left side of the tree
                if (curr.left != null) {
                    queue.add(curr.left);
                }

                // Move to the right side of the tree
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
        Node root = leftView.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = leftView.new Node(Integer.parseInt(currval));
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
                currNode.right = leftView.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}