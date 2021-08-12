/**
 * Implement stack using Linked List
 */

package stack.stackBasicQuestions;

public class ImplementStackUsingLinkedList {

	// Define the topnode of the stack
	StackNode topNode;

	// StackNode Class
	static class StackNode {
		int data;
		StackNode nextNode;

		public StackNode(int data) {
			this.data = data;
		}
	}

	/**
	 * This function checks the stack is empty or not. If the topnode is null then
	 * the stack is empty and it @return true else false
	 */
	public boolean isEmpty() {
		if (topNode == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * This method is used to push an element into the stack. It take @param data.
	 * 
	 * Create a newNode of the stack. If the topNode is null then make the newly
	 * created node as topNode.
	 * 
	 * else Declare a newNode "tempNode" and store the topNode as tempNode. Make the
	 * newNode as topNode and store the tempNode as the nextNode of newNode.
	 */
	public void push(int data) {

		StackNode newNode = new StackNode(data);

		if (topNode == null) {
			topNode = newNode;
		} else {
			StackNode tempNode = topNode;
			topNode = newNode;
			newNode.nextNode = tempNode;
		}

		System.out.println(data + " pushed into stack");
	}

	// This method is used to pop the element from stack
	public int pop() {

		int popedElement = Integer.MIN_VALUE;
		if (topNode == null) {
			System.out.println("Stack is empty");
		} else {
			popedElement = topNode.data;
			topNode = topNode.nextNode;
		}
		return popedElement;
	}

	// This method is used to peek element in an stack
	public int peekElement() {

		if (topNode == null) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;
		} else {
			return topNode.data;
		}
	}

	public static void main(String[] args) {

		ImplementStackUsingLinkedList stackULL = new ImplementStackUsingLinkedList();

		stackULL.push(10);
		stackULL.push(20);
		stackULL.push(30);
		stackULL.push(40);
		stackULL.push(50);

		System.out.println("The top element is = " + stackULL.peekElement());

		System.out.println("The elements of the stack ");
		while (!stackULL.isEmpty()) {
			int data = stackULL.pop();
			System.out.println(data + "");
		}
	}
}