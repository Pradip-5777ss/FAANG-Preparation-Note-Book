/**
 * Reverse a Doubly Linked list in group of Given Size.
 * Given a doubly linked list containing n nodes. The problem is to reverse every group of k nodes in the list.
 * 
 * Example:
 *      Input : DLL: 1<->2<->4<->5<->6<->8
 *              k = 3
 *      Output : 4<->2<->1<->8<->6<->5
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LinkedList.IntermediateQuestions;

import java.util.Scanner;

public class ReverseDLLInGroup {

    static Node headNode;
    static Node tempNode;

    // Node class for creating linked list
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

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        ReverseDLLInGroup rDllInGroup = new ReverseDLLInGroup();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elemnts of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = rDllInGroup.new Node(val);
            createNewNode(hNode);
        }

        // Ask user to enter the size of the group to reverse DLL
        System.out.print("Enter the size of group : ");
        int size = sc.nextInt();

        sc.close();

        // Method call to reverse the list in size
        headNode = reverseInGroup(headNode, size);

        // Method call to print the list
        System.out.print("After rotating the array is : ");
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

        // Add other nodes in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
        node.prevNode = tempNode;
    }

    // Method to reverse a DLL in group
    private static Node reverseInGroup(Node head, int size) {

        Node curr = head;
        Node prev = null;
        Node next;

        int count = 0;

        while (count < size && curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            curr.prevNode = next;
            prev = curr;
            curr = next;
            count++;
        }

        /**
         * Checking if the reversed LinkedList size is equal to K or not. If it is not
         * equal to k that means we have reversed the last set of size K and we don't
         * need to call the recursive function
         */
        if (count >= size) {
            Node rest = reverseInGroup(curr, size);
            head.nextNode = rest;
            if (rest != null) {
                rest.prevNode = head;
            }
        }
        return prev;
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
