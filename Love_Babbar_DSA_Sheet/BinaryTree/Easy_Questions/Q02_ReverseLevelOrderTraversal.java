/**
 * @author Pradip Sahoo
 * Created on 14/08/2022
 * ------------------------------
 * Reverse Level Order Traversal.
 * Given a binary tree of size N, find its reverse level order traversal. ie-
 * the traversal must begin from the last level.
 * 
 * Example 1:
 *  Input:
 *              1
 *            /  \ 
 *           3    2
 *  Output:3 2 1
 * Example 2:
 *  Input:
 *              10
 *            /   \
 *          20    30
 *        /  \
 *      40   60
 *  Output:40 60 20 30 10
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */

package Love_Babbar_DSA_Sheet.BinaryTree.Easy_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Q02_ReverseLevelOrderTraversal {

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
    static Q02_ReverseLevelOrderTraversal reLT = new Q02_ReverseLevelOrderTraversal();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the tree : ");
        String s = sc.nextLine();

        // Method call to build the tree
        Node root = buildTree(s);

        // Method call to perform the reverse level order traversal
        ArrayList<Integer> res = ReverselevelOrder(root);

        // print the Reverse level order traversal of the tree
        System.out.print("The level order traversal of the tree is : ");
        for (Integer num : res) {
            System.out.print(num + " ");
        }
        System.out.println();

        sc.close();
    }

    /**
     * Method to perform the reverse level order traversal
     * 
     * @param root
     * @return the tree with reverse level order traversal
     */
    private static ArrayList<Integer> ReverselevelOrder(Node root) {

        // Declare ArrayList to store the result
        ArrayList<Integer> res = new ArrayList<>();

        // Creating an empty stck & queue for level order traversal
        Stack<Node> s = new Stack<>();
        Queue<Node> q = new LinkedList<>();

        // Add the root of the tree into the queue
        q.add(root);

        while (!q.isEmpty()) {

            // Storing the front element of the queue into the stack & remove it from queue
            Node temp = q.poll();
            s.push(temp);

            // Storing the left child of the parent node in queue
            if (temp.right != null) {
                q.add(temp.right);
            }

            // Storing the right child of the parent in the queue
            if (temp.left != null) {
                q.add(temp.left);
            }
        }

        // Retrieve the element from the stack and store it into the ArrayList
        while (!s.isEmpty()) {
            res.add(s.pop().data);
        }

        // Return the ArrayList
        return res;
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
        Node root = reLT.new Node(Integer.parseInt(ip[0]));

        // // Declare a queue and push the root to the queue
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
                currNode.left = reLT.new Node(Integer.parseInt(currval));
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
                currNode.right = reLT.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}