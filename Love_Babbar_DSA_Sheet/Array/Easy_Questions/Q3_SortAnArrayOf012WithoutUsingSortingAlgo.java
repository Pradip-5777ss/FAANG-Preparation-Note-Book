/**
 * Sort an array of 0s, 1s and 2s.
 * Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
 * 
 * Example 1:
 *  Input: 
 *      N = 5
 *      arr[]= {0 2 1 2 0}
 *  Output: 0 0 1 2 2
 *  Explanation: 0s 1s and 2s are segregated into ascending order.
 * 
 * Example 2:
 *  Input: 
 *      N = 3
 *      arr[] = {0 1 0}
 *  Output: 0 0 1
 * Explanation: 0s 1s and 2s are segregated into ascending order.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.Scanner;

public class Q3_SortAnArrayOf012WithoutUsingSortingAlgo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        sortArrOf012(arr);
        System.out.print("After sorting the array is : ");
        printArr(arr);
    }
    
    // Method to sort the array
    private static void sortArrOf012(int[] arr) {
        /**
         * Using Two pointer method. "start" pointer points to first index of the array
         * and "end" pointer points to the last index of the array. "position" points to
         * first index of the array
         */
        int start = 0, end = arr.length - 1, pos = 0;
        while (pos <= end) {

            /**
             * If the element of a particular position is 0 then swap it with start
             * index of the array. And increment start and position pointer.
             */
            if (arr[pos] == 0) {
                int temp = arr[start];
                arr[start] = arr[pos];
                arr[pos] = temp;
                start++;
                pos++;
            }
            /**
             * If the element of a particular position is 1 then increment the position
             */
            else if (arr[pos] == 1) {
                pos++;
            }
            /**
             * If the element of a particular position is 2 then swap it with last index
             * element of the array. and decrement end pointer.
             */
            else {
                int temp = arr[pos];
                arr[pos] = arr[end];
                arr[end] = temp;
                end--;
            }
        }
    }

    // Method to print the array
    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}