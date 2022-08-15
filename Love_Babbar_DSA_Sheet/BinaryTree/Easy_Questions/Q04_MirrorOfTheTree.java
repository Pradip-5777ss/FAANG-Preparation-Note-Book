/**
 * @author Pradip Sahoo
 * Created on 15/08/2022
 * ---------------------------
 * Mirror Of a Binary tree.
 * Given a binary tree, create a new binary tree which is a mirror image of the
 * given binary tree.
 * 
 * Example: 
 *  Input:
 *          5
 *         / \
 *        3   6
 *       / \
 *      2   4
 *  Output: Inorder of original tree: 2 3 4 5 6 
 *          Inorder of mirror tree: 6 5 4 3 2
 *          Mirror tree will be:
 *                                  5
 *                                 / \
 *                                6   3
 *                                   / \
 *                                  4   2
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(Height of the tree)
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Easy_Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q04_MirrorOfTheTree {

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
    static Q04_MirrorOfTheTree mirror = new Q04_MirrorOfTheTree();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the Elements of the tree : ");
        String s = sc.nextLine();

        // Method call to build the binary tree
        Node root = buildTree(s);

        // Method call to mirrorify the binary tree
        MirrorTree(root);

        // Print the inorder traversal of the binary tree
        System.out.print("The inorder traversal of the mirror tree is : ");
        inorderTraversal(root);

        sc.close();
    }

    /**
     * Method to print the inorder traversal
     * 
     * @param root
     */
    private static void inorderTraversal(Node root) {

        if (root == null) {
            return;
        }

        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    /**
     * Method to Mirrorify the tree
     * 
     * @param root
     * @return the root of the mirror tree
     */
    private static Node MirrorTree(Node root) {

        if (root == null) {
            return null;
        }

        // Recursively call the method to get the left & right element
        Node left = MirrorTree(root.left);
        Node right = MirrorTree(root.right);

        // Swap the left & right links
        root.left = right;
        root.right = left;

        return root;
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
        Node root = mirror.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = mirror.new Node(Integer.parseInt(currval));
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
                currNode.right = mirror.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}