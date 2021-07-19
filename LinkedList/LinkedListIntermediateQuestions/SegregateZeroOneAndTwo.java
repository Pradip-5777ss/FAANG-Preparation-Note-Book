/**
 * Given a linked list of 0s, 1s and 2s, sort it.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class SegregateZeroOneAndTwo {

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

    static SegregateZeroOneAndTwo sZeroOneAndTwo = new SegregateZeroOneAndTwo();

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.println("Enter the length of the linked list");
        int length = sc.nextInt();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = sZeroOneAndTwo.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to sort the list of 0s, 1s, 2s
        headNode = segregate(headNode);

        // Method call to print the linked list
        System.out.println("After sorting the list is : ");
        printList(headNode);
    }

    // Method to print the list
    private static void printList(Node head) {

        if (head == null) {
            return;
        }
        tempNode = head;

        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.nextNode;
        }
        System.out.println("null");
    }

    // Method to sort a linked list of 0s, 1s and 2s
    private static Node segregate(Node head) {

        if (head == null || head.nextNode == null) {
            return head;
        }

        // Create dummy nodes to point to the beginning of the linked list
        Node zeroD = sZeroOneAndTwo.new Node(0);
        Node oneD = sZeroOneAndTwo.new Node(0);
        Node twoD = sZeroOneAndTwo.new Node(0);

        // Initialize current pointers for three lists
        Node zero = zeroD, one = oneD, two = twoD;
        Node curr = head;

        // Traversing over the list with a pointer
        while (curr != null) {

            /**
             * We check data at current node and store the node in it's respective list and
             * update the link part of that list
             */
            if (curr.data == 0) {
                zero.nextNode = curr;
                zero = zero.nextNode;
                curr = curr.nextNode;
            } else if (curr.data == 1) {
                one.nextNode = curr;
                one = one.nextNode;
                curr = curr.nextNode;
            } else {
                two.nextNode = curr;
                two = two.nextNode;
                curr = curr.nextNode;
            }
        }

        // Attaching all three lists containing 0s, 1s, 2s respectively
        zero.nextNode = (oneD.nextNode != null) ? (oneD.nextNode) : (twoD.nextNode);
        one.nextNode = twoD.nextNode;
        two.nextNode = null;

        // Updataing the head of the list
        head = zeroD.nextNode;
        return head;

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
