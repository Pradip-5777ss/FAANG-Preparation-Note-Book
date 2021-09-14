/**
 * Multiply two linked list.
 * Given elements as nodes of the two linked lists. The task is to multiply these two linked lists, say L1 and L2. 
 * Note: The output could be large take modulo 10^9+7.
 * 
 * Example :
 * Input :
 *      L1: 1->2->3
 *      L2: 4->5
 * Output : 5535
 */
package LinkedList.EasyQuestions;

import java.util.Scanner;

public class MultiplyTwoLL {

    static Node headNode1;
    static Node headNode2;
    static Node tailNode;

    // Node class for creating Linked list
    class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Create object of the class
        MultiplyTwoLL mTwoLL = new MultiplyTwoLL();

        // Ask user to enter the length of the 1st linked list
        System.out.print("Enter the length of the 1st Linked list : ");
        int length1 = sc.nextInt();

        // Ask user to enter the elements of the 1st linked list
        System.out.println("Enter the elements of the 1st Linked list");
        int num1 = sc.nextInt();
        headNode1 = tailNode = mTwoLL.new Node(num1);

        for (int i = 1; i < length1; i++) {
            int val = sc.nextInt();
            tailNode.nextNode = mTwoLL.new Node(val);
            tailNode = tailNode.nextNode;
        }

        // Ask user to enter the length of the 2nd linked list
        System.out.print("Enter the length of the 2nd linked list : ");
        int length2 = sc.nextInt();

        // Ask user to enter the elements of the 2nd linked list
        System.out.println("Enter the elements of the 2nd linked list : ");
        int num2 = sc.nextInt();
        headNode2 = tailNode = mTwoLL.new Node(num2);

        for (int i = 1; i < length2; i++) {
            int val = sc.nextInt();
            tailNode.nextNode = mTwoLL.new Node(val);
            tailNode = tailNode.nextNode;
        }

        sc.close();

        // Print the first list
        System.out.print("The 1st list is : ");
        printList(headNode1);

        // Print the second list
        System.out.print("The 2nd list is : ");
        printList(headNode2);

        // Method call to multiply two list
        long result = multiplyList(headNode1, headNode2);

        // Print the result
        System.out.println("After multiply two list the result is : " + result);
    }

    // Method to multiply two linked list
    private static long multiplyList(Node firstlist, Node secondlist) {

        long N = 1000000007;

        // Declare two variable to store the linked list as number
        long num1 = 0, num2 = 0;

        // Run a loop until both list is not null
        while (firstlist != null || secondlist != null) {

            // Traverse the first list until it is not null
            if (firstlist != null) {
                num1 = ((num1 * 10) % N + firstlist.data);
                firstlist = firstlist.nextNode;
            }

            // Traverse the second list until it is not null
            if (secondlist != null) {
                num2 = ((num2 * 10) % N + secondlist.data);
                secondlist = secondlist.nextNode;
            }
        }

        // Multiply two numbers and return the result
        return ((num1 % N) * (num2 % N)) % N;
    }

    // Method to print the list
    private static void printList(Node head) {

        if (head == null) {
            return;
        }

        while (head != null) {
            System.out.print(head.data + " ");
            head = head.nextNode;
        }
        System.out.println();
    }
}
