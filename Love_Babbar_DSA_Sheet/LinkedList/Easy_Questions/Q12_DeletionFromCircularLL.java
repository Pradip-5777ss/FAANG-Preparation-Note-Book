/**
 * @author Pradip Sahoo
 * Created on 23/07/2022
 * ----------------------------
 * Deletion from a Circular Linked List.
 * 
 * Example :
 *  Input : 2->5->7->8->10->(head node)
 *          data = 5
 *  Output : 2->7->8->10->(head node)
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q12_DeletionFromCircularLL {

    static Node headNode;
    static Node tempNode;
    static Node tailNode;

    // Node class for creating new nodes in linked list
    class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
            tailNode = null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        Q12_DeletionFromCircularLL dCircularLL = new Q12_DeletionFromCircularLL();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = dCircularLL.new Node(val);
            createNewNode(hNode);
        }

        // Method call to make a list circular
        headNode = makeCircular(headNode);

        // print the circular list
        System.out.print("The circular list is : ");
        printList();

        // Ask user to enter the position of the node to be deleted
        System.out.print("Enter the position of the node to delete : ");
        int pos = sc.nextInt();

        sc.close();

        // Method call to delete the node
        headNode = deleteNode(headNode, pos);

        // Method call to print the list after deleting the node
        printList();
    }

    // Method to delete the node
    private static Node deleteNode(Node head, int pos) {

        Node curr = head;
        Node newNext;

        tempNode = head;

        int len = 1;

        if (head == null) {
            System.out.println("The list is empty");
            return null;
        } else {

            // Iterate over the list and find the length of the list
            while (tempNode.nextNode != head) {
                len++;
                tempNode = tempNode.nextNode;
            }
        }

        Node lastNode = tempNode;

        // If list has only 1 node
        if (curr == head && curr.nextNode == head) {
            head = null;
            return head;
        }

        // If the user given position is out of range
        if (pos > len || pos <= 0) {
            System.out.println("Index is not found, The list is : ");
            return headNode;
        }

        // when we have to delete the 1st node
        else if (pos == 1) {
            headNode = headNode.nextNode;
            lastNode.nextNode = headNode;
            System.out.print("First node is deleted, After deleting the element the list is : ");
        }

        // When we have to delete the user specified node
        else {
            for (int i = 1; curr != null && i < pos - 1; i++) {
                curr = curr.nextNode;
            }
            newNext = curr.nextNode.nextNode;
            curr.nextNode = newNext;

            System.out.print("The " + pos + " node data is deleted, After deleting the element the list is : ");
        }

        return headNode;
    }

    // Method to make a list circular
    private static Node makeCircular(Node head) {

        tempNode = head;
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = head;

        return headNode;
    }

    // Method to print the list
    private static void printList() {

        tempNode = headNode;

        if (headNode == null) {
            System.out.println("The list is empty");
        } else {
            do {
                System.out.print(tempNode.data + " ");
                tempNode = tempNode.nextNode;
            } while (tempNode != headNode);
        }
        System.out.println();
    }

    // Method to create new node in the list
    private static void createNewNode(Node node) {

        // First time when the list is empty then create new node
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
}