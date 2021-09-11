/**
 * Find	duplicates in an array.
 * Given an array a[] of size N which contains elements from 0 to N-1,
 * you need to find all the elements occurring more than once in the given array.
 * 
 * Example 1:
 * 			Input:	N = 4
 * 					a[] = {0,3,1,2}
 * 			Output: -1
 * Explanation: N=4 and all elements from 0 to (N-1 = 3) are present in the given
 * array. Therefore output is -1.
 * 
 * Example 2:
 * 			Input:	N = 5
 * 					a[] = {2,3,1,2,3}
 * 			Output: 2 3 
 * Explanation: 2 and 3 occur more than once in the given array.
 */

package Array.ArrayIntermediateQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class FindDuplicates {

	public static void main(String[] args) {

		// create scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// initialize the size into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		sc.close();

		// method call to find the duplicates
		ArrayList<Integer> ans = findDuplicate(arr, size);

		// Printing statement
		System.out.print("Duplicate elements are = ");
		for (Integer val : ans) {
			System.out.print(val + " ");
		}
		System.out.println();
	}

	// method to find the duplicates of the array
	private static ArrayList<Integer> findDuplicate(int arr[], int n) {

		/**
		 * First check all the values that are present in an array then go to that
		 * values as indexes and increment by the size of array.
		 */
		for (int i = 0; i < n; i++) {
			int index = arr[i] % n;
			arr[index] += n;
		}

		/**
		 * Now check which value exists more than once by dividing with the size of
		 * array.
		 */
		int flag = 0;
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < n; i++) {
			if ((arr[i] / n) > 1) {
				ans.add(i);
				flag = 1;
			}
		}

		// If no element is repeated then return -1
		if (flag == 0) {
			ans.add(-1);
		}
		return ans;
	}
}
