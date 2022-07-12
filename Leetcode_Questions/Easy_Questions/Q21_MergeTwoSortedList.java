/**
 * @author Pradip Sahoo
 * Created on 12/07/2022
 * -------------------------------
 * 21. Merge Two Sorted List
 * You are given the heads of two sorted linked lists list1 and list2.
 * 
 * Merge the two lists in a one sorted list. The list should be made by splicing
 * together the nodes of the first two lists.
 * 
 * Return the head of the merged linked list.
 * 
 * Example 1:
 *  Input: list1 = [1,2,4], list2 = [1,3,4]
 *  Output: [1,1,2,3,4,4]
 * Example 2:
 *  Input: list1 = [], list2 = []
 *  Output: []
 * Example 3:
 *  Input: list1 = [], list2 = [0]
 *  Output: [0]
 * 
 * Space Complexity : O(N)
 * Time Complexity : O(N)
 */
package Leetcode_Questions.Easy_Questions;

import java.util.Scanner;

public class Q21_MergeTwoSortedList {

    static Node firstList;
    static Node secondList;
    static Node tail;

    // Node class for create the nodes of the linked list
    public class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    static Q21_MergeTwoSortedList mergeList = new Q21_MergeTwoSortedList();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the length of list1 : ");
        int length1 = sc.nextInt();

        // Ask user to enter the elements of the 1st list
        System.out.println("Enter the elements of list1 :");
        int val = sc.nextInt();

        firstList = mergeList.new Node(val);
        tail = firstList;

        for (int i = 1; i < length1; i++) {
            val = sc.nextInt();
            tail.nextNode = mergeList.new Node(val);
            tail = tail.nextNode;
        }

        // Ask user to enter the length of the 2nd linked list
        System.out.print("Enter the length of list2 : ");
        int length2 = sc.nextInt();

        // Ask user to enter the elements of the 2nd list
        System.out.println("Enter the elements of list2 :");
        val = sc.nextInt();

        secondList = mergeList.new Node(val);
        tail = secondList;

        for (int i = 1; i < length2; i++) {
            val = sc.nextInt();
            tail.nextNode = mergeList.new Node(val);
            tail = tail.nextNode;
        }

        sc.close();

        // Method call to merge two sorted list
        Node result = mergeTwoSortedList(firstList, secondList);

        System.out.print("The new list is : ");
        printList(result);
    }

    /**
     * Method to print the list
     * 
     * @param result
     */
    private static void printList(Node result) {
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.nextNode;
        }
        System.out.println();
    }

    /**
     * Method to merge two sorted list. It takes two parameter
     * 
     * @param list1
     * @param list2
     * @return the merged list
     */
    private static Node mergeTwoSortedList(Node list1, Node list2) {

        // If first list is null then return second list
        if (list1 == null) {
            return list2;
        }

        // If second list is null then return first list
        if (list2 == null) {
            return list1;
        }

        // recursively call the method to merge the two sorted list
        if (list1.data < list2.data) {
            list1.nextNode = mergeTwoSortedList(list1.nextNode, list2);
            return list1;
        } else {
            list2.nextNode = mergeTwoSortedList(list1, list2.nextNode);
            return list2;
        }
    }
}