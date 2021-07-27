/**
 * Write a Program to check whether the Singly Linked list is a palindrome or not.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class CheckSinglyLLPalindrome {

    static Node headNode;
    static Node tailNode;
    static Node temp;

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            next = null;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the Linked list
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Ask user to enter the elements of the linked list
        System.out.println("Enter the elements of the linked list");

        // Create object of the class
        CheckSinglyLLPalindrome list = new CheckSinglyLLPalindrome();

        // Run a loop to take user input
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = list.new Node(val);
            createNewNode(hNode);
        }

        sc.close();

        // Method call to print the whole list
        printLL();

        // Method call to check wheather the list is palindrome or not
        if (is_palindrome(headNode) == true) {
            System.out.println("Is Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }
    }

    // Method to add elements in linked list
    private static void createNewNode(Node node) {

        if (headNode == null) {
            headNode = node;
            return;
        }

        temp = headNode;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = node;
    }

    // Method to check wheather the list is palindrome or not
    private static boolean is_palindrome(Node head) {

        // Declare a variable and initialize by 0
        int size = 0;
        temp = head;

        // Finding the number of nodes in the list
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        /**
         * If the size of the linked list is less than 2 then the linked list is
         * palindrome
         */
        if (size < 2) {
            return true;
        }

        // Store the address of the head in temp node
        temp = head;

        /**
         * now, we split list into 2 halves. In case of odd number of elements, first
         * half will have the middle element.
         */
        int mid = (size - 1) / 2;

        // Using a pointer to get to middle element element to get second half of list
        while (mid > 0) {
            temp = temp.next;
            mid--;
        }

        // temp now holds address of the last element of first half
        // Storing the element of second half separately in head2
        Node head2 = temp.next;
        temp.next = null;

        // Reverse the second half of list
        head2 = reverse_list(head2);

        /**
         * We check wheather both halves are identical or not (For odd number of
         * elements first half will have one extra element)
         */
        boolean res = is_Identical(head, head2);

        // Again reverse the second list and connect it to first half
        head2 = reverse_list(head2);
        temp.next = head2;

        // returning true if the list is palindrome else false
        return res;
    }

    // Method to check wheather two list are identical or not
    private static boolean is_Identical(Node head1, Node head2) {

        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }
            head1 = head1.next;
            head2 = head2.next;
        }

        return true;
    }

    // Method to reverse the list
    private static Node reverse_list(Node head) {

        Node prev = null;
        Node curr = head;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Method to print the linked list
    private static void printLL() {

        temp = headNode;

        System.out.println("The output LL is : ");

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}