/*
 * 	Move all the negative elements to one side of the array.
 */
package Array.EasyQuestions;

import java.util.Scanner;

public class MoveAllNegetiveElementsOneSide {

	public static void main(String[] args) {

		// create scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// initialize the size into the array
		int arr[] = new int[size];

		// Run a loop to take user input for the array elements
		System.out.println("Enter the array elemrnts : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// method call to rearrange the array elements
		rearrange(arr, size);

		// Method call to print the sorted array
		System.out.print("The sorted array is : ");
		printArr(arr, size);

	}

	// method to rearrange the array elements
	static void rearrange(int arr[], int size) {
		int i, j = 0, temp;
		for (i = 0; i < size; i++) {
			if (arr[i] < 0) {
				if (i != j) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j++;
			}
		}
	}

	// method to print the array elements
	static void printArr(int arr[], int size) {
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
