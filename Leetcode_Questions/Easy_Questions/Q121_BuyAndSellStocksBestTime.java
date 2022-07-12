/**
 * @author Pradip Sahoo
 * Created on 13/07/2022
 * -------------------------------
 * 121. Best Time to Buy and Sell Stock.
 * You are given an array prices where prices[i] is the price of a given stock
 * on the ith day.
 * 
 * You want to maximize your profit by choosing a single day to buy one stock
 * and choosing a different day in the future to sell that stock.
 * 
 * Return the maximum profit you can achieve from this transaction. If you
 * cannot achieve any profit, return 0.
 * 
 * Example 1:
 *  Input: prices = [7,1,5,3,6,4]
 *  Output: 5
 *  Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit =
 *  6-1 = 5.
 *  "Note that buying on day 2 and selling on day 1 is not allowed because you
 *  must buy before you sell."
 * 
 * Example 2:
 *  Input: prices = [7,6,4,3,1]
 *  Output: 0
 *  Explanation: In this case, no transactions are done and the max profit = 0.
 */
package Leetcode_Questions.Easy_Questions;

import java.util.Scanner;

public class Q121_BuyAndSellStocksBestTime {

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

        int result = maxProfit(arr);
        System.out.println("The maximum profit is : " + result);
    }

    /**
     * Method to find the maximum profit from the stocks
     * 
     * @param prices
     * @return the maximum profit
     */
    private static int maxProfit(int[] prices) {
        int minimal = Integer.MAX_VALUE;
        int maximum_Profit = 0;

        // Traverse the array
        for (int i = 0; i < prices.length; i++) {

            /**
             * If the 'ith-position' price is less than the minimal value then that value is
             * the current minimal value.
             */
            if (prices[i] < minimal) {
                minimal = prices[i];
            }

            /**
             * If the difference between 'ith-position' price and the 'minimal' value is
             * greater than the 'maximum _profit' value then that is the 'maximum profit'
             * value.
             */
            if (prices[i] - minimal > maximum_Profit) {
                maximum_Profit = prices[i] - minimal;
            }
        }

        // Return the maximum profit value
        return maximum_Profit;
    }
}