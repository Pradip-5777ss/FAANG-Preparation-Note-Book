/**
 * Reverse Linked List Recursively
 * Given a pointer to the head node of a linked list, the task is to reverse the
 * linked list. We need to reverse the list by changing the links between nodes.
 * 
 * Example 1:
 *  Input: 1->2->3->4->NULL
 *  Output: 4->3->2->1->NULL
 * 
 * Example 2:
 *  Input: 1->2->3->4->5->NULL
 *  Output: 5->4->3->2->1->NULL
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 * -----------------------------------
 * @author  Pradip Sahoo
 * @since   08/06/2023
 */
package LinkedList;

import java.util.Scanner;

public class Q05_Reverse_LinkedList_Recursively {

    public class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    static Q05_Reverse_LinkedList_Recursively reverseList = new Q05_Reverse_LinkedList_Recursively();
    static Node headNode;
    static Node tempNode;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the list : ");
        int size = sc.nextInt();

        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < size; i++) {
            int val = sc.nextInt();
            Node hNode = reverseList.new Node(val);
            createNewNode(hNode);
        }

        sc.close();

        System.out.print("The original list is : ");
        printList(headNode);

        Node revRecursive = headNode;
        System.out.print("The recursively reverse list is : ");
        Node revRecursiveAns = reverseListRecursively(revRecursive);
        printList(revRecursiveAns);
    }

    /**
     * This method recursively reverses a linked list.
     * 
     * @param head The head of the linked list.
     * @return The new head of the reversed linked list.
     */
    private static Node reverseListRecursively(Node head) {

        // *Step 1: Set a temporary node to the head of the list
        Node temp = head;

        /**
         ** Step 2: Check if the list is empty or has only one node.
         ** If so, the list is already reversed, so return the head
         */
        if (temp == null || temp.nextNode == null) {
            return temp;
        }

        // * Step 3:Recursively reverse the rest of the list starting from the next node
        Node newHead = reverseListRecursively(temp.nextNode);

        // * Step 4: Reverse the connection between the current node and its next node
        temp.nextNode.nextNode = temp;
        temp.nextNode = null;

        // * Step 5: Return the new head of the reversed list
        return newHead;
    }

    /**
     * This method prints the elements of a linked list.
     * 
     * @param head The head of the linked list to be printed.
     */
    private static void printList(Node head) {

        // Set a temporary node to the head of the list
        tempNode = head;

        // Traverse the list and print each element
        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.nextNode;
        }
        System.out.println("null");
    }

    /**
     * This method adds a new node to the end of a linked list.
     * 
     * @param node The node to be added
     */
    private static void createNewNode(Node node) {

        // If the list is empty, set the new node as the head and return
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Set a temporary node to the head of the list
        tempNode = headNode;

        // Traverse the list until the last node is reached
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }

        // Add the new node as the next node of the last node in the list
        tempNode.nextNode = node;
    }
}