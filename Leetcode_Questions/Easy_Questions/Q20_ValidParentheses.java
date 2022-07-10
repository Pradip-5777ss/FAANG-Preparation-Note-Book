/**
 * @author Pradip Sahoo
 * Created at 10/07/2022
 * ------------------------
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 *  Open brackets must be closed by the same type of brackets.
 *  Open brackets must be closed in the correct order.
 * 
 * Example 1:
 *  Input: s = "()"
 *  Output: true
 * Example 2:
 *  Input: s = "()[]{}"
 *  Output: true
 * Example 3:
 *  Input: s = "(]"
 *  Output: false
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package Leetcode_Questions.Easy_Questions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q20_ValidParentheses {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string expression : ");
        String str = sc.nextLine();

        sc.close();

        if (isValidParentheses(str)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }
    }

    /**
     * Method to check that the string expressions(parentheses) are valid or not.
     * It takes @param str as input.
     * It @return true or false.
     */
    private static boolean isValidParentheses(String str) {

        // Using Dequeue is faster than using stack class
        Deque<Character> stackDeque = new ArrayDeque<>();

        // Traversing the Expression
        for (int i = 0; i < str.length(); i++) {

            // charAt returns the char value at the specific index of the string.
            char ch = str.charAt(i);

            /**
             * If the current characters are the opening brackets, then push it into the
             * Dequeue.
             */
            if (ch == '(' || ch == '{' || ch == '[') {
                stackDeque.push(ch);
                continue;
            }

            /**
             * If current characters are not opening brackets then must be cloing brackets,
             * So stack can not be empty at this point. If it is empty then return false.
             */
            if (stackDeque.isEmpty()) {
                return false;
            }

            char check;

            /**
             * If the current characters are the closing brackets then it pop from the
             * Dequeue and if the popped character is matching with the starting brackets
             * then the brackets are balanced else the brackets are not balanced.
             */
            switch (ch) {
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

        // Check empty stack
        return stackDeque.isEmpty();
    }
}