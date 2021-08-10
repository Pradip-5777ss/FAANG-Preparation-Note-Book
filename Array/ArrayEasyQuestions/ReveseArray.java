/*
 * Write a program to reverse the array.	
 */
package Array.ArrayEasyQuestions;

import java.util.Scanner;

public class ReveseArray {

	public static void main(String[] args) {

		// Create scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// Initialixe the size into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		//	Method call to reverse the array
		reverseArr(arr);

		//	Method call to print the array
		printArr(arr);
	}

	//	Method to print the array
	private static void printArr(int[] arr) {

		System.out.print("The output array is : ");
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
	}

	//	Method to reverse the array
	private static void reverseArr(int[] arr) {
		
		// Declare two pointers
		int start = 0, end = arr.length - 1;

		// swap the array
		while (start < end) {
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			start++;
			end--;
		}
	}
}