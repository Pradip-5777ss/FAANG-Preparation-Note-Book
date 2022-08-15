/**
 * @author Pradip Sahoo
 * Created on 15/08/2022
 * ---------------------------
 * Write a program to print the elements in inorder traversal on both
 * recursive & iteratively.
 * 
 * Example: 
 *  Input:
 *          5
 *         / \
 *        3   6
 *       / \
 *      2   4
 *  Output: Inorder of original tree: 2 3 4 5 6 
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(Height of the tree)
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Easy_Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q05_InorderTreeTraversalRecursiveAndIterative {

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
    static Q05_InorderTreeTraversalRecursiveAndIterative recursiveAndIterative = new Q05_InorderTreeTraversalRecursiveAndIterative();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the tree : ");
        String s = sc.nextLine();

        // Method call to build the tree
        Node root = buildTree(s);

        sc.close();

        // Print the tree in recursive order
        System.out.print("The recursive inorder traversal is : ");
        recursiveInorder(root);

        System.out.println();

        // Print the tree in iterative order
        System.out.print("The iterative inorder traversal is : ");
        iterativeInorder(root);
    }

    // Method to print the tree in iterative order
    private static void iterativeInorder(Node root) {

        // Use a stack
        Stack<Node> stack = new Stack<>();

        // Take a node to store the root of the tree
        Node curr = root;

        /**
         * If the stack is not empty or the current element is not null then entered the
         * loop.
         * 
         * If the current element is not null then push the element into the stack &
         * move the current element of the tree to the left child.
         * 
         * else, we pop the top element from the stack and print the data & move the
         * current node to the right child.
         */
        while (!stack.empty() || curr != null) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                curr = stack.pop();
                System.out.print(curr.data + " ");
                curr = curr.right;
            }
        }
    }

    // Method to recursively print the stack
    private static void recursiveInorder(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        recursiveInorder(root.left);
        System.out.print(root.data + " ");
        recursiveInorder(root.right);
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
        Node root = recursiveAndIterative.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = recursiveAndIterative.new Node(Integer.parseInt(currval));
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
                currNode.right = recursiveAndIterative.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}