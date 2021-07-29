/*
 * circular linked list class implementation in java
 */

package LinkedList.LinkedListBasic;

public class CircularLinkedList {

	public static class myCll<C> {
		
		static class Node<C> {	
			public C data;	//data in the node
			public Node<C> nextNode;	//points to the nextnode in the list
			
			public Node(C data) {
				this.data = data;
				nextNode = null;
			}
		}
		
		boolean isEmpty() {
			return headNode == null;
		}
		
		Node<C> headNode;	//declare the node as the headnode
		Node<C> tempNode;	//declare the node as the tempnode to store the headnode value.
		Node<C> tailNode;	//declare the node as the tailnode
		
		//method to create a new node of a empty linked list
		public void createNewode(C data) {
			
			//create a object name "newNode" of the class name "Node"
			Node<C> newNode = new Node<C>(data);
			
			//if there is no element in the linked list, then the head value is zero/null
			//if this condition is true then we insert the reference of the newNode in the headNode & tempNode variable.
			if (headNode == null) {
				headNode = tailNode =newNode;
				newNode.nextNode = null;
			} else {
				tailNode.nextNode = newNode;
				tailNode = newNode;
				tailNode.nextNode = headNode;
			}
		}
		
		public void addNodeAtBegining(C data) {
			Node<C> addBeginingNode = new Node<C>(data);
			
			addBeginingNode.nextNode = headNode;
			
			headNode = addBeginingNode;
			
		}
		
		public void AddNodeAtEnd(C data) {
			Node<C> addEndNode = new Node<C>(data);
			
			if (tailNode != headNode) {
				tailNode.nextNode = addEndNode;
				tailNode = addEndNode;
				tailNode.nextNode = headNode;
			} 
		}
		
		public void addNodeAtAnyPosition(int position, C data) {
			
			Node<C> addAnyPositionNode = new Node<C>(data);
			
			if (headNode == null) {
				return;
			}
			
			tempNode = headNode;
			
			for (int i = 1; i < position; i++) {
				tempNode = tempNode.nextNode;
			}
			addAnyPositionNode.nextNode = tempNode.nextNode;
			tempNode.nextNode = addAnyPositionNode;
		}
		
		public void print() {
			tempNode = headNode;
			
			if (headNode == null) {
				System.out.println("List is empty");
			} else {
				System.out.println("Nodes of the circular linked list : ");
				System.out.print("[ ");
			
				do{
					System.out.print(tempNode.data+" ");
					tempNode = tempNode.nextNode;
				} while (tempNode != headNode);
			System.out.print("]");
			System.out.println();
			}
		}
		
		public int length() {
			int count = 0;
			
			tempNode = headNode;
			
			do {
				tempNode = tempNode.nextNode;
				count++;
			} while (tempNode != headNode);

			System.out.println("The length of the linked list is = "+count);
			return count;
		}
		
		public void search(C data) {
			tempNode = headNode;
			
			int i = 1;
			boolean flag = false;
			
			if (headNode == null) {
				System.out.println("List is empty");
			} else {
				while (tempNode.nextNode != headNode) {
					if (tempNode.data == data) {
						flag = true;
						break;
					}
					i++;
					tempNode = tempNode.nextNode;
				}
			}
			
			if (flag) {
				System.out.println("Element is present in the list at position : "+i);
			} else {
				System.out.println("Element is not present in the list");
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
			
			for (int i = 1; tempNode != null && i<position - 1; i++) {
				tempNode = tempNode.nextNode;
			}
			
			Node<C> nextNode = tempNode.nextNode.nextNode;
			
			tempNode.nextNode = nextNode;
			
			System.out.println("The data is deleted");
			System.out.println("After deleting the element the list is : ");
			print();
		}
		
		public int getNth(int index) {
			tempNode = headNode;
			int count = 1;
			
			while (tempNode.nextNode != headNode) {
				if (count == index) {
					return (int) tempNode.data;
				}
				count++;
				tempNode = tempNode.nextNode;
			}
			assert (false);
			return 0;
		}
		
		public int occurence(C x) {
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
		
		public void findMinMax() {
			tempNode = headNode;
			int min;
			int max;
			
			if (headNode == null) {
				System.out.println("List is empty");
			} else {
				min = (int) headNode.data;
				max = (int) tailNode.data;
				
				while (tempNode.nextNode != headNode) {
					if (min > (Integer)tempNode.data) {
						min = (int) tempNode.data;
					}
					if (max < (Integer)tempNode.data) {
						max = (int) tempNode.data;
					}
					tempNode = tempNode.nextNode;
				}
				System.out.println("Minimum element of the list is = "+min);
				System.out.println("Maximum element of the list is = "+max);
			}
		}
		
	}
}