/**
 * Reverse a Doubly Linked list.
 * Given a doubly linked list of n elements. The task is to reverse the doubly linked list.
 * 
 * Example 1:
 *      Input: LinkedList: 3 <--> 4 <--> 5
 *      Output: 5 4 3
 * 
 * Example 2:
 *      Input: LinkedList: 75 <--> 122 <--> 59 <--> 196
 * Output: 196 59 122 75
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LinkedList.EasyQuestions;

import java.util.Scanner;

public class ReverseDoublyLL {

    static Node headNode;
    static Node tempNode;

    // Node class for creating linked list
    class Node {

        int data;
        Node nextNode;
        Node prevNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
            prevNode = null;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        ReverseDoublyLL rDoublyLL = new ReverseDoublyLL();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = rDoublyLL.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to print the general list
        System.out.print("The general list is : ");
        printList(headNode);

        // Method call to reverse the doubly linked list
        headNode = reverseDll(headNode);

        // Method call to print the reverse linked list
        System.out.print("the reverse list is : ");
        printList(headNode);
    }

    // Method to create new node in the list
    private static void createNewNode(Node node) {

        // First time when the list is empty then create the headNode
        if (headNode == null) {
            headNode = node;
            headNode.prevNode = null;
            return;
        }

        // Make headNode as tempNode
        tempNode = headNode;

        // Add other nodes in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
        node.prevNode = tempNode;
    }

    // Method to reverse the doubly linked list
    private static Node reverseDll(Node head) {

        Node next;
        Node curr = head;
        Node prev = null;

        while (curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            curr.prevNode = next;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Method to print the list
    private static void printList(Node head) {

        tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }
}