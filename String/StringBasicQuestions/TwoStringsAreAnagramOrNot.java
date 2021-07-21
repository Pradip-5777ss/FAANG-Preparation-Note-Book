/**
 * Write a program to check whether given two strings are anagram or not.	
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class TwoStringsAreAnagramOrNot {

    public static void main(String[] args) {

        // Create Scanner class to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the first string
        System.out.println("Enter the first string : ");
        String str1 = sc.nextLine();

        // Ask user to enter the second string
        System.out.println("Enter the second string : ");
        String str2 = sc.nextLine();

        sc.close();

        // Method call to check the string is anagram or not
        boolean isAnagram = checkAnagram(str1, str2);

        // print the result
        if (isAnagram) {
            System.out.println("these Two strings are anagram to each other");
        } else {
            System.out.println("These two strings are not anagram to each other");
        }
    }

    // Method to check the string is anagram or not
    private static boolean checkAnagram(String str1, String str2) {

        /**
         * If the length of the two strings are not same then this condition returns
         * false
         */
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create a count array and initialize all values as 0.
        int count[] = new int[256];

        /**
         * For each character in input string, increment count in the corresponding
         * count array
         */
        for (int i = 0; i < str1.length(); i++) {
            count[str1.charAt(i) - 'a']++;
            count[str2.charAt(i) - 'a']--;
        }

        for (int res : count) {
            if (res != 0) {
                return false;
            }
        }
        return true;
    }
}