/**
 * @author Pradip Sahoo
 * Created on 01/05/2022
 * -------------------------------------
 * 4. Median of Two Sorted Arrays
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * 
 * Example 1:
 *  Input: nums1 = [1,3], nums2 = [2]
 *  Output: 2.00000
 *  Explanation: merged array = [1,2,3] and median is 2.
 * 
 * Example 2:
 *  Input: nums1 = [1,2], nums2 = [3,4]
 *  Output: 2.50000
 *  Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * Time Complexity : O(log(m+n))
 * Space Complexity : O(1)
 */
package Leetcode_Questions.Hard_Questions;

import java.util.Scanner;

public class Q4_MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of first array : ");
        int size_1 = sc.nextInt();

        int arr1[] = new int[size_1];

        System.out.println("Enter the elements of the first sorted array : ");
        for (int i = 0; i < size_1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the size of the second array : ");
        int size_2 = sc.nextInt();

        int arr2[] = new int[size_2];

        System.out.println("Enter the elements of the second sorted array : ");
        for (int i = 0; i < size_2; i++) {
            arr2[i] = sc.nextInt();
        }

        sc.close();

        System.out.println("The median of two sorted array is : " + findMedian(arr1, arr2));
    }

    private static double findMedian(int[] arr1, int[] arr2) {

        // Find the length of the array
        int arr1_size = arr1.length;
        int arr2_size = arr2.length;

        /**
         * Perform binary search on smaller array, If not then Interchange it.
         */
        if (arr1_size > arr2_size) {
            return findMedian(arr2, arr1);
        }

        // Declare high & low of the first array
        int low = 0;
        int high = arr1_size;

        // Find the mid of the total merged array.
        int mid = ((arr1_size + arr2_size) + 1) / 2;

        // Run the loop, Until condition is true
        while (low <= high) {

            // Find the positions, from where we segregate the arrays in two parts(left &
            // right).
            int cut1 = (low + high) / 2;
            int cut2 = mid - cut1;

            /**
             * Find the left_1 from first array & left_2 from second array.
             * left_1 is basically the left side maximum element(after segregation) of the
             * first array,
             * left_2 is basically the left side maximum element(after segregation) of the
             * second array.
             * 
             * Note : If the segregation index(cut1 & cut2) is zero, then we store the
             * Integer.MIN_VALUE in left1 and left2. Because, we find the maximum.
             */
            int left_1 = (cut1 == 0) ? Integer.MIN_VALUE : arr1[cut1 - 1];
            int left_2 = (cut2 == 0) ? Integer.MIN_VALUE : arr2[cut2 - 1];

            /**
             * Find the right_1 from first array & right_2 from second array.
             * right_1 is basically the right side minimum element(after segregation) of the
             * first array,
             * right_2 is basically the right side minimum element(after segregation) of the
             * second array.
             * 
             * Note : If the segregation index(cut1 & cut2) is equal to the size of the
             * array(point to the last element), then we store the Integer.MAX_VALUE in
             * right1 and right2. Because, we find the minimum.
             */
            int right_1 = (cut1 == arr1_size) ? Integer.MAX_VALUE : arr1[cut1];
            int right_2 = (cut2 == arr2_size) ? Integer.MAX_VALUE : arr2[cut2];

            // When Conditions are true, that means we get the right segregation
            if (left_1 <= right_2 && left_2 <= right_1) {

                /**
                 * If the size of the merged array is odd, Then we have to return the maximum
                 * between left_1 & left_2.
                 * Because, for odd no of elements the middle element of the array is the
                 * median.
                 */
                if ((arr1_size + arr2_size) % 2 != 0) {
                    return Math.max(left_1, left_2);
                }

                /**
                 * If the size of the merged array is even, Then find the maximum element from
                 * the left side segregation of the array, and minimum element form the right
                 * side segregation of the array and divide it by 2.
                 */
                else {
                    return (Math.max(left_1, left_2) + Math.min(right_1, right_2)) / 2.0;
                }
            }

            /**
             * If the left_1 value is greater than from right_2 value then move left
             */
            else if (left_1 > right_2) {
                high = cut1 - 1;
            }
            /**
             * If the left_2 value is greater than from right_2 value then move right
             */
            else {
                low = cut1 + 1;
            }
        }

        // If could not find the median then return 0
        return 0.0;
    }
}