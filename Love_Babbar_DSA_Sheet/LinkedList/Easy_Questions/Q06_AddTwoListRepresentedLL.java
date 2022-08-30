/**
 * Add two numbers represented by linked lists.
 * Given two numbers represented by two linked lists of size N and M. The task is to return a sum list.
 * The sum list is a linked list representation of the addition of two input numbers from the last.
 * 
 * Example 1:
 *      Input: N = 2
 *             value N[] = {4,5}
 *             M = 3
 *             value M[] = {3,4,5}
 *      Output: 3 9 0  
 * Explanation: For the given two linked list (4 5) and (3 4 5), after adding the two linked list 
 * resultant linked list will be (3 9 0).
 * 
 * Example 2:
 *      Input: N = 2
 *             valueN[] = {6,3}
 *             M = 1
 *             valueM[] = {7}
 *      Output: 7 0
 * Explanation: For the given two linked list (6 3) and (7), after adding the two linked list 
 * resultant linked list will be (7 0).
 * 
 * Time Complexity: O(N+M)
 * Space Complexity: O(Max(N,M))
 */
package Love_Babbar_DSA_Sheet.LinkedList.Easy_Questions;

import java.util.Scanner;

public class Q06_AddTwoListRepresentedLL {

    static Node tail;
    static Node firstList;
    static Node secondList;

    // Node class for creating new nodes in Linked List
    class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    // create object of the class
    static Q06_AddTwoListRepresentedLL aLl = new Q06_AddTwoListRepresentedLL();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the 1st linked list
        System.out.print("Enter the length of list1 : ");
        int length1 = sc.nextInt();

        // Ask user to enter the elements of the 1st list
        System.out.println("Enter the elements of list1 ");
        int val = sc.nextInt();

        firstList = aLl.new Node(val);
        tail = firstList;

        for (int i = 1; i < length1; i++) {
            val = sc.nextInt();
            tail.nextNode = aLl.new Node(val);
            tail = tail.nextNode;
        }

        // Ask user to enter the length of the 2nd linked list
        System.out.print("Enter the length of list2 : ");
        int length2 = sc.nextInt();

        // Ask user to enter the elements of the 2nd list
        System.out.println("Enter the elements of list2");
        val = sc.nextInt();

        secondList = aLl.new Node(val);
        tail = secondList;

        for (int i = 1; i < length2; i++) {
            val = sc.nextInt();
            tail.nextNode = aLl.new Node(val);
            tail = tail.nextNode;
        }

        sc.close();

        // Method call to add two list
        Node res = addTwoList(firstList, secondList);

        // Method call to Print the list
        System.out.print("the new list is : ");
        printList(res);

    }

    // Method to print the list
    private static void printList(Node node) {

        while (node != null) {
            System.out.print(node.data + " ");
            node = node.nextNode;
        }
        System.out.println();
    }

    // Method to add two list
    private static Node addTwoList(Node firstList, Node secondList) {

        // reversing both lists to simplify addition.
        firstList = reverse(firstList);
        secondList = reverse(secondList);

        // Declare an dummy node to store the answer
        Node ans = null;

        // Initially carry is 0
        int carry = 0;

        // using a loop till both lists and carry gets exhausted.
        while (firstList != null || secondList != null || carry > 0) {

            // using a variable to store sum of two digits along with carry.
            int sum = carry;

            // if nodes are left in any list, we add their data in newVal.
            if (firstList != null) {
                sum += firstList.data;
                firstList = firstList.nextNode;
            }
            if (secondList != null) {
                sum += secondList.data;
                secondList = secondList.nextNode;
            }

            // updating carry.
            carry = sum / 10;

            // using modulus to get the node value
            sum = sum % 10;

            /**
             * creating a new node and store the node value
             */
            Node newNode = aLl.new Node(sum);

            // Connecting the previously made nodes
            newNode.nextNode = ans;

            // making the new node as the first node of all previously made node.
            ans = newNode;
        }

        // Return the node
        return ans;
    }

    // Method to reverse the list
    private static Node reverse(Node head) {

        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }
}