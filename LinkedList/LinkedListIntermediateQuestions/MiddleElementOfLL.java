/**
 * Write a program to find the middle element of a linked list.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class MiddleElementOfLL {

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
        MiddleElementOfLL mElementOfLL = new MiddleElementOfLL();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = mElementOfLL.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to find the middle element of the list
        int mid = findMiddleElement(headNode);

        // Print the middle element of the list
        System.out.print("The middle element of the list is : " + mid);
    }

    // Method to find the middle element of the list
    private static int findMiddleElement(Node head) {

        /**
         * We use two pointer method to find the middle element of the list Declare two
         * pointer slow & fast. Initially both are pointing to head
         */
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.nextNode != null) {

            // this pointer moves 2 nodes ahead everytime loop is run
            fast = fast.nextNode.nextNode;

            // this pointer moves 1 nodes ahead everytime loop is run
            slow = slow.nextNode;
        }

        // slow was moving with half speed, it is there at halfway point
        return slow.data;
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
}
