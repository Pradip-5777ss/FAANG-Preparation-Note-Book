/**
 * @author Pradip Sahoo
 * Created on 23/07/2022
 * ---------------------------
 * Write a program to get the “Nth” Node from the end of the Singly Linked List.
 * Given a linked list consisting of L nodes and given a number N. The task is
 * to find the Nth node from the end of the linked list.
 * 
 * Example 1:
 * 	Input : N = 2
 * 			LinkedList: 1->2->3->4->5->6->7->8->9
 * 	Output: 8
 * 	Explanation: In the first example, there are 9 nodes in linked list and we
 * 	need to find 2nd node from end. 2nd node from end os 8.
 * 
 * Example 2:
 * 	Input : N = 5
 * 			LinkedList: 10->5->100->5
 * 	Output: -1
 * 	Explanation: In the second example, there are 4 nodes in the linked list and
 * 	we need to find 5th from the end. Since 'n' is more than the number of nodes
 * 	in the linked list, the output is -1.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q18_GetNthNodeFromEnd {

	static Node headNode;
	static Node tailNode;
	static Node tempNode;

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

		// Create onject of the class
		Q18_GetNthNodeFromEnd list = new Q18_GetNthNodeFromEnd();

		// Ask user to enter the elements of the linked list
		System.out.println("Enter the elements of the Linked list");
		for (int i = 0; i < length; i++) {
			int val = sc.nextInt();
			Node hNode = list.new Node(val);
			createNewNode(hNode);
		}

		// Ask user to enter the nth node position
		System.out.print("Enter the Index of the Nth node : ");
		int index = sc.nextInt();

		// Print the nth node value from end of the linked list
		System.out.print("The value of node " + index + " from last is = " + getNthFromLast(headNode, index));
		sc.close();
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

		// Make the headNode as tempNode
		tempNode = headNode;

		// Add other nodes in the list
		while (tempNode.nextNode != null) {
			tempNode = tempNode.nextNode;
		}
		tempNode.nextNode = node;
	}

	/**
	 * Method to find the data of the nth node from the end of the linked list
	 * 
	 * @param head
	 * @param n
	 * @return the nth node data from last
	 */
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
			currentNode = currentNode.nextNode;
			n--;
		}

		/**
		 * Now traversing both the pointers and when first pointer gives null we got the
		 * nth node from the end in second pointer since the first pointer had already
		 * traversed n nodes and thus had difference of n nodes with second pointer.
		 */
		while (currentNode != null) {
			nthNode = nthNode.nextNode;
			currentNode = currentNode.nextNode;
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