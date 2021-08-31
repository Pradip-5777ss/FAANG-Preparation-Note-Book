/**
 * Merge Without Extra Space 
 * 
 * Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order.
 * Merge them in sorted order without using any extra space. Modify arr1 so that it 
 * contains the first N elements and modify arr2 so that it contains the last M elements.
 * 
 * Example : 
 *      Input: 
 *          n = 4, arr1[] = [1 3 5 7] 
 *          m = 5, arr2[] = [0 2 6 8 9]
 *      Output: 
 *          arr1[] = [0 1 2 3] 
 *          arr2[] = [5 6 7 8 9]
 * 
 * Explanation: After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
 */
package Array.ArrayIntermediateQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class MergeWithoutExtraSpace {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the first array
        System.out.print("Enter the size of the first array : ");
        int size1 = sc.nextInt();

        // Initialize the size into the array
        int arr1[] = new int[size1];

        // Ask user to enter the first array elements
        System.out.println("Enter the first array elements");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        // Ask user to enter the size of the second array
        System.out.print("Enter the size of the second array : ");
        int size2 = sc.nextInt();

        // Initialize the size into the array
        int arr2[] = new int[size2];

        // Ask user to enter the second array elements
        System.out.println("Enter the second array elements");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }
        sc.close();

        // Method call to merge two arrays without using extra space
        mergeWithoutExtraSpace(arr1, arr2);

        // Print the first array
        System.out.print("The first array is : ");
        printArr(arr1);

        // Print the second array
        System.out.print("The second array is : ");
        printArr(arr2);

        StringBuffer str = new StringBuffer();

        for (int i = 0; i < size1; i++) {
            str.append(arr1[i] + " ");
        }

        for (int i = 0; i < size2; i++) {
            str.append(arr2[i] + " ");
        }

        // Print the final array after merging
        System.out.println("After merging two arrays the output array is : " + str);
    }

    // Method to print the array
    private static void printArr(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Method to merge arrays without using extra space
    private static void mergeWithoutExtraSpace(int[] arr1, int[] arr2) {

        // Use two pointer
        int i = arr1.length - 1, j = 0;

        /**
         * Iterate through every element of arr1 & arr2 using two pointer
         */
        while (i >= 0 && j < arr2.length) {

            /**
             * If the first array element is greater than the second array element then swap
             * them & decrement i and increment j.
             */
            if (arr1[i] > arr2[j]) {
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
                i--;
                j++;
            } else {
                break;
            }
        }

        // Sort two arrays
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
}