/*
 * Write a program to cyclically rotate an array by one.
 */

package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class Question2 {

	public static void main(String[] args) {

		// create scanner class to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array & save it in variable name "size".
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// initialize the size value into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements and run a loop to take user input
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// print the original array elements before rotating.
		System.out.print("The original array is : ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();

		// method call
		cyclicallyRotate(arr, size);
	}

	// method definition for array cyclic rotate
	static void cyclicallyRotate(int arr[], int size) {
		// declare the variable
		int last;

		// initialize the variable by "arr[size-1]" value
		last = arr[size - 1];

		// iterate the for loop from "size-1" to 0
		for (int i = size - 1; i > 0; i--) {
			/**
			 * "arr[i-1]" value is stored in arr[i].[i.e suppose the size of the array is 6.
			 * then arr[4] value is store into arr[5]
			 */
			arr[i] = arr[i - 1];
		}

		// the "last" variable value is stored into arr[0]
		arr[0] = last;

		// printing statement
		// print the rotated array.
		System.out.print("The rotated array is : ");
		{
			for (int i = 0; i < size; i++) {
				System.out.print(arr[i] + " ");
			}
		}
	}
}