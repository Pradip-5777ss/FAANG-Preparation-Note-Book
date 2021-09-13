/**
 * Find first node of loop in a linked list.
 * Write a program to find the starting point of the loop in Linked list. Given a linked list of N nodes. 
 * The task is to check if the linked list has a loop then find the first node of loop in the Linked List.
 * 
 * Example 1:
 *      Input:  N = 3
 *              value[] = {1,3,4}
 *              x = 2
 *      Output: True
 * Explanation: In this example N = 3. The linked list with nodes N = 3 is given. Then value
 * of x=2 is given which means last node is connected with xth node of linked list. 
 * Therefore, the first node of the list is 3.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class FindFirstNodeOfLoopInLL {

    static Node headNode;
    static Node tempNode;
    static Node tailNode;

    // Node class for creating Linked List
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

        // Method call for make the loop in the linked list
        makeLoop(headNode, tailNode, pos);

        // Method call to find the first node of loop in linked list
        Node result = detectFirstNodeOfLoop(headNode);

        if (result == null) {
            System.out.println("Loop does not exists");
        } else {
            System.out.println("Loop starting node is : " + result.data);
        }
    }

    // Method to create new node in the list
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
        tailNode = tempNode.nextNode;
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
}