/**
 * @author Pradip Sahoo
 * Created on 05/04/2022
 * -------------------------
 * Common elements
 * Given three arrays sorted in increasing order. Find the elements that are common in all three arrays.
 * Note: can you take care of the duplicates without using any additional Data Structure?
 * 
 * Example 1:
 *  Input:
 *      n1 = 6; A = {1, 5, 10, 20, 40, 80}
 *      n2 = 5; B = {6, 7, 20, 80, 100}
 *      n3 = 8; C = {3, 4, 15, 20, 30, 70, 80, 120}
 *  Output: 20 80
 *  Explanation: 20 and 80 are the only common elements in A, B and C.
 * 
 * Time Complexity : O(n1+n2+n3)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class Q9_FindCommonElementsInThreeSortedArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the first array : ");
        int size1 = sc.nextInt();

        int arr1[] = new int[size1];

        System.out.println("Enter the elements of the first array");
        for (int i = 0; i < size1; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the second array : ");
        int size2 = sc.nextInt();

        int arr2[] = new int[size2];

        System.out.println("Enter the elements of the second array");
        for (int i = 0; i < size2; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.print("Enter the size of the third array : ");
        int size3 = sc.nextInt();

        int arr3[] = new int[size3];

        System.out.println("Enter the elements of the first array");
        for (int i = 0; i < size3; i++) {
            arr3[i] = sc.nextInt();
        }

        sc.close();

        ArrayList<Integer> res = FindCommonElements(arr1, arr2, arr3);

        System.out.print("The common elements are : ");

        if (res.size() == 0) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<Integer> FindCommonElements(int[] arr1, int[] arr2, int[] arr3) {

        ArrayList<Integer> res = new ArrayList<>();

        // Initialize starting indexes for ar1[], ar2[] and ar3[]
        int i = 0, j = 0, k = 0;
        int n1 = arr1.length;
        int n2 = arr2.length;
        int n3 = arr3.length;

        // Declare three variables prev1, prev2, prev3 to track previous element
        int prev1, prev2, prev3;

        // Initialize prev1, prev2, prev3 with INT_MIN
        prev1 = prev2 = prev3 = Integer.MIN_VALUE;

        while (i < n1 && j < n2 && k < n3) {

            // If ar1[i] = prev1 and i < n1, keep incrementing i
            while (i < n1 && arr1[i] == prev1) {
                i++;
            }

            // If ar2[j] = prev2 and j < n2, keep incrementing j
            while (j < n2 && arr2[j] == prev2) {
                j++;
            }

            // If ar3[k] = prev3 and k < n3, keep incrementing k
            while (k < n3 && arr3[k] == prev3) {
                k++;
            }

            if (i < n1 && j < n2 && k < n3) {

                /**
                 * If x = y and y = z, print any of them, update prev1 prev2, prev3 and move
                 * ahead in each array
                 */
                if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                    res.add(arr1[i]);
                    prev1 = arr1[i];
                    prev2 = arr2[j];
                    prev3 = arr3[k];
                    i++;
                    j++;
                    k++;
                }

                // If x < y, update prev1 and increment i
                else if (arr1[i] < arr2[j]) {
                    prev1 = arr1[i];
                    i++;
                }

                // If y < z, update prev2 and increment j
                else if (arr2[j] < arr3[k]) {
                    prev2 = arr2[j];
                    j++;
                }

                /**
                 * We reach here when x > y and z < y, i.e., z is smallest update prev3 and
                 * imcrement k
                 */
                else {
                    prev3 = arr3[k];
                    k++;
                }
            }
        }
        return res;
    }
}