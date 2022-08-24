/**
 * @author Pradip Sahoo
 * Create on 14/08/2022
 * ------------------------
 * ZigZag Tree Traversal.
 * Given a Binary Tree. Find the Zig-Zag Level Order Traversal of the Binary Tree.
 * 
 * Example 1:
 *  Input:
 *           3
 *          / \
 *         2   1
 *  Output : 3 1 2
 * 
 * Example 2:
 *  Input:
 *                 7
 *               /  \
 *              9    7
 *            /  \  /   
 *           8   8 6     
 *         /  \
 *        10   9 
 *  Output : 7 7 9 8 8 6 9 10 
 * 
 * Time Complexity: O(N).
 * Auxiliary Space: O(N).
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Easy_Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q10_ZigZagTraversal {

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
    static Q10_ZigZagTraversal zigZag = new Q10_ZigZagTraversal();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the tree : ");
        String str = sc.nextLine();

        sc.close();

        // Method call to build the tree
        Node root = buildTree(str);

        System.out.print("The zig-zag traversal of the tree is : ");

        // Method call to print the tree in zig zag pattern
        zigzagTreeTraversal(root);
    }

    /**
     * Method to print the tree in zig zag pattern
     * 
     * @param root
     */
    private static void zigzagTreeTraversal(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        // Declare two stack
        Stack<Node> currLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        // Push the root into the current level stack
        currLevel.push(root);

        // Declare a boolean variable and initialize it true
        boolean leftToRight = true;

        // If the current level stack is not empty then enter the loop
        while (!currLevel.isEmpty()) {

            // Pop the top element of the stack
            Node node = currLevel.pop();

            // Print the data of the node
            System.out.print(node.data + " ");

            // When the condition is true
            if (leftToRight) {

                /**
                 * If the left node of the tree is not null then push it into the "nextLevel"
                 * stack
                 */
                if (node.left != null) {
                    nextLevel.push(node.left);
                }

                /**
                 * If the right node of the tree is not null then push it into the "nextLevel"
                 * stack
                 */
                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            }

            // When the condition("leftToRight") is false
            else {

                // If the right node is not null then push it into the "nextLevel" stack
                if (node.right != null) {
                    nextLevel.push(node.right);
                }

                // If the left node is not null then push it into the "nextLevel" stack
                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            /**
             * If the "currentLevel" stack is empty then make the boolean value false and
             * create a stack "temp" to swap the elements of the stack from "nextLevel"
             * stack to "currLevel" stack
             */
            if (currLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> temp = currLevel;
                currLevel = nextLevel;
                nextLevel = temp;
            }
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
        Node root = zigZag.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = zigZag.new Node(Integer.parseInt(currval));
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
                currNode.right = zigZag.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}