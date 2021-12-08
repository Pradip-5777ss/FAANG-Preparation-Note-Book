/**
 * Non Repeating Numbers.
 * 
 * Given an array A containing 2*N+2 positive numbers, out of which 2*N numbers
 * exist in pairs whereas the other two number occur exactly once and are distinct. 
 * Find the other two numbers.
 * 
 * Example 1:
 *  Input:  N = 2
 *          arr[] = {1, 2, 3, 2, 1, 4}
 *  Output: 3 4 
 *  Explanation: 3 and 4 occur exactly once.
 * 
 * Example 2:
 *  Input:  N = 1
 *          arr[] = {2, 1, 3, 2}
 *  Output: 1 3
 *  Explanation: 1 3 occur exactly once.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package BitManipulation;

import java.util.Scanner;

public class TwoNonRepeatingElements {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        // Declare the array with the given size
        int arr[] = new int[(2 * size) + 2];

        // Ask user to enter the elements of the array
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < (2 * size) + 2; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        // Method call to find the two non repeating elements of the array
        int ans[] = NonRepeatingElements(arr);

        // Print the non repeating elements
        System.out.print("the non repeating elements are : ");
        for (int res : ans) {
            System.out.println(res);
        }
    }

    // Method to find the Non repeating elements
    private static int[] NonRepeatingElements(int[] arr) {

        // Declare an array of size 2
        int elements[] = new int[2];

        int sum = 0;

        /**
         * Run a loop to XOR all the array elements and store the result into the
         * variable "sum"
         */
        for (int i = 0; i < arr.length; i++) {
            sum = (sum ^ arr[i]);
        }

        /**
         * Do the bitwise & operation with "sum" and its 2's compliment and restore the
         * value in sum
         */
        sum = (sum & -sum);

        /**
         * Declare two variables to store the two distinct elements of the array, and
         * both are initialize by 0
         */
        int ele1 = 0;
        int ele2 = 0;

        // Traverse the array to find the two distinct elements
        for (int i = 0; i < arr.length; i++) {

            /**
             * Now, Doing bitwise & between the current array element and "sum". here we
             * have two posibilities either result > 0 or result == 0.
             * 
             * If the "result > 0", then XOR the current array element with ele1, and store
             * the result into ele1.
             * 
             * else the "result == 0", then XOR the current array element with ele2, and
             * store the result into ele2.
             */
            if ((arr[i] & sum) > 0) {
                ele1 = (ele1 ^ arr[i]);
            } else {
                ele2 = (ele2 ^ arr[i]);
            }
        }

        // Store the two distinct elements into the array
        elements[0] = ele1 < ele2 ? ele1 : ele2;
        elements[1] = ele1 > ele2 ? ele1 : ele2;

        // Return the elements
        return elements;
    }
}