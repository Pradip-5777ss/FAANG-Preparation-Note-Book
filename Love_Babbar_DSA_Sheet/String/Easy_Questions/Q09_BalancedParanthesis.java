/**
 * @author Pradip Sahoo
 * Created on 12/08/2022
 * -----------------------------
 * Parenthesis Checker
 * Given an expression string x. Examine whether the pairs and the orders of
 * “{“,”}”,”(“,”)”,”[“,”]” are correct in exp.
 * For example, the function should return 'true' for exp = “[()]{}{[()()]()}”
 * and 'false' for exp = “[(])”.
 * 
 * Example 1:
 *  Input : {([])}
 *  Output : true
 *  Explanation : { ( [ ] ) }. Same colored brackets can form balaced pairs, with
 *  0 number of unbalanced bracket.
 * 
 * Example 2:
 *  Input : ()
 *  Output : true
 *  Explanation : (). Same bracket can form balanced pairs, and here only 1 type
 *  of bracket is present and in balanced way.
 * 
 * Example 3:
 *  Input : ([]
 *  Output : false
 *  Explanation : ([]. Here square bracket is balanced but the small bracket is
 *  not balanced and Hence , the output will be unbalanced.
 */
package Love_Babbar_DSA_Sheet.String.Easy_Questions;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Q09_BalancedParanthesis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the brackets : ");
        String str = sc.nextLine();

        sc.close();

        System.out.print("Output : ");
        if (isBalanceParanthesis(str)) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not balanced");
        }
    }

    /**
     * Method to check that the string expression(parenthesis) are vaid or not
     * 
     * @param str as input
     * @return true or false
     */
    private static boolean isBalanceParanthesis(String str) {

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