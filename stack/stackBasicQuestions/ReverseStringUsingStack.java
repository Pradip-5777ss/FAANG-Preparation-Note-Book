/**
 * Write a program to reverse a string using stack
 * 
 * Example:
 * Input: S="GeeksforGeeks"
 * Output: skeeGrofskeeG
 */
package stack.stackBasicQuestions;

import java.util.Scanner;
import java.util.Stack;

public class ReverseStringUsingStack {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the string
        System.out.print("Enter the sting : ");
        String str = sc.nextLine();

        sc.close();

        // Method call to reverse the string and print the output
        System.out.println("The output string will be : " + reverseString(str));
    }

    // Method to reverse the string
    private static String reverseString(String str) {

        // Find the length of the string
        int len = str.length();

        // Create a stack of character
        Stack<Character> st = new Stack<>();

        // Run a loop and push the element into the stack
        for (int i = 0; i < len; i++) {

            st.push(str.charAt(i));
        }

        // Declare a resultant string
        String res = "";

        /**
         * Now check if the stack is not empty then pop the element from the stack and
         * add it into the resultant string
         */
        while (!st.isEmpty()) {
            res += st.pop();
        }

        // Return the resultant string
        return res;
    }
}