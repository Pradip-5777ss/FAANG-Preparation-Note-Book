/**
 * Check if a linked list is a circular linked list.
 * Given head, the head of a singly linked list, find if the linked list is circular or not. 
 * A linked list is called circular if it not NULL terminated and all nodes are connected in 
 * the form of a cycle. An empty linked list is considered as circular.
 * 
 * Example 1:
 *      Input: LinkedList: 1->2->3->4->5
 *             (the first and last node is connected,i.e. 5 --> 1)
 *      Output: 1
 * 
 * Example 2:
 *      Input: LinkedList: 2->4->6->7->5->1
 *      Output: 0
 */
package LinkedList.EasyQuestions;

import java.util.Scanner;

public class CheckLLISCircular {

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
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        CheckLLISCircular circular = new CheckLLISCircular();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = circular.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to make a linked list circular
        headNode = makeCircular(headNode);

        // Method call to check the list is circular or not
        boolean c = isCircular(headNode);

        // Print the output
        System.out.println("The output is : ");
        if (c == true) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    // Method to create new node in the list
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

    // Method to make a linked list circulat
    private static Node makeCircular(Node head) {

        tempNode = head;

        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = head;
        return headNode;
    }

    // Method to check the list is circular or not
    private static boolean isCircular(Node head) {

        tempNode = head;

        while (tempNode != null) {
            if (tempNode.nextNode == head) {
                return true;
            }
            tempNode = tempNode.nextNode;
        }

        return false;
    }
}