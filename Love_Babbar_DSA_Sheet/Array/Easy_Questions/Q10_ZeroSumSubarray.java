/**
 * @author Pradip Sahoo
 * Created on 05/04/2022
 * -------------------------
 * Subarray with 0 sum
 * Given an array of positive and negative numbers. Find if there is a subarray (of size at-least one) with 0 sum.
 * 
 * Example 1:
 *  Input:  5
 *          arr[] = 4 2 -3 1 6
 *  Output: Yes
 * Explanation: 2, -3, 1 is the subarray with sum 0.
 * 
 * Example 2:
 *  Input:  5
 *          arr[] = 4 2 0 1 6
 *  Output: Yes
 *  Explanation: 0 is one of the element in the array so there exist a subarray with sum 0.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(N)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.HashMap;
import java.util.Scanner;

public class Q10_ZeroSumSubarray {

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
        System.out.print("Output : ");
        System.out.print(findZeroSumSubarray(arr) == true ? "Yes" : "NO");
    }

    // Method to find the zero sum subarray
    private static boolean findZeroSumSubarray(int[] arr) {

        // Using Hashmap to store the prefix sum which has appeared already.
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        int sum = 0;

        // Iterating over the array.
        for (int i = 0; i < arr.length; i++) {

            // storing prefix sum.
            sum += arr[i];

            /**
             * if prefix sum is 0 or if it is already present in Hashmap then it is repeated
             * which means there is a subarray whose summation is 0, so we return true.
             */
            if (sum == 0 || hM.get(sum) != null)
                return true;

            // storing every prefix sum obtained in Hashmap.
            hM.put(sum, i);
        }
        // returning false if we don't get any subarray with 0 sum.
        return false;
    }
}