/**
 * @author Pradip Sahoo
 * Created on 18/08/2022
 * -------------------------
 * Boundary Traversal of binary tree.
 * Given a Binary Tree, find its Boundary Traversal. The traversal should be in
 * the following order:
 *  1.  Left boundary nodes: defined as the path from the root to the left-most node
 *      ie- the leaf node you could reach when you always travel preferring the left
 *      subtree over the right subtree.
 *  2.  Leaf nodes: All the leaf nodes except for the ones that are part of left or
 *      right boundary.
 *  3.  Reverse right boundary nodes: defined as the path from the right-most node to
 *      the root. The right-most node is the leaf node you could reach when you
 *      always travel preferring the right subtree over the left subtree. Exclude the
 *      root from this as it was already included in the traversal of left boundary
 *      nodes.
 * Note: If the root doesn't have a left subtree or right subtree, then the root
 * itself is the left or right boundary.
 * 
 * Example 1:
 *  Input:
 *              1
 *             / \
 *           2    3
 *          / \  / \
 *         4  5 6  7
 *           / \
 *          8   9
 * 
 *  Output: 1 2 4 8 9 6 7 3
 * 
 * Example 2:
 *  Input:
 *              1
 *             /
 *            2
 *           / \
 *          4   9
 *         / \   \
 *        6   5   3
 *               / \
 *              7   8
 * Output: 1 2 4 6 5 7 8
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Medium_Questions;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q21_BoundaryTraversalOfTree {

    // Node class for creating the nodes of the tree
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
    static Q21_BoundaryTraversalOfTree boundaryTraversl = new Q21_BoundaryTraversalOfTree();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the tree : ");
        String str = sc.nextLine();

        sc.close();

        // Method call to build the tree
        Node root = buildTree(str);

        // Method call to find the boundary of the tree
        ArrayList<Integer> res = findBoundary(root);

        System.out.print("The boundary elements of the tree is : ");
        for (Integer i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    /**
     * Method to find the boundary of the tree
     * 
     * @param root
     * @return
     */
    private static ArrayList<Integer> findBoundary(Node root) {

        // Declare an ArrayList to store the answer
        ArrayList<Integer> ans = new ArrayList<>();

        // Base case
        if (root != null) {
            ans.add(root.data);
        }

        // Method call for left boundary nodes
        findLeftBoundary(root.left, ans);

        // Method call for left subtree leaf nodes
        findLeafBoundary(root.left, ans);
        // Method call for right subtree leaf nodes
        findLeafBoundary(root.right, ans);

        // Method call for right boundary nodes
        findRightBoundary(root.right, ans);

        return ans;
    }

    /**
     * Method to find the left boundary elements of the tree
     * 
     * @param node
     * @param ans
     */
    private static void findLeftBoundary(Node node, ArrayList<Integer> ans) {

        // Base Case
        if ((node == null) || (node.left == null && node.right == null)) {
            return;
        }

        // Add node in the ArrayList
        ans.add(node.data);

        /**
         * If the left child of root node is present then move to the left child and if
         * left child is not present then move to the right child of root
         */
        if (node.left != null) {
            findLeftBoundary(node.left, ans);
        } else {
            findLeftBoundary(node.right, ans);
        }
    }

    /**
     * Method to find the right boundary of the tree
     * 
     * @param node
     * @param ans
     */
    private static void findRightBoundary(Node node, ArrayList<Integer> ans) {

        // Base case
        if ((node == null) || (node.left == null && node.right == null)) {
            return;
        }

        /**
         * If the right child of root node is present then move to the right child and
         * if the right child is not present then move to the left child of the root
         */
        if (node.right != null) {
            findRightBoundary(node.right, ans);
        } else {
            findRightBoundary(node.left, ans);
        }

        // When it reach the previous node of leaf node then add it into the ArrayList
        ans.add(node.data);
    }

    /**
     * Method to find the leaf nodes of the tree
     * 
     * @param node
     * @param ans
     */
    private static void findLeafBoundary(Node node, ArrayList<Integer> ans) {

        // Base Case
        if (node == null) {
            return;
        }

        // Checks the leaf nodes and add them into the ArrayList
        if (node.left == null && node.right == null) {
            ans.add(node.data);
        }

        // Recursively call the method to find the left subtree leaf nodes
        findLeafBoundary(node.left, ans);

        // Recursively call the method to find the right subtree leaf nodes
        findLeafBoundary(node.right, ans);
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
        Node root = boundaryTraversl.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = boundaryTraversl.new Node(Integer.parseInt(currval));
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
                currNode.right = boundaryTraversl.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}