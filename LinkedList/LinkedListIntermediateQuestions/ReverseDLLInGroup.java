/**
 * Rotate a Doubly Linked list in group of Given Size.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class ReverseDLLInGroup {

    static Node headNode;
    static Node tempNode;

    public class Node {

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
        System.out.println("Enter the length of the linked list : ");
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
        System.out.println("Enter the size of group");
        int size = sc.nextInt();

        sc.close();

        // Method call to reverse the list in size
        headNode = reverseInGroup(headNode, size);

        // Method call to print the list
        System.out.println("After rotating the array is : ");
        printList();
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

        if (curr != null) {
            head.nextNode = reverseInGroup(curr, size);
        }
        return prev;
    }

    // Method to add new elements of the list
    private static void createNewNode(Node node) {

        if (headNode == null) {
            headNode = node;
            return;
        }

        tempNode = headNode;

        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
        node.prevNode = tempNode;
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
