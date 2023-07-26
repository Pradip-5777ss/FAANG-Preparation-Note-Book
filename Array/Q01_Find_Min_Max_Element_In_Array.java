/**
 ** Find the minimum and maximum element in an array.
 * Given an array of size N. The task is to find the maximum and the minimum
 * element of the array using the minimum number of comparisons.
 * 
 * Example 1:
 *  Input: arr[] = {3, 5, 4, 1, 9}
 *  Output: Minimum element is: 1
 *  Maximum element is: 9
 * 
 * Example 2:
 *  Input: arr[] = {22, 14, 8, 17, 35, 3}
 *  Output: Minimum element is: 3
 *  Maximum element is: 35
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 * -----------------------------------------
 * @author  Pradip Sahoo
 * @since   27/07/2023
 */
package Array;

import java.util.Scanner;

public class Q01_Find_Min_Max_Element_In_Array {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];
        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        // *Method call to find the minimum and maximum element in an array
        findMinMaxElement(arr);
    }

    /**
     * Find the minimum and maximum elements of an array
     * 
     * @param arr The input integer array.
     */
    private static void findMinMaxElement(int[] arr) {
        /**
         ** Step 1: Initialize two variables min and max to the first element of the
         ** input array.
         */
        int min = arr[0];
        int max = arr[0];

        /**
         ** Step 2: Iterate through the array to find the actual minimum and maximum
         ** element. If current element is smaller than min, then update min else
         ** update max.
         */
        for (int i = 0; i < arr.length; i++) {

            /**
             ** For each element, compare it with the current min value. If the
             ** element is smaller than min, update min to the value of the element.
             */
            if (min > arr[i]) {
                min = arr[i];
            }
            /**
             ** If the element is not smaller than min, compare it with the current
             ** max value. If the element is larger than max, update max to the value of the
             ** element.
             */
            else if (max < arr[i]) {
                max = arr[i];
            }
        }

        // *Print the minimum and maximum elements
        System.out.println("The minimum element is : " + min);
        System.out.println("The maximum element is : " + max);
    }
}