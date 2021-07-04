/*
 * Sort an Array using Quicksort algorithm.
 */

package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class Question6 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.println("Enter the array element : ");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		QuickSort(arr, 0,size-1);
		System.out.println("The sorted elements are : ");
		printArr(arr, size);
		
	}
	
	static int partition(int arr[], int low, int high)
	{
	    int pivot = arr[high];
	    int i = (low -1);

	    for (int j = low; j <= high; j++)
	    {
	        if (arr[j] < pivot)
	        {
	            i++;
	            
	            int temp = arr[i];
	            arr[i] = arr[j];
	            arr[j] =temp;
	        }   
	    }
	    int temp = arr[i+1];
	    arr[i+1] = arr[high];
	    arr[high] = temp;
	    return (i+1);
	}

	static void QuickSort(int arr[], int low, int high)
	{
	    if (low < high)
	    {
	        int pi = partition(arr, low, high);
	        QuickSort(arr, low, pi-1);
	        QuickSort(arr, pi+1, high);
	    }
	    
	}

	static void printArr(int arr[], int size)
	{
	    int i;
	    for ( i = 0; i < size; i++)
	    {
	        System.out.print(arr[i]+" ");
	    }
	    System.out.println();
	}
}
