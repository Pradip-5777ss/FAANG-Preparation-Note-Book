/**
 ** Reverse Linked List
 * Given the head of a singly linked list, reverse the list, and return
 * the reversed list.
 * 
 * Example 1:
 *  Input: head = [1->2->3->4->5]
 *  Output: [5->4->3->2->1]
 * 
 * Example 2:
 *  Input: head = [1->2]
 *  Output: [2->1]
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * ------------------------------------------
 * @author  Pradip Sahoo
 * @since   05/06/2023
 */
package LinkedList;

import java.util.Scanner;

public class Q02_Reverse_LinkedList {

    public class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    static Q02_Reverse_LinkedList reverseList = new Q02_Reverse_LinkedList();
    static Node headNode;
    static Node tempNode;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the list : ");
        int size = sc.nextInt();

        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < size; i++) {
            int val = sc.nextInt();
            Node heaNode = reverseList.new Node(val);
            createNewNode(heaNode);
        }

        sc.close();
        Node revNode = reverseLinkedList(headNode);

        System.out.print("The reverse list is : ");
        printList(revNode);
    }

    /**
     * This method prints the elements of a linked list.
     * 
     * @param head The head of the linked list to be printed.
     */
    private static void printList(Node head) {

        // Set a temporary node to the head of the list
        tempNode = head;

        // Traverse the list and print each element
        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.nextNode;
        }
        System.out.println("null");
    }

    /**
     * This method reverses a linked list by iteratively changing the direction of
     * the links between nodes.
     * 
     * @param head The head of the linked list to be reversed.
     * @return The new head of the reversed linked list.
     */
    private static Node reverseLinkedList(Node head) {

        /**
         ** Step 1: Initialize current node as the head of the list and Initialize
         ** previous node as null
         */
        Node curr = head;
        Node prev = null;

        /**
         ** Step 2: Iterate through the list until the current node becomes null
         */
        while (curr != null) {

            // * Store the reference to the next node
            Node next = curr.nextNode;

            /**
             ** Reverse the direction of the link, make current node point to the previous
             ** node
             */
            curr.nextNode = prev;

            /**
             ** Update the previous node to be the current node, as it will be the previous
             ** node in the next iteration.
             */
            prev = curr;

            // * Move to the next node in the original list, updating the current node.
            curr = next;
        }

        /**
         ** Step 3: Return the new head of the reversed linked list (which is the last
         ** node in the original list).
         */
        return prev;
    }

    /**
     * This method adds a new node to the end of a linked list.
     * 
     * @param node The node to be added
     */
    private static void createNewNode(Node node) {

        // If the list is empty, set the new node as the head and return
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Set a temporary node to the head of the list
        tempNode = headNode;

        // Traverse the list until the last node is reached
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }

        // Add the new node as the next node of the last node in the list
        tempNode.nextNode = node;
    }
}