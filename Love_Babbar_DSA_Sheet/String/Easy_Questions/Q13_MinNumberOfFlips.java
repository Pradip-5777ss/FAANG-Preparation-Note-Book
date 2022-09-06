/**
 * @author Pradip Sahoo
 * Created on 06/09/2022
 * --------------------------
 * Given a binary string, that is it contains only 0s and 1s. We need to make
 * this string a sequence of alternate characters by flipping some of the bits,
 * our goal is to minimize the number of bits to be flipped.
 * 
 * Example 1:
 *  Input: S = "001"
 *  Output: 1
 *  Explanation: We can flip the 0th bit to 1 to have 101.
 * 
 * Example 2:
 *  Input: S = "0001010111"
 *  Output: 2
 * Explanation: We can flip the 1st and 8th bit to have "0101010101"
 * 
 * Time Complexity : O(|S|)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.String.Easy_Questions;

import java.util.Scanner;

public class Q13_MinNumberOfFlips {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the binary string : ");
        String str = sc.nextLine();

        sc.close();

        System.out.println("The minimum flips are : " + minFlips(str));
    }

    /**
     * Method to find the minimum flips
     * @param str
     * @return the count of minimum flips
     */
    private static int minFlips(String str) {
        // Declare two variables to count the minimum number of flips
        int count_1 = 0;
        int count_2 = 0;

        // Traverse the stirng
        for (int i = 0; i < str.length(); i++) {

            // For case: 01010101...
            if ((i % 2 == 1 && str.charAt(i) == '0') || (i % 2 == 0 && str.charAt(i) == '1')) {
                count_1++;
            }

            // For case: 10101010...
            if ((i % 2 == 1 && str.charAt(i) == '1') || (i % 2 == 0 && str.charAt(i) == '0')) {
                count_2++;
            }
        }

        // Return the minimum of count1 and count2
        return Math.min(count_1, count_2);
    }
}