/**
 * Check the expression	has valid of Balanced parenthesis or not.
 */
package stack.stackBasicQuestions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedBraketes {

	public static void main(String[] args) {

		// Create Scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the brackets
		System.out.print("Enter the brackets : ");
		String brackets = sc.nextLine();

		sc.close();

		// Method Call to check that the brackets are balanced or not
		if (bracketBalanced(brackets)) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not Balanced");
		}
	}

	/**
	 * Method to check that brackets are balanced or not. It take @param bracket and
	 * 
	 * @return either true or false
	 */
	static boolean bracketBalanced(String bracket) {

		// Using ArrayDeque is faster than using Stack Class
		Deque<Character> stackDeque = new ArrayDeque<Character>();

		// Traversing the Expression
		for (int i = 0; i < bracket.length(); i++) {

			/**
			 * charAt returns the char value at the specified index of the string. We store
			 * the char value in the variable.
			 */
			char x = bracket.charAt(i);

			/**
			 * If the current character is a starting bracket then push it into the stack
			 */
			if (x == '(' || x == '{' || x == '[') {
				stackDeque.push(x);
				continue;
			}

			/**
			 * If current character is not opening bracket, then it must be closing. So
			 * stack cannot be empty at this point.
			 */
			if (stackDeque.isEmpty()) {
				return false;
			}

			/**
			 * Declare a char variable If the current character is a closing bracket then it
			 * pop from stack and if the popped character is matching with the starting
			 * bracket then the brackets are balanced else the brackets are not balanced.
			 */
			char check;
			switch (x) {
				case ')':
					check = stackDeque.pop();
					if (check == '{' || check == '[') {
						return false;
					}
					break;

				case '}':
					check = stackDeque.pop();
					if (check == '(' || check == '[') {
						return false;
					}
					break;

				case ']':
					check = stackDeque.pop();
					if (check == '(' || check == '{') {
						return false;
					}
					break;
			}
		}

		// Check Empty stack
		return (stackDeque.isEmpty());
	}
}