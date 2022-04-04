/**
 * @author Pradip Sahoo
 * Created on 05/04/2022
 * -----------------------------
 * Factorials of large numbers
 * Given an integer N, find its factorial.
 * 
 * Example 1:
 *  Input: N = 5
 *  Output: 120
 *  Explanation : 5! = 1*2*3*4*5 = 120
 * 
 * Example 2:
 *  Input: N = 10
 *  Output: 3628800
 *  Explanation : 10! = 1*2*3*4*5*6*7*8*9*10 = 3628800
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Medium_Questions;

import java.math.BigInteger;
import java.util.Scanner;

public class Q26_FactorialsOfLargeNumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number : ");
        long num = sc.nextLong();

        sc.close();
        System.out.println("The factorial is : " + findFactorial(num));
    }

    // Method to find the factorial of a large number
    private static BigInteger findFactorial(long num) {

        // Initialize result
        BigInteger fact = new BigInteger("1");

        // Multiply f with 2,3,...,N
        for (int i = 2; i <= num; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }
        return fact;
    }
}