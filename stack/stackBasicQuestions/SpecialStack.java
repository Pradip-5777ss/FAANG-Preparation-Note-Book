/**
 * Special Stack
 * 
 * Design a data-structure SpecialStack that supports all the stack operations
 * like push(), pop(), isEmpty(), isFull() and an additional operation getMin()
 * which should return minimum element from the SpecialStack. 
 * 
 * Note : It is only use Stack data structure
 * 
 * Example :
 * Input: 
 *      Stack: 18 19 29 15 16
 * Output: 15
 * Explanation: The minimum element of the stack is 15.
 */
package stack.stackBasicQuestions;

import java.util.Scanner;
import java.util.Stack;

public class SpecialStack {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the stack
        System.out.print("Enter the size of the stack : ");
        int size = sc.nextInt();

        // Create Stack of integer
        Stack<Integer> st = new Stack<>();

        // If the stack is not empty then pop the element of the stack
        while (!isEmpty(st)) {
            pop(st);
        }

        // If the stack is not full then push the elements into the stack
        System.out.println("Enter the stack elements");
        while (!isFull(st, size)) {
            push(sc.nextInt(), st);
        }

        sc.close();

        // Method call to find the minimum element of the stack
        System.out.println("The minimum stack is : " + getMin(st));
    }

    /**
     * Method to push element into the stack
     * 
     * @param val
     * @param st
     */
    private static void push(int val, Stack<Integer> st) {

        st.push(val);
    }

    /**
     * Method to pop element from the stack and return that particular element
     * 
     * @param st
     * @return
     */
    private static int pop(Stack<Integer> st) {

        int a = st.pop();
        return a;
    }

    /**
     * Method to find the minimum element of the stack
     * 
     * @param st
     * @return the minimum element
     */
    private static int getMin(Stack<Integer> st) {

        // Store the poped element
        int m = pop(st);

        /**
         * Now check that the stack is empty or not. If not then we popped another
         * element from stack If the first element is greater than the second element
         * then store the second element as minimum element and return it
         */
        while (!isEmpty(st)) {

            int n = pop(st);
            if (n < m)
                m = n;
        }
        return m;
    }

    /**
     * Method to check the stack is empty or not
     * 
     * @param st
     * @return ture or false
     */
    private static boolean isEmpty(Stack<Integer> st) {

        if (st.size() == 0) {
            return true;
        }
        return false;
    }

    /**
     * Method to check the stack is full or not
     * 
     * @param st
     * @param size
     * @return true or false
     */
    private static boolean isFull(Stack<Integer> st, int size) {

        if (st.size() == size) {
            return true;
        }
        return false;
    }
}