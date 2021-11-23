/**
 * Write a program to print the elements in Postorder traversal on both recursive & iteratively.
 */
package BinaryTree.EasyQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class PostorderTreeTraversalRecursiveAndIterative {

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

    // Create the object of the class
    static PostorderTreeTraversalRecursiveAndIterative postIterativeRecursive = new PostorderTreeTraversalRecursiveAndIterative();

    public static void main(String[] args) {

        // Create scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the elements of the tree
        System.out.println("Enter the elements of the tree : ");
        String s = sc.nextLine();

        // Method call to build the tree
        Node root = buildTree(s);

        sc.close();

        // Print the tree in recursive order
        System.out.print("The recursive postorder traversal is : ");
        recursivePostorder(root);

        System.out.println();

        // Print the tree in iterative order
        System.out.print("The iterative postorder traversal is : ");
        iterativePostorder(root);
    }

    // Method to print the tree in iterative order
    private static void iterativePostorder(Node root) {

        // return if the tree is empty
        if (root == null) {
            return;
        }

        // create an empty stack and push the root node
        Stack<Node> stack = new Stack<>();
        stack.push(root);

        // create another stack to store postorder traversal
        Stack<Integer> out = new Stack<>();

        // loop till stack is empty
        while (!stack.empty()) {

            // pop a node from the stack and push the data into the output stack
            Node curr = stack.pop();
            out.push(curr.data);

            // push the left and right child of the popped node into the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (curr.right != null) {
                stack.push(curr.right);
            }
        }

        // print postorder traversal
        while (!out.empty()) {
            System.out.print(out.pop() + " ");
        }
    }

    // Method to print the tree in recursive order
    private static void recursivePostorder(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // Traverse the left subTree
        recursivePostorder(root.left);

        // Traverse the right subtree
        recursivePostorder(root.right);

        // Print the root of the tree
        System.out.print(root.data + " ");
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
        Node root = postIterativeRecursive.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = postIterativeRecursive.new Node(Integer.parseInt(currval));
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
                currNode.right = postIterativeRecursive.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}