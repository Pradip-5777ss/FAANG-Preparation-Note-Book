/**
 * Add two numbers represented by linked lists.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class AddTwoListRepresentedLL {

    static Node tail;
    static Node firstList;
    static Node secondList;

    public class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    //   create object of the class
    static AddTwoListRepresentedLL aLl = new AddTwoListRepresentedLL();

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the size of the 1st linked list
        System.out.println("Enter the length of list1 : ");
        int length = sc.nextInt();
        
        //  Ask user to enter the elements of the 1st list
        System.out.println("Enter the elements of list1 ");
        int val = sc.nextInt();
        firstList = aLl.new Node(val);

        tail = firstList;
        for (int i = 1; i < length; i++) {
            val = sc.nextInt();
            tail.nextNode = aLl.new Node(val);
            tail = tail.nextNode;
        }

        //  Ask user to enter the length of the 2nd linked list
        System.out.println("Enter the length of list2 : ");
        int length2 = sc.nextInt();

        //  Ask user to enter the elements of the 2nd list
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

        //  Method call to add two list
        Node res = addTwoList(firstList, secondList);

        //  Method call to Print the list
        System.out.println("the new list is : ");
        printList(res);

    }

    //  Method to print the list
    private static void printList(Node node) {

        while (node != null) {
            System.out.println(node.data + " ");
            node = node.nextNode;
        }
        System.out.println();
    }

    //  Method to add two list
    private static Node addTwoList(Node first, Node second) {

        // reversing both lists to simplify addition.
        first = reverse(first);
        second = reverse(second);

        Node sum = null;
        int carry = 0;

        // using a loop till both lists and carry gets exhausted.
        while (first != null || second != null || carry > 0) {
            // using a variable to store sum of two digits along with carry.
            int newVal = carry;

            // if nodes are left in any list, we add their data in newVal.
            if (first != null) {
                newVal = newVal + first.data;
            }
            if (second != null) {
                newVal = newVal + second.data;
            }

            // updating carry.
            carry = newVal / 10;

            // using modulus to store only a single digit at that place.
            newVal = newVal % 10;

            /**
             * creating new node which gets connected with other nodes that we get after
             * calculating sum of respective digits.
             */
            Node newNode = aLl.new Node(newVal);

            // storing the previously made nodes in the link part of new node.
            newNode.nextNode = sum;
           
            // making the new node as the first node of all previously made node.
            sum = newNode;

            // moving ahead in both lists.
            if (first != null) {
                first = first.nextNode;
            }

            if (second != null) {
                second = second.nextNode;
            }
        }

        return sum;
    }

    //  Method to reverse the list
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