/**
 * @author Pradip Sahoo
 * Created on 31/03/2022
 * --------------------------------
 * Find the median
 * Given an array arr[] of N integers, calculate the median
 *  
 * Example 1:
 *  Input:  N = 5
 *          arr[] = 90 100 78 89 67
 *  Output: 89
 *  Explanation: After sorting the array middle element is the median 
 * 
 * Example 2:
 *  Input:  N = 4
 *          arr[] = 56 67 30 79
 *  Output: 61
 *  Explanation: In case of even number of elements, average of two middle elements is the median.
 * 
 * Time Complexity : O(N*logN)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.Arrays;
import java.util.Scanner;

public class Q15_MedianOfTheArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the elements 0f the array : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        System.out.println("The Median of the array is : " + findMedian(arr));
    }

    private static int findMedian(int[] arr) {

        Arrays.sort(arr);
        int length = arr.length;

        if (length % 2 == 0) {
            return (arr[length / 2] + arr[(length / 2) - 1]) / 2;
        }
        return arr[length / 2];
    }
}