package Array.ArrayIntermediateQuestions;

import java.util.Scanner;

public class Question8 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.println("Enter the array elements");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("the first repeating element is = ");
		firstRepeatingElement(arr, size);
	}
	
	static void firstRepeatingElement(int arr[], int size)
	{
		int i,j,firstRepeat;
		
		for (i = 0; i < arr.length; i++) {
			for (j = i;  j< arr.length; j++) {
				if (arr[i] == arr[j]) {
					firstRepeat = arr[i];
					System.out.println(firstRepeat);
				}
			}
		}
	}
}
