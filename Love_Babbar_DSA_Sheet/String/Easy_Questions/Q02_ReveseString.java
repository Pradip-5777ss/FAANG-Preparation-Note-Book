/**
 * @author Pradip Sahoo
 * Created on 11/08/2022
 * ----------------------------
 * reverse a string.
 * Write a function that reverses a string. The input string is given as an
 * array of characters s.
 * 
 * Example 1:
 *  Input: s = ["h","e","l","l","o"]
 *  Output: ["o","l","l","e","h"]
 * Example 2:
 *  Input: s = ["H","a","n","n","a","h"]
 *  Output: ["h","a","n","n","a","H"]
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.String.Easy_Questions;

import java.util.Scanner;

public class Q02_ReveseString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the string : ");
        String str = sc.nextLine();

        // Convert the string into array
        char s[] = str.toCharArray();

        sc.close();

        // Method call to reverse the string
        char[] ans = reverseString(s);

        System.out.print("The reverse string is : ");
        for (char c : ans) {
            System.out.print(c + " ");
        }
        System.out.println();
    }

    /**
     * Method to reverse the string
     * 
     * @param s the string
     * @return the reverse string
     */
    private static char[] reverseString(char[] s) {

        /**
         * Use two pointer method. set start pointer on first element of the string and
         * end pointer on last element of the string
         */
        int start = 0;
        int end = s.length - 1;

        // Run the loop until end pointer is greater than the start pointer
        while (end > start) {
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;

            start++;
            end--;
        }

        // Return the reverse string
        return s;
    }
}