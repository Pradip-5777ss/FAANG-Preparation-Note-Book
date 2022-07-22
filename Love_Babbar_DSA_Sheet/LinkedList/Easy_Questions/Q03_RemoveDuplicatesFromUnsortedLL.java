/**
 * @author Pradip Sahoo
 * Created on 22/07/2022
 * -----------------------------
 * Remove duplicates from an unsorted linked list.
 * Given an unsorted linked list of N nodes. The task is to remove duplicate
 * elements from this unsorted Linked List. When a value appears in multiple
 * nodes, the node which appeared first should be kept, all others duplicates
 * are to be removed.
 * 
 * Example 1:
 *  Input: N = 4
 *         value[] = {5,2,2,4}
 *  Output: 5 2 4
 *  Explanation: Given linked list elements are 5->2->2->4, in which 2 is
 *  repeated only.So, we will delete the extra repeated elements 2 from the
 *  linked list and the resultant linked list will contain 5->2->4
 * 
 * Example 2:
 *  Input: N = 5
 *         value[] = {2,2,2,2,2}
 *  Output: 2
 *  Explanation:Given linked list elements are 2->2->2->2->2, in which 2 is
 *  repeated. So, we will delete the extra repeated elements 2 from the linked
 *  list and the resultant linked list will contain only 2.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.HashSet;
import java.util.Scanner;

public class Q03_RemoveDuplicatesFromUnsortedLL {

    static Node tempNode;
    static Node headNode;

    // Node class for creating new nodes in Linked List
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

        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        Q03_RemoveDuplicatesFromUnsortedLL rInUnsortedLL = new Q03_RemoveDuplicatesFromUnsortedLL();

        System.out.println("Enter the elements of the list ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = rInUnsortedLL.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Print the general list
        System.out.print("The general list is : ");
        printList();

        // Method call to remove the duplicates from an unsorted linked list
        headNode = removeDuplicates(headNode);

        // Print the new list after delete the duplicate elements
        System.out.print("The new list is : ");
        printList();
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

        // Add other elements in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }

    /**
     * Method to remove the duplicates from an unsorted linked list
     * 
     * @param head
     * @return
     */
    private static Node removeDuplicates(Node head) {

        // Using set to store already seen values in list
        HashSet<Integer> hs = new HashSet<>();

        // Using two pointers one of which stores first node and other null
        Node current = head;
        Node prev = null;

        // Traversing over the linked list
        while (current != null) {
            int currVal = current.data;

            /**
             * if data at current node is already present in set, then we skip the current
             * node and store the value of(current->nextNode) in the link of previous node.
             */
            if (hs.contains(currVal)) {
                prev.nextNode = current.nextNode;
                System.out.println("The duplicate element is : " + currVal);

                // deleting current node which contains duplicates.
                current = null;
            }
            /**
             * else we just insert the data at current node in set and update prev to the
             * current node.
             */
            else {
                hs.add(currVal);
                prev = current;
            }

            // Updating current to the next node of prev
            current = prev.nextNode;
        }
        return head;
    }

    // Method to print the list
    private static void printList() {
        tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }
}