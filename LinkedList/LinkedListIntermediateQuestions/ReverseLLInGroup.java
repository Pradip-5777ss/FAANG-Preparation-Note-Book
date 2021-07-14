/**
 * Write a program to reverse a linked list in group of given size.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class ReverseLLInGroup {

    static Node head;
    static Node temp;
    
    class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    public static void main(String[] args) {
        
        //  Create Scanner class to take user input
        Scanner sc = new Scanner(System.in);

        //  Ask user to enter the length of the linked list
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        //  Create object in the class
        ReverseLLInGroup rInGroup = new ReverseLLInGroup();

        //  Ask user to enter the elements of the list
        System.out.println("Enter the elements of list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = rInGroup.new Node(val);
            createNewNode(hNode);
        }

        //  Print the general list
        System.out.print("The general list is : ");
        printList();

        //  Ask user to enter the size of the group
        System.out.println("Enter the size of the groups : ");
        int k = sc.nextInt();

        sc.close();

        //  Call the method to reverse the list in group
        head = reverse(head, k);

        //  Print the reverse list
        System.out.println("The reverse list is :");
        printList();
    }

    //  Method to reverse the list in group
    private static Node reverse(Node node, int k) {

        Node curr = node, prev = null, next = null;

        int count = 0;

        //  Reversing k elements
        while (curr != null && count < k) {

            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
            count++;
        }

        /**
         * Checking if there are nodes ahead.
         * Reversing those nodes recursively.
         */ 
        if (curr != null) {
            node.nextNode = reverse(curr, k);
        }
        return prev;
    }

    //  Method to print the list
    private static void printList() {

        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.nextNode;
        }
        System.out.println();
    }

    //  Method to add element in the list
    private static void createNewNode(Node node) {

        if (head == null) {
            head = node;
            return;
        }

        temp = head;

        while (temp.nextNode != null) {
            temp = temp.nextNode;
        }
        temp.nextNode = node;
    }
}