package LinkedList.LinkedListBasicQuestions;

public class DoublyCircularLinkedList {

	public static class myDCll<DC> {
		
		static class node<DC> {
			public DC data;
			public node<DC> nextNode;
			public node<DC> prevNode;
			
			public node(DC data) {
				this.data = data;
				prevNode = null;
				nextNode = null;
			}
		}
		
		node<DC> headNode;
		node<DC> tailNode;
		node<DC> tempNode;
		
		public void createNewNode(DC data) {
			
			node<DC> addNewNode = new node<DC>(data);
			
			if (headNode == null) {
				headNode = tailNode = addNewNode;
				headNode.prevNode = null;
				headNode.nextNode = null;
			} else {
				tailNode.nextNode = addNewNode;
				addNewNode.prevNode = tailNode;
				tailNode = addNewNode;
				tailNode.nextNode = headNode.prevNode;
				headNode.prevNode = tailNode.nextNode;
			}
		}
		
		public void AddNodeAtBegining(DC data) {
			
			node<DC> addBegining = new node<DC>(data);
			
			if (headNode == null) {
				System.out.println("The list is empty");
			}
			
			addBegining.nextNode = headNode;
			addBegining.prevNode = headNode.prevNode;
			headNode.prevNode = addBegining;
			headNode = addBegining;
		}
		
		public void AddNodeAtEnd(DC data) {
			
			node<DC> addEnd = new node<DC>(data);
				
				if (tailNode != headNode) {
					tailNode.nextNode = addEnd;
					addEnd.prevNode = tailNode;
					addEnd.nextNode = headNode;
					tailNode = addEnd;
					headNode.prevNode = tailNode;
				}			
		}
		
		public void AddNodeAnyPosition(int position, DC data) {
			
			node<DC> AddAnyPos = new node<DC>(data);
			
			if (headNode == null) {
				System.out.println("The list is empty");
				return;
			}
			
			tempNode = headNode;
			
			for (int i = 1; i < position - 1; i++) {
				tempNode = tempNode.nextNode;
			}
			AddAnyPos.nextNode = tempNode.nextNode;
			tempNode.nextNode.prevNode = AddAnyPos;
			AddAnyPos.prevNode = tempNode;
			tempNode.nextNode = AddAnyPos;
		}
		
		public void printList() {
			
			tempNode = headNode;
			if (headNode == null) {
				System.out.println("the list is empty");
				return;
			}
			
			System.out.println("The linked list is : ");
			System.out.print("[");
			do {
				System.out.print(tempNode.data+" ");
				tempNode = tempNode.nextNode;
			} while (tempNode != headNode);
			System.out.print("]");
			System.out.println();
		}
		
		public void length() {
			int count = 0;
			
			tempNode = headNode;
			
			do {
				count++;
				tempNode = tempNode.nextNode;
			} while (tempNode != headNode);
			System.out.println("The length of the list is = "+count);
		}
		
		public void search(DC data) {
			tempNode = headNode;
			
			boolean flag = false;
			
			if (headNode == null) {
				System.out.println("The list is empty");
			} else {
				while (tempNode.nextNode != headNode) {
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
		
		public int occurence(DC x) {
			
			tempNode = headNode;
			
			int count = 0;
			
			while (tempNode.nextNode != headNode) {
				if (tempNode.data == x) {
					count++;
				}
				tempNode = tempNode.nextNode;
			}
		return count;
		}
		
		public void deleteNode(int position) {
			
			tempNode = headNode;
			
			if (headNode == null) {
				System.out.println("The list is empty");
				return;
			}
			
			if (position == 1) {
				headNode = headNode.nextNode;
			}
			
			for (int i = 1; tempNode.nextNode!=headNode && i<position-1; i++) {
				tempNode = tempNode.nextNode;
			}
			
			node<DC> nextNodeAdd = tempNode.nextNode.nextNode;
			
			tempNode.nextNode = nextNodeAdd;
			
			System.out.println("After deleting the element the list is = ");
			printList();
		}
		
		public DC getNthElememt(int index) {
			tempNode = headNode;
			
			int count = 1;
			
			while (tempNode.nextNode != headNode) {
				if (count == index) {
					return tempNode.data;
				}
				count++;
				tempNode = tempNode.nextNode;
			}
			assert(false);
			return null;
		}
		
		public void findMaxMin() {
			
			tempNode = headNode;
			
			int min;
			int max;
			
			if (headNode == null) {
				System.out.println("The list is empty");
				return;
			} else {
				min = (int) headNode.data;
				max = (int) tempNode.data;
							
				do {
					if (min > (Integer)tempNode.data) {
						min = (int)tempNode.data;
					}
					if (max < (Integer)tempNode.data) {
						max = (int) tempNode.data;
					}					
					tempNode = tempNode.nextNode;
				} while (tempNode != headNode);
				
				System.out.println("The minimum element of the list = "+min);
				System.out.println("The maximum element of the list = "+max);
			}
		}
	}
}
