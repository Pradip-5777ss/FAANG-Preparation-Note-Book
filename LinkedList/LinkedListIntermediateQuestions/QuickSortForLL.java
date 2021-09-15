/**
 * QuickSort on Linked list.
 * Write a program to Sort the given Linked List using quicksort.
 * 
 * Example 1:
 *      Input:  N = 5
 *              value[]  = {3,5,2,4,1}
 *      Output: 1 2 3 4 5
 * Explanation: After sorting the given linked list, the resultant will be 1->2->3->4->5.
 * 
 * Example 2:
 *      Input:  N = 3
 *              value[]  = {9,15,0}
 *      Output: 0 9 15
 * Explanation: After sorting the given linked list, resultant will be 0->9->15.
 * 
 * Time Complexity : O(nLogn)
 * Space Complexity : O(n)
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class QuickSortForLL {

    static Node tempNode;
    static Node headNode;
    static Node tailNode;

    // Node class for creating Linked list
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

        // Ask user to enter the size of the linked list
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        QuickSortForLL qSortForLL = new QuickSortForLL();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = qSortForLL.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        // Method call to print the general list
        System.out.print("The general List is : ");
        printList();

        // Method call to sort the list
        sort(headNode, tailNode);

        // Method call to print the sorted list
        System.out.print("The sorted list is : ");
        printList();
    }

    // Method to create new nodes in the list
    private static void createNewNode(Node node) {

        // First time when the list is empty then create headNode
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
        tailNode = tempNode.nextNode;
    }

    private static void sort(Node head, Node tail) {
        if (head == tail || tail == null || head == null) {
            return;
        }

        Node pivot = partition(head, tail);

        sort(head, pivot);
        sort(pivot.nextNode, tail);
    }

    private static Node partition(Node head, Node tail) {

        Node prev = head;
        Node curr = head.nextNode;
        Node pivot = head;

        while (curr != tail.nextNode) {
            if (curr.data < pivot.data) {

                int data = prev.nextNode.data;
                prev.nextNode.data = curr.data;
                curr.data = data;

                prev = prev.nextNode;
            }
            curr = curr.nextNode;
        }

        int data = pivot.data;
        pivot.data = prev.data;
        prev.data = data;

        return prev;
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