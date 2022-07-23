/**
 * @author Pradip Sahoo
 * Created on 23/07/2022
 * ------------------------------
 * Rotate Doubly Linked list by N nodes.
 * Given a doubly-linked list, rotate the linked list counter-clockwise by N
 * nodes. Here N is a given positive integer and is smaller than the count of
 * nodes in linked list.
 * 
 * Example:
 *  Input : 1<->2<->4<->5<->6<->8<->9
 *          N = 3
 *  Output : 5<->6<->8<->9<->1<->2<->4
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q15_RotateDLLByNNodes {

    static Node headNode;
    static Node tempNode;

    // Node class for creating new nodes in Linked List
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

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        Q15_RotateDLLByNNodes rNNodes = new Q15_RotateDLLByNNodes();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = rNNodes.new Node(val);
            createNewNode(hNode);
        }

        // Ask user to enter the position to rotate the list
        System.out.print("Enter the position of the node to be rotated : ");
        int N = sc.nextInt();

        sc.close();

        // Method call to rotate the list by N nodes
        rotateList(N);

        // Method call to print the new rotated list
        System.out.print("The new rotated list is : ");
        printList();
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
        node.prevNode = tempNode;
    }

    /**
     * Method to rotate the doubly linked list by N node
     * 
     * @param pos
     */
    private static void rotateList(int pos) {

        if (pos == 0) {
            return;
        }

        Node curr = headNode;

        int count = 1;

        // current will point to the Nth node
        while (count < pos && curr != null) {
            curr = curr.nextNode;
            count++;
        }

        if (curr == null) {
            return;
        }

        // store the current value as NthNode
        Node NthNode = curr;

        // current will point to last node of the list after this loop
        while (curr.nextNode != null) {
            curr = curr.nextNode;
        }

        // Insert the head value in the next node of lastnode
        curr.nextNode = headNode;

        // Insert the last node value to in previous node of headnode
        headNode.prevNode = curr;

        // change the head node to the next node of NthNode
        headNode = NthNode.nextNode;

        // make new headNode previous node as null
        headNode.prevNode = null;

        // make the next node of NthNode as null which is the current last node
        NthNode.nextNode = null;
    }

    // Method to print the list
    private static void printList() {

        tempNode = headNode;

        if (headNode == null) {
            System.out.println("List is empty");
            return;
        }

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }
}