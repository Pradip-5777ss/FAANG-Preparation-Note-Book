/**
 * Write a program to reverse a linked list Recursively.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class RecursiveLLReverse {

    static Node headNode;
    static Node tempNode;

    public class Node {
    
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
        }        
    }

    public static void main(String[] args) {
        
        //  Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        //  Ask user to enter the length of the linked list
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        //  create object of the class
        RecursiveLLReverse llReverse = new RecursiveLLReverse();

        //  Ask user to enter the elements of list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = llReverse.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        //  Print the general list
        System.out.print("The general list is : ");
        printList();

        //  Method call to reverse the list
        headNode = reverseListRecursively(headNode);

        //  Print the reverse list
        System.out.print("The reverse list is : ");
        printList();
    }

    //  Method to revere the list
    private static Node reverseListRecursively(Node node) {

        /**
         * base case
         * It returns the last node
         */  
        if (node == null || node.nextNode == null) {
            return node;
        }
 
        // recursive call
        Node newHead = reverseListRecursively(node.nextNode);

        //  Reverse the link
        node.nextNode.nextNode = node;
        node.nextNode = null;

        //  Return new head
        return newHead;
    }

    //  Method to print the linked list
    private static void printList() {
        tempNode = headNode;
        
        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }

    //  Method to add new element in list
    private static void createNewNode(Node node) {

        if (headNode == null) {
            headNode = node;
            return;
        }

        tempNode = headNode;

        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }
}