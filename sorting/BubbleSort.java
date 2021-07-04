package sorting;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Create Scanner class to take user input
		Scanner sc = new Scanner(System.in);
		
		//Ask user to enter the size of the array
		System.out.println("Enter the size of the array");
		int size = sc.nextInt();
		
		//Initialize the size into the array
		int arr[] = new int[size];
		
		//Ask user to enter the array elements
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		//call the method
		bubbleSort(arr, size);
	}

	//Definition of the method
	private static void bubbleSort(int[] arr, int size) {
		// TODO Auto-generated method stub
		
		//Declare a variable
		int temp;
		boolean sorted;
		
		//Run the outer loop from 0 to size-1 
		for (int i = 0; i < size - 1; i++) {
			
			/*	Run the inner loop from 0 to size-i-1, 
				because we don't want to check the last sorted value again
			*/
			//Initialize the sorted variable by true
			sorted = true;
			for (int j = 0; j < size - i - 1; j++) {
				
				/*	We check that the element at the lower index is greater
					than the element at the higher index or not. If it is true
					then we swap the values.
					we put the element of the lower index value in the temp variable, 
					then we put the element of the upper index value at the position
					of lower index value, And finally put the temp variable value at 
					the position of upper index value.
				*/
				
				if (arr[j] > arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					sorted = false;
				}
			}
			
			if (sorted == true) {
				break;
			}
		}
		
		//method call for print the sorted array
		printArray(arr, size);
	}

	//method definition for print the array
	private static void printArray(int[] arr, int size) {
		// TODO Auto-generated method stub
		System.out.println("After sorting the array is : ");
		for (int i = 0; i < size; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
