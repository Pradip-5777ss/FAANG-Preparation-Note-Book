/**
 * Middle of the Linked List.
 * Write a program to find the middle element of a linked list. Given the head of a singly linked list, 
 * return the middle node of the linked list. If there are two middle nodes, return the second middle node.
 * 
 * Example 1:
 *      Input: head = [1,2,3,4,5]
 *      Output: [3,4,5]
 * Explanation: The middle node of the list is node 3.
 * 
 * Example 2:
 *      Input: head = [1,2,3,4,5,6]
 *      Output: [4,5,6]
 * Explanation: Since the list has two middle nodes with values 3 and 4, we return the second one.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LinkedList.EasyQuestions;

import java.util.Scanner;

public class MiddleElementOfLL {

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

        // First time when the list is empty then create the headNode
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Make the headNode as tempNode
        tempNode = headNode;

        // Add other nodes in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }
}
