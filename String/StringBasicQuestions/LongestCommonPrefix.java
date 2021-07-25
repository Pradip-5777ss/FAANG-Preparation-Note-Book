/**
 * Find the Longest Common Prefix of an array of string.
 * 
 * Example:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class LongestCommonPrefix {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        String str[] = new String[size];

        // Ask user to enter the elements of the array
        System.out.println("Enter the elements of the string array : ");
        for (int i = 0; i < size; i++) {
            str[i] = sc.next();
        }
        sc.close();

        // Method call to find and print the longest common prefix
        System.out.println("The longest common prefix is : " + longestCommonPrefix(str));
    }

    // Method to find the longest common prefixvstring amongst an array of strings.
    private static String longestCommonPrefix(String[] str) {

        /**
         * First check the length of the string . If it is null then return null
         */
        if (str.length == 0) {
            return "";
        }

        // Declare a string variable and store the first array element
        String prefix = str[0];

        // Run a loop and traverse the whole string to find the maximum prefix
        for (int i = 1; i < str.length; i++) {

            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty())
                    return "";
            }
        }
        return prefix;
    }
}