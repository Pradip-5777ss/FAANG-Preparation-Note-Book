/**
 * Level order traversal.
 * Given a binary tree, find its level order traversal.
 * 
 * Example 1:
 *      Input:
 *              1
 *            /  \ 
 *           3    2
 *      Output:1 3 2
 * Example 2:
 *      Input:
 *              10
 *            /   \
 *          20    30
 *        /  \
 *      40   60
 *      Output:10 20 30 40 60 N N
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package BinaryTree.EasyQuestions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LevelOrderTraversal {

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
    static LevelOrderTraversal lT = new LevelOrderTraversal();

    public static void main(String[] args) {

        // Create scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the elements of the tree
        System.out.print("Enter the elements of the tree : ");
        String s = sc.nextLine();

        // Method call to build the tree
        Node root = buildTree(s);

        // Method call to perform the level order traversal
        ArrayList<Integer> res = levelOrder(root);

        // print the level order traversal of the tree
        System.out.print("The level order traversal of the tree is : ");
        for (Integer num : res) {
            System.out.print(num + " ");
        }
        System.out.println();

        sc.close();
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
        Node root = lT.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = lT.new Node(Integer.parseInt(currval));
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
                currNode.right = lT.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }

    // Method to perform the level order traversal
    private static ArrayList<Integer> levelOrder(Node root) {

        // Declare a Arraylist to store the result
        ArrayList<Integer> res = new ArrayList<>();

        // base case
        if (root == null) {
            return res;
        }

        // Creating an empty queue for level order traversal
        Queue<Node> q = new LinkedList<>();

        // Add the root of the tree into the queue
        q.add(root);

        while (!q.isEmpty()) {
            // Storing the front element of the queue in List and removing it from queue
            root = q.peek();
            res.add(root.data);
            q.poll();

            // Storing the left child of the parent node in queue
            if (root.left != null) {
                q.add(root.left);
            }

            // Storing the right child of the parent node in queue
            if (root.right != null) {
                q.add(root.right);
            }
        }
        // Return the list
        return res;
    }
}
