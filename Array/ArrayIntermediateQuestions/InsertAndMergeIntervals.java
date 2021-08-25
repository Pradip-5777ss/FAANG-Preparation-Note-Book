/**
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * 
 * Example 1:
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in [1,5],[6,9].
 * 
 * Example 2:
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result in [1,2],[3,10],[12,16].
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * Make sure the returned intervals are also sorted.
 */
package Array.ArrayIntermediateQuestions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class InsertAndMergeIntervals {

    public class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Create object of the class
        InsertAndMergeIntervals m = new InsertAndMergeIntervals();

        // Make a Arraylist
        ArrayList<Interval> intervals = new ArrayList<Interval>();

        // Ask user to enter the size of the array
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();

        // Run a loop to take user input to make intervals
        for (int i = 0; i < size; i++) {

            System.out.println("Enter data for interval " + (i + 1) + " : ");

            System.out.print("Start : ");
            int a = sc.nextInt();

            System.out.print("End : ");
            int b = sc.nextInt();

            intervals.add(m.new Interval(a, b));
        }

        // Ask user to enter the data for new interval which we want to insert
        System.out.println("Enter data for new interval which we want to insert");
        System.out.print("start : ");
        int a = sc.nextInt();

        System.out.print("End : ");
        int b = sc.nextInt();

        Interval newInterval = m.new Interval(a, b);

        sc.close();

        // Method call to insert and merge intervals
        ArrayList<Interval> res = insert(intervals, newInterval);

        // Print the final result
        System.out.print("The resultant array is : ");
        for (Interval i : res) {
            System.out.print("[" + i.start + ", " + i.end + "] ");
        }
        System.out.println();
    }

    // Method to insert and merge intervals
    public static ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {

        // Declare a arraylist to store the result
        ArrayList<Interval> res = new ArrayList<>();

        // Run a loop and traverse through all the intervals
        for (int i = 0; i < intervals.size(); i++) {

            /**
             * First, we have to find the maximum between the start values of given interval
             * and new interval.
             * 
             * Second, we have to find the minimum between the end values of given interval
             * and new interval.
             * 
             * If the maximum of start value is less than the minimum of end value, then we
             * update the data of new interval.
             * 
             * For update the start value of new interval we have to find the minimum of
             * given interval start value and the new interval start value.
             * 
             * For update the end value of new interval we have to find the maximum of given
             * interval end value and the new interval end value.
             */
            if (Math.max(intervals.get(i).start, newInterval.start) <= Math.min(intervals.get(i).end,
                    newInterval.end)) {
                newInterval.start = Math.min(intervals.get(i).start, newInterval.start);
                newInterval.end = Math.max(intervals.get(i).end, newInterval.end);
            }

            /**
             * else we insert the interval into the arraylist in which we are storing
             * result.
             */
            else {
                res.add(intervals.get(i));
            }
        }

        /**
         * Finally we add the new interval with the arraylist in which we are storing
         * result
         */
        res.add(newInterval);

        // At last, we merge and sort the intervals
        Collections.sort(res, new Comparator<Interval>() {
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start, o2.start);
            };
        });

        // Return the arraylist in which we store the result.
        return res;
    }
}