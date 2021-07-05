/**
 * Check whether n is present in an	array of size m	or not
 */
package Array.ArrayBasicQuestions;

import java.util.Scanner;

class Question2 {

	public static void main(String[] args) {

		// Scanner class to take user input
		Scanner sc = new Scanner(System.in);

		try {
			// Ask user to enter the size of the array
			System.out.print("Enter the size of the array : ");
			int size = sc.nextInt();

			// Initialize the size into the array
			int arr[] = new int[size];

			// Declare a variable
			int i;

			// Ask user to enter the array elements
			System.out.println("Enter the array elements");
			for (i = 0; i < size; i++) {
				arr[i] = sc.nextInt();
			}

			// Ask user to enter the key elements
			System.out.println("Enter the key element : ");
			int key = sc.nextInt();

			/**
			 * Run a loop and check the key element is present in the loop or not
			 */
			for (i = 0; i < size; i++) {
				if (key == arr[i]) {
					System.out.println("The element is present in the array at " + i + " position");
				}
			}

			// If thr key element is equal to the size of the array
			if (key == size) {
				System.out.println("The element is not present in the array");
			}
		} finally {
			sc.close();
		}
	}
}