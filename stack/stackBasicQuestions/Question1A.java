/*
 * Implement Stack using Array
 */

package stack.stackBasicQuestions;

public class Question1A {

	/**
	 * Stack class
	 * 
	 * @author Pradip
	 */
	static class Stack {
		/*
		 * Define the max size of the array
		 */
		static final int max = 1000;

		/*
		 * Declare the variable
		 */
		int top;

		/*
		 * Initialize the max size of the array into the array
		 */
		int arr[] = new int[max];

		/*
		 * Public constructor for initialize the value of the stack
		 */
		public Stack() {
			top = -1;
		}

		/**
		 * method to check the stack is empty or not. In initial the top value is -1, if
		 * the top value is less than 0 then the stack is empty. this method returns
		 * true / false. If the stack is empty then it returns true otherwise false.
		 * 
		 * @author Pradip
		 * @return
		 */
		boolean isEmpty() {
			return (top < 0);
		}

		/**
		 * Method to push the element into the stack with the value take as parameter.
		 * if the "top" value is greater than the "max-1" value then the stack is in
		 * Overflow condition. And it return false. else we initialize the "top" value
		 * into the array as a position and increment it. And initialize the user input
		 * value in that position and print it. And it returns true.
		 * 
		 * @author Pradip
		 * @param val The value which is entered by user
		 * @return
		 *
		 */
		boolean push(int val) {
			if (top >= (max - 1)) {
				System.out.println("Stack Overflow");
				return false;
			} else {
				arr[++top] = val;
				System.out.println(val + " Pushed into stack at position : " + top);
				return true;
			}
		}

		/**
		 * Method to pop the element into the stack. if, after push the elements, if the
		 * "top" value is less than 0 then the stack is in Underflow condition.
		 * 
		 * @return it return 0. else, we initialize the "top" variable with current
		 *         "top" value into the array as a position, and we store the arr[top]
		 *         position value in a variable. And we decrement the "top" value.
		 * @return it return the variable.
		 * 
		 * @author Pradip
		 */
		int pop() {
			if (top < 0) {
				System.out.println("Stack Underflow");
				return 0;
			} else {
				int value = arr[top];
				top--;
				return value;
			}
		}

		int peek() {
			if (top < 0) {
				System.out.println("Stack Underflow");
				return 0;
			} else {
				int peek_value = arr[top];
				return peek_value;
			}
		}

		void search(int val) {

			for (int pos = 0; pos < arr.length; pos++) {
				if (val == arr[pos]) {
					System.out.println("The element is present at position : ");
					break;
				} else {
					System.out.println("The element is not present in the array");
					break;
				}
			}

		}
	}

	/**
	 * Main method
	 * @author Pradip
	 * @param args
	 */
	public static void main(String[] args) {

		/*
		 * make the object of "Stack"class
		 */
		Stack stack = new Stack();

		// call push method for push the element into the stack
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);

		// Call pop method for pop the element from the stack
		System.out.println(stack.pop() + "popped from stack");
		System.out.println(stack.pop() + "popped from stack");

		// Call isEmpty method for check the stack is empty or not
		System.out.println(stack.isEmpty());

		System.out.println(stack.peek() + " is the peek element");
	}

}
