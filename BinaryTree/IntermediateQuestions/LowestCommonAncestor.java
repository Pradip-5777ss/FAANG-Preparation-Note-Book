/**
 * Lowest Common Ancestor in a Binary Tree.
 * 
 * Given a Binary Tree with all unique values and two nodes value, n1 and n2,
 * find the lowest common ancestor (LCA) of two given nodes in the tree.
 * 
 * Example 1:
 *  Input:  n1 = 2 , n2 = 3  
 *            1 
 *           / \ 
 *          2   3
 *  Output: 1
 *  Explanation: LCA of 2 and 3 is 1.
 * 
 * Example 2:
 *  Input:  n1 = 3 , n2 = 4
 *            5    
 *           /    
 *          2  
 *         / \  
 *        3   4
 *  Output: 2
 * Explanation: LCA of 3 and 4 is 2.
 * 
 * Time Complexity:O(N).
 * Auxiliary Space:O(Height of Tree).
 */
package BinaryTree.IntermediateQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class LowestCommonAncestor {

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
    static LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the elements of the tree
        System.out.println("Enter the elements of the tree : ");
        String str = sc.nextLine();

        // Method call to build the tree and store the root
        Node root = buildTree(str);

        // Ask user to enter the two nodes to find the lowest common ancestor
        System.out.println("Enter two nodes to find lowest common ancestor : ");
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        sc.close();

        /**
         * Method call to find the lowest common ancestor of the root and store the
         * answer in a root
         */
        Node ans = findLca(root, n1, n2);

        // Print the result
        if (ans != null) {
            System.out.println("Lca of " + n1 + " and " + n2 + " is : " + ans.data);
        } else {
            System.out.println("The given nodes are not present in the tree");
        }
    }

    // Method to find the Lowest common ancestor of the given root
    private static Node findLca(Node root, int n1, int n2) {

        // If the root is null then return root
        if (root == null) {
            return root;
        }

        /**
         * if either n1 or n2 matches with data at current node, we return root.
         * (Note that if a node is ancestor of other, then the ancestor node
         * becomes the lowest common ancestor).
         */
        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // Calling the findLca method recursively for left and right subtree
        Node leftChild = findLca(root.left, n1, n2);
        Node rightChild = findLca(root.right, n1, n2);

        /**
         * if both of the above calls return non-NULL value then one node
         * is present in one subtree and other is present in another subtree.
         * So, this node is the lowest common ancestor.
         */
        if (leftChild != null && rightChild != null) {
            return root;
        }
        /**
         * else we check if left subtree or right subtree is the
         * lowest common ancestor.
         */
        else {
            return (leftChild != null) ? leftChild : rightChild;
        }
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
        Node root = lowestCommonAncestor.new Node(Integer.parseInt(ip[0]));

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
                currNode.left = lowestCommonAncestor.new Node(Integer.parseInt(currval));
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
                currNode.right = lowestCommonAncestor.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}