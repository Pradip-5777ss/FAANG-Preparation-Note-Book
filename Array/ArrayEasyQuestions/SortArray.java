/*
 * Write a program to sort the given array
 */
package Array.ArrayEasyQuestions;

import java.util.Arrays;
import java.util.Scanner;

public class SortArray {

	public static void main(String[] args) {

		// Create Scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// Initialize the size into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements
		System.out.println("Enter the array elements :");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// Method call to print the general array
		System.out.println("The general array is : ");
		printArr(arr, size);

		// Method to sort the array
		Arrays.sort(arr);

		// Method call to print the sorted array
		System.out.print("The sorted array is : ");
		printArr(arr, size);
	}

	// Method to print the array
	static void printArr(int arr[], int size) {

		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

}
