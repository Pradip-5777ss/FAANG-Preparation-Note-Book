/**
 * Sum of two numbers without using arithmetic operators.
 * 
 * Given two integers a and b. Find the sum of two numbers without using arithmetic operators.
 * Example 1:
 *  Input:  a = 5, b = 3
 *  Output: 8
 *  Explanation :   5 + 3 = 8
 * 
 * Example 2:
 *  Input:  a = 10, b = 30
 *  Output: 40
 *  Explanation:    10 + 30 = 40
 * 
 * Time Complexity : O(max(number of bits in 'a', number of bits in 'b'))
 * Auxiliary Space : O(1)
 */
package BitManipulation.EasyQuestions;

import java.util.Scanner;

public class SumWithoutOperator {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the two numbers
        System.out.println("Enter two numbers : ");
        int a = sc.nextInt();
        int b = sc.nextInt();

        sc.close();

        // Method call to find the sum of two numbers
        System.out.println("The sum of two numbers are : " + sum(a, b));
    }

    // Method to find the sum of two numbers without using any arithmatic operator
    private static int sum(int a, int b) {

        // Iterate while there is no carry
        while (b != 0) {
            
            // Carry contains the common set bits of a and b
            int carry = a & b;

            /**
             * Sum of bits of a and b where at least one of the bits is not set. a is
             * basically store the running addition result
             */
            a = a ^ b;

            // Carry is left shifted by one so that adding it to a gives the required sum
            b = carry << 1;
        }

        // Return the result
        return a;
    }
}