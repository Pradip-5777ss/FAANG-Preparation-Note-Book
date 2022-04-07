/**
 * @author Pradip Sahoo
 * Created on 07/04/2022
 * ----------------------
 * Triplet Sum in Array.
 * Given an array arr of size n and an integer X. Find if there's a triplet in
 * the array which sums up to the given integer X.
 * 
 * Example 1:
 *  Input : n = 6, X = 13
 *          arr[] = [1 4 45 6 10 8]
 *  Output : 1
 *  Explanation : The triplet {1, 4, 8} in the array sums up to 13.
 * 
 * Example 2:
 *  Input : n = 5, X = 10
 *          arr[] = [1 2 4 3 6]
 *  Output : 1
 *  Explanation : The triplet {1, 3, 6} in the array sums up to 10.
 * 
 * Time Complexity : O(N^2)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Medium_Questions;

import java.util.Arrays;
import java.util.Scanner;

public class Q30_TripletSumInArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter the number : ");
        int num = sc.nextInt();

        sc.close();

        findTriplet(arr, num);
    }

    private static boolean findTriplet(int[] arr, int num) {

        // Sort the array
        Arrays.sort(arr);

        // Traversing the array
        for (int i = 0; i < arr.length - 2; i++) {

            /**
             * Taking two pointers. One at element after ith index and another
             * at the last index.
             */
            int left = i + 1;
            int right = arr.length - 1;

            while (left < right) {

                /**
                 * If sum of elements at indexes i, left and right is equal to required number,
                 * then return true.
                 */
                if (arr[i] + arr[left] + arr[right] == num) {
                    System.out.println("Triplet is : " + arr[i] + "," + arr[left] + "," + arr[right]);
                    return true;
                }
                /**
                 * Else if, the sum is less than required number, it means we need to increase
                 * the sum so we increase the left pointer.
                 */
                else if (arr[i] + arr[left] + arr[right] < num) {
                    left++;
                }
                /**
                 * Else, the sum is more than required number & we need to decrease the sum so
                 * we decrease the right pointer.
                 */
                else {
                    right--;
                }
            }
        }

        // returning false if no triplet sum equal to required number is present.
        return false;
    }
}