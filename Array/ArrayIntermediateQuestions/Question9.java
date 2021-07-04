/*
 * Find	the	first non-repeating	element	in a given array of integers.	
 */

package Array.ArrayIntermediateQuestions;

import java.util.*;

public class Question9 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the size of the array : ");
		int size = sc.nextInt();
		
		int arr[] = new int[size];
		
		System.out.println("Enter the array elements");
		for (int i = 0; i < size; i++) {
			arr[i] = sc.nextInt();
		}
		
		System.out.println("the first non repeating element is = " +firstNonRepeating(arr, size));
		
	}
	
	static int firstNonRepeating(int arr[], int size)
	{
		Map<Integer,Integer>m=new HashMap<>();
		for(int i=0;i<size;i++)
		{
			if (m.containsKey(arr[i])) {
				m.put(arr[i],m.get(arr[i])+1);
			} else {
				m.put(arr[i],1);
			}
		}
		
		for(int i=0;i<size;i++) {
			if(m.get(arr[i])==1) {
				return arr[i];
			}	
		}	
		return -1;
	}
}
