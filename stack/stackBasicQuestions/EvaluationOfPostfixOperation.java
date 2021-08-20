/**
 * Evaluation of Postfix Expression 
 * 
 * Given string S representing a postfix expression, the task is to 
 * evaluate the expression and find the final value. Operators will 
 * only include the basic arithmetic operators like *, /, + and -.
 * 
 * Example:
 *      Input: S = "231*+9-"
 *      Output: -4
 *      Explanation: After solving the given expression, we have -4 as result.
 */
package stack.stackBasicQuestions;

import java.util.Scanner;
import java.util.Stack;

public class EvaluationOfPostfixOperation {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the string
        System.out.print("Enter the string : ");
        String str = sc.next();

        sc.close();

        // Print the result
        System.out.println("After solving the expression the result is = " + postfixEvaluation(str));
    }

    // Method to evaluate a postfix expression
    private static Integer postfixEvaluation(String str) {

        // Declare a stack
        Stack<Integer> st = new Stack<Integer>();
        int n = str.length();

        // iterating over the given string.
        for (int i = 0; i < n; i++) {

            // if current character is an operand, we push it to the stack.
            if (Character.isDigit(str.charAt(i))) {
                st.push(str.charAt(i) - '0');
            }

            // else current character is an operator.
            else {
                int val1 = st.pop();
                int val2 = st.pop();
                switch (str.charAt(i)) {

                    // we perform required operation and push the result in stack.
                    case '+':
                        st.push(val2 + val1);
                        break;
                    case '-':
                        st.push(val2 - val1);
                        break;
                    case '*':
                        st.push(val2 * val1);
                        break;
                    case '/':
                        st.push(val2 / val1);
                        break;
                }
            }
        }

        // returning the top element of the stack.
        return st.pop();
    }
}