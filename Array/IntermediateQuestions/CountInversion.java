/**
 * Given an array of integers. Find the Inversion Count in the array. 
 * Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If array is already
 * sorted then the inversion count is 0. If an array is sorted in the reverse order then the inversion count is the maximum
 * Formally, two elements a[i] and a[j] form an inversion if a[i] > a[j] and i < j.
 * 
 * Example :
 * Input: N = 5, arr[] = {2, 4, 1, 3, 5}
 * Output: 3
 * Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
 */
package Array.IntermediateQuestions;

import java.util.Scanner;

public class CountInversion {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // Method call to count the inversion and print the result
        System.out.println("The result is : " + mergeSortAndCount(arr, 0, size - 1));
    }

    private static int mergeSortAndCount(int[] arr, int left, int right) {

        int count = 0;
        /*
         * First check that, left is smaller than the right or not, if this condition is
         * true, then we have to find the mid of the array
         */
        if (left < right) {
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

        // Declare a variable to find the size of the left subarray
        int n1 = mid - left + 1;

        // Initialize the size of the left subarray into a temporary Left subarray
        int L[] = new int[n1];

        // Declare a variable to find the size of the right subarray
        int n2 = right - mid;

        // Initialize the size of the right subarray into a temporary right subarray
        int R[] = new int[n2];

        // Copy the original left subarray elements into the temporary Left subarray
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        // Copy the original right subarray elements into the temporary Right subarray
        for (int j = 0; j < n2; j++) {
            R[j] = arr[mid + 1 + j];
        }

        // Declare a variable to count the inversion
        int inversion = 0;

        // Initialize the indexes of the left & right subarray
        int i = 0, j = 0;

        // Initialize the index of the merge array
        int k = left;

        /*
         * Now check, the size of the left & right subarray is greatter than the index
         * of the left & right subarray or not. If this condition is true then we check,
         * in the left sorted subarray the ith index value is less than equal to the
         * right sorted subarray jth index value or not. If this condition is ture then
         * we take the element of the given index of the left subarray and place it in
         * the new array & increment i value. otherwise, we take the element of the
         * given index of the right subarray and place it in the new array & increment j
         * value. And finally increment k value.
         */
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                inversion += (n1 - i);
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /*
         * If the right subarray is exhausted then we copy all the elements of left
         * subarray
         */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        /*
         * If the left subarray is exhausted then we copy all the elements of the right
         * subarray
         */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

        return inversion;
    }
}