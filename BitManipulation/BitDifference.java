/**
 * Bit Difference
 * 
 * Given two numbers A and B. The task is to count the number of bits needed to be flipped to convert A to B.
 * 
 * Example 1:
 *  Input: A = 10, B = 20
 *  Output: 4
 *  Explanation:
 *      A  = 01010
 *      B  = 10100
 *      As we can see, the bits of A that need to be flipped are 01010. If we flip these bits, we get 10100, which is B.
 * 
 * Example 2:
 *  Input: A = 20, B = 25
 *  Output: 3
 *  Explanation:
 *      A  = 10100
 *      B  = 11001
 *      As we can see, the bits of A that need to be flipped are 10100. If we flip these bits, we get 11001, which is B.
 * 
 * Time Complexity: O(log N)
 * Auxiliary Space: O(1)
 */
package BitManipulation;

import java.util.Scanner;

public class BitDifference {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to eneter the two numbers
        System.out.println("Enter the two numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.close();

        // Method call to find number of bits needed to be flipped to convert A to B
        int res = countFlipBits(a, b);

        // Print the answer
        System.out.println("It needs " + res + " flips to convert");
    }

    // Method to find number of bits needed to be flipped to convert A to B
    private static int countFlipBits(int a, int b) {

        /**
         * XOR operation gives set bits only when there are dissimilar bits. We store
         * the
         * value of XOR operation of a and b.
         */
        int XOR = a ^ b;

        // Declare a counter variable
        int count = 0;

        while (XOR > 0) {

            /**
             * AND operation of XOR and 1 gives us the rightmost bit. counter variable is
             * increased if we get 1 as the rightmost bit.
             */
            count += (XOR & 1);

            // Right Shift XOR by 1 to remove the rightmost bit.
            XOR >>= 1;
        }

        // Return the counter
        return count;
    }
}