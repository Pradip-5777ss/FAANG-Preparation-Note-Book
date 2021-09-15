/**
 * Write a program to count Nodes in a circular Linked list.
 */
package LinkedList.IntermediateQuestions;

import java.util.Scanner;

public class CountNodesInCircularLL {

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
        CountNodesInCircularLL countNodes = new CountNodesInCircularLL();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = countNodes.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to make a list circular
        headNode = makeCircular(headNode);

        // Method call to print the list
        System.out.print("The list is : ");
        printList(headNode);

        // Method call to count the no. of nodes in the list
        countNode(headNode);
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

    // Method to make a linked list circular
    private static Node makeCircular(Node head) {

        tempNode = head;

        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = head;

        return headNode;
    }

    // Method to count the node in the list
    private static void countNode(Node head) {

        tempNode = head;

        int count = 1;

        while (tempNode.nextNode != head) {
            count++;
            tempNode = tempNode.nextNode;
        }
        System.out.println("The number of nodes are : " + count);
    }

    // Method to print the circular list
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