/**
 * Write a program to get the “Nth” Node from the end of the Singly Linked List.
 */

package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

class Node {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		next = null;
	}	
}

public class GetNthNodeFromEnd {

	static Node head;
	static Node tail;

	public static void main(String[] args) {
		
		//	Scanner class to take user input
		Scanner sc = new Scanner(System.in);

		//	Ask user to enter the length of the linked list
		System.out.println("Enter the length of the linked list : ");
		int length = sc.nextInt();

		//	Ask user to enter the elements of the linked list
		System.out.println("Enter the elements of the Linked list");
		
		//	Declare a variable and take the first value of the linked list
		int val = sc.nextInt();

		//	Make this value as the first node of the linked list
		Node head = new Node(val);
		addNodeAtEnd(head);

		//	Iterate a loop and take other values from user
		for (int i = 1; i < length; i++) {
			int val1 = sc.nextInt();
			addNodeAtEnd(new Node(val1));
		}

		//	Ask user to enter the nth node position
		System.out.println("Enter the Index of the Nth node : ");
		int index = sc.nextInt();

		//	Print the nth node value from end of the linked list
		System.out.print("The value of node " + index + " from last is = " + getNthFromLast(head, index));
		sc.close();
	}

	//	Method to add data at the end of the linked list
	public static void addNodeAtEnd(Node node) {
		if (head == null) {
			head = node;
			tail = node;
		} else {
			tail.next = node;
			tail = node;
		}
	}

	//	Method to find the data of the nth node from the end of the linked list
	public static int getNthFromLast(Node head, int n) {

		/**
		 * Using two pointer method
		 * Declare two variable and both are pointing to the head node
		 */	
		Node currentNode = head, nthNode = head;

		/**
		 * First check the index is null or not.
		 * Then check the currentnode is null or not, If it is null then it returns -1.
		 * If both the conditions are true then increment the currentnode value.
		 * And decrement the index value.
		 */
		while (n != 0) {
			if (currentNode == null) {
				return -1;
			}
			currentNode = currentNode.next;
			n--;
		}

		/**
		 * Now traversing both the pointers and when first pointer gives null we got
		 * the nth node from the end in second pointer since the first pointer had 
		 * already traversed n nodes and thus had difference of n nodes with second
		 * pointer.
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