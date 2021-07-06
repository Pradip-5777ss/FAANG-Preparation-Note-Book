package LinkedList.LinkedListBasicQuestions;

public class SinglyLinkedList {

	public static class mySll<E> {

		static class node<E> {
			public E data; // data in node
			public node<E> next; // points to next node in the list

			public node(E data) {
				this.data = data;
				next = null;
			}
		}

		boolean isEmpty() {
			return head == null;
		}

		// declare the node as head
		node<E> head;

		// declare a temp variable to store the head value
		node<E> temp;

		// method to create a new node of a empty linked list
		public void createNewNode(E data) {

			// create object name "createNewNode" to the class name "node"
			node<E> createNewNode = new node<E>(data);

			/**
			 * if there is no element in the linked list, then the head value is zero/null.
			 * if this condition is true then we insert the reference of the new node in the
			 * head variable.
			 */ 
			if (head == null) {
				head = createNewNode;
				return;
			}

			// we store the head node value in the variable name "temp".
			temp = head;

			// run a loop & check the condition upto it is not false. and we store the
			// temp.next value in temp.
			// then we insert the reference of the new node in temp.next position.
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = createNewNode;
		}

		// method to insert a new node at the beginning of the linked list
		public void addNodeAtBegin(E data) {

			// create the node
			// create object of the class
			node<E> addNodeAtBegin = new node<E>(data);

			// insert the head value at the new node's next position
			addNodeAtBegin.next = head;

			// then update the head value by the new node value
			head = addNodeAtBegin;
		}

		// method to insert a new node at the end of the linked list
		public void addNodeAtEnd(E data) {

			// create the node
			// create object of the class
			node<E> addNodeAtEnd = new node<E>(data);

			// initialize the new node next value as null
			addNodeAtEnd.next = null;

			// initialize the head value in temp
			temp = head;

			// run the loop until the condition is not false
			// update temp value by temp.next value
			while (temp != null && temp.next != null) {
				temp = temp.next;
			}

			// update the temp.next value by new node reference
			temp.next = addNodeAtEnd;
		}

		// method to find the length of the of the linked list
		public int length() {

			// declare the variable and initialize it by zero
			int count = 0;

			// initialize the head value in temp
			temp = head;

			// run the loop until the condition is not false
			// then update the temp by temp.next value
			// then increment the count value
			while (temp != null) {
				temp = temp.next;
				count++;
			}

			// print statement
			System.out.print(count);

			// return the count value to the method
			return count;
		}

		// method to print the linked list
		public void print() {

			// initialize the head value in temp
			temp = head;

			System.out.print("[ ");

			// run the loop until the condition id not false
			while (temp != null) {

				// print statement
				System.out.print(temp.data + " ");

				// update the temp by temp.next value
				temp = temp.next;
			}
			System.out.print("]");
			System.out.println();
		}

		// method to search an element of the linked list
		public void search(E data) {

			// initialize the head value in temp
			temp = head;

			// declare & initialize the variable
			int i = 1;

			// declare a flag to false
			boolean flag = false;

			/*
			 * [(if statement)... check the condition. if the condition is true then the
			 * list is empty ]
			 * 
			 * [(while loop)... run the loop until the condition is not false. check the
			 * condition [temp.data == data] or not. if its true then we set the flag true.
			 * then increment the i variable value. increment the temp value. initialize the
			 * temp.next value in temp ]
			 */
			if (head == null) {
				System.out.println("List is empty");
			} else {
				while (temp != null) {
					if (temp.data == data) {
						flag = true;
						break;
					}
					i++;
					temp = temp.next;
				}
			}
			if (flag) {
				System.out.println("Element is present in the list at position : " + i);
			} else {
				System.out.println("Element is not present in the list");
			}
		}

		// method to delete any node of the list
		public void deleteNode(int position) {

			// if head is null then it return nothing
			if (head == null) {
				return;
			}

			// initialize the temp variable by the head value
			temp = head;

			// if the position is 1 input by the user then the head value is updated by the
			// [temp.next] value and delete the first value in the list.
			if (position == 1) {
				head = temp.next;
				return;
			}

			for (int i = 1; temp != null && i < position - 1; i++) {
				temp = temp.next;
			}

			if (temp == null || temp.next == null) {
				return;
			}
			node<E> next = temp.next.next;

			temp.next = next;
		}

		public int getNth(int index) {
			temp = head;
			int count = 1;

			while (temp != null) {
				if (count == index) {
					return (int) temp.data;
				}
				count++;
				temp = temp.next;
			}
			assert (false);
			return 0;
		}

		public int occurence(E x) {

			temp = head;
			int count = 1;

			while (temp != null) {
				if (temp.data == x) {
					count++;
				}
				temp = temp.next;
			}
			return count;
		}

		public void findMinMax() {
			temp = head;
			int min;
			int max;

			if (head == null) {
				System.out.println("List is empty");
			} else {
				// Initializing min with head node data
				min = (int) head.data;
				max = (int) head.data;

				while (temp != null) {
					// If current node's data is smaller than min
					// Then, replace value of min with current node's data
					if (min > (Integer) temp.data) {
						min = (int) temp.data;
					}
					if (max < (Integer) temp.data) {
						max = (int) temp.data;
					}
					temp = temp.next;
				}
				System.out.println("Minimum value node in the list : " + min);
				System.out.println("Maximum value node in the list : " + max);
			}
		}
	}
}