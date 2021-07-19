/**
 * Write a program to segregate even and odd nodes in a linked list
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class SegregateEvenAndOddNodesInLL {

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
        SegregateEvenAndOddNodesInLL sEvenAndOdd = new SegregateEvenAndOddNodesInLL();

        // Ask user to enter the elements of the linked list
        System.out.println("Enter the elements of the linked list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = sEvenAndOdd.new Node(val);
            createNewNode(hNode);
        }

        // Method call to print the general list
        System.out.print("The general list is : ");
        printList();

        // Method call to arrange the linked list
        segregateEvenOdd();

        // Method call to print the linked list after arrangement
        System.out.print("After arranging the list is : ");
        printList();
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

    // Method to segregate the list
    private static void segregateEvenOdd() {

        Node evenStart = null;
        Node evenEnd = null;

        Node oddStart = null;
        Node oddEnd = null;

        Node curr = headNode;

        while (curr != null) {

            int element = curr.data;

            if (element % 2 == 0) {
                if (evenStart == null) {
                    evenStart = curr;
                    evenEnd = evenStart;
                } else {
                    evenEnd.nextNode = curr;
                    evenEnd = evenEnd.nextNode;
                }
            } else {
                if (oddStart == null) {
                    oddStart = curr;
                    oddEnd = oddStart;
                } else {
                    oddEnd.nextNode = curr;
                    oddEnd = oddEnd.nextNode;
                }
            }

            // Move the head pointer
            curr = curr.nextNode;
        }

        if (evenStart == null || oddStart == null) {
            return;
        }

        evenEnd.nextNode = oddStart;
        oddEnd.nextNode = null;
        headNode = evenStart;
    }

    // Method to add new elements in the list
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
}