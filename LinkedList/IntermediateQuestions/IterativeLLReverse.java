/**
 * Reverse Linked List Iteratively.
 * Write a program to reverse a linked list iteratively.
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

public class IterativeLLReverse {

    static Node headNode;
    static Node tempNode;

    // Node class for creating Linked List
    class Node {
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
        System.out.print("Enter the length of the Linked List : ");
        int length = sc.nextInt();

        // Create object of the class
        IterativeLLReverse llReverse = new IterativeLLReverse();

        // Ask user to enter the elements of the linked list
        System.out.println("Enter the elements of the linked list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = llReverse.new Node(val);
            createNewNode(hNode);
        }

        sc.close();

        // Method call to Print the general list
        System.out.print("The general list is : ");
        printList();

        // Method call to reverse the list
        reverseNode();

        // Method call to print the reverse list
        System.out.print("The reverse list is : ");
        printList();
    }

    // Method to create add the new elements in the Linked List
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

    // Method to reverse the linked list
    private static void reverseNode() {

        Node prev = null;
        Node curr = headNode;

        while (curr != null) {
            Node next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }

        // At last prev points to the head node
        headNode = prev;
    }

    // Method to print the linked list
    private static void printList() {
        tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.nextNode;
        }
        System.out.println("null");
    }
}