/**
 * Reverse Stack using Recursion.
 * 
 * Write a program to reverse a stack using recursion. You are not allowed
 * to use loop constructs like while, for..etc, and you can only use the 
 * following ADT functions on Stack S: 
 * isEmpty(S) 
 * push(S) 
 * pop(S)
 */
package stack.StackIntermediateQuestions;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    // Using Stack class for Stack implementation
    static Stack<Character> st = new Stack<>();

    public static void main(String[] args) {

        // Push element into the stack
        st.push('3');
        st.push('5');
        st.push('6');
        st.push('1');
        st.push('7');

        // Print the original stack
        System.out.println("The original stack is : " + st);

        // Method to reverse the stack
        reverseStack();

        // Print the reverse stack
        System.out.println("The reverse stack is : " + st);
    }

    // Method to reverse the stack
    private static void reverseStack() {

        if (st.size() > 0) {

            /**
             * Hold all items in method, Call stack until we reach end of the stack
             */
            char p = st.peek();
            st.pop();
            reverseStack();

            /**
             * Insert all the items held in, Method call by one from the bottom to top.
             * Every item is inserted at the bottom.
             */
            insert_at_bottom(p);
        }
    }

    /**
     * Method to insert an element at the bottom of a stack
     * 
     * @param p
     */
    private static void insert_at_bottom(char p) {

        // If the Stack is empty then push the element
        if (st.empty()) {
            st.push(p);
        } else {

            /**
             * All items are held in method call Stack until we reach end of the stack. When
             * the stack becomes empty and the size becomes 0. then the if part is executed
             * and the item is inserted at the bottom.
             */
            char a = st.peek();
            st.pop();
            insert_at_bottom(p);

            /**
             * push all the items held in method call Stack once the item is inserted at the
             * bottom
             */
            st.push(a);
        }
    }
}