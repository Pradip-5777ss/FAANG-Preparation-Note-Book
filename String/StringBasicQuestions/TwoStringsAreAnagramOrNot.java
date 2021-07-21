/**
 * Write a program to check whether given two strings are anagram or not.	
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class TwoStringsAreAnagramOrNot {

    static int No_Of_Char = 256;

    public static void main(String[] args) {

        // Create Scanner class to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the first string
        System.out.println("Enter the first string : ");
        String str1 = sc.nextLine();

        // Convert the string into array
        char ch1[] = str1.toCharArray();

        // Ask user to enter the second string
        System.out.println("Enter the second string : ");
        String str2 = sc.nextLine();

        sc.close();

        // Convert the string into array
        char ch2[] = str2.toCharArray();

        // Method call to check the string is anagram or not
        boolean isAnagram = checkAnagram(ch1, ch2);

        // print the result
        if (isAnagram) {
            System.out.println("these Two strings are anagram to each other");
        } else {
            System.out.println("These two strings are not anagram to each other");
        }
    }

    // Method to check the string is anagram or not
    private static boolean checkAnagram(char[] ch1, char[] ch2) {

        // Create a count array and initialize all values as 0.
        int count[] = new int[No_Of_Char];
        int i;

        /**
         * For each character in input string, increment count in the corresponding
         * count array
         */
        for (i = 0; i < ch1.length; i++) {
            count[ch1[i] - 'a']++;
            count[ch2[i] - 'a']--;
        }

        /**
         * If the length of the two strings are not same then this condition returns
         * false
         */
        if (ch1.length != ch2.length) {
            return false;
        }

        // If there is any non zero value in count array
        for (i = 0; i < No_Of_Char; i++) {
            if (count[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
