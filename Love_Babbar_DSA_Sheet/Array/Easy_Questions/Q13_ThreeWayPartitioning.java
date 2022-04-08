/**
 * @author Pradip Sahoo
 * Created on 08/04/2022
 * ------------------------
 * Three way partitioning
 * Given an array of size n and a range [a, b]. The task is to partition the
 * array around the range such that array is divided into three parts.
 *  1) All elements smaller than a come first.
 *  2) All elements in range a to b come next.
 *  3) All elements greater than b appear in the end.
 * The individual elements of three sets can appear in any order. You are
 * required to return the modified array.
 * 
 * Example 1:
 *  Input : n = 5
 *          A[] = {1, 2, 3, 3, 4}
 *          [a, b] = [1, 2]
 *  Output : 1
 *  Explanation : One possible arrangement is: {1, 2, 3, 3, 4}. If you return a
 *                valid arrangement, output will be 1.
 * 
 * Example 2:
 *  Input : n = 3
 *          A[] = {1, 2, 3}
 *          [a, b] = [1, 3]
 *  Output : 1
 *  Explanation : One possible arrangement is: {1, 2, 3}. If you return a valid
 *                arrangement, output will be 1.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.Scanner;

public class Q13_ThreeWayPartitioning {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the array elements : ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter the range : ");
        int lowVal = sc.nextInt();
        int highVal = sc.nextInt();

        partition(arr, lowVal, highVal);

        sc.close();

        System.out.print("Modified array : ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void partition(int[] arr, int lowVal, int highVal) {

        /**
         * Using two pointers which help in finding the index with which the element
         * need to be swaped if they are not in correct position.
         */
        int start = 0, end = arr.length - 1;

        int index = 0;

        // Traverse the array
        while (index <= end) {

            /**
             * If current element is smaller than lower range, swap it with value on next
             * available smallest position.
             */
            if (arr[index] < lowVal) {
                int temp = arr[start];
                arr[start] = arr[index];
                arr[index] = temp;
                start++;
                index++;
            }

            /**
             * If current element is greater than higher range, swap it with value on next
             * available greatest position.
             */
            else if (arr[index] > highVal) {
                int temp = arr[end];
                arr[end] = arr[index];
                arr[index] = temp;
                end--;
            }

            // Else we just move ahead in the array
            else {
                index++;
            }
        }
    }
}