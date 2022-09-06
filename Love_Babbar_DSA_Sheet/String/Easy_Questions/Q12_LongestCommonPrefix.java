/**
 * @author Pradip Sahoo
 * Created on 06/09/2022
 * -------------------------
 * Write a function to find the longest common prefix string amongst an array of
 * strings. If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 *  Input: strs = ["flower","flow","flight"]
 *  Output: "fl"
 * 
 * Example 2:
 *  Input: strs = ["dog","racecar","car"]
 *  Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * Time Complexity : O(S), S is the sum of all characters in all string
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.String.Easy_Questions;

import java.util.Scanner;

public class Q12_LongestCommonPrefix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        String str[] = new String[size];
        System.out.print("Enter the strings : ");
        for (int i = 0; i < size; i++) {
            str[i] = sc.next();
        }

        sc.close();

        // Method call to find the Longest common prefix
        String ans = findLCP(str);
        System.out.println("Output : " + ans);
    }

    /**
     * Method to find the Lowest common prefix of the string
     * 
     * @param str
     * @return the prefix
     */
    private static String findLCP(String[] str) {

        // If the string length is 0 then return null
        if (str.length == 0) {
            return "";
        }

        // Store the first element of the string
        String prefix = str[0];

        // Traverse the string
        for (int i = 1; i < str.length; i++) {

            // If prefix not matched then decrease the prefix by 1
            while (str[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        // Return the prefix
        return prefix;
    }
}