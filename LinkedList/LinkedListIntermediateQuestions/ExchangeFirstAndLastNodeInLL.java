/**
 * Write a program to Exchange first and last nodes in a linked list
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class ExchangeFirstAndLastNodeInLL {

    static Node headNode;
    static Node tempNode;

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
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        ExchangeFirstAndLastNodeInLL fLl = new ExchangeFirstAndLastNodeInLL();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = fLl.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to make a linked list circular
        headNode = makeCircular(headNode);

        // Method call to print the list
        System.out.print("The list is : ");
        printList(headNode);

        // Method call to exchange the first and last node
        headNode = exchangeNodes(headNode);

        // Method call to print the new list after exchange
        System.out.print("The new list is : ");
        printList(headNode);
    }

    // Method to add new element in the list
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

    // Method to make a list circular
    private static Node makeCircular(Node head) {

        tempNode = head;

        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = head;

        return headNode;
    }

    // Method to exchange the nodes of a circular list
    private static Node exchangeNodes(Node head) {

        tempNode = head;

        // If list is of length 2
        if (tempNode.nextNode.nextNode == head) {
            tempNode = tempNode.nextNode;
            return tempNode;
        }

        // Find pointer to previous of last node
        while (tempNode.nextNode.nextNode != head) {
            tempNode = tempNode.nextNode;
        }

        // Exchange first and last nodes using head and temp
        tempNode.nextNode.nextNode = head.nextNode;
        head.nextNode = tempNode.nextNode;
        tempNode.nextNode = head;
        head = head.nextNode;

        // Return the new head;
        return head;
    }

    // Method to print the list
    private static void printList(Node head) {

        tempNode = head;

        if (head != null) {
            do {
                System.out.print(tempNode.data + " ");
                tempNode = tempNode.nextNode;
            } while (tempNode != head);
        }
        System.out.println();
    }
}