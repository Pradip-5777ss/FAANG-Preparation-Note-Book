/**
 * @author Pradip Sahoo
 * Created on 05/04/2022
 * --------------------------
 * Maximum Product Subarray.
 * Given an array Arr[] that contains N integers(May be positive, negetive or
 * zero). Find the product of the maximum product subarray.
 * 
 * Example 1:
 *  Input:  N = 5
 *          Arr[] = {6, -3, -10, 0, 2}
 *  Output: 180
 *  Explanation: Subarray with maximum product is [6, -3, -10] which gives product as 180.
 * 
 * Example 2:
 *  Input:  N = 6
 *          Arr[] = {2, 3, 4, 5, -1, 0}
 *  Output: 120
 *  Explanation: Subarray with maximum product is [2, 3, 4, 5] which gives product as 120.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Medium_Questions;

import java.util.Scanner;

public class Q27_MaximumProductSubarray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        System.out.println("The maximum product of the subarray is : " + subarrayMaxProduct(arr));
    }

    /**
     * Method to find the maximum product of the subarray
     */
    private static int subarrayMaxProduct(int[] arr) {

        /**
         * Variables to store maximum and minimum product till ith index.
         */
        int minVal = arr[0];
        int maxVal = arr[0];

        int maxProduct = arr[0];

        // Traverse the array from index 1
        for (int i = 1; i < arr.length; i++) {

            /**
             * When multiplied by -ve number, maxVal becomes minVal and minVal becomes
             * maxVal.
             */

            if (arr[i] < 0) {
                int temp = maxVal;
                maxVal = minVal;
                minVal = temp;
            }

            /**
             * maxVal and minVal stores the product of subarray ending at arr[i].
             */
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            // Max Product of array.
            maxProduct = Math.max(maxProduct, maxVal);
        }

        // Return maximum product found in array.
        return maxProduct;
    }
}