/**
 * @author Pradip Sahoo
 * Created on 24/08/2022
 * -----------------------
 * Binary Tree to DLL.
 * Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL) In-Place.
 * The left and right pointers in nodes are to be used as previous and next
 * pointers respectively in converted DLL. The order of nodes in DLL must be
 * same as Inorder of the given Binary Tree. The first node of Inorder traversal
 * (leftmost node in BT) must be the head node of the DLL.
 * 
 * Example 1:
 *  Input:
 *           1
 *         /  \
 *        3    2
 *  Output:
 *          3 1 2 
 *          2 1 3 
 *  Explanation: DLL would be 3<=>1<=>2
 * 
 * Example 2:
 *  Input:
 *            10
 *           /   \
 *          20   30
 *        /   \
 *       40   60
 *  Output:
 *          40 20 60 10 30 
 *          30 10 60 20 40
 *  Explanation: DLL would be 40<=>20<=>60<=>10<=>30.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(Height of Tree)
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Hard_Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q32_ConvertBinaryTreeToDLL {
    // Node class for create the nodes of the binary tree
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
    static Q32_ConvertBinaryTreeToDLL bTreeToDLL = new Q32_ConvertBinaryTreeToDLL();
    static Node head = null, prev = null;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the nodes of the tree : ");
        String s = sc.nextLine();

        // Method call to build the tree
        Node root = buildTree(s);

        sc.close();

        // Method to convert the binary tree to doubly linked list
        Node ans = convert_bTreeToDll(root);

        // Method to print the list in inorder traversal
        printList(ans);
    }

    /**
     * Method to print the list in inorder traversal
     * 
     * @param node
     */
    public static void printList(Node node) {

        // Copy the node into another node
        Node prev = node;

        // Traverse the node until its not null. It print the list from front
        System.out.print("Elements from front : ");
        while (node != null) {
            // Print the current node data
            System.out.print(node.data + " ");
            // update the node pointer also
            prev = node;
            // Move all the node elements to right
            node = node.right;
        }

        System.out.println();

        // Traverse the prev until its not null, It print the list from back
        System.out.print("Elements from back : ");
        while (prev != null) {
            // Print the current node data
            System.out.print(prev.data + " ");
            // Move all the node elements to left
            prev = prev.left;
        }
    }

    /**
     * Method to convert the binary tree to Doubly Linked list
     * 
     * @param root
     * @return the tree with DLL representation
     */
    private static Node convert_bTreeToDll(Node root) {

        // Base case
        if (root == null) {
            return null;
        }

        // Recursively call the method for left subtree
        convert_bTreeToDll(root.left);

        // Initially prev is null so set the root element as head
        if (prev == null) {
            head = root;
        }
        // Chain the elements
        else {
            root.left = prev;
            prev.right = root;
        }
        // Update the previous element with current root
        prev = root;
        // Recursively call the method for right subtree
        convert_bTreeToDll(root.right);

        // Finally return the head with DLL representation
        return head;
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
        Node root = bTreeToDLL.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = bTreeToDLL.new Node(Integer.parseInt(currval));
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
                currNode.right = bTreeToDLL.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}