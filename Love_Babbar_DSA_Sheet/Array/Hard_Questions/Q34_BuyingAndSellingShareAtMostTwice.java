/**
 * @author Pradip Sahoo
 * Created on 09/04/2022
 * --------------------------
 * Maximum profit by buying and selling a share at most twice.
 * In daily share trading, a buyer buys shares in the morning and sells them on
 * the same day. If the trader is allowed to make at most 2 transactions in a
 * day, whereas the second transaction can only start after the first one is
 * complete (Buy->sell->Buy->sell). Given stock prices throughout the day, find
 * out the maximum profit that a share trader could have made.
 * 
 * Example 1:
 *  Input: price[] = {10, 22, 5, 75, 65, 80}
 *  Output: 87
 *  Explanation : Trader earns 87 as sum of 12, 75 Buy at 10, sell at 22,
 *                Buy at 5 and sell at 80
 * 
 * Example 2:
 *  Input: price[] = {2, 30, 15, 10, 8, 25, 80}
 *  Output: 100
 *  Explanation : Trader earns 100 as sum of 28 and 72 Buy at price 2, sell at 30,
 *                buy at 8 and sell at 80
 * 
 * Example 3:
 *  Input: price[] = {100, 30, 15, 10, 8, 25, 80};
 *  Output: 72
 *  Explanation : Buy at price 8 and sell at 80.
 * 
 * Example 4:
 *  Input: price[] = {90, 80, 70, 60, 50}
 *  Output: 0
 *  Explanation : Not possible to earn.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Hard_Questions;

import java.util.Scanner;

public class Q34_BuyingAndSellingShareAtMostTwice {

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
        System.out.println("Max Profit : " + maxTwoBuySell(arr));
    }

    private static int maxTwoBuySell(int[] arr) {

        int first_Buy = Integer.MIN_VALUE;
        int first_Sell = 0;
        int second_Buy = Integer.MIN_VALUE;
        int second_Sell = 0;

        for (int i = 0; i < arr.length; i++) {
            first_Buy = Math.max(first_Buy, -arr[i]);
            first_Sell = Math.max(first_Sell, first_Buy + arr[i]);
            second_Buy = Math.max(second_Buy, first_Sell - arr[i]);
            second_Sell = Math.max(second_Sell, second_Buy + arr[i]);
        }
        return second_Sell;
    }
}