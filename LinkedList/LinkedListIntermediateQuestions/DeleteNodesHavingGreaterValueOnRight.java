/**
 * Delete nodes which having greater value on right side.
 * Given a singly linked list, remove all the nodes which have a greater value on its following nodes.
 * 
 * Example:
 *      Input:
 *          LinkedList = 12->15->10->11->5->6->2->3
 *      Output: 15 11 6 3
 * Explanation: Since, 12, 10, 5 and 2 are the elements which have greater elements on the following nodes. 
 * So, after deleting them, the linked list would like be 15,11, 6, 3.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class DeleteNodesHavingGreaterValueOnRight {

    static Node headNode;
    static Node tempNode;

    // Node class for creating linked list
    class Node {

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
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        DeleteNodesHavingGreaterValueOnRight dOnRight = new DeleteNodesHavingGreaterValueOnRight();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = dOnRight.new Node(val);
            createNewNode(hNode);
        }

        sc.close();

        // Method call to print the general list
        System.out.print("The general list is : ");
        printList(headNode);

        // Method call to delete nodes from right
        headNode = deleteNodeFromRight(headNode);

        // Method call to print the final list
        System.out.print("The final list is : ");
        printList(headNode);
    }

    // Method to create new nodes in the list
    private static void createNewNode(Node node) {

        // First time when the list is empty then create the headNode
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Make headNode as tempNode
        tempNode = headNode;

        // Add other nodes in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }

    // Method to delete nodes which have greater value on right
    private static Node deleteNodeFromRight(Node head) {

        // Reverse the list
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }

        head = prev;

        /**
         * Computing and deleting the nodes which have larger nodes on the left
         */
        Node current = head;
        Node maxNode = head;

        while (current != null && current.nextNode != null) {

            /**
             * If this condition is true then we store the next of next value of current in
             * the position of next value of current
             */
            if (current.nextNode.data < maxNode.data) {
                current.nextNode = current.nextNode.nextNode;
            }
            /**
             * else we update the recent current value update the maxNode by recent current
             * value
             */
            else {
                current = current.nextNode;
                maxNode = current;
            }
        }

        // reversing list again to get required result
        curr = head;
        prev = null;

        while (curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Method to print the list
    private static void printList(Node head) {

        if (head == null) {
            System.out.println("No list found");
        }

        while (head != null) {
            System.out.print(head.data + "->");
            head = head.nextNode;
        }
        System.out.println("null");
    }
}