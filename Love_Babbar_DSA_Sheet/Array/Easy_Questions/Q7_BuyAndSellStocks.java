/**
 * @author Pradip Sahoo
 * Created on 31/03/2022
 * ---------------------------------
 * Best Time to Buy and Sell Stock.
 * You are given an array 'prices' where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a 
 * different day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *  
 * Example 1:
 *  Input: prices = [7,1,5,3,6,4]
 *  Output: 5
 *  Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *  Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 * 
 * Example 2:
 *  Input: prices = [7,6,4,3,1]
 *  Output: 0
 *  Explanation: In this case, no transactions are done and the max profit = 0.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package Love_Babbar_DSA_Sheet.Array.Easy_Questions;

import java.util.Scanner;

public class Q7_BuyAndSellStocks {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        int prices[] = new int[size];

        System.out.println("Enter the elements of the array : ");
        for (int i = 0; i < size; i++) {
            prices[i] = sc.nextInt();
        }

        sc.close();

        int profit = maxProfit(prices);
        System.out.print("The maximum profit is : " + profit);
    }

    // Method to find the maxProfit
    private static int maxProfit(int[] prices) {

        int minimal = Integer.MAX_VALUE;
        int max_Profit = 0;

        // Traverse the array
        for (int i = 0; i < prices.length; i++) {

            /**
             * If any ith day the price is less than the minimal value then update the
             * minimal value by on that day price.
             */
            if (prices[i] < minimal) {
                minimal = prices[i];
            }
            /**
             * If the difference between ith day price & minimanl is greater than max_profit
             * then update the max_profit by the difference between ith day price and the
             * minimal
             */
            else if (prices[i] - minimal > max_Profit) {
                max_Profit = prices[i] - minimal;
            }
        }

        // Return the maxprofit
        return max_Profit;
    }
}