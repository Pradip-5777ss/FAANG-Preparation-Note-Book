package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class Question7 {
	
	public static void main(String[] args) {
		
		//create scanner class to take user input
		Scanner sc = new Scanner(System.in);
		
		//ask user to enter the size of the array1
		System.out.println("Enter the size of the array1 : ");
		int n1= sc.nextInt();
		
		//initialize the size into the array
		int arr1[] = new int[n1];
		
		//ask user to enter the array elements & iterate for loop to take the user input
		System.out.println("Enter the array elements");
		for (int i = 0; i < n1; i++) {
			arr1[i] = sc.nextInt();
		}
		
		//ask user to enter the size of the array2
		System.out.println("Enter the size of the array2 : ");
		int n2 = sc.nextInt();
		
		//initialize the size into the array
		int arr2[] = new int[n2];
		
		//ask user to enter the array elements & iterate for loop to take the user input
		System.out.println("Enter the array elements");
		for (int j = 0; j < n2; j++) {
			arr2[j] = sc.nextInt();
		}
		
		//ask user to enter the size of the array2
		System.out.println("enter the size of the array3 : ");
		int n3 = sc.nextInt();
		
		//initialize the size into the array
		int arr3[] = new int[n3];
		
		//ask user to enter the array elements & iterate for loop to take the user input
		System.out.println("Enter the array elements");
		for (int k = 0; k < n3; k++) {
			arr3[k] = sc.nextInt();
		}
		
		//printing statement
		System.out.print("The common elements in three sorted arrays are = ");
		
		//method call
		commonElements(arr1, n1, arr2, n2, arr3, n3);
	}
	
	//method definition for find the common elements
	static void commonElements(int arr1[], int n1, int arr2[], int n2, int arr3[], int n3)
	{
		//declare variables & initialize it by 0
		int i=0,j=0,k=0;
		
		//iterate while loop & check the conditions are true or not
		while(i<n1&&j<n2&&k<n3)
		{
			if(arr1[i] == arr2[j] && arr2[j] == arr3[k])
			{
				System.out.println(arr1[i] +" ");
				i++;
				j++;
				k++;
			}
			else if (arr1[i] < arr2[j]) {
				i++;
			}
			else if (arr2[j] < arr3[k]) {
				j++;
			}
			else {
				k++;
			}
		}
	}

}
