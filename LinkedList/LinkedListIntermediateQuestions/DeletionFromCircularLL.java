/**
 * Deletion from a Circular Linked List.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class DeletionFromCircularLL {

    static Node headNode;
    static Node tempNode;
    static Node tailNode;

    public class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
            tailNode = null;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        DeletionFromCircularLL dCircularLL = new DeletionFromCircularLL();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = dCircularLL.new Node(val);
            createNewNode(hNode);
        }

        // Method call to make a list circular
        headNode = makeCircular(headNode);

        // print the circular list
        System.out.println("The circular list is ");
        printList();

        // Ask user to enter the position of the node to be deleted
        System.out.println("Enter the position of the node to delete : ");
        int pos = sc.nextInt();

        sc.close();

        // Method call to delete the node
        headNode = deleteNode(headNode, pos);

        // Method call to print the list after deleting the node
        printList();
    }

    // Method to delete the node
    private static Node deleteNode(Node head, int pos) {

        Node curr = head;
        Node newNext;

        tempNode = head;

        int len = 1;

        if (head == null) {
            System.out.println("The list is empty");
            return null;
        } else {

            // Iterate the whole loop to find the length and lastnode of the loop
            while (tempNode.nextNode != head) {
                len++;
                tempNode = tempNode.nextNode;
            }
        }

        Node lastNode = tempNode;

        // If list has only 1 node
        if (curr == head && curr.nextNode == head) {
            head = null;
            return head;
        }

        // If the user given position is out of range
        if (pos > len || pos <= 0) {
            System.out.println("Index is not found, The list is : ");
            return headNode;
        }

        // when we have to delete the 1st node
        else if (pos == 1) {
            headNode = headNode.nextNode;
            lastNode.nextNode = headNode;
            System.out.print("First node is deleted, ");
            System.out.println("After deleting the element the list is : ");
        }

        // When we have to delete the user specified node
        else {
            for (int i = 1; curr != null && i < pos - 1; i++) {
                curr = curr.nextNode;
            }
            newNext = curr.nextNode.nextNode;
            curr.nextNode = newNext;

            System.out.print("The " + pos + " node data is deleted, ");
            System.out.println("After deleting the element the list is : ");

        }

        return headNode;
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

    // Method to print the list
    private static void printList() {

        tempNode = headNode;

        if (headNode == null) {
            System.out.println("The list is empty");
        } else {
            do {
                System.out.print(tempNode.data + " ");
                tempNode = tempNode.nextNode;
            } while (tempNode != headNode);
        }
        System.out.println();
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