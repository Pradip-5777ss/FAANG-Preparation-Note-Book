/*
 * Write a program to find the minimum and maximum element in the array.
 */
package Array.ArrayEasyQuestions;

import java.util.Scanner;

public class FindMinMaxOfAnArray {

	public static void main(String[] args) {

		// create scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// Initialize the size into the array
		int arr[] = new int[size];

		// Run a loop to take enter the array elements from the user
		System.out.println("Enter the array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// Method call to find the maximum and minimum of the array
		findMinAndMax(arr);
	}

	// Method to find the maximum and minimum of the array
	private static void findMinAndMax(int[] arr) {

		// Declare two variables
		int min, max;

		// Both are initialize by the 0th index element of the array
		min = max = arr[0];

		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > max) {
				max = arr[i];
			}
			else if (arr[i] < min) {
				min = arr[i];
			}
		}

		// Print the maximum and minimum element of the array
		System.out.println("The minimum element is : " + min);
		System.out.println("The maximum element is : " + max);
	}
}