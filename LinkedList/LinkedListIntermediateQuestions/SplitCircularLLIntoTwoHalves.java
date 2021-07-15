/**
 * Split a circular linked list into two halves.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class SplitCircularLLIntoTwoHalves {

    static Node tempNode;
    static Node headNode;
    static Node head1, head2;

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

        // Asl user to enter the size of the linked list
        System.out.println(" Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        SplitCircularLLIntoTwoHalves sLlIntoTwoHalves = new SplitCircularLLIntoTwoHalves();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = sLlIntoTwoHalves.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to make a linked list circular
        headNode = makeCircular(headNode);

        // Method call to split the list into two halves
        splitList(headNode);

        // Method call to print the first circular list
        System.out.print("The first circular list is : ");
        printList(head1);

        // Method call to print the second circular list
        System.out.print("The second circular list is : ");
        printList(head2);
    }

    // Method to split the circular linked list into two halves
    private static void splitList(Node head) {

        tempNode = head;
        head1 = head;

        // Declare two pointer to find the middle element of the list
        Node slow = head;
        Node fast = head;

        while (fast.nextNode != tempNode && fast.nextNode.nextNode != tempNode) {

            // this pointer moves 2 nodes ahead everytime loop is run
            slow = slow.nextNode;

            // this pointer moves 1 nodes ahead everytime loop is run
            fast = fast.nextNode.nextNode;
        }

        // put the middle element next node as head2
        head2 = slow.nextNode;

        // Initialize the head value in nextNode of slow
        slow.nextNode = head1;

        // Initialize the head2 value as current
        Node curr = head2;

        // Make the second list circular
        while (curr.nextNode != head) {
            curr = curr.nextNode;
        }
        curr.nextNode = head2;
    }

    // Method to print the list
    private static void printList(Node node) {

        tempNode = node;

        if (node != null) {
            do {
                System.out.print(tempNode.data + " ");
                tempNode = tempNode.nextNode;
            } while (tempNode != node);
        }
        System.out.println();
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
}