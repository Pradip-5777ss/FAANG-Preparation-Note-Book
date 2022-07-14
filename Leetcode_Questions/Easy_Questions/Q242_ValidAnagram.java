/**
 * @author Pradip Sahoo
 * Created on 14/07/2022
 * ------------------------
 * 242. Valid Anagram
 * Given two strings s and t, return true if t is an anagram of s, and false
 * otherwise.
 * An Anagram is a word or phrase formed by rearranging the letters of a
 * different word or phrase, typically using all the original letters exactly
 * once.
 * 
 * Example 1:
 *  Input: s = "anagram", t = "nagaram"
 *  Output: true
 * 
 * Example 2:
 *  Input: s = "rat", t = "car"
 *  Output: false
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */

package Leetcode_Questions.Easy_Questions;

import java.util.Scanner;

public class Q242_ValidAnagram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first string : ");
        String str1 = sc.nextLine();

        System.out.println("Enter the second string : ");
        String str2 = sc.nextLine();

        sc.close();
        
        boolean result = isAnagram(str1, str2);

        if (result) {
            System.out.println("true : The string is Anagram");
        } else {
            System.out.println("false : The string is not Anagram");
        }
    }

    /**
     * Method to find that the string is Anagram or not. It takes two parameters
     * 
     * @param str1
     * @param str2
     * @return true or false
     */
    private static boolean isAnagram(String str1, String str2) {

        // If both the string length is not same then return false
        if (str1.length() != str2.length()) {
            return false;
        }

        // Create an counter array
        int counter[] = new int[26];

        /**
         * Traverse the first string and check the counter of the string character for
         * both the string
         */
        for (int i = 0; i < str1.length(); i++) {
            counter[str1.charAt(i) - 'a']++;
            counter[str2.charAt(i) - 'a']--;
        }

        // Traverse the counter array, if the count is not 0 return false
        for (int count : counter) {
            if (count != 0) {
                return false;
            }
        }

        // either return true
        return true;
    }
}