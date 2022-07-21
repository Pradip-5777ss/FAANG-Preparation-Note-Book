/**
 * @author Pradip Sahoo
 * Created on 22/07/2022
 * ----------------------------
 * Remove duplicate element from sorted Linked List.
 * Given a singly linked list consisting of N nodes. The task is to remove
 * duplicates (nodes with duplicate values) from the given list (if exists).
 * Note: Try not to use extra space. Expected time complexity is O(N).
 * The nodes are arranged in a sorted way.
 * 
 * Example 1:
 *  Input:
 *      LinkedList: 2->2->4->5
 *  Output: 2 4 5
 *  Explanation: In the given linked list 2 ->2 -> 4-> 5, only 2 occurs more than
 *  1 time.
 * 
 * Example 2:
 *  Input:
 *      LinkedList: 2->2->2->2->2
 *  Output: 2
 *  Explanation: In the given linked list 2 ->2 ->2 ->2 ->2, 2 is the only
 *  element and is repeated 5 times.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q2_RemoveDuplicatesFromSortedLL {

    static Node headNode;
    static Node tempNode;

    // Node class for creating new nodes in Linked List
    public class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        Q2_RemoveDuplicatesFromSortedLL removeDuplicateSortedLL = new Q2_RemoveDuplicatesFromSortedLL();

        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = removeDuplicateSortedLL.new Node(val);
            createNewNode(hNode);
        }

        sc.close();

        // Print the general list
        System.out.print("The general list is : ");
        printList(headNode);

        /**
         * Method call to remove the duplicate element from the list & Print the
         * duplicate elements present in the list
         */
        System.out.print("The duplicate elements are : ");
        headNode = removeDuplicates(headNode);

        // Print the list after removing the duplicate element
        System.out.print("After removing the duplicates the list is : ");
        printList(headNode);
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
     * Method to remove the duplicates from sorted linked list
     * 
     * @param head
     * @return the headNode after removing the duplicates
     */
    private static Node removeDuplicates(Node head) {

        // Using a pointer to iterate over linked list
        Node current = head;

        // Traversing through the linked list
        while (current.nextNode != null) {

            /**
             * If data at current node and next node of current node are same, then remove
             * the link of the node and store the node value(current->next->next) to the
             * next node of current node and link them
             */
            if (current.data == current.nextNode.data) {
                System.out.print(current.data + " ");
                current.nextNode = current.nextNode.nextNode;
            }

            // else we just move the pointer to the next node
            else {
                current = current.nextNode;
            }
        }
        System.out.println();

        return head;
    }

    /**
     * Method to print the list
     * 
     * @param head
     */
    private static void printList(Node head) {

        tempNode = head;

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }
}