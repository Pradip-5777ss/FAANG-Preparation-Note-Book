package LinkedList.LinkedListBasic;

import LinkedList.LinkedListBasic.CircularLinkedList.myCll;

public class mainCll {

	public static void main(String[] args) {
		
		myCll<Integer> ll = new myCll<Integer>();
		
		ll.createNewode(10);
		ll.createNewode(20);
		ll.createNewode(3);
		ll.createNewode(40);
		ll.createNewode(50);
		
		ll.addNodeAtBegining(1);
		ll.addNodeAtBegining(3);
		ll.addNodeAtBegining(5);
		ll.addNodeAtBegining(7);
		
		ll.AddNodeAtEnd(60);
		ll.AddNodeAtEnd(3);
		ll.AddNodeAtEnd(80);
		ll.AddNodeAtEnd(23);
		
		ll.addNodeAtAnyPosition(4, 12);
		System.out.println("The linked list is : ");
		ll.print();
		
		ll.length();
		ll.search(50);
		
		ll.deleteNode(7);
//		System.out.println("Data is deleted");
//		ll.print();
//		System.out.printf("the deleted data is = %d \n", position+1);
		
		System.out.println("The nth element is = "+ll.getNth(6));
		
		System.out.println("The occurence of the element is = "+ll.occurence(3));
		
		ll.findMinMax();
	}
}
