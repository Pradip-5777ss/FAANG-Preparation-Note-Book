/**
 * Reverse Linked List Recursively.
 * Write a program to reverse a linked list Recursively.
 * 
 * Example:
 *      Input : 1->2->3->4->NULL
 *      Output : 4->3->2->1->NULL
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */
package LinkedList.IntermediateQuestions;

import java.util.Scanner;

public class RecursiveLLReverse {

    static Node headNode;
    static Node tempNode;

    // Node class for creating Linked List
    public class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // create object of the class
        RecursiveLLReverse llReverse = new RecursiveLLReverse();

        // Ask user to enter the elements of list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = llReverse.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Print the general list
        System.out.print("The general list is : ");
        printList();

        // Method call to reverse the list recursively
        headNode = reverseListRecursively(headNode);

        // Print the reverse list
        System.out.print("The reverse list is : ");
        printList();
    }

    // Method to add new element in list
    private static void createNewNode(Node node) {

        // First time when the List is empty then create the headNode
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Make the headNode as tempNode
        tempNode = headNode;

        // Add other nodes in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }

    // Method to reverse the list recursively
    private static Node reverseListRecursively(Node head) {

        // base case
        if (head == null || head.nextNode == null) {
            return head;
        }

        // recursive call
        Node newHead = reverseListRecursively(head.nextNode);

        // Reverse the link
        head.nextNode.nextNode = head;
        head.nextNode = null;

        // Return new head
        return newHead;
    }

    // Method to print the Linked List
    private static void printList() {
        tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.nextNode;
        }
        System.out.println("null");
    }
}