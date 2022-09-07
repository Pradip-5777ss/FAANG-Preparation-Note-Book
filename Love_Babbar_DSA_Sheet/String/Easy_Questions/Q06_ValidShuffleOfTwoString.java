/**
 * @author Pradip Sahoo
 * Created on 07/09/2022
 * ----------------------------
 * Write a Program to check whether a string is a valid shuffle of two strings or not.
 * 
 * Example:
 *  Input:  
 *      str1 = xy
 *      str2 = 12
 *      res = x1y2
 *  Output: true
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.String.Easy_Questions;

import java.util.Scanner;

public class Q06_ValidShuffleOfTwoString {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the 1st string : ");
        String str1 = sc.nextLine();

        System.out.print("Enter the 2nd string : ");
        String str2 = sc.nextLine();

        System.out.print("Enter the resultant string : ");
        String res = sc.nextLine();

        sc.close();

        // Method call to check the string is a valid shuffle or not
        boolean result = isShuffle(str1, str2, res);

        // print the result
        if (result) {
            System.out.println(res + " - is a valid shuffle of " + str1 + " and " + str2);
        } else {
            System.out.println(res + " - is not a valid shuffle of " + str1 + " and " + str2);
        }
    }

    // Method to check a string is a valid shuffle of two string or not
    private static boolean isShuffle(String str1, String str2, String res) {

        // Find the length of the strings
        int str1_length = str1.length();
        int str2_length = str2.length();
        int res_length = res.length();

        /**
         * If the length of first & second string is not equal to the resultant string
         * then return false
         */
        if (str1_length + str2_length != res_length) {
            return false;
        }

        // Variable to track each character of 3 strings
        int i = 0, j = 0, k = 0;

        // Iterate through all characters of the resultant string
        while (k != res_length) {

            /**
             * check if ith position character of resultant string matches with ith position
             * character of first string
             */
            if (i < str1_length && str1.charAt(i) == res.charAt(k)) {
                i++;
            }
            /**
             * check if ith position character of resultant string matches with ith position
             * character of second string
             */
            else if (j < str2_length && str2.charAt(j) == res.charAt(k)) {
                j++;
            }
            // If the character does not match
            else {
                return false;
            }

            // Increment the k value to check the next character of resultant string
            k++;
        }

        /**
         * After accessing all characters of resultant string if either first or second
         * string has some character left
         */
        if (i < str1_length || j < str2_length) {
            return false;
        }

        // If all characters are matched then return true
        return true;
    }
}