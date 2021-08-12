/*
 * Implement Stack using Array
 */

package stack.stackBasicQuestions;

public class ImplementStackUsingArray {

	static class Stack {

		// Define the max size of the array
		static final int Max_Size = 100;

		// Initialize the max size of the array into the array
		int arr[] = new int[Max_Size];

		int top = -1;

		/**
		 * method to check the stack is empty or not.
		 * 
		 * @return true/false
		 */
		boolean isEmpty() {
			return (top < 0);
		}

		/**
		 * Method to push the element into the stack.
		 * 
		 * @param value
		 * 
		 * if the "top" value is greater than the size of array then the
		 * stack is in Overflow condition. it @return false.
		 * 
		 * else we initialize the "top" value into the array as a position
		 * and increment it. And initialize the user input value in that
		 * position and print it. it @return true.
		 */
		private boolean push(int val) {
			if (top >= (Max_Size - 1)) {
				System.out.println("Stack Overflow");
				return false;
			} else {
				arr[++top] = val;
				System.out.println(val + " Pushed into stack at position : " + top);
				return true;
			}
		}

		/**
		 * Method to pop the element into the stack. If the "top" value is less than 0
		 * then the stack is in Underflow condition. It @return 0.
		 * 
		 * else we initialize the top value into the array as a position and store that
		 * particular position value in a variable and decrement the top. It @return the
		 * value of the particular position
		 */
		private int pop() {
			if (top < 0) {
				System.out.println("Stack Underflow");
				return 0;
			} else {
				int value = arr[top];
				top--;
				return value;
			}
		}

		/**
		 * Method to print the top value of the stack. If the top value is less than 0
		 * then the stack is in Underflow condition. It @return 0.
		 * 
		 * else, We Initialize the top value into the array as a position and store that
		 * particular position value in a variable. And @return that particular value.
		 */
		private int peek() {
			if (top < 0) {
				System.out.println("Stack Underflow");
				return 0;
			} else {
				int peek_value = arr[top];
				return peek_value;
			}
		}
	}

	public static void main(String[] args) {

		// Create object of "Stack" class
		Stack stack = new Stack();

		// call push method for push the element into the stack
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);

		// call peek method to print the top element of the array
		System.out.println("The peek element is = " + stack.peek());

		// pop the elements from stack and print it
		System.out.print("The elements of the stack are : ");
		while (!stack.isEmpty()) {
			int value = stack.pop();
			System.out.print(value + " ");
		}
		System.out.println();
	}
}