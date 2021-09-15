/**
 * First Repeating Element.
 * Given an array arr[] of size n, find the first repeating element. The element should 
 * occurs more than once and the index of its first occurrence should be the smallest.
 * 
 * Example 1:
 * 		Input:	n = 7
 * 				arr[] = {1, 5, 3, 4, 3, 5, 6}
 * 		Output: 2
 * Explanation: 5 is appearing twice and its first appearence is at index 2 which is less 
 * than 3 whose first occuring index is 3.
 * 
 * Example 2:
 * 		Input:	n = 4
 * 				arr[] = {1, 2, 3, 4}
 * 		Output: -1
 * Explanation: All elements appear only once so answer is -1.
 */
package Array.EasyQuestions;

import java.util.HashMap;
import java.util.Scanner;

public class FirstRepeatingElement {

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
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();

		// Method call to find the first repeating element & print the result
		System.out.println("the first repeating element is = " + firstRepeatingElement(arr, size));
	}

	// Method to find the first repeating element
	static int firstRepeatingElement(int arr[], int n) {

		// using map to store frequency of each element.
		HashMap<Integer, Integer> hash = new HashMap<>();

		// Storing the frequency of each character
		for (int i : arr) {
			if (hash.containsKey(i)) {
				hash.put(i, hash.get(i) + 1);
			} else {
				hash.put(i, 1);
			}
		}

		// Iterating over the array element
		for (int i = 0; i < n; i++) {
			/**
			 * if frequency of current element in map is greater than 1, then we store the
			 * index and break the loop.
			 */
			if (hash.get(arr[i]) > 1) {
				return (i + 1);
			}
		}

		// returning the position of the first repeating element.
		return -1;
	}
}