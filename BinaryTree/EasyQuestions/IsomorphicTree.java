/**
 * Check if Tree is Isomorphic.
 * 
 * Given two Binary Trees. Check whether they are Isomorphic or not.
 * 
 * Note: Two trees are called isomorphic if one can be obtained from another 
 * by a series of flips, i.e. by swapping left and right children of several 
 * nodes. Any number of nodes at any level can have their children swapped. 
 * Two empty trees are isomorphic.
 * 
 * Example 1:
 *  Input:
 *      T1    1     T2:   1
 *          /   \        /  \
 *         2     3      3    2
 *        /            /
 *       4            4
 *  Output: No
 * Example 2:
 *  Input:
 *      T1    1     T2:    1
 *          /  \         /   \
 *         2    3       3     2
 *        /                    \
 *        4                     4
 *  Output: Yes
 * 
 * Expected Time Complexity: O(min(M, N)) where M and N are the sizes of the two trees.
 * Expected Auxiliary Space: O(min(H1, H2)) where H1 and H2 are the heights of the two trees.
 */
package BinaryTree.EasyQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class IsomorphicTree {

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

    // Create the object of the class
    static IsomorphicTree isoTree = new IsomorphicTree();

    public static void main(String[] args) {

        // Create scanner object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the elements of the first tree
        System.out.println("Enter the elements of the first tree : ");
        String str1 = sc.nextLine();

        /**
         * Call buildTree method to build the tree and create an Node variable root1 to
         * store the root of the first tree
         */
        Node root1 = buildTree(str1);

        // Ask user to enter the elements of the second tree
        System.out.println("Enter the elements of the second tree : ");
        String str2 = sc.nextLine();

        /**
         * Call buildTree method to build the tree and create an Node variable root2 to
         * store the root of the second tree
         */
        Node root2 = buildTree(str2);

        sc.close();

        // Call a method to check that two trees are isomorthic or not
        if (isIsomorphic(root1, root2) == true) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    // Method to find that two trees are isomorphic or not
    private static boolean isIsomorphic(Node root1, Node root2) {

        /**
         * When the root of the both trees are null that means they are isomorphic each
         * other. So returns true.
         */
        if (root1 == null && root2 == null) {
            return true;
        }

        /**
         * When the root of any tree is null that means they are not isomorphic each
         * other. So returns false.
         */
        if (root1 == null || root2 == null) {
            return false;
        }

        /**
         * When the data of any particular node of two tree is not equal to each other
         * that means they are not isomorphic each other. So returns false.
         */
        if (root1.data != root2.data) {
            return false;
        }

        /**
         * Recursively call the method to find that both the trees are isomorphic or
         * not.
         * This method checks both the left elements of any particular node the tree,
         * both the right elements of any particular node of the tree, left element of
         * first tree and right element of second tree, right element of first tree and
         * second element of first tree.
         */
        return (isIsomorphic(root1.left, root2.left) && isIsomorphic(root1.right, root2.right)
                || isIsomorphic(root1.left, root2.right) && isIsomorphic(root1.right, root2.left));
    }

    // Method to build the tree
    private static Node buildTree(String str) {

        /**
         * If the length of the string is '0' or first character of the string is 'N'
         * then return null
         */
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        // Split the string into an array
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = isoTree.new Node(Integer.parseInt(ip[0]));

        // Declare an queue and enqueue the root of the tree
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Declare an variable 'i' and initialize it with 1
        int i = 1;

        // Run the loop until the condition is not satisfied
        while (queue.size() > 0 && i < ip.length) {

            // Create an Node variable to store the front element of the queue
            Node currNode = queue.peek();

            // Remove the head from the queue
            queue.remove();

            // Get the current node value from the sting
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = isoTree.new Node(Integer.parseInt(currVal));

                // Push it into the queue
                queue.add(currNode.left);
            }

            i++;

            // If the 'i' value is greater than the length of the string then break the loop
            if (i >= ip.length) {
                break;
            }

            // Update the current value for right child
            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = isoTree.new Node(Integer.parseInt(currVal));

                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }

        // Finally return the root of the tree
        return root;
    }
}