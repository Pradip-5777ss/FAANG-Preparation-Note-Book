/**
 * Remove Duplicates in a sorted Linked List.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class RemoveDuplicatesInSortedLL {

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

        // Asl user to enter the size of the linked list
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        RemoveDuplicatesInSortedLL rdLl = new RemoveDuplicatesInSortedLL();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = rdLl.new Node(val);
            createNewNode(hNode);
        }
        
        sc.close();

        // Print the general list
        System.out.print("The general list is : ");
        printList();

        // Print the duplicate elements present in the list
        System.out.print("The duplicate elements are : ");
        headNode = removeDuplicates(headNode);

        // Print the list after removing the duplicate element
        System.out.print("After removing the duplicates the list is : ");
        printList();
    }

    // Method to add elements in the list
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

    // Method to remove the duplicates from sorted linked list
    private static Node removeDuplicates(Node head) {

        // Using a pointer to iterate over linked list
        Node current = head;

        // Traversing through the linked list
        while (current.nextNode != null) {

            /**
             * If data at current node and next node are same, we store the node next to the
             * next node of current node in link of current node
             */
            if (current.data == current.nextNode.data) {
                System.out.print(current.data + " ");
                current.nextNode = current.nextNode.nextNode;
            }

            /**
             * else we just move the pointer to the next node
             */
            else {
                current = current.nextNode;
            }
        }
        System.out.println();

        return head;
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
