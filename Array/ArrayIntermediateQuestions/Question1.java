package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class Question1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the size of the array1 : ");
		int size1 = sc.nextInt();
		
		int arr1[] = new int[size1];
		
		System.out.println("Enter the array1 elements : ");
		for (int i = 0; i < size1; i++) {
			arr1[i] = sc.nextInt();
		}
		
		System.out.print("Enter the size of the array2 : ");
		int size2 = sc.nextInt();
		
		int arr2[] = new int[size2];
		
		System.out.println("Enter the array2 elements : ");
		for (int j = 0; j < size2; j++) {
			arr2[j] = sc.nextInt();
		}
		
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
