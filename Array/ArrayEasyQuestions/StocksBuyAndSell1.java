/**
 * Best Time to Buy and Sell Stock 1.
 * 
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different 
 * day in the future to sell that stock.
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * 
 * Example :
 * Input: prices = [7,1,5,3,6,4]
 * Output: 5
 * 
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
 */
package Array.ArrayEasyQuestions;

import java.util.Scanner;

public class StocksBuyAndSell1 {

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the array
        System.out.println("Enter the size of the array : ");
        int size = sc.nextInt();

        // Initialize the size into the array
        int[] arr = new int[size];

        // Ask user to enter the array elements
        System.out.println("Enter the array elements : ");
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }

        sc.close();
        // Method call to find the maximum profit
        int profit = maxProfit(arr);

        // Print the maximum profit
        System.out.println("The maximum profit is : " + profit);
    }

    // Method to find the maximum profit
    private static int maxProfit(int[] arr) {

        int minimal = Integer.MAX_VALUE;
        int max_Profit = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < minimal) {
                minimal = arr[i];
            } else if (arr[i] - minimal > max_Profit) {
                max_Profit = arr[i] - minimal;
            }
        }
        return max_Profit;
    }
}
