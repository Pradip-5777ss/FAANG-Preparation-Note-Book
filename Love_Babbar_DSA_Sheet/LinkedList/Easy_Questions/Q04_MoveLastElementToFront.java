/**
 * @author Pradip Sahoo
 * Created on 22/07/2022
 * --------------------------
 * Move last element to front of a Linked List.
 * Write a Program to Move the last element to Front in a singly Linked List.
 * 
 * Example:
 *  Input: N = 5
 *         List : 1->2->3->4->5
 *  Output: 5->1->2->3->4
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q04_MoveLastElementToFront {

    static Node tempNode;
    static Node headNode;

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
        Q04_MoveLastElementToFront mFront = new Q04_MoveLastElementToFront();

        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = mFront.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to print the general list
        System.out.print("The general list is : ");
        printList();

        // Method call to move the last element to front
        moveToFirst(headNode);

        // Method call to print the final list after moving
        System.out.print("After moving the last element to front the final list is : ");
        printList();
    }

    /**
     * Method to create new node in the list
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

    // Method to move the last element to front of the list
    private static void moveToFirst(Node head) {

        /**
         * If linked list is empty or it contains only one node then simply return.
         */
        if (head == null || head.nextNode == null) {
            return;
        }

        // Initialize secondLast and last pointer
        Node second_last = null;
        Node last = headNode;

        /**
         * Iterate this loop in the whole list. After this loop second_last points to
         * the second last element of the list and the last points to the last node of
         * the list.
         */
        while (last.nextNode != null) {
            second_last = last;
            last = last.nextNode;
        }

        /**
         * Set the next node of second last node is null. This break the link of the
         * last node
         */
        second_last.nextNode = null;

        // now, set the next of last as headnode
        last.nextNode = head;

        // Make the last node as headnode
        headNode = last;
    }

    // Method to print the list
    private static void printList() {
        tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }
}