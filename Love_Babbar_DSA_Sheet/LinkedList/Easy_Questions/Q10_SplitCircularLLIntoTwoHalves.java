/**
 * @author Pradip Sahoo
 * Created on 23/07/2022
 * ---------------------------
 * Split a circular linked list into two halves.
 * Given a Cirular Linked List of size N, split it into two halves circular
 * lists.
 * If there are odd number of nodes in the given circular linked list then out
 * of the resulting two halved lists, first list should have one node more than
 * the second list.
 * The resultant lists should also be circular lists and not linear lists.
 * 
 * Example 1:
 *  Input: Circular LinkedList: 1->5->7
 *  Output: 1 5
 *          7
 * 
 * Example 2:
 *  Input: Circular LinkedList: 2->6->1->5
 *  Output: 2 6
 *          1 5
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q10_SplitCircularLLIntoTwoHalves {

    static Node tempNode;
    static Node headNode;
    static Node head1, head2;

    // Node class for creating new nodes in linked list
    class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print(" Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        Q10_SplitCircularLLIntoTwoHalves sLlIntoTwoHalves = new Q10_SplitCircularLLIntoTwoHalves();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = sLlIntoTwoHalves.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to make a linked list circular
        headNode = makeCircular(headNode);

        // Method call to split the list into two halves
        splitList(headNode);

        // Method call to print the first circular list
        System.out.print("The first circular list is : ");
        printList(head1);

        // Method call to print the second circular list
        System.out.print("The second circular list is : ");
        printList(head2);
    }

    /**
     * Method to create new nodes in the list
     * 
     * @param node
     */
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

    /**
     * Method to make a linked list circular
     * 
     * @param head
     * @return the head of the circular linked list
     */
    private static Node makeCircular(Node head) {

        tempNode = head;

        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = head;
        return headNode;
    }

    /**
     * Method to split the circular linked list into two halves
     * 
     * @param head
     */
    private static void splitList(Node head) {

        tempNode = head;
        head1 = head;

        // Declare two pointer to find the middle element of the list
        Node slow = head;
        Node fast = head;

        while (fast.nextNode != tempNode && fast.nextNode.nextNode != tempNode) {

            // this pointer moves 1 nodes ahead everytime loop is run
            slow = slow.nextNode;

            // this pointer moves 2 nodes ahead everytime loop is run
            fast = fast.nextNode.nextNode;
        }

        // put the middle element next node as head2
        head2 = slow.nextNode;

        // Initialize the head value in nextNode of slow
        slow.nextNode = head1;

        // Initialize the head2 value as current
        Node curr = head2;

        // Make the second list circular
        while (curr.nextNode != head) {
            curr = curr.nextNode;
        }
        curr.nextNode = head2;
    }

    // Method to print the list
    private static void printList(Node node) {

        tempNode = node;

        if (node != null) {
            do {
                System.out.print(tempNode.data + " ");
                tempNode = tempNode.nextNode;
            } while (tempNode != node);
        }
        System.out.println();
    }
}