/**
 * @author Pradip Sahoo
 * Created on 09/04/2022
 * ---------------------------
 * 3. Longest Substring Without Repeating Characters
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * Example 1:
 *  Input: s = "abcabcbb"
 *  Output: 3
 *  Explanation: The answer is "abc", with the length of 3.
 * 
 * Example 2:
 *  Input: s = "bbbbb"
 *  Output: 1
 *  Explanation: The answer is "b", with the length of 1.
 * 
 * Example 3:
 *  Input: s = "pwwkew"
 *  Output: 3
 *  Explanation: The answer is "wke", with the length of 3.
 * 
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a
 * substring.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(min(m,n))
 */
package Leetcode_Questions.Medium_Questions;

import java.util.HashMap;
import java.util.Scanner;

public class Q3_LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the String : ");
        String str = sc.nextLine();

        sc.close();
        System.out.println("The length of longest substring is : " + lengthOfLongestSubstring(str));
    }

    private static int lengthOfLongestSubstring(String str) {

        // If the string length is 0 then return 0
        if (str.length() == 0) {
            return 0;
        }

        // Declare a map
        HashMap<Character, Integer> map = new HashMap<>();

        // Declare an variable 'max' & initialize it by 0
        int max = 0;

        /**
         * Using sliding window to get the longest substring. Take two pointers & Run
         * the loop through the whole string
         */
        for (int right = 0, left = 0; right < str.length(); ++right) {

            // If the map contains the characters of the string then update left pointer
            if (map.containsKey(str.charAt(right))) {
                left = Math.max(left, map.get(str.charAt(right)) + 1);
            }

            /**
             * If the map does not contain the elements of the string then we move the right
             * pointer and put that element into map. Where the key is the character of
             * right pointer index and the value is the right pointer index.
             * Also, If the character is already present in the map then we update the
             * position of that character present in the string.
             */
            map.put(str.charAt(right), right);

            // Find the maximum value of longest substring
            max = Math.max(max, right - left + 1);
        }

        // Return the maximum value
        return max;
    }
}