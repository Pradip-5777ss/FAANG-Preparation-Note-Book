/**
 * Swap kth elements.
 * 
 * Given an array Arr of size N, swap the Kth element from beginning with Kth element from end.
 * 
 * Example 1:
 *  Input:
 *      N = 8, K = 3
 *      Arr[] = {1, 2, 3, 4, 5, 6, 7, 8}
 *  Output: 1 2 6 4 5 3 7 8
 * Explanation: Kth element from beginning is 3 and from end is 6.
 * 
 * Example 2:
 *  Input:
 *      N = 5, K = 2
 *      Arr[] = {5, 3, 6, 1, 2}
 *  Output: 5 1 6 3 2
 * Explanation: Kth element from beginning is 3 and from end is 1.
 * 
 * Time Complexity: O(1)
 * Auxiliary Space: O(1)
 */
package Array.EasyQuestions;

import java.util.Scanner;

public class SwapKthElements {

    public static void main(String[] args) {

        // Create scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the elements of the array
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        // Ask user to enter the kth position element
        System.out.print("Enter the position of the element which we want to swap from begining and end : ");
        int position = sc.nextInt();

        sc.close();

        // Method call to swap the kth element
        swapKthElement(arr, position);

        // Print the result
        System.out.println("After swapping the array is : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Method to swap the kth element
    private static void swapKthElement(int[] arr, int k) {

        // Find the length of the array
        int n = arr.length;

        // swap the elements
        int temp = arr[n - k];
        arr[n - k] = arr[k - 1];
        arr[k - 1] = temp;
    }
}