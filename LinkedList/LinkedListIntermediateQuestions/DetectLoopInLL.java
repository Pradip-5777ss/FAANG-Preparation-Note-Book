/**
 * Write a program to detect loop in a linked list.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class DetectLoopInLL {

    static Node head;
    static Node temp;
    static Node tail;

    class Node {

        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {

        // Scanner class to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        DetectLoopInLL dLoopInLL = new DetectLoopInLL();

        // Ask user to enter the elements of the linked list
        System.out.println("Enter the elements of the linked list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = dLoopInLL.new Node(val);
            createNewNode(hNode);
        }

        // Ask user to enter the position of the node for create the loop
        System.out.print("Enter the position of the node : ");
        int pos = sc.nextInt();

        // Call the method for make the loop
        makeLoop(head, tail, pos);

        sc.close();

        /**
         * Call the method for detect the loop in the linked list. If the loop is
         * detected then it returns true else false.
         */
        if (detectLoop(head)) {
            System.out.println("Loop detected");
        } else {
            System.out.println("Loop not detected");
        }
    }

    // Method to add elements in the list
    private static void createNewNode(Node node) {

        if (head == null) {
            head = node;
            return;
        }

        temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
        tail = temp.next;
    }

    /**
     * Method to check the loop in the linked list. We use Floyd's cycle finding
     * algorithm
     */
    private static boolean detectLoop(Node head) {

        /**
         * Using two pointer and moving one pointer(slow) by one node and another
         * pointer(fast) by two nodes in each iteration.
         */
        Node fast = head.next;
        Node slow = head;

        while (fast != slow) {

            /**
             * If the node pointed by the first pointer(fast) or the node next to it is
             * null, then it return false
             */
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        /**
         * If the above condition is true, it means both the pointers fast and slow
         * point to the same node. which shows the presence of the loop in the linked
         * list and it returns true.
         */
        return true;
    }

    // Method to create the loop in the linked list
    private static void makeLoop(Node head, Node tail, int pos) {
        if (pos == 0) {
            return;
        }

        temp = head;

        for (int i = 1; i < pos; i++) {
            temp = temp.next;
        }
        tail.next = temp;
    }
}