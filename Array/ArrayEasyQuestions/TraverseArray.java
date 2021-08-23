/**
 * Create an Array of size 10 of integers. Take input from the user 
 * for these 10 elements and print the entire array after that.
 */
package Array.ArrayEasyQuestions;

import java.util.Scanner;

public class TraverseArray {

	public static void main(String[] args) {

		// create scanner class for taking user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// Initialize the size into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements
		System.out.println("Enter the array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		// Print the array
		System.out.println("The array elemets are : ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
		sc.close();
	}
}
