/**
 * Write a program to find the length of loop in the linked list.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class LoopLengthInLL {

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

        // Create scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        LoopLengthInLL lInLL = new LoopLengthInLL();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = lInLL.new Node(val);
            createNewNode(hNode);
        }

        // Ask user to enter the position of the node for create the loop
        System.out.print("Enter the position of the node : ");
        int pos = sc.nextInt();

        // Call the method for make the loop
        makeLoop(headNode, tailNode, pos);

        sc.close();

        /**
         * Call the method to count the no. of nodes in the linked list. If the loop is
         * detected then it returns the no. of nodes in loop else 0.
         */
        System.out.println("The length of the loop is = " + countNodeInLoop(headNode));

    }

    // Method to add elements in the loop
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

    /**
     * Method to count the no. of nodes in the loop. We use flody's cycle finding algorithm 
     */ 
    private static int countNodeInLoop(Node head) {

        /**
         * Using two pointer and moving one pointer(slow) by one node and another
         * pointer(fast) by two nodes in each iteration.
         */
        Node slow = head;
        Node fast = head.nextNode;

        while (slow != fast) {

            /**
             * If the node pointed by the first pointer(fast) or the node next to it is
             * null, then it return false
             */
            if (fast == null || fast.nextNode == null) {
                return 0;
            }
            fast = fast.nextNode.nextNode;
            slow = slow.nextNode;
        }

        // both pointers now point to the same node in the loop.
        int count = 1;
        slow = slow.nextNode;

        /**
         * we start iterating the loop with first pointer and continue till both
         * pointers point to same node again.
         */
        while (slow != fast) {
            slow = slow.nextNode;
            count++;
        }

        // Returning the length of the loop
        return count;
    }

    // Method to create loop in the linked list
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
