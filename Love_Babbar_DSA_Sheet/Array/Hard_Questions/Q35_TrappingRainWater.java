/**
 * @author Pradip Sahoo
 * Created on 08/04/2022
 * --------------------------
 * Trapping Rain Water.
 * Given an array arr[] of N non-negative integers representing the height of
 * blocks. If width of each block is 1, compute how much water can be trapped
 * between the blocks during the rainy season.
 * 
 * Example 1:
 *  Input : N = 6
 *          arr[] = {3,0,0,2,0,4}
 *  Output : 10
 * 
 * Example 2:
 *  Input : N = 4
 *          arr[] = {7,4,0,9}
 *  Output : 10
 *  Explanation : Water trapped by above block of height 4 is 3 units and above
 *  block of height 0 is 7 units. So, the total unit of water trapped is 10 units.
 * 
 * Example 3:
 *  Input : N = 3
 *          arr[] = {6,9,9}
 *  Output : 0
 * Explanation : No water will be trapped.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Hard_Questions;

import java.util.Scanner;

public class Q35_TrappingRainWater {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int arr[] = new int[size];

        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();

        System.out.println("Output : " + maxWater(arr));
    }

    private static int maxWater(int[] arr) {

        // indices to traverse the array
        int left = 0;
        int right = arr.length - 1;

        // To store Left max and right max for two pointers left and right
        int l_max = 0;
        int r_max = 0;

        // To store the total amount of rain water trapped
        int result = 0;
        while (left <= right) {

            // We need check for minimum of left and right max for each element
            if (r_max <= l_max) {

                // Add the difference between current value and right max at index r
                result += Math.max(0, r_max - arr[right]);

                // Update right max
                r_max = Math.max(r_max, arr[right]);

                // Update right pointer
                right -= 1;
            } else {

                // Add the difference between current value and left max at index l
                result += Math.max(0, l_max - arr[left]);

                // Update left max
                l_max = Math.max(l_max, arr[left]);

                // Update left pointer
                left += 1;
            }
        }
        return result;
    }
}