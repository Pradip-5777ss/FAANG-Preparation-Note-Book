/**
 * Number of 1 Bits.
 * Given a positive integer N, print count of set bits in it. 
 * 
 * Example 1:
 *  Input:
 *          N = 6
 *  Output: 2
 *  Explanation: Binary representation is '110' So the count of the set bit is 2.
 * 
 * Example 2:
 *  Input:
 *          N = 8
 *  Output: 1
 *  Explanation: Binary representation is '1000' So the count of the set bit is 1.
 * 
 * Time Complexity: O(LogN)
 * Space Complexity: O(1)
 */
package BitManipulation;

import java.util.Scanner;

public class CountSetBits {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the number
        System.out.print("Enter the number : ");
        int num = sc.nextInt();

        sc.close();

        // Print the Count of set bits
        System.out.println("The Count of set bits are : " + countSetBits(num));
    }

    // Method to count the set bits
    private static int countSetBits(int num) {

        // Take a variable count
        int count = 0;

        // Run the loop until the number is not zero
        while (num > 0) {

            // Do bitwise & with (num-1) and assign the value back to num
            num = num & (num - 1);

            // Increment the count
            count++;
        }

        // Return the Count of set bits
        return count;
    }
}