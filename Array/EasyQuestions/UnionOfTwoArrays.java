/**
 * Write a program to find the Union of two sorted array.
 */
package Array.EasyQuestions;

import java.util.*;

public class UnionOfTwoArrays {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the first array
        System.out.print("Enter the size of the array1 : ");
        int size1 = sc.nextInt();

        // Initialize the size into the array
        int arr1[] = new int[size1];

        // Ask user to enter the first array elements
        System.out.println("Enter the array1 elements");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        // Ask user to enter the size of the second array
        System.out.print("Enter the size of the array2 : ");
        int size2 = sc.nextInt();

        // Initialize the size into the array
        int arr2[] = new int[size2];

        // Ask user to enter the second array element
        System.out.println("Enter the array2 elements : ");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }

        sc.close();

        // Method call to find the union of two arrays.
        findUnion(arr1, arr2);
    }

    // Method to find the union of two arrays
    private static void findUnion(int[] arr1, int[] arr2) {

        // Declare a HashSet object
        HashSet<Integer> hSet = new HashSet<>();

        // Traverse a loop through the first array and add all elements into the set
        for (int i = 0; i < arr1.length; i++) {
            hSet.add(arr1[i]);
        }

        // Traverse a loop through the second array
        for (int i = 0; i < arr2.length; i++) {

            // If the set does not contain any elements of second array then add it into set
            if (!hSet.contains(arr2[i])) {
                hSet.add(arr2[i]);
            }
        }

        // Print the whole set
        System.out.println("The union of two array is : " + hSet);
    }
}
