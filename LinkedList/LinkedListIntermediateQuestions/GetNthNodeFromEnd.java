/**
 * Write a program to get the “Nth” Node from the end of the Singly Linked List.
 */

package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class GetNthNodeFromEnd {

	static Node head;
	static Node tail;
	static Node temp;

	class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}
	}

	public static void main(String[] args) {

		// Scanner class to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the length of the linked list
		System.out.print("Enter the length of the linked list : ");
		int length = sc.nextInt();

		// Create onject of the class
		GetNthNodeFromEnd list = new GetNthNodeFromEnd();

		// Ask user to enter the elements of the linked list
		System.out.println("Enter the elements of the Linked list");

		// Iterate a loop and tak user input
		for (int i = 0; i < length; i++) {
			int val = sc.nextInt();
			Node hNode = list.new Node(val);
			createNewNode(hNode);
		}

		// Ask user to enter the nth node position
		System.out.print("Enter the Index of the Nth node : ");
		int index = sc.nextInt();

		// Print the nth node value from end of the linked list
		System.out.print("The value of node " + index + " from last is = " + getNthFromLast(head, index));
		sc.close();
	}

	// Method to add elements in linked list
	private static void createNewNode(Node node) {

		if (head == null) {
			head = node;
			return;
		}

		temp = head;

		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}

	// Method to find the data of the nth node from the end of the linked list
	public static int getNthFromLast(Node head, int n) {

		/**
		 * Using two pointer method Declare two variable and both are pointing to the
		 * head node
		 */
		Node currentNode = head, nthNode = head;

		// traversing first n elements with first pointer.
		while (n != 0) {
			if (currentNode == null) {
				return -1;
			}
			currentNode = currentNode.next;
			n--;
		}

		/**
		 * Now traversing both the pointers and when first pointer gives null we got the
		 * nth node from the end in second pointer since the first pointer had already
		 * traversed n nodes and thus had difference of n nodes with second pointer.
		 */
		while (currentNode != null) {
			nthNode = nthNode.next;
			currentNode = currentNode.next;
		}

		/**
		 * Returning the data of the nth node from end
		 */
		if (nthNode != null) {
			return nthNode.data;
		} else {
			return -1;
		}
	}
}