/**
 * Implement stack using Linked List
 */

package stack.stackBasicQuestions;

public class Question1B {

	/**
	 * Define the topnode of the stack
	 */
	StackNode topNode;
	
	/**
	 * StackNode Class 
	 * First we declare variable for data and a nextnode reference
	 * Then we declare a public constructor to take the data input
	 * @author sonu
	 *
	 */
	static class StackNode {
		int data;
		StackNode nextNode;
		
		public StackNode(int data) {
			this.data = data;
		}
	}
	
	/**
	 * This function checks the stack is empty or not
	 * If the topnode is null then the stack is empty
	 * and ir @return true.
	 * If the stack is not empty then it @return false* 
	 */
	public boolean isEmpty() {
		if (topNode == null) {
			return true;			
		} else {
			return false;
		}
	}
	
	/**
	 * This function is used for push an element into the stack.
	 * It take one @param data which we want to push into the stack.
	 * 
	 * Make a object of the "StackNode" class.
	 * First check if "topNode" is null or not. If "topNode" is null
	 * then the newNode is new topNode.
	 * if the "topNode" is not null then we store the "topNode" value
	 * into the variable name as "tempNode".
	 * then we store the newNode value into the topNode.
	 * then we store the tempNode value
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
	
	public int peekElement() {
		
		if (topNode == null) {
			System.out.println("Stack is empty");
			return Integer.MIN_VALUE;			
		} else {
			return topNode.data;
		}
	}
	
	public static void main(String[] args) {
		
		Question1B sLL = new Question1B();
		
		sLL.push(10);
		sLL.push(20);
		sLL.push(30);
		sLL.push(40);
		sLL.push(50);
		
		System.out.println(sLL.pop() + "Popped from stack");
		
		System.out.println("The top element is = "+sLL.peekElement());
	}


}
