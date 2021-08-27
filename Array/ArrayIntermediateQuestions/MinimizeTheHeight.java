/**
 * Minimize the Heights
 * 
 * Given an array arr[] denoting heights of N towers and a positive integer K, 
 * you have to modify the height of each tower either by increasing or decreasing 
 * them by K only once. After modifying, height should be a non-negative integer. 
 * Find out what could be the possible minimum difference of the height of shortest
 * and longest towers after you have modified each tower.
 * 
 * Example:
 *      Input: K = 2, N = 4
 *             Arr[] = {1, 5, 8, 10}
 *      Output: 5
 * Explanation: The array can be modified as {3, 3, 6, 8}. The difference between 
 * the largest and the smallest is 8-3 = 5.
 */
package Array.ArrayIntermediateQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class MinimizeTheHeight {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the elements of the array
        System.out.println("Enter the elements of the array");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Ask user to enter the number
        System.out.println("Enter the number : ");
        int num = sc.nextInt();

        sc.close();

        // Method call to find the minimum difference and print the output
        System.out.println("The possible minimum difference of height is : " + getMinDiff(arr, size, num));
    }

    // Method to find the minimum difference of the height
    private static int getMinDiff(int[] arr, int n, int k) {

        // If the array is not sorted then sorted it
        Arrays.sort(arr);

        // Declare variables and store the maximum and minimum value of the array
        int max = arr[n - 1];
        int min = arr[0];

        // Find the difference between the maximum and minimum element
        int ans = max - min;

        // Run a loop through the array
        for (int i = 1; i < n; i++) {
            if (arr[i] >= k) {

                /**
                 * Add the user given number with the ith element of the array and substract the
                 * user given number with the last element of the array and Find the maximum
                 * between these elements
                 */
                max = Math.max(arr[i - 1] + k, arr[n - 1] - k);

                /**
                 * Add the user given number with the 0th element of the array and substract the
                 * user given number with the ith element of the array and find the minimum
                 * between these elements
                 */
                min = Math.min(arr[0] + k, arr[i] - k);

                /**
                 * Find the minimum between the previous maximum and minimum element and the
                 * current maximum and minimum element
                 */

                ans = Math.min(ans, max - min);
            }
        }

        // Return the answer
        return ans;
    }
}