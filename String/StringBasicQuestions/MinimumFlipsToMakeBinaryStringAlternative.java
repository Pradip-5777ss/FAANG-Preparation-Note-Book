/**
 * Minimum Changes To Make Alternating Binary String.
 * 
 * Given a binary string, that is it contains only 0s and 1s.
 * We need to make this string a sequence of alternate characters
 * by flipping some of the bits, our goal is to minimize the number
 * of bits to be flipped.
 * 
 * Example:
 * Input: s = "0100"
 * Output: 1
 * Explanation: If you change the last character to '1', s will be "0101", which is alternating.
 */
package String.StringBasicQuestions;

import java.util.Scanner;

public class MinimumFlipsToMakeBinaryStringAlternative {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the string
        System.out.print("Enter the binary string : ");
        String str = sc.nextLine();

        sc.close();

        // Method call to find the minimum required flips to make a string alternative
        System.out.println("The minimum required flips are : " + minFlips(str));
    }

    /**
     * Method to return the minimum number of characters of the given binary string
     * to be replaced to make the string alternating
     */
    private static int minFlips(String str) {

        // Declare a variable count and initialize by 0
        int count = 0;

        for (int i = 0; i < str.length(); i++) {

            // If there is 1 at even index positions
            if (i % 2 == 0 && str.charAt(i) == '1') {
                count++;
            }

            // If there is 0 at odd index positions
            if (i % 2 == 1 && str.charAt(i) == '0') {
                count++;
            }
        }

        return Math.min(count, str.length() - count);
    }
}
