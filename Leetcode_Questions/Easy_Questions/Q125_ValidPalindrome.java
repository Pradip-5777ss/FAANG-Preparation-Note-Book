/**
 * @author Pradip sahoo
 * Created on 14/07/2022
 * ------------------------
 * 125. Valid Palindrome
 * A phrase is a palindrome if, after converting all uppercase letters into
 * lowercase letters and removing all non-alphanumeric characters, it reads the
 * same forward and backward. Alphanumeric characters include letters and
 * numbers.
 * Given a string s, return true if it is a palindrome, or false otherwise.
 * 
 * Example 1:
 *  Input: s = "A man, a plan, a canal: Panama"
 *  Output: true
 *  Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * Example 2:
 *  Input: s = "race a car"
 *  Output: false
 *  Explanation: "raceacar" is not a palindrome.
 * 
 * Example 3:
 *  Input: s = " "
 *  Output: true
 *  Explanation: s is an empty string "" after removing non-alphanumeric
 *  characters. 
 *  Since an empty string reads the same forward and backward, it is a
 *  palindrome.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Leetcode_Questions.Easy_Questions;

import java.util.Scanner;

public class Q125_ValidPalindrome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string expression : ");
        String str = sc.nextLine();

        sc.close();

        boolean result = isPalindrome(str);

        if (result == true) {
            System.out.println("The given string is palindrome");
        } else {
            System.out.println("The given string is not palindrome");
        }
    }

    /**
     * Method to check wheather the given input string is palindrome or not
     * 
     * @param str
     * @return true or false
     */
    private static boolean isPalindrome(String str) {

        // If the string is null then print the message
        if (str == null) {
            throw new IllegalArgumentException("Input string is null");
        }

        // Declare two pointers
        int left = 0;
        int right = str.length() - 1;

        // Traverse the string until left pointer is less than the right pointer
        while (left < right) {

            /**
             * If the left pointer is less than the right pointer and if the character of a
             * particular position of left pointer is not a digit or letter then increment
             * the left pointer
             */
            while (left < right && !Character.isLetterOrDigit(str.charAt(left))) {
                left++;
            }

            /**
             * If the left pointer is less than the right pointer and if the character of a
             * particular position of right pointer is not a digit or letter then decrement
             * the right pointer
             */
            while (left < right && !Character.isLetterOrDigit(str.charAt(right))) {
                right--;
            }

            /**
             * we convert the uppercase letters into lowercase letters, If the character at
             * the position of left pointer is not equal to the character at the position of
             * right pointer then return false
             */
            if (Character.toLowerCase(str.charAt(left)) != Character.toLowerCase(str.charAt(right))) {
                return false;
            }

            // Otherwise increment the left pointer and decrement the right pointer
            left++;
            right--;
        }
        return true;
    }
}