/**
 * Write a program to find the Intersection of two array
 */
package Array.ArrayEasyQuestions;

import java.util.*;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of first array
        System.out.print("Enter the size of first array : ");
        int size1 = sc.nextInt();

        // Initialize the size into the array
        int arr1[] = new int[size1];

        // Ask user to enter the array elements
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        // Ask user to enter the size of the second array
        System.out.print("Enter the size of second array : ");
        int size2 = sc.nextInt();

        // Initialize the size into the array
        int arr2[] = new int[size2];

        // Ask user to enter the array elements
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }
        sc.close();

        // Method call to find the intersection of two arrays
        findIntersection(arr1, arr2);

    }

    // Method to find the Intersection of two arrays
    private static void findIntersection(int[] arr1, int[] arr2) {

        // Declare two HashSet object
        HashSet<Integer> hSet = new HashSet<Integer>();
        HashSet<Integer> res = new HashSet<Integer>();

        // Traverse the first array and add all elements into the set
        for (int i = 0; i < arr1.length; i++) {
            hSet.add(arr1[i]);
        }

        // Traverse the second array
        for (int i = 0; i < arr2.length; i++) {

            /**
             * If set contains any element of second array then store that element into
             * another Hashset
             */
            if (hSet.contains(arr2[i])) {
                res.add(arr2[i]);
            }
        }

        // Print the result
        System.out.println("The Intersection of two array is : " + res);
    }
}
