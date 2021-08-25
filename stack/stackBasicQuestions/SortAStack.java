/**
 * Sort the Stack using Recursion.
 * Given a stack, the task is to sort it such that the top of the stack has the greatest element.
 * 
 * Example:
 *      Input : 
 *          Stack: 11 2 32 3 41
 *      Output: 41 32 11 3 2
 */
package stack.stackBasicQuestions;

import java.util.Scanner;
import java.util.Stack;

public class SortAStack {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Create a stack
        Stack<Integer> st = new Stack<>();

        // Ask user to enter the number of elements in stack
        System.out.print("Enter the number of elements in stack : ");
        int n = sc.nextInt();

        // Ask user to enter the elements of the stack
        System.out.println("Enter the elements of the stack : ");
        while (n-- > 0) {
            st.push(sc.nextInt());
        }
        sc.close();

        // Method call to sort stack
        Stack<Integer> s = sortStack(st);

        // Print the output
        System.out.print("The output is : ");
        while (!s.empty()) {
            System.out.print(s.peek() + " ");
            s.pop();
        }
        System.out.println();
    }

    // Method to sort stack
    private static Stack<Integer> sortStack(Stack<Integer> st) {

        // base case
        if (st == null || st.empty()) {
            return st;
        }

        // Create a new Stack to store the result
        Stack<Integer> res = new Stack<>();

        // Declare a Interger variable and initialize it by null
        Integer top = null;

        /**
         * If stack is not empty then pop the top element of the stack and store it in a
         * variable. again run a loop and check the resultant stack is empty or not and
         * the top element of the stack is less then the top element of the resultant
         * stack, If this condition is true then pop the element from resultant stack
         * and push it into the stack. Otherwise, push the top element into the
         * resultant stack and return the resultant stack.
         */
        while (!st.empty()) {
            top = st.pop();
            while (!res.isEmpty() && top < res.peek()) {
                st.push(res.pop());
            }
            res.push(top);
        }
        return res;
    }
}