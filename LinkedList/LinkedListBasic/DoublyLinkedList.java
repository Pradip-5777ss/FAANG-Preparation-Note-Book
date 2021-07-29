package LinkedList.LinkedListBasic;

public class DoublyLinkedList {

	public static class myDll<D> {
		
		static class node<D> {
			public D data;
			public node<D> nextNode;
			public node<D> prevNode;
			
			public node(D data) {
				this.data = data;
				nextNode = null;
				prevNode = null;
			}
		}
		
		node<D> headNode;
		node<D> tempNode;
		node<D> currentNode;
		
		public static int count;
		
		public void createNewNode(D data) {
			node<D> newNode = new node<D>(data);
			
			if (headNode == null) {
				headNode = tempNode = newNode;
				headNode.prevNode = null;
				headNode.nextNode = null;
			} else {
				tempNode.nextNode = newNode;
				newNode.prevNode = tempNode;
				tempNode = newNode;
				tempNode.nextNode = null;
			}
		}
		
		public void printList() {
						
			tempNode = headNode;
			if (headNode == null) {
				System.out.println("List is empty");
				return;
			}
			
			System.out.print("[");
			while (tempNode != null) {
				System.out.print(tempNode.data + " ");
				tempNode = tempNode.nextNode;
			}
			System.out.print("]");
			System.out.println();
		}
		
		public void reversePrint() {
			
			tempNode = null;
			currentNode = headNode;
			
			while (currentNode != null) {
				tempNode = currentNode.prevNode;
				currentNode.prevNode = currentNode.nextNode;
				currentNode.nextNode = tempNode;
				currentNode = currentNode.prevNode;
			}
			if (tempNode != null) {
				headNode = tempNode.prevNode;
			}			
			printList();
		}
		
		public void addNodeAtBeginning(D data) {
			node<D> addBeginning = new node<D>(data);
			
			if (headNode == null) {
				System.out.println("The list is empty");
			}
			
			addBeginning.nextNode = headNode;
			addBeginning.prevNode = null;
			headNode.prevNode = addBeginning;
			headNode = addBeginning;			
		}
		
		public void addNodeAtEnd(D data) {
			node<D> addEnd = new node<D>(data);
			
			tempNode = headNode;
			
			if (headNode == null) {
				System.out.println("The list is empty");
				return;
			}
			
			while (tempNode != null && tempNode.nextNode != null) {
				tempNode = tempNode.nextNode;
			}
			
			addEnd.nextNode = null;
			addEnd.prevNode = tempNode;
			tempNode.nextNode = addEnd;
			tempNode = addEnd;
		}
		
		public void addNodeAtAnyPosition(int position, D data) {
			node<D> addAnyPos = new node<D>(data);
			
			if (headNode == null) {
				return;
			}
			
			tempNode = headNode;
			
			for (int i = 1; i < position-1; i++) {

				tempNode = tempNode.nextNode;
			}
			addAnyPos.nextNode = tempNode.nextNode;
			addAnyPos.prevNode = tempNode;
			tempNode.nextNode = addAnyPos;
		}
		public void length() {
			
			count = 1;
			tempNode = headNode;
			
			while (tempNode.nextNode != null) {
				count++;
				tempNode = tempNode.nextNode;
			}
			System.out.println("The length of the linked list is = "+count);
		}
		
		public void search(D data) {
			
			tempNode = headNode;
			
			boolean flag = false;
			
			if (headNode == null) {
				System.out.println("The list is empty");
			} else {
				while (tempNode != null) {
					if (tempNode.data == data) {
						flag = true;
						break;
					}
					tempNode = tempNode.nextNode;
				}
			}
			
			if (flag) {
				System.out.println("The element is present in the list");
			} else {
				System.out.println("The element is not present in the list");
			}
			
		}
		
		public void deleteNode(int position) {
			if (headNode == null) {
				return;
			}
			
			tempNode = headNode;
			
			if (position == 1) {
				headNode = headNode.nextNode;
			}
			
			for (int i = 1; tempNode != null && i < position - 1; i++) {
				tempNode = tempNode.nextNode;
			}
			
			node<D> nextNodeToAdd = tempNode.nextNode.nextNode;
			
			tempNode.nextNode = nextNodeToAdd;
			
			System.out.println("After delete the element the list is = ");
			printList();
		}
		
		public int getNthElement(int index) {
			tempNode = headNode;
			
			int count = 1;
			
			while (tempNode != null) {
				if (count == index) {
					return (int) tempNode.data;
				}
				count++;
				tempNode = tempNode.nextNode;
				
			}
			assert (false);
			return 0;
		}
		
		public int occurence(D x) {
			tempNode = headNode;
			int count = 0;
			
			while (tempNode != null) {
				if (tempNode.data == x) {
					count++;
				}
				tempNode = tempNode.nextNode;
			}
			return count;
		}
		
		public void findMinMAx() {
			tempNode = headNode;
			
			int min;
			int max;
			
			if (headNode == null) {
				System.out.println("The list is empty");
			} else {
				min = (int) headNode.data;
				max = (int) tempNode.data;
				
				while (tempNode!= null) {
					if (min>(Integer)tempNode.data) {
						min = (int) tempNode.data;
					}
					if (max<(Integer)tempNode.data) {
						max = (int) tempNode.data;
					}
					tempNode = tempNode.nextNode;
				}
				System.out.println("The minimum element of the list is = "+min);
				System.out.println("The maximum element of the list is = "+max);
			}
		}
	}
}
