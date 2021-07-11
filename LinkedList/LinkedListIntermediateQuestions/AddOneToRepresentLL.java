/**
 * Add “1” to a number represented as a Linked List.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class AddOneToRepresentLL {

    static Node tempNode;
    static Node headNode;

    public class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    static AddOneToRepresentLL aLl = new AddOneToRepresentLL();

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Asl user to enter the size of the linked list
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = aLl.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to add one with the list
        headNode = addOne(headNode);

        // Method call to print the list
        System.out.println("The list is : ");
        printList();
    }

    // Method to add new elements in list
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

    // Method to add one with the list
    private static Node addOne(Node head) {

        // Reverse the list to make addition easy
        head = reverse(head);

        // Initialize the head node value in temp
        tempNode = head;

        // Declare a variable & initialize it by 1
        int carry = 1;

        while (carry != 0) {

            // Adding one to current node
            tempNode.data++;

            /**
             * If this condition is true, it means no carry present in the list. so, we can
             * reverse back the list and return it
             */
            if (tempNode.data < 10) {
                return reverse(head);
            }
            /**
             * else, we continue tracking carry for forward. Make the tempnode data as null.
             */
            else {
                tempNode.data = 0;
            }

            // If end of list, we break loop
            if (tempNode.nextNode == null) {
                break;
            }
            /**
             * else, we move to the next node
             */
            else {
                tempNode = tempNode.nextNode;
            }
        }

        // Adding new node for carried 1
        tempNode.nextNode = aLl.new Node(1);
        return reverse(head);
    }

    // Method to reverse the list
    private static Node reverse(Node head) {

        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // Method to print the list
    private static void printList() {
        tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }
}