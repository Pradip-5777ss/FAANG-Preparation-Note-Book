/**
 * Isomorphic Strings
 * 
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings s and t are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character while preserving 
 * the order of characters. No two characters may map to the same character, but a character may map to itself.
 * 
 * Example : 
 * Input: s = "egg", t = "add"
 * Output: true
 */
package String.StringBasicQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class IsomorphicString {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the first string
        System.out.println("Enter the first string : ");
        String str1 = sc.nextLine();

        // Ask user to enter the second string
        System.out.println("Enter the second string : ");
        String str2 = sc.nextLine();

        sc.close();

        // Method call to check that the strig is isomorphic of each other or not
        boolean res = IsIsomorphic(str1, str2);

        if (res == true) {
            System.out.println(res + " Both strings are Isometric");
        } else {
            System.out.println(res + " Both strings are not Isometric");
        }
    }

    // Method to check the string is isomorphic
    private static boolean IsIsomorphic(String s, String t) {

        // Declare two array for two string and both are fill with '-1'
        int[] mappingDictStoT = new int[256];
        Arrays.fill(mappingDictStoT, -1);

        int[] mappingDictTtoS = new int[256];
        Arrays.fill(mappingDictTtoS, -1);

        // Run a loop to find the character of the ith position
        for (int i = 0; i < s.length(); ++i) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // Case 1: No mapping exists in either of the dictionaries
            if (mappingDictStoT[c1] == -1 && mappingDictTtoS[c2] == -1) {
                mappingDictStoT[c1] = c2;
                mappingDictTtoS[c2] = c1;
            }

            /**
             * Case 2: Ether mapping doesn't exist in one of the dictionaries or Mapping
             * exists and it doesn't match in either of the dictionaries or both
             */
            else if (!(mappingDictStoT[c1] == c2 && mappingDictTtoS[c2] == c1)) {
                return false;
            }
        }

        return true;
    }
}
