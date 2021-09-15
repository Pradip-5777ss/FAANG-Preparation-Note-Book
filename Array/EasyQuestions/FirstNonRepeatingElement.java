/**
 * Find	the	first non-repeating	element	in a given array of integers.
 * 
 * Examples:
 * 		Input : -1 2 -1 3 2
 * 		Output : 3
 * Explanation : The first number that does not repeat is : 3
 */

package Array.EasyQuestions;

import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class FirstNonRepeatingElement {

	public static void main(String[] args) {

		// Create Scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();

		// Initialize the size into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements
		System.out.println("Enter the array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();

		// Method call to find the first non repeating element & print the result
		System.out.println("the first non repeating element is = ");
		firstNonRepeating(arr, size);
	}

	// Method to find the first non repeating element
	static void firstNonRepeating(int arr[], int size) {

		// Using Map to store all the array elements
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < size; i++) {
			if (m.containsKey(arr[i])) {
				m.put(arr[i], m.get(arr[i]) + 1);
			} else {
				m.put(arr[i], 1);
			}
		}

		/**
		 * Traverse through map only and using for-each loop for iteration over
		 * Map.entrySet()
		 */
		for (Map.Entry<Integer, Integer> x : m.entrySet()) {
			if (x.getValue() == 1) {
				System.out.println(x.getKey() + " ");
			}
		}
	}
}