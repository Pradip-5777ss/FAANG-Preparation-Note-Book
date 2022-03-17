/**
 * 121. Best Time to Buy and Sell Stock
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
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
 */
package LeetcodeTopInterviewQuestions.Array.EasyQuestions;

import java.util.Scanner;

public class Q121_BestTimeToBuyAndSellStock {

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

        int max_profit = findMaxProfit(prices);
        System.out.println("The Maximum Profit is : " + max_profit);
    }

    // Method to find the maximum profit
    private static int findMaxProfit(int[] prices) {

        int minimal = Integer.MAX_VALUE;
        int overAllProfit = 0;
        int profit = 0;

        // Traverse the array
        for (int i = 0; i < prices.length; i++) {

            /**
             * if we found new buy value which is more smaller then previous one.
             * update our minimal
             */
            if (prices[i] < minimal) {
                minimal = prices[i];
            }

            profit = prices[i] - minimal;
            /**
             * Calculating profit if sold today by, Buy - sell
             * If profit is more then previous overall profit then, update overall profit
             */
            if (profit > overAllProfit) {
                overAllProfit = profit;
            }
        }

        // Retrun the overall profit
        return overAllProfit;
    }
}