/**
 * Find Longest Recurring Subsequence in String.
 * 
 * Given a string, find the length of the longest repeating subsequence 
 * such that the two subsequences don’t have same string character at the
 * same position, i.e., any i’th character in the two subsequences shouldn’t
 * have the same index in the original string. 
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class LongestRecurringSubsequence {

    public static void main(String[] args) {

        // Create Scanner class to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the string
        System.out.print("Enter the string : ");
        String str = sc.nextLine();
        sc.close();

        // Print the longest subsequence of string
        System.out.println("The lognest subsequence of the string is : " + findLongestRepeatingSubsequence(str));
    }

    // Method to find the longest repeating subsequence
    private static int findLongestRepeatingSubsequence(String str) {

        // Find the length of the string
        int n = str.length();

        // Create and initialize DP table
        int[][] dp = new int[n + 1][n + 1];

        // Fill dp table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {

                // If character matches and indexes are not same
                if (str.charAt(i - 1) == str.charAt(j - 1) && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                }
                // If indexes do not match
                else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[n][n];
    }
}