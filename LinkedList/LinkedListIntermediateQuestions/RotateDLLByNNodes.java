/**
 * Rotate Doubly Linked list by N nodes.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class RotateDLLByNNodes {

    static Node headNode;
    static Node tempNode;

    public class Node {

        int data;
        Node nextNode;
        Node prevNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
            prevNode = null;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        RotateDLLByNNodes rNNodes = new RotateDLLByNNodes();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = rNNodes.new Node(val);
            createNewNode(hNode);
        }

        // Ask user to enter the position to rotate the list
        System.out.println("Enter the position of the node to be rotated : ");
        int N = sc.nextInt();

        sc.close();

        // Method call to rotate the list by N nodes
        rotateList(N);

        // Method call to print the new rotated list
        System.out.println("The new rotated list is : ");
        printList();
    }

    // Method to rotate the doubly linked list by N node
    private static void rotateList(int pos) {

        if (pos == 0) {
            return;
        }

        Node curr = headNode;

        int count = 1;

        // current will point to the Nth node
        while (count < pos && curr != null) {
            curr = curr.nextNode;
            count++;
        }

        if (curr == null) {
            return;
        }

        // store the current value as NthNode
        Node NthNode = curr;

        // current will point to last node of the list after this loop
        while (curr.nextNode != null) {
            curr = curr.nextNode;
        }

        // Insert the head value in the next node of lastnode
        curr.nextNode = headNode;

        // Insert the last node value to in previous node of headnode
        headNode.prevNode = curr;

        // change the head node to the next node of NthNode
        headNode = NthNode.nextNode;

        // make new headNode previous node as null
        headNode.prevNode = null;

        // make the next node of NthNode as null which is the current last node
        NthNode.nextNode = null;
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
        node.prevNode = tempNode;
    }

    // Method to print the list
    private static void printList() {

        tempNode = headNode;

        if (headNode == null) {
            System.out.println("List is empty");
            return;
        }

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }
}