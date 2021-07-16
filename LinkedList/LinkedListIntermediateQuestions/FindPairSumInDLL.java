/**
 * Write a program to Find pairs with a given sum in a Doubly Linked List.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class FindPairSumInDLL {

    static Node headNode;
    static Node tempNode;

    public class Node {

        int data;
        Node nextNode;
        Node prev;

        public Node(int data) {
            this.data = data;
            nextNode = null;
            prev = null;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        FindPairSumInDLL fPairSumInDLL = new FindPairSumInDLL();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = fPairSumInDLL.new Node(val);
            createNewNode(hNode);
        }

        // Ask user to enter the sum to find pair in the list
        System.out.println("Enter the sum : ");
        int sum = sc.nextInt();

        sc.close();

        // Method call to print the list
        System.out.print("The Doubly list is : ");
        printList();

        // Method call to find the pair sum in a linked list
        System.out.print("The pair sum is : ");
        pairSum(headNode, sum);

    }

    // Method to find the pairsum
    private static void pairSum(Node head, int sum) {

        /**
         * We use two pointer method to find the pair of a given sum. Declare two
         * pointers first and second, both are initialize by head
         */
        Node first = head;
        Node second = head;

        // Set second pointer at the end of the list
        while (second.nextNode != null) {
            second = second.nextNode;
        }

        // Declare a boolean variable to track If we find a pair or not
        boolean found = false;

        // The loop terminates when they cross each other or they become same
        while (first != second && second.nextNode != first) {

            // If Pair found
            if ((first.data + second.data) == sum) {
                found = true;
                System.out.print("(" + first.data + "," + second.data + ")");

                // Move the fast pointer to forward direction
                first = first.nextNode;

                // Move the second pointer to backward direction
                second = second.prev;
            }

            // If pair not found
            else {

                // If the given sum value is greater than the addition of two nodes
                if ((first.data + second.data) < sum) {

                    // Move first pointer to forward direction
                    first = first.nextNode;
                } else {

                    // Move second pointer to backward direction
                    second = second.prev;
                }
            }
        }

        // If pair is not present
        if (found == false) {
            System.out.println("No pair found");
        }
        System.out.println();
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

    // Method to add new element in the list
    private static void createNewNode(Node node) {

        if (headNode == null) {
            headNode = node;
            headNode.prev = null;
            return;
        }

        tempNode = headNode;

        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
        node.prev = tempNode;
    }
}
