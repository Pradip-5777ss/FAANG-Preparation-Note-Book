/**
 * Second Largest Element
 * 
 * Given an array Arr of size N, print second largest element from an array.
 * 
 * Example 1:
 *  Input: 
 *          N = 6
 *          Arr[] = {12, 35, 1, 10, 34, 1}
 *  Output: 34
 *  Explanation: The largest element of the array is 35 and the second largest element is 34.
 * 
 * Example 2:
 *  Input: 
 *          N = 3
 *          Arr[] = {10, 5, 10}
 *  Output: 5
 *  Explanation: The largest element of the array is 10 and the second largest element is 5.
 * 
 * Time Complexity: O(N)
 * Auxiliary Space: O(1)
 */
package Array.EasyQuestions;

import java.util.Scanner;

public class SecondLargestElement {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.println("Enter the number of elements in the array : ");
        int n = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[n];

        // Ask user to enter the elements of the array
        System.out.println("enter the elements of the array : ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        // Method call to find the second largest element from an array
        int ans = secondLargest(arr);

        // Print the result
        System.out.println("The second largest element in array is : " + ans);
    }

    // Method to find the second largest element from an array
    private static int secondLargest(int[] arr) {

        // Store the size of the array
        int n = arr.length;

        // Declare two variables to store the largest and second largest element
        int first, second;

        // If the size of the array is less than 2 then return -1
        if (n < 2) {
            return -1;
        }

        // Initialize first and second by "Integer.MIN_VALUE"
        first = second = Integer.MIN_VALUE;

        // Traverse the array
        for (int i = 0; i < n; i++) {

            /**
             * If the current element in array say,'arr[i]' is greater than first, then
             * update both first and second.
             */
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            }
            /**
             * If the current element in array say,'arr[i]' is in between first and second,
             * then update second
             */
            else if (arr[i] > second && arr[i] != first) {
                second = arr[i];
            }
        }

        // Rerturn the second value
        if (second == Integer.MIN_VALUE) {
            return -1;
        } else {
            return second;
        }
    }
}