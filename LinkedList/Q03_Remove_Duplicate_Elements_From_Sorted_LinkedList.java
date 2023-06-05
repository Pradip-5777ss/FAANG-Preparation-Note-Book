/**
 * Remove duplicate elements from sorted linkedlist.
 * Given a singly linked list consisting of N nodes. The task is to remove
 * duplicates (nodes with duplicate values) from the given list (if exists).
 * Note: Try not to use extra space. Expected time complexity is O(N). The nodes
 * are arranged in a sorted way.
 * 
 * Example 1:
 *  Input: LinkedList= 2->2->4->5
 *  Output: 2 4 5
 *  Explanation: In the given linked list 2->2->4->5, only 2 occurs more than 1
 *  time.
 * 
 * Example 2:
 *  Input: LinkedList= 2->2->2->2->2
 *  Output: 2
 *  Explanation: In the given linked list 2->2->2->2->2, 2 is the only element
 *  and is repeated 5 times.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * -----------------------------------------------
 * @author  Pradip Sahoo
 * @since   06/06/2023
 */
package LinkedList;

import java.util.Scanner;

public class Q03_Remove_Duplicate_Elements_From_Sorted_LinkedList {

    public class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    static Q03_Remove_Duplicate_Elements_From_Sorted_LinkedList remove_duplicate = new Q03_Remove_Duplicate_Elements_From_Sorted_LinkedList();
    static Node headNode;
    static Node tempNode;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the list : ");
        int size = sc.nextInt();

        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < size; i++) {
            int val = sc.nextInt();
            Node hNode = remove_duplicate.new Node(val);
            createNewNode(hNode);
        }

        sc.close();

        System.out.print("The list is: ");
        printList(headNode);

        System.out.print("The duplicate elements are : ");
        Node newHead = removeDuplicates(headNode);

        System.out.print("After remove duplicate elements the list is : ");
        printList(newHead);
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
     * This method removes duplicates from a sorted linked list.
     * 
     * @param head The head of the linked list.
     * @return The head of the modified linked list without duplicates.
     */
    private static Node removeDuplicates(Node head) {

        // * Set the current node as the head of the list
        Node curr = head;

        // * Iterate through the list until the next node of the current node is null
        while (curr.nextNode != null) {

            // * Check if the data of the current node is equal to the data of the next node
            if (curr.data == curr.nextNode.data) {
                // * Print the duplicate value
                System.out.print(curr.data + " ");
                /**
                 ** Remove the duplicate node by skipping it and linking the current node to the
                 ** next next node
                 */
                curr.nextNode = curr.nextNode.nextNode;
            } else {
                // * If no duplicate is found, move to the next node
                curr = curr.nextNode;
            }
        }
        System.out.println();

        // * Return the head of the modified linked list without duplicates
        return head;
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