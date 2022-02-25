/**
 * Minimum distance between two numbers.
 * 
 * You are given an array A, of N elements. Find minimum index based distance between two elements of the array, x and y.
 * 
 * Example 1:
 *  Input:
 *      N = 4
 *      A[] = {1,2,3,2}
 *      x = 1, y = 2
 *  Output: 1
 *  Explanation: x = 1 and y = 2. There are two distances between x and y, which are 1 and 3 out of which the least is 1.
 * 
 * Example 2:
 *  Input:
 *      N = 7
 *      A[] = {86,39,90,67,84,66,62}
 *      x = 42, y = 12
 *  Output: -1
 *  Explanation: x = 42 and y = 12. We return -1 as x and y don't exist in the array.
 * 
 * Time Complexity: O(N)
 * Auxiliary Space: O(1)
 */
package Array.EasyQuestions;

import java.util.Scanner;

public class MinimumDistanceBetweenTwoNumbers {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the elements of the array
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Ask user to enter the two elements for find distance
        System.out.println("Enter two elements : ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        sc.close();

        // Method call to find the distance and print the result
        System.out.println("The minimum distance between two elements is : " + minimumDistance(arr, x, y));
    }

    // Method to find the minimum distance
    private static int minimumDistance(int[] arr, int x, int y) {

        // Find the length of the array
        int n = arr.length;

        /**
         * For find distance between two element we take two variable and initialize it
         * by -1
         */
        int distance1 = -1;
        int distance2 = -1;

        // Declare variable to store the result
        int res = Integer.MAX_VALUE;

        // Traverse the array
        for (int i = 0; i < n; i++) {

            // If the first element is found then store the index in distance1
            if (arr[i] == x) {
                distance1 = i;
            }

            // If the second element is found then store the index in distance2
            if (arr[i] == y) {
                distance2 = i;
            }

            // When the both distance are found then find the minimum and store in res
            if (distance1 != -1 && distance2 != -1) {
                res = Math.min(res, Math.abs(distance1 - distance2));
            }
        }

        // Return the result
        if (distance1 == -1 || distance2 == -1) {
            return -1;
        } else {
            return res;
        }
    }
}