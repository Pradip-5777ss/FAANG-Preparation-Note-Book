/**
 * Split the binary string into substrings with equal number of 0s and 1s.
 * 
 * Given a binary string str of length N, the task is to find the maximum 
 * count of consecutive substrings str can be divided into such that all 
 * the substrings are balanced i.e. they have equal number of 0s and 1s. 
 * If it is not possible to split str satisfying the conditions then print -1.
 * 
 * Example :
 * Input: str = “0100110101” 
 * Output: 4
 * The required substrings are “01”, “0011”, “01” and “01”.
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class SplitBinaryStringIntoSubstring {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the string
        System.out.print("Enter the string : ");
        String str = sc.nextLine();

        sc.close();

        // Find the length of the string
        int len = str.length();

        // Method call to find the maximum number of consecutive substring
        System.out.println("the maximum substring is : " + maxSubString(str, len));
    }

    /**
     * Method to find the maximum no of substring with equal no of 0s and 1s. It
     * take two parameter
     * 
     * @param str
     * @param len
     * @return the maximum no of substring
     */
    private static int maxSubString(String str, int len) {

        /**
         * Declare two variable to store count of 0s and 1s Initially both are
         * initialize by 0
         */
        int count0 = 0, count1 = 0;

        // Declare this variable to count the maximum substring
        int cnt = 0;

        // Traverse through the whole string
        for (int i = 0; i < len; i++) {

            // if ith position element is equal to 0 then increment count0 else count1
            if (str.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }

            /**
             * If both count0 and count1 are same that means substrings are found so
             * increment cnt
             */
            if (count0 == count1) {
                cnt++;
            }
        }

        // If no substring is found then return -1
        if (cnt == 0) {
            return -1;
        }

        // return the maximum no of substring
        return cnt;
    }
}