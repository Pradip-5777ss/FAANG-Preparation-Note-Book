/**
 * Rearrange array alternatively.
 * Rearrange the array in alternating positive and negative	items with O(1) extra space.
 * 
 * Example:
 * 		Input :	arr[] = {-2, 3, 4, -1}
 * 		Output : arr[] = {-2, 3, -1, 4} OR {-1, 3, -2, 4}
 * 
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */

package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class RearrangeArrayAlternatively {

	public static void main(String[] args) {

		// Create Scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array
		System.out.println("emter the size of the array : ");
		int size = sc.nextInt();

		// Initialize the size into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements
		System.out.println("Enter the array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();

		// Print the given array
		System.out.println("given array is : ");
		printArray(arr);

		// Method call to rearrange the array alternatively
		rearrange(arr, size);

		// Print the rearrange array
		System.out.println("the rearrange array is : ");
		printArray(arr);
	}

	/**
	 * Function to rearrange positive and negative integers in alternate fashion.
	 * The below solution doesn't maintain original order of elements
	 * 
	 * @param arr
	 * @param size
	 */
	static void rearrange(int arr[], int size) {

		int i = 0, j = size - 1;

		// shift all negative values to the end
		while (i < j) {
			while (i <= size - 1 && arr[i] > 0) {
				i++;
			}

			while (j >= 0 && arr[j] < 0) {
				j--;
			}

			if (i < j) {
				swap(arr, i, j);
			}
		}

		// i has index of leftmost negative element
		if (i == 0 || i == size)
			return;

		/**
		 * start with first positive element at index 0
		 * 
		 * Rearrange array in alternating positive & negative items
		 */
		int k = 0;
		while (k < size && i < size) {

			// swap next positive element at even position from next negative element.
			swap(arr, k, i);
			i = i + 1;
			k = k + 2;
		}
	}

	// Method to print the array
	static void printArray(int arr[]) {
		for (int i : arr) {
			System.out.println(i + " ");
		}
		System.out.println();
	}

	// Method to swap the array
	static void swap(int arr[], int index1, int index2) {
		int c = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = c;
	}

}
