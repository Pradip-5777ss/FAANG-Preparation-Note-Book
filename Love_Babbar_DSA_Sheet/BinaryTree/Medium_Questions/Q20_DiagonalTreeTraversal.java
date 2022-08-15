/**
 * @author Pradip Sahoo
 * Created on 16/08/2022
 * ------------------------
 * Diagonal Traversal of Binary Tree.
 * Given a Binary Tree, print the diagonal traversal of the binary tree.
 * Consider lines of slope -1 passing between nodes. Given a Binary Tree, print
 * all diagonal elements in a binary tree belonging to same line.
 * 
 * Example:
 *  Input :
 *             8
 *           /   \
 *         3      10
 *       /  \       \
 *      1    6      14
 *          / \    /
 *         4   7  13
 * Output : 8 10 14 3 6 7 13 1 4
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Medium_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q20_DiagonalTreeTraversal {

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

    static Q20_DiagonalTreeTraversal diagonal = new Q20_DiagonalTreeTraversal();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the tree : ");
        String str = sc.nextLine();

        sc.close();

        // Method call to build the tree
        Node root = buildTree(str);

        // Method call to find the diagonal traversal of the tree
        ArrayList<Integer> diagonalNode = diagonal(root);

        // Print the diagonal traversal
        System.out.print("The diagonal traversal of the tree is : ");
        for (Integer res : diagonalNode) {
            System.out.print(res + " ");
        }
        System.out.println();
    }

    /**
     * Method to find the diagonal traversal of a tree
     * 
     * @param root
     * @return a list with diagonally traverse order
     */
    private static ArrayList<Integer> diagonal(Node root) {

        // Declare an ArrayList to store the answer
        ArrayList<Integer> diagonalNodes = new ArrayList<>();

        // Declare a queue to track the nodes of the tree
        Queue<Node> queue = new LinkedList<>();

        // Add the root into queue
        queue.add(root);

        // Run a loop until the queue is not empty
        while (!queue.isEmpty()) {

            // Store the front element of queue in a node
            Node currentNode = queue.remove();

            // If the node is not empty
            while (currentNode != null) {

                // Add that node data into the ArrayList
                diagonalNodes.add(currentNode.data);

                // If any left node is present then add it into the queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // If any right node is present then update the currentNode by it
                currentNode = currentNode.right;
            }
        }

        // Retutn the ArrayList
        return diagonalNodes;
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
        Node root = diagonal.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = diagonal.new Node(Integer.parseInt(currval));
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
                currNode.right = diagonal.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}