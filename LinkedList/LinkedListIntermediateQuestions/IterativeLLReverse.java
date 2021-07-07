/**
 * Write a program to reverse a linked list iteratively.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class IterativeLLReverse {

    static Node headNode;
    static Node tempNode;

    class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class to take user input
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

        // Print the general list
        System.out.println("The general list is");
        printList();

        // Method call to reverse the list
        reverseNode();

        System.out.println("The reverse list is");
        printList();
    }

    // Method to add the elements in the link list
    private static void createNewNode(Node node) {

        if (headNode == null) {
            headNode = node;
            return;
        }

        tempNode = headNode;

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

        //  At last prev points to the head node
        headNode = prev;
    }

    // Method to print the linked list
    private static void printList() {
        tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }
}