/**
 * @author Pradip Sahoo
 * Created on 11/08/2022
 * -------------------------------
 * Palindromic String
 * Check whether the String is a palindrome or not.
 * 
 * Example 1:
 *  Input: S = "abba"
 *  Output: 1
 *  Explanation: S is a palindrome
 * Example 2:
 *  Input: S = "abc" 
 *  Output: 0
 *  Explanation: S is not a palindrome
 * 
 * Time Complexity : O(S)(Length of string)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.String.Easy_Questions;

import java.util.Scanner;

public class Q03_CheckStringIsPalindromeOrNot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string : ");
        String str = sc.nextLine();

        sc.close();

        // Method call to check the string is palindrome or not
        boolean result = isPalindrome(str);

        // Print the output
        System.out.print("Output : ");
        if (result) {
            System.out.println("The string is palindrome");
        } else {
            System.out.println("The stirng is not palindrome");
        }
    }

    /**
     * Method to check the string is palindrome or not
     * 
     * @param str
     * @return true if the string is palindrome, else return false
     */
    private static boolean isPalindrome(String str) {

        // Use two pointer technique
        int start = 0;
        int end = str.length() - 1;

        // Declare a boolean flag and initialize it by true
        boolean flag = true;

        /**
         * Run a loop until end is greater than start and check the characters are same
         * or not. If all characters are matched then return true else return false.
         */
        while (end > start) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}