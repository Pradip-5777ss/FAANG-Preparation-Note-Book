/**
 * @author Pradip Sahoo
 * Created on 25/08/2022
 * -----------------------
 * Write a program to print the elements in Preorder traversal on both
 * recursive & iteratively.
 * 
 * Example: 
 *  Input:
 *          5
 *         / \
 *        3   6
 *       / \
 *      2   4
 *  Output: Preorder of original tree: 5 3 2 4 6
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(Height of the tree)
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Easy_Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q06_PreorderTreeTraversalRecusiveAndIterative {

    // Node class for creating the node of the tree
    public class Node {
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
    static Q06_PreorderTreeTraversalRecusiveAndIterative pTraversalRecusiveAndIterative = new Q06_PreorderTreeTraversalRecusiveAndIterative();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the tree : ");
        String s = sc.nextLine();

        // Method call to build the tree
        Node root = buildTree(s);

        sc.close();

        // Print the tree in recursive order
        System.out.print("The recursive preorder traversal is : ");
        recursivePreorder(root);

        System.out.println();

        // Print the tree in iterative order
        System.out.print("The iterative preorder traversal is : ");
        iterativePreorder(root);
    }

    /**
     * Method to find the Preorder traversal in iterative way
     * 
     * @param root
     */
    private static void iterativePreorder(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // create an empty stack and push the root node
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        // start from the root node (set current node to the root node)
        Node curr = root;

        // loop till stack is empty
        while (!stack.empty()) {
            /**
             * if the current node exists, print it and push its right child to the stack
             * before moving to its left child
             */
            if (curr != null) {
                System.out.print(curr.data + " ");

                if (curr.right != null) {
                    stack.push(curr.right);
                }

                curr = curr.left;
            }
            /**
             * if the current node is null, pop a node from the stack set the current node
             * to the popped node
             */
            else {
                curr = stack.pop();
            }
        }
    }

    /**
     * Method to find the Preorder in recursive way
     * 
     * @param root
     */
    private static void recursivePreorder(Node root) {
        // Base case
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        recursivePreorder(root.left);
        recursivePreorder(root.right);
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
        Node root = pTraversalRecusiveAndIterative.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = pTraversalRecusiveAndIterative.new Node(Integer.parseInt(currval));
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
                currNode.right = pTraversalRecusiveAndIterative.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}