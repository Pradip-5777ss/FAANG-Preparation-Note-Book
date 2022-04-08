/**
 * @author Pradip Sahoo
 * Created on 08/04/2022
 * ------------------------
 * Minimum swaps required to bring all elements less than or equal to k together.
 * Given an array of n positive integers and a number k. Find the minimum number
 * of swaps required to bring all the numbers less than or equal to k together.
 * 
 * Example 1:
 *  Input : arr[] = {2, 1, 5, 6, 3}
 *          k = 3
 *  Output: 1
 *  Explanation : To bring elements 2, 1, 3 together, swap element '5' with '3' 
 *                such that final array will be- arr[] = {2, 1, 3, 6, 5}
 * 
 * Example 2:
 *  Input : arr[] = {2, 7, 9, 5, 8, 7, 4}
 *          k = 5
 *  Output: 2
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Medium_Questions;

import java.util.Scanner;

public class Q32_MinSwapsToAllElementsAndKTogether {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the value of k : ");
        int k = sc.nextInt();

        sc.close();

        System.out.println("Minimum swaps required is : " + minSwapsRequired(arr, k));
    }

    private static int minSwapsRequired(int[] arr, int k) {

        // Find count of elements which are less than equals to k
        int count = 0;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] <= k) {
                ++count;
            }
        }

        // Find unwanted elements in current window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; ++i) {
            if (arr[i] > k) {
                ++bad;
            }
        }

        // Initialize answer with 'bad' value of current window
        int ans = bad;
        for (int i = 0, j = count; j < arr.length; ++i, ++j) {

            // Decrement count of previous window
            if (arr[i] > k) {
                --bad;
            }

            // Increment count of current window
            if (arr[j] > k) {
                ++bad;
            }

            // Update ans if count of 'bad' is less in current window
            ans = Math.min(ans, bad);
        }
        return ans;
    }
}