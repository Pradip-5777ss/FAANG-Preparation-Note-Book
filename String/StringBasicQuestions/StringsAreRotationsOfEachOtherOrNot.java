/**
 * Write a Code to check whether one string is a rotation of another.
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class StringsAreRotationsOfEachOtherOrNot {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the first string
        System.out.println("Enter the 1st string : ");
        String str1 = sc.nextLine();

        // Ask user to enter the second string
        System.out.println("Enter the 2nd string : ");
        String str2 = sc.nextLine();

        sc.close();

        // Method call to check the strings are rotations of each other or not
        boolean res = areRotations(str1, str2);

        // Print the result
        if (res) {
            System.out.println("Strings are rotations of each other");
        } else {
            System.out.println("Strings are not rotations of each other");
        }
    }

    // Method to check the strings are rotations of each other or not
    private static boolean areRotations(String str1, String str2) {

        // find the length of the strings
        int len1 = str1.length();
        int len2 = str2.length();

        // check both strings length are equal or not
        if (len1 != len2) {
            return false;
        }

        // Concatenate fitst string with first string and store it in a variable
        String temp = str1 + str1;

        /**
         * If str2 is a substring of temp then str1 and str2 are rotations of each
         * other.
         */
        if (temp.indexOf(str2) != -1) {
            return true;
        } else {
            return false;
        }
    }
}