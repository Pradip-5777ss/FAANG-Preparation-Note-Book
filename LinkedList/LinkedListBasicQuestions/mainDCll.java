package LinkedList.LinkedListBasicQuestions;

import LinkedList.LinkedListBasicQuestions.DoublyCircularLinkedList.myDCll;

public class mainDCll {

	public static void main(String[] args) {
		
		myDCll<Integer> ll = new myDCll<Integer> ();
		
		ll.createNewNode(10);
		ll.createNewNode(20);
		ll.createNewNode(30);
		ll.createNewNode(40);
		
		ll.AddNodeAtBegining(5);
		ll.AddNodeAtBegining(6);
		
		ll.AddNodeAtEnd(20);
		ll.AddNodeAtEnd(60);
		ll.AddNodeAtEnd(80);
		ll.AddNodeAtEnd(90);
		
		ll.AddNodeAnyPosition(3, 120);
		ll.printList();
		
		ll.length();
		ll.search(30);
		
		System.out.println("The occurence of the number is = "+ll.occurence(20));
		
		ll.deleteNode(3);
		
		System.out.println("The element of the given position is = "+ ll.getNthElememt(5));
		
		ll.findMaxMin();
	}
}
