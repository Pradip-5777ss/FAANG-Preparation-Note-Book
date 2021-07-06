package LinkedList.LinkedListBasicQuestions;

import LinkedList.LinkedListBasicQuestions.SinglyLinkedList.mySll;

public class mainSll {

	public static void main(String[] args) {

		mySll<Integer> ll = new mySll<Integer>();

		ll.createNewNode(1);
		ll.createNewNode(10);
		ll.createNewNode(20);
		ll.createNewNode(30);
		ll.createNewNode(40);

		ll.addNodeAtBegin(120);
		ll.addNodeAtEnd(190);
		ll.addNodeAtEnd(450);
		ll.createNewNode(10);
		ll.addNodeAtBegin(10);

		System.out.print("The linked list is = ");
		ll.print();
		System.out.print("The length of the linked list is = ");
		ll.length();
		System.out.println();
		ll.search(30);

		ll.deleteNode(1);
		System.out.println("The node is deleted");

		System.out.println("After delete the node the linked list is = ");
		ll.print();

		System.out.println("Element of the index 3 is = " + ll.getNth(3));

		System.out.println("The numbers of a specific value is = " + ll.occurence(10));

		ll.findMinMax();
	}
}