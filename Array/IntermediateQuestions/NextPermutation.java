/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
 * The replacement must be in place and use only constant extra memory.
 */
package Array.IntermediateQuestions;

import java.util.Scanner;

public class NextPermutation {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int arr[] = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        // Method call to find next permutation
        nextPerutation(arr);

        // Print the final output array
        System.out.print("The output array is : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Method to find next permutation
    private static void nextPerutation(int[] arr) {

        // When the array is null or length is less than 1 then return that array
        if (arr == null || arr.length <= 1) {
            return;
        }

        int i = arr.length - 2;

        /**
         * We traverse the array from right side and check that the last element is
         * smaller than the previous of last element or not if condition true then
         * decrement the pointer
         */
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Now we find the just greater element from the ith index element and swap them
        if (i >= 0) {
            int j = arr.length - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }

        // Finally reverse the array from (i+1) to last element
        reverse(arr, i + 1, arr.length - 1);
    }

    // Method to swap the elements of the array
    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Method to reverse the array
    public static void reverse(int[] arr, int i, int j) {
        while (i < j) {
            swap(arr, i++, j--);
        }
    }
}
