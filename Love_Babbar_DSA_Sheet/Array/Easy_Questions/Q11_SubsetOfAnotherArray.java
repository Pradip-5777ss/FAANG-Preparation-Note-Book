/**
 * @author Pradip Sahoo
 * Created on 07/04/2022
 * -------------------------------
 * Array Subset of another array. 
 * Given two arrays: a1[0..n-1] of size n and a2[0..m-1] of size m. 
 * Task is to check whether a2[] is a subset of a1[] or not. 
 * Both the arrays can be sorted or unsorted. It may be assumed that
 * elements in both array are distinct.
 * 
 * Example 1:
 *  Input : a1[] = {11, 1, 13, 21, 3, 7}
 *          a2[] = {11, 3, 7, 1}
 *  Output : Yes
 *  Explanation : a2[] is a subset of a1[]
 * 
 * Example 2:
 *  Input : a1[] = {1, 2, 3, 4, 5, 6}
 *          a2[] = {1, 2, 4}
 *  Output : Yes
 *  Explanation : a2[] is a subset of a1[]
 * 
 * Example 3:
 *  Input : a1[] = {10, 5, 2, 23, 19}
 *          a2[] = {19, 5, 3}
 * Output : No
 * Explanation : a2[] is not a subset of a1[]
 * 
 * Time Complexity : O(Nlogn)
 * Space Complexity : O(N)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.HashSet;
import java.util.Scanner;

public class Q11_SubsetOfAnotherArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the 1st array : ");
        int size_1 = sc.nextInt();

        int arr_1[] = new int[size_1];

        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size_1; i++) {
            arr_1[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the 2nd array : ");
        int size_2 = sc.nextInt();

        int arr_2[] = new int[size_2];

        System.out.println("Enter the 2nd array elements : ");
        for (int i = 0; i < size_2; i++) {
            arr_2[i] = sc.nextInt();
        }

        sc.close();

        if (isSubset(arr_1, arr_2)) {
            System.out.println("Yes, Arr2 is subset of Arr1");
        } else {
            System.out.println("No, Arr2 is not subset of Arr1");
        }
    }

    // Method to find that array is subset of another array
    private static boolean isSubset(int[] arr_1, int[] arr_2) {

        // Declare an Hashmap
        HashSet<Integer> hs = new HashSet<>();

        /**
         * Traverse the arr1[], If the arr1[] elements are not present in hashmap then
         * add it in hashmap.
         */
        for (int i = 0; i < arr_1.length; i++) {
            if (!hs.contains(arr_1[i])) {
                hs.add(arr_1[i]);
            }
        }

        // loop to check if all elements of arr2 also lies in arr1
        for (int i = 0; i < arr_2.length; i++) {
            if (!hs.contains(arr_2[i])) {
                return false;
            }
        }

        return true;
    }
}