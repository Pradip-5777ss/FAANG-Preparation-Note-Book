/**
 * . Find the Union	and	Intersection of	the	two	sorted arrays.
 */
package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		
		//Create scanner class to take user input
		Scanner sc = new Scanner(System.in);
		
		//Ask user to enter the size of the 1st array
		System.out.print("Enter the size of the array1 : ");
		int size1 = sc.nextInt();
		
		//Initialize the size of the array1 into the 1st array
		int arr1[] = new int[size1];
		
		//Ask user to enter the 1st array elements & iterate a loop to take user input
		System.out.println("Enter the array1 elements : ");
		for (int i = 0; i < size1; i++) {
			arr1[i] = sc.nextInt();
		}
		
		//Ask user to enter the size of the 2nd array
		System.out.print("Enter the size of the array2 : ");
		int size2 = sc.nextInt();
		
		//Initialize the size of the array2 into the 2nd array
		int arr2[] = new int[size2];
		
		//Ask user to enter the 2nd array element & iterate a loop to take user input
		System.out.println("Enter the array2 elements : ");
		for (int j = 0; j < size2; j++) {
			arr2[j] = sc.nextInt();
		}
		sc.close();
		
		
		System.out.print("the union of the two array is = ");
		unionArray(arr1, size1, arr2, size2);
	}
	
	static void unionArray(int arr1[], int size1, int arr2[], int size2)
	{
		int m = arr1[size1 - 1];
		int n = arr2[size2 - 1];
		
		int ans = 0;
		
		if(m>n) {
			ans = m;
		}
		else {
			ans = n;
		}
		
		int newArray[] = new int[ans+1];
		
		System.out.println(arr1[0] + " ");
		
		++newArray[arr1[0]];
		
		for (int i = 0; i < size1; i++) {
			if (arr1[i] != arr1[i-1]) {
				System.out.println(arr1[i] + " ");
				++newArray[arr1[i]];
			}
		}
		
		for (int j = 0; j < size2 ; j++) {
			if (newArray[arr2[j]] == 0) {
				System.out.println(arr2[j] + " ");
				++newArray[arr2[j]];
			}
		}
		
	}
}
