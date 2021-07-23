/**
 * Write a program to find the starting point of the loop in Linked list.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class FindFirstNodeOfLoopInLL {

    static Node headNode;
    static Node tempNode;
    static Node tailNode;

    public class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {

        // Scanner class to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        FindFirstNodeOfLoopInLL fFirstNode = new FindFirstNodeOfLoopInLL();

        // Ask user to enter the elements of the linked list
        System.out.println("Enter the elements of the linked list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = fFirstNode.new Node(val);
            createNewNode(hNode);
        }

        // Ask user to enter the position of the node for create the loop
        System.out.print("Enter the position of the node : ");
        int pos = sc.nextInt();

        sc.close();

        // Call the method for make the loop
        makeLoop(headNode, tailNode, pos);

        // Method call to find the first node of loop in linked list
        Node result = detectFirstNodeOfLoop(headNode);

        if (result == null) {
            System.out.println("Loop does not exists");
        } else {
            System.out.println("Loop starting node is : " + result.data);
        }
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
        tailNode = tempNode.nextNode;
    }

    // Method to find the first node of loop in a linked list
    private static Node detectFirstNodeOfLoop(Node head) {

        /**
         * If list is empty or has one node without loop
         */
        if (head == null || head.nextNode == null) {
            return null;
        }

        // Using two pointer method
        Node slow = head;
        Node fast = head;

        // Search loop using first and slow pointer
        while (fast != null && fast.nextNode != null) {

            // slow pointer moves 1 nodes ahead everytime
            slow = slow.nextNode;

            // fast pointer moves 2 nodes ahead everytime
            fast = fast.nextNode.nextNode;

            // If condition true then break the loop
            if (slow == fast) {
                break;
            }
        }

        // If loop does not exists
        if (slow != fast) {
            return null;
        }

        // If loop exists then start slow from head & fast from meeting point
        slow = head;

        // Run the loop until slow and fast are not same
        while (slow != fast) {
            slow = slow.nextNode;
            fast = fast.nextNode;
        }
        return slow;
    }

    // Method to create the loop in the linked list
    private static void makeLoop(Node head, Node tail, int pos) {
        if (pos == 0) {
            return;
        }

        tempNode = head;

        for (int i = 1; i < pos; i++) {
            tempNode = tempNode.nextNode;
        }
        tail.nextNode = tempNode;
    }
}