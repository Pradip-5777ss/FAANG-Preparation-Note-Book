/**
 * Missing number in array.
 * Given an array of size N-1 such that it only contains distinct 
 * integers in the range of 1 to N. Find the missing element.
 * 
 * Example:
 * 		Input:	N = 5	
 * 				A[] = {1,2,3,5}
 * 		Output: 4
 */
package Array.EasyQuestions;

import java.util.Scanner;

public class FindMissingNumber {

	public static void main(String[] args) {

		// create the scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array.
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();

		// initialize the size into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements.
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();

		// method call to find the missing number.
		int missNo = missingNumber(arr, size);

		// printing statement
		System.out.println("The missing number is = " + missNo);

	}

	// Method to find the missing number
	static int missingNumber(int arr[], int size) {

		// Declare the variable
		int i, total;

		// Find total of all the array elements
		total = (size + 1) * (size + 2) / 2;

		// Iterate a loop to find the missing number in the array
		for (i = 0; i < size; i++) {

			/**
			 * We subtract the array element from total and store it in total for the next
			 * iteration.
			 */
			total = total - arr[i];
		}

		return total;
	}
}