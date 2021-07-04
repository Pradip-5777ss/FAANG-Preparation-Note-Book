package sorting;

import java.util.Scanner;

public class SelectionSort {

	public static void main(String[] args) {

		// Create a scanner class to take user input
		Scanner scanner = new Scanner(System.in);

		// Ask user to enter the size of the array
		System.out.println("Enter the size of the array : ");
		int size = scanner.nextInt();

		// Initialize the size into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements & iterate for loop to take user input
		System.out.println("Enter the array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}

		// Call the method for sort the array using selection sort
		selectionSort(arr, size);

		// Call the method to print the sorted array
		printArr(arr, size);
	}

	// Method definition to print the array
	private static void printArr(int[] arr, int size) {

		System.out.print("After sorting the array is : ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	// Method definition to sort the array
	private static void selectionSort(int[] arr, int size) {

		// Declare a variable to hold the minimum index of the array
		int min_Index;

		// Outer loop, It runs from 0 to size-1 of the array
		for (int i = 0; i < size - 1; i++) {

			// Initialize the variable with the value of i
			min_Index = i;

			// Inner loop, It runs from i+1 to the size of the array
			for (int j = i + 1; j < size; j++)

				/*
				 * Now check, min_Index value is greater than the j value or not. If it is true,
				 * then we update the min_Index value with the value of j index.
				 */
				if (arr[j] < arr[min_Index]) {
					min_Index = j;
				}

			/*
			 * Now check, the min_Index value is not equal to the value of i. If it is true,
			 * then we swap the value of arr[min_Index] with the value of arr[i].
			 */
			if (min_Index != i) {
				int temp = arr[min_Index];
				arr[min_Index] = arr[i];
				arr[i] = temp;
			}
		}
	}
}