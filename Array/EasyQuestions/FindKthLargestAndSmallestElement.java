/*
 * Find	the	Kth	largest	and	Kth	smallest number	in an array.	
 */
package Array.EasyQuestions;

import java.util.*;

public class FindKthLargestAndSmallestElement {

	public static void main(String[] args) {

		// Create Scanner class object to take user input
		Scanner sc = new Scanner(System.in);

		// Ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = sc.nextInt();

		// Initialize the size into the array
		int arr[] = new int[size];

		// Ask user to enter the array elements
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}

		/**
		 * ask user to enter the key value for finding the k-th largest/smallest element
		 * in the array
		 */
		System.out.print("Enter the key value : ");
		int k = sc.nextInt();
		sc.close();

		// method call to find & print the k-th smallest element
		System.out.println("k-th smallest element is = " + kthSmallest(arr, size, k));

		// method call to find & print the k-th largest element
		System.out.println("k-th largest element is = " + kthLargest(arr, size, k));
	}

	// method to find kth smallest element
	public static int kthSmallest(int arr[], int size, int k) {

		Arrays.sort(arr);
		return arr[k - 1];
	}

	// method to find kth largest element
	public static int kthLargest(int arr[], int size, int k) {

		Arrays.sort(arr);
		return arr[size - k];
	}
}