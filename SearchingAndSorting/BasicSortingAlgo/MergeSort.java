package SearchingAndSorting.BasicSortingAlgo;

import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {

		// Create Scanner class to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();

		// Initialize the size into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements & iterate for loop to take user input
		System.out.println("Enter the array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();

		// Call the method
		mergeSort(arr, size, 0, size - 1);

		// Call the print method
		printArr(arr, size);
	}

	// method definition to print the sorted array
	private static void printArr(int[] arr, int size) {

		System.out.print("After sorting the array is : ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	// mergesort method definition
	private static void mergeSort(int[] arr, int size, int left, int right) {

		/*
		 * First check that, left is smaller than the right or not, if this condition is
		 * true, then we have to find the mid of the array
		 */
		if (left < right) {
			int mid = left + (right - left) / 2;

			// Recursively call the function from the left side to the middle of the array
			mergeSort(arr, size, left, mid);

			// Recursively call the function from the mid to the right of the array
			mergeSort(arr, size, mid + 1, right);

			// method call to merge the two sorted array
			merge(arr, size, left, mid, right);
		}
	}

	// method definition
	private static void merge(int[] arr, int size, int left, int mid, int right) {

		// Declare a variable to find the size of the left subarray
		int n1 = mid - left + 1;

		// Initialize the size of the left subarray into a temporary Left subarray
		int L[] = new int[n1];

		// Copy the original left subarray elements into the temporary Left subarray
		for (int i = 0; i < n1; i++) {
			L[i] = arr[left + i];
		}

		// Declare a variable to find the size of the right subarray
		int n2 = right - mid;

		// Initialize the size of the right subarray into a temporary right subarray
		int R[] = new int[n2];

		// Copy the original right subarray elements into the temporary Right subarray
		for (int j = 0; j < n2; j++) {
			R[j] = arr[mid + 1 + j];
		}

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
	}

}
