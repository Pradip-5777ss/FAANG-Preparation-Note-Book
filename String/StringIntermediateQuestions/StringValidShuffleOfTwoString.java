/**
 * Write a Program to check whether a string is a valid shuffle of two strings or not.
 */
package String.StringIntermediateQuestions;

import java.util.Scanner;

public class StringValidShuffleOfTwoString {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the first string
        System.out.println("Enter the 1st string : ");
        String str1 = sc.nextLine();

        // Ask user to enter the 2nd string
        System.out.println("Enter the 2nd string : ");
        String str2 = sc.nextLine();

        // Ask user to enter the resultant string to check it is a valid shuffle or not
        System.out.println("Enter the resultant string : ");
        String res = sc.nextLine();

        sc.close();

        // Method call to check the string is a valid shuffle or not
        boolean result = isShuffle(str1, str2, res);

        // print the result
        if (result) {
            System.out.println(res + " is a valid shuffle of " + str1 + " and " + str2);
        } else {
            System.out.println(res + " is not a valid shuffle of " + str1 + " and " + str2);
        }
    }

    // Method to check a string is a valid shuffle of two string or not
    private static boolean isShuffle(String str1, String str2, String res) {

        // First, check the length of all string
        int length1 = str1.length();
        int length2 = str2.length();
        int length3 = res.length();

        /**
         * If the length of first & second string is not equal to the resultant string
         * then return false
         */
        if (length1 + length2 != length3) {
            return false;
        }

        // Variable to track each character of 3 strings
        int i = 0, j = 0, k = 0;

        // Iterate through all characters of the resultant string
        while (k != length3) {

            /**
             * check if first character of resultant string matches with first character of
             * first string
             */
            if (i < length1 && str1.charAt(i) == res.charAt(k)) {
                i++;
            }
            /**
             * check if first character of resultant string matches with first character of
             * second string
             */
            else if (j < length2 && str2.charAt(j) == res.charAt(k)) {
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
        if (i < length1 || j < length2) {
            return false;
        }

        return true;
    }
}
