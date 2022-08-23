/**
 * @author Pradip Sahoo
 * Created on 23/08/2022
 * -------------------------
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
 *  Explanation: LCA of 3 and 4 is 2.
 * 
 * Time Complexity:O(N).
 * Auxiliary Space:O(Height of Tree).
 */
package Love_Babbar_DSA_Sheet.BinaryTree.Medium_Questions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q28_LowestCommonAncestor {

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
    static Q28_LowestCommonAncestor lowestCommonAncestor = new Q28_LowestCommonAncestor();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the elements of the tree : ");
        String str = sc.nextLine();

        // Method call to build the tree and store the root
        Node root = buildTree(str);

        // Ask user to enter the two nodes to find the lowest common ancestor
        System.out.println("Enter two nodes to find lowest common ancestor : ");
        System.out.print("FirstNode : ");
        int firstNode = sc.nextInt();
        System.out.print("SecondNode : ");
        int SecondNode = sc.nextInt();

        sc.close();

        /**
         * Method call to find the lowest common ancestor of the root and store the
         * answer in a root
         */
        Node ans = findLca(root, firstNode, SecondNode);

        // Print the result
        if (ans != null) {
            System.out.println("Lca of " + firstNode + " and " + SecondNode + " is : " + ans.data);
        } else {
            System.out.println("The given nodes are not present in the tree");
        }
    }

    /**
     * Method to find the Lowest common ancestor of the given root
     * 
     * @param root
     * @param firstNode
     * @param secondNode
     * @return the lowest common ancestor of the tree
     */
    private static Node findLca(Node root, int firstNode, int secondNode) {

        /**
         * Base case.
         * If the root is null then return root, if the firstNode or secondNode
         * matches with data at current node, then return root.
         * (Note that if a node is ancestor of other, then the ancestor node
         * becomes the lowest common ancestor).
         */
        if (root == null || root.data == firstNode || root.data == secondNode) {
            return root;
        }

        // Calling the findLca method recursively for left and right subtree
        Node leftChild = findLca(root.left, firstNode, secondNode);
        Node rightChild = findLca(root.right, firstNode, secondNode);

        // If the leftchild returns null then return the rightchild
        if (leftChild == null) {
            return rightChild;
        }
        // If the rightchild returns null then return the leftchild
        else if (rightChild == null) {
            return leftChild;
        }
        /**
         * If both leftchild and rightchild returns null then return root, which is the
         * answer
         */
        else {
            return root;
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