/**
 * Common elements.
 * 
 * Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
 * Note: can you take care of the duplicates without using any additional Data Structure?
 * 
 * Example:
 * Input:
 *      n1 = 6; A = {1, 5, 10, 20, 40, 80}
 *      n2 = 5; B = {6, 7, 20, 80, 100}
 *      n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
 * 
 * Output: 20 80
 * Explanation: 20 and 80 are the only common elements in A, B and C.
 */
package Array.ArrayEasyQuestions;

import java.util.ArrayList;
import java.util.Scanner;

public class CommonElementsInThreeSortedArray {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the first array
        System.out.print("Enter the size of the first array : ");
        int size1 = sc.nextInt();

        // Initialize the size into the array
        int arr1[] = new int[size1];

        // Ask user to enter the elements of the first array
        System.out.println("Enter the elements of the first array");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        // Ask user to enter the size of the second array
        System.out.print("Enter the size of the second array : ");
        int size2 = sc.nextInt();

        // Initialize the size into the array
        int arr2[] = new int[size2];

        // Ask user to enter the elements of the second array
        System.out.println("Enter the elements of the second array");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }

        // Ask user to enter the size of the third array
        System.out.print("Enter the size of the third array : ");
        int size3 = sc.nextInt();

        // Initialize the size into the array
        int arr3[] = new int[size3];

        // Ask user to enter the elements of the third array
        System.out.println("Enter the elements of the first array");
        for (int i = 0; i < size3; i++) {
            arr3[i] = sc.nextInt();
        }

        sc.close();

        // Method call to find the common elements in three array
        ArrayList<Integer> res = FindCommonElements(arr1, arr2, arr3);

        // If the result is 0 then returns -1, else return the value.
        if (res.size() == 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < res.size(); i++) {
                System.out.println(res.get(i) + " ");
            }
            System.out.println();
        }
    }

    // Method to find common elements
    private static ArrayList<Integer> FindCommonElements(int[] arr1, int[] arr2, int[] arr3) {

        ArrayList<Integer> result = new ArrayList<>();

        int i = 0, j = 0, k = 0;

        int last = Integer.MIN_VALUE;

        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr1[i] == arr3[k] && arr1[i] != last) {
                result.add(arr1[i]);
                last = arr1[i];
                i++;
                j++;
                k++;
            } else if (Math.min(arr1[i], Math.min(arr2[j], arr3[k])) == arr1[i]) {
                i++;
            } else if (Math.min(arr1[i], Math.min(arr2[j], arr3[k])) == arr2[j]) {
                j++;
            } else {
                k++;
            }
        }
        return result;
    }
}