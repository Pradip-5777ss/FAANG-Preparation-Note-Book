/**
 * @author Pradip Sahoo
 * Created on 22/07/2022
 * ---------------------------
 * Check if a linked list is a circular linked list.
 * Given head, the head of a singly linked list, find if the linked list is
 * circular or not.
 * A linked list is called circular if it not NULL terminated and all nodes are
 * connected in the form of a cycle. An empty linked list is considered as
 * circular.
 * 
 * Example 1:
 *  Input: LinkedList: 1->2->3->4->5
 *  (the first and last node is connected,i.e. 5 --> 1)
 *  Output: 1
 * 
 * Example 2:
 *  Input: LinkedList: 2->4->6->7->5->1
 *  Output: 0
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q09_CheckLLISCircular {

    static Node headNode;
    static Node tempNode;

    // Node class for creating new nodes in Linked List
    class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        Q09_CheckLLISCircular circular = new Q09_CheckLLISCircular();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = circular.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to make a linked list circular
        headNode = makeCircular(headNode);

        // Method call to check the list is circular or not
        boolean ans = isCircular(headNode);

        // Print the output
        System.out.print("output : ");
        if (ans) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    /**
     * Method to create new nodes in the list
     * 
     * @param node
     */
    private static void createNewNode(Node node) {

        // First time when the list is empty then create the headNode
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Make headNode as tempNode
        tempNode = headNode;

        // Add other nodes in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }

    /**
     * Method to make a linked list circular
     * 
     * @param head
     * @return the headnode with circular list
     */
    private static Node makeCircular(Node head) {

        tempNode = head;

        // Traverse through the list to reach the last element
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }

        // At the lastnode's link part put the headNode address and return headNode
        tempNode.nextNode = head;
        return headNode;
    }

    /**
     * Method to check the list is either circular or not
     * 
     * @param head
     * @return true if circular, else false
     */
    private static boolean isCircular(Node head) {

        // An empty linked list is circular
        if (head == null) {
            return true;
        }

        // Make the headnode as tempnode
        tempNode = head;

        /**
         * Run loop until the tempnode is not null, If the lastnode is connected to the
         * head again then the list is circular and return true
         */
        while (tempNode != null) {
            if (tempNode.nextNode == head) {
                return true;
            }
            tempNode = tempNode.nextNode;
        }

        // Either return false
        return false;
    }
}