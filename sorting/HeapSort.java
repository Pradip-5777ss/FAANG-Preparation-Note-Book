package sorting;

import java.util.Scanner;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create scanner class to take user input
		Scanner scanner = new Scanner(System.in);
		
		//Ask user to enter the size of the array
		System.out.print("Enter the size of the array : ");
		int size = scanner.nextInt();
		
		//Initialize the size into the array
		int arr[] = new int[size];
		
		//Ask user to enter the array elements & iterate for loop to take user input
		System.out.println("Enter the array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}

		//Call the method
		heapsort(arr, size);
		
		//	Call the print method
		printArr(arr, size);
		
	}

	/**
	 * method definition
	 * This method take @param arr @param size as parameter.
	 * In this method we basically do 2 things, 
	 * first - build the heap using heapify method
	 * second - delete the root element of the tree using heapify method
	 */
	private static void heapsort(int[] arr, int size) {

		//build heap (rearrange array)
		for (int i = (size/2)-1 ; i >= 0; i--) {
			heapify(arr, size, i);
		}
		
		//one by one extract an element form heap
		for (int i = size-1; i > 0; i--) {
			
			//move the current root element at the end of the heap
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			
			//call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	/**
	 * method definition
	 * @param arr
	 * @param size
	 * @param i
	 * To heapify a subtree rooted with node i which is an index in arr[]. 
	 */
	private static void heapify(int[] arr, int size, int i) {

		//	Initialize largest as root
		int largest = i;
		
		/*
		 * Initialize left node of the root, left = 2*i+1, 
		 * the array indexing is starting from 0
		 */
		int left = 2*i+1;
		
		/*
		 * Initialize right node of the root, right = 2*i+2,
		 * the array indexing is starting from 0
		 */
		int right = 2*i+2;
		
		/*
		 * If left child is larger than the root.
		 * then the largest value will be updated by the left value
		 */
		if (left < size && arr[left] > arr[largest]) {
			largest = left;
		}
		
		/*
		 * If right child is larger than the root.
		 * then the largest value will be updated by the right value
		 */
		if (right < size && arr[right] > arr[largest]) {
			largest = right;
		}
		
		//	If largest and root is not equal then swap it
		if (largest != i) {
			int swap = arr[i];
			arr[i] = arr[largest];
			arr[largest] = swap;
			
			//	Recursively call the heapify method
			heapify(arr, size, largest);
		}
	}
	
	//	Print the array
	private static void printArr(int[] arr, int size) {
		System.out.println("The sorted array is");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}