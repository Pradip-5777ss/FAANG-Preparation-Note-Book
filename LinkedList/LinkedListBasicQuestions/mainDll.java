package LinkedList.LinkedListBasicQuestions;

import LinkedList.LinkedListBasicQuestions.DoublyLinkedList.myDll;

public class mainDll {

	public static void main(String[] args) {
		
		myDll<Integer> ll = new myDll<Integer>();
		
		ll.createNewNode(10);
		ll.createNewNode(20);
		ll.createNewNode(30);
		ll.createNewNode(40);
		ll.createNewNode(50);
		
		ll.addNodeAtBeginning(5);
		ll.addNodeAtBeginning(20);
		
		ll.addNodeAtAnyPosition(3, 301);
		ll.addNodeAtEnd(55);
		
		System.out.println("The linked list in forward direction is : ");
		ll.printList();
	
		ll.length();
		
		ll.search(90);
		
		ll.deleteNode(6);
		
		System.out.println("The nth element is = "+ll.getNthElement(5));

		System.out.println("The occurence of the number is = "+ll.occurence(20));
		
		ll.findMinMAx();
		
		ll.addNodeAtEnd(120);
		ll.printList();
	}
}
