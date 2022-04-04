/**
 * @author Pradip Sahoo
 * Created on 05/04/2022
 * --------------------------------
 * Count Inversions
 * Given an array of integers. Find the Inversion Count in the array. 
 * 
 * Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already
 * sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 * 
 * Example 1:
 *  Input:  N = 5
 *          arr[] = {2, 4, 1, 3, 5}
 *  Output: 3
 *  Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 * 
 * Example 2:
 *  Input:  N = 5
 *          arr[] = {2, 3, 4, 5, 6}
 *  Output: 0
 *  Explanation: As the sequence is already sorted so there is no inversion count.
 * 
 * Example 3:
 *  Input:  N = 3, 
 *          arr[] = {10, 10, 10}
 *  Output: 0
 *  Explanation: As all the elements of array are same, so there is no inversion count.
 * 
 * Time Complexity : O(NlogN)
 * Spcae Complexity : O(N)
 */
package Love_Babbar_DSA_Sheet.Array.Medium_Questions;

import java.util.Arrays;
import java.util.Scanner;

public class Q24_CountInversion {

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

        System.out.print("The result is : " + mergeSortAndCount(arr, 0, size - 1));
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {

        int count = 0;

        if (left < right) {

            // Find the mid of the array
            int mid = left + (right - left) / 2;

            // Recursively call the function from the left side to the middle of the array
            count += mergeSortAndCount(arr, left, mid);

            // Recursively call the function from the mid to the right of the array
            count += mergeSortAndCount(arr, mid + 1, right);

            // method call to merge the two sorted array
            count += mergeAndCount(arr, left, mid, right);
        }
        return count;
    }

    private static int mergeAndCount(int[] arr, int left, int mid, int right) {

        // Left subarray
        int left_Subarray[] = Arrays.copyOfRange(arr, left, mid + 1);

        // Right subarray
        int right_Subarray[] = Arrays.copyOfRange(arr, mid + 1, right + 1);

        // Declare a variable to count the inversion
        int count_inversion = 0;

        // Initialize the indexes of the left & right subarray
        int i = 0, j = 0;

        // Initialize the index of the merge array
        int k = left;

        /**
         * Using two pointers over the array which helps in storing the smaller element
         * and thus merging the subarray
         */
        while (i < left_Subarray.length && j < right_Subarray.length) {
            /**
             * Comparing element of the array at pointers i and j and accordingly storing
             * the smaller element and updating the pointers
             */
            if (left_Subarray[i] <= right_Subarray[j]) {
                arr[k++] = left_Subarray[i++];
            } else {
                arr[k++] = right_Subarray[j++];

                /**
                 * Adding the inversions which is the number of elements which are smaller than
                 * arr[j] in the left half of the array
                 */
                count_inversion += (mid + 1) - (left + i);
            }
        }

        /*
         * If the right subarray is exhausted then we copy all the elements of left
         * subarray
         */
        while (i < left_Subarray.length) {
            arr[k++] = left_Subarray[i++];
        }

        /*
         * If the left subarray is exhausted then we copy all the elements of the right
         * subarray
         */
        while (j < right_Subarray.length) {
            arr[k++] = right_Subarray[j++];
        }

        return count_inversion;
    }
}