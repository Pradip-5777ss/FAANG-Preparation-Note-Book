/*
 * Rearrange the array in alternating positive and negative	items with O(1) extra space.
 */

package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class Question11 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("emter the size of the array : ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.println("Enter the array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("given array is : ");
		printArray(arr, size);
		
		rearrange(arr, size);
		
		System.out.println("the rearrange array is : ");
		printArray(arr, size);
	}
	
	// Function to rearrange positive and negative 
	// integers in alternate fashion. The below 
	// solution doesn't maintain original order of 
	// elements 
	static void rearrange(int arr[], int size) 
	{ 
		int i = 0, j = size - 1; 

		// shift all negative values to the end 
		while (i < j) 
		{ 
			while(i <= size - 1 && arr[i] > 0) {
				i++;
			}
		
			while (j >= 0 && arr[j] < 0) {
				j--;
			}
				 
			if (i < j) 
				swap(arr, i,j); 
		} 

		// i has index of leftmost negative element 
		if (i == 0 || i == size) 
			return; 

		// start with first positive 
		// element at index 0 

		// Rearrange array in alternating positive & 
		// negative items 
		int k = 0; 
		while (k < size && i < size) 
		{ 
			// swap next positive element 
			// at even position 
			// from next negative element. 
			swap(arr,k,i); 
			i = i + 1; 
			k = k + 2; 
		} 
	} 

	// Utility function to print an array 
	static void printArray(int arr[], int size) 
	{ 
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " "); 
		}
		System.out.println("");
	} 


	static void swap(int arr[], int index1, int index2)
	{
		int c = arr[index1];
		arr[index1]=arr[index2];
		arr[index2]=c;
	} 

} 
