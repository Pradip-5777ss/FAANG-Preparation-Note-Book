/**
 * Binary Search 
 * 
 * Given a sorted array of size N and an integer K, find the position at which K is present in the array using binary search.
 * 
 * Example 1:
 *  Input:
 *      N = 5
 *      arr[] = {1 2 3 4 5} 
 *      K = 4
 *  Output: 3
 *  Explanation: 4 appears at index 3.
 * 
 * Example 2:
 *  Input:
 *      N = 5
 *      arr[] = {11 22 33 44 55} 
 *      K = 445
 *  Output: -1
 *  Explanation: 445 is not present.
 * 
 * Time Complexity: O(LogN)
 * Auxiliary Space: O(LogN) if solving recursively and O(1)
 */
package Array.EasyQuestions;

import java.util.Scanner;

public class FindElementUsingBinarySearch {

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

        // Ask user to enter the element which we want to search
        System.out.println("Enter the element which we want to search : ");
        int k = sc.nextInt();

        sc.close();

        // Mwthod call to find the key element using binary search
        int ans = findElementBinarySearch(arr, k);
        System.out.println("The element " + k + " is present at position " + ans + " in the array");
    }

    // Method to find the key element
    private static int findElementBinarySearch(int[] arr, int k) {

        // Find the size of the array
        int n = arr.length;

        // Declare two pointers, start is initialize by 0 and end is initialize by n-1
        int start = 0;
        int end = n - 1;

        // Run a loop until the element is not found
        while (start <= end) {

            // Find the middle element of the array
            int mid = start + (end - start) / 2;

            /**
             * If the key element is equal to the middle element of the array then return
             * middle element.
             * 
             * If the key element is greater than the middle element of array, then move the
             * start pointer.
             * If the key element is less than the middle element of array, then move the
             * end pointer.
             */
            if (mid == k) {
                return mid;
            } else if (k > arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}