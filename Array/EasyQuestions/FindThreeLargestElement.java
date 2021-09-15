/**
 * Find largest three elements.
 * Given an array with all distinct elements, find the largest three elements. 
 * Expected time complexity is O(n) and extra space is O(1).
 * 
 * Example:
 * 		Input: arr[] = {10, 4, 3, 50, 23, 90}
 * 		Output: 90, 50, 23
 */
package Array.EasyQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class FindThreeLargestElement {

	public static void main(String[] args) {

		// create scanner class to take user input
		Scanner sc = new Scanner(System.in);

		// ask user to enter the size of the array & initialize it in variable name size
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();

		// initialize the size value into the array
		int arr[] = new int[size];

		// ask user to enter the array elements & iterate for loop to take user input
		System.out.println("Enter the array elements ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();

		// printing statement
		System.out.println("The three largest elements are = ");

		// method call
		threeLargestElement(arr, size);
	}

	// method to find the three largest element in the array
	static void threeLargestElement(int arr[], int size) {
		// Sort the unsorted array
		Arrays.sort(arr);

		// declare two variables
		int check = 0, count = 1;

		// Iterate a loop to find the largest three element
		for (int i = 1; i <= size; i++) {

			// Check the count is less then 4 or not
			if (count < 4) {

				if (check != arr[size - i]) {
					System.out.println(arr[size - i] + " ");
					check = arr[size - i];
					count++;
				}
			} else {
				break;
			}
		}
	}
}
