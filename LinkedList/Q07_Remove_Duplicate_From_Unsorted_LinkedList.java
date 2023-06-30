/**
 * Given an unsorted linked list of N nodes. The task is to remove duplicate
 * elements from this unsorted Linked List. When a value appears in multiple
 * nodes, the node which appeared first should be kept, all others duplicates
 * are to be removed.
 * 
 * Example 1:
 *  Input: N = 4, value[] = {5,2,2,4}
 *  Output: 5 2 4
 *  Explanation: Given linked list elements are 5->2->2->4, in which 2 is repeated
 *  only. So, we will delete the extra repeated elements 2 from the linked list
 *  and the resultant linked list will contain 5->2->4
 * 
 * Example 2:
 *  Input: N = 5, value[] = {2,2,2,2,2}
 *  Output: 2
 *  Explanation:Given linked list elements are 2->2->2->2->2, in which 2 is
 *  repeated. So, we will delete the extra repeated elements 2 from the linked
 *  list and the resultant linked list will contain only 2.
 * 
 * Expected Time Complexity: O(N)
 * Expected Auxiliary Space: O(N)
 * ----------------------------------------------
 * @author  Pradip Sahoo
 * @since   30/06/2023
 */
package LinkedList;

import java.util.HashSet;
import java.util.Scanner;

public class Q07_Remove_Duplicate_From_Unsorted_LinkedList {

    public class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    static Q07_Remove_Duplicate_From_Unsorted_LinkedList removeDuplicate = new Q07_Remove_Duplicate_From_Unsorted_LinkedList();
    static Node headNode;
    static Node tempNode;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the List : ");
        int size = sc.nextInt();

        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < size; i++) {
            int val = sc.nextInt();
            Node hNode = removeDuplicate.new Node(val);
            createNewNode(hNode);
        }

        System.out.print("The list is : ");
        printList(headNode);

        sc.close();

        System.out.print("The duplicate element is : ");
        headNode = removeDuplicates(headNode);

        System.out.print("After deletion the list is : ");
        printList(headNode);
    }

    /**
     * This method removes duplicates from an unsorted linked list.
     * 
     * @param head The head of the linked list.
     * @return The head of the updated linked list with duplicates removed.
     */
    private static Node removeDuplicates(Node head) {

        // *Check if the list is empty or has only one node
        if (head == null || head.nextNode == null) {
            return head;
        }

        // *Create a HashSet to store unique values encountered in the linked list.
        HashSet<Integer> hSet = new HashSet<>();

        // *Initialize two pointers, 'current' and 'prev'
        Node current = head;
        Node prev = null;

        // *Iterate through the linked list until the 'current' pointer reaches the end
        while (current != null) {

            // *Get the value of the current node and store it in 'currVal'.
            int currVal = current.data;

            // *Check if 'hSet' already contains the current value, indicating a duplicate
            if (hSet.contains(currVal)) {

                /**
                 * *Update the 'nextNode' of the previous node to skip the current node and
                 * *remove it from the list
                 */
                prev.nextNode = current.nextNode;

                // *Print the value of the duplicate node
                System.out.println(currVal + " ");

                /**
                 * *Set 'current' to null, indicating that the current node has been removed
                 * *from the list
                 */
                current = null;
            } else {
                // *Add the current value to 'hSet' to mark it as encountered
                hSet.add(currVal);

                /**
                 * *Update 'prev' to 'current' as it becomes the previous node for the next
                 * *iteration
                 */
                prev = current;
            }

            // *Move 'current' to the next node
            current = prev.nextNode;
        }

        // *Return the head of the updated linked list
        return head;
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