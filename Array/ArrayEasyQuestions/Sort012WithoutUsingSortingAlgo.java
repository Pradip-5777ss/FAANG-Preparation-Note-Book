/*
 * Given an array which consists of only 0, 1 and 2. Sort the array without using any sorting algorithm.	
 */
package Array.ArrayEasyQuestions;

import java.util.Scanner;

public class Sort012WithoutUsingSortingAlgo {

	public static void main(String[] args) {

		// Create scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// Initialize the size into the array
		int arr[] = new int[size];

		// Run a loop to take user input for the array elements
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// method call to Sort Array
		sortArr(arr, size);

		System.out.print("After sorting the array is : ");
		// method call to print the array
		printArr(arr, size);
	}

	// method for sorting the array.
	static void sortArr(int arr[], int size) {

		/**
		 * Using Two pointer method. start pointer points to first index of the array
		 * and end pointer points to the last index of the array. position points to
		 * first index of the array
		 */
		int start = 0, end = size - 1, pos = 0;
		while (pos <= end) {

			/**
			 * If the element of a particular position is 0 then swap it with first index
			 * element of the array. And increment start and position pointer.
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

	// method to print the sorted array
	static void printArr(int arr[], int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
