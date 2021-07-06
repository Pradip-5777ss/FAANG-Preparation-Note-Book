/*
 * Find	all	pairs	on	integer	array	whose	sum	is	equal	to	given	number.
 */

package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {

		// create scanner class to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array. initialize the size into the
		// variable name size.
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// initialize the size value in the array
		int arr[] = new int[size];

		// Ask user to enter the array elements
		System.out.println("Enter the array elements : ");

		// iterate for loop to take the user input
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		// Ask user to enter the given number for find the pairs & store the value in
		// variable name "sum"
		System.out.print("Enter the given number : ");
		int sum = sc.nextInt();

		// printing statement
		System.out.print("The pair is = ");

		// method call
		findPairs(arr, size, sum);
	}

	// method definition to find the pair
	static void findPairs(int arr[], int size, int sum) {
		// first for loop which iterate from 0 to size and increment the i value
		for (int i = 0; i < size; i++) {
			// second for loop which iterate from (i+1) to size and increment j value
			for (int j = i + 1; j < size; j++) {
				// if both the loop conditions are true then it checks the if condition.
				// if the addition of arr[i] & arr[j] is same as the given number value then the
				// condition is true
				if ((arr[i] + arr[j]) == sum) {
					/*
					 * if the all conditions are true then we simply print the arr[i] & arr[j] value
					 * which are equivalent to the given number. this is the following pair of the
					 * given number.
					 */
					System.out.println("[" + arr[i] + "," + arr[j] + "]");
				}
			}
		}
	}
}
