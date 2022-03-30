/**
 * @author Pradip Sahoo 
 * Created on 30/03/2022
 * ---------------------------------------------------
 * Find Union and Intersection of two unsorted arrays.
 * Given two unsorted arrays that represent two sets (elements in every array are distinct), find the union and intersection of two arrays.
 * 
 * Example :
 *  Input : arr1[] = {7, 1, 5, 2, 3, 6} 
 *          arr2[] = {3, 8, 6, 20, 7}
 *  Output : Union = {1, 2, 3, 5, 6, 7, 8, 20} 
 *           Intersection = {3, 6, 7}. 
 *  Note that the elements of union and intersection can be printed in any order.
 * 
 * Time Complexity : O(m+n)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.HashSet;
import java.util.Scanner;

public class Q5_UnionAndIntersectionOfTwoArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array1 : ");
        int size_1 = sc.nextInt();

        int arr_1[] = new int[size_1];

        System.out.println("Enter the elements of the array1 : ");
        for (int i = 0; i < size_1; i++) {
            arr_1[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the array2 : ");
        int size_2 = sc.nextInt();

        int arr_2[] = new int[size_2];

        System.out.println("Enter the elements of the array2 : ");
        for (int i = 0; i < size_2; i++) {
            arr_2[i] = sc.nextInt();
        }

        sc.close();

        System.out.println("The Union of the two arrays are : " + findUnion(arr_1, arr_2));
        System.out.println("The Intersection of the two arrays are : " + findIntersection(arr_1, arr_2));
    }

    // Method to find the intersection of two arrays
    private static HashSet<Integer> findIntersection(int[] arr_1, int[] arr_2) {

        // Declare two HashSet
        HashSet<Integer> hash_set = new HashSet<>();
        HashSet<Integer> result = new HashSet<>();

        // Traverse the first array
        for (int i = 0; i < arr_1.length; i++) {
            hash_set.add(arr_1[i]);
        }

        // Traverse the second array
        for (int i = 0; i < arr_2.length; i++) {

            /**
             * If the hashset contains the second array elements then Stroe that elements as
             * result
             */
            if (hash_set.contains(arr_2[i])) {
                result.add(arr_2[i]);
            }
        }

        // Return the result
        return result;
    }

    // Method to find the union of two arrays
    private static HashSet<Integer> findUnion(int[] arr_1, int[] arr_2) {

        // Declare a Hashset
        HashSet<Integer> hash_set = new HashSet<>();

        // Traver the first array
        for (int i = 0; i < arr_1.length; i++) {
            hash_set.add(arr_1[i]);
        }

        // Traverse the second array
        for (int i = 0; i < arr_2.length; i++) {
            /**
             * If the hashset does contains the second array elements then add them into the
             * hashset
             */
            if (!hash_set.contains(arr_2[i])) {
                hash_set.add(arr_2[i]);
            }
        }

        // Return the hashset
        return hash_set;
    }
}