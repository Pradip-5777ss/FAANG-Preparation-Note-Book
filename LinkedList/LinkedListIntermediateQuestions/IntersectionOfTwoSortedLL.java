/**
 * Intersection of two Sorted Linked List.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class IntersectionOfTwoSortedLL {
    
    static Node firstList;
    static Node secondList;
    static Node tail;
   
    public class Node {
        int data;
        Node nextNode;
        
        public Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }
    
    //  Create object of the class
    static IntersectionOfTwoSortedLL iOfTwoSortedLL = new IntersectionOfTwoSortedLL();

    public static void main(String[] args) {
        
        //  Create scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        //  Ask user to enter the length of the 1st list
        System.out.println("Enter the length of the linked list1 : ");
        int length = sc.nextInt();

        //  Ask user to enter the elements of 1st list
        System.out.println("Enter the elements of list1");
        int val = sc.nextInt();
        firstList = iOfTwoSortedLL.new Node(val);

        tail = firstList;
        
        for (int i = 1; i < length; i++) {
            val = sc.nextInt();
            tail.nextNode = iOfTwoSortedLL.new Node(val);
            tail = tail.nextNode;
        }

        //  Ask user to enter the length of 2nd list
        System.out.println("Enter the length of the linked list2 : ");
        int length2 = sc.nextInt();

        //  Ask user to enter the elements of 2nd list
        System.out.println("Enter the elements of list2");
        int val2 = sc.nextInt();
        secondList = iOfTwoSortedLL.new Node(val2);

        tail = secondList;
        
        for (int i = 1; i < length2; i++) {
            val2 = sc.nextInt();
            tail.nextNode = iOfTwoSortedLL.new Node(val2);
            tail = tail.nextNode;
        }

        sc.close();

        //  Method call to find the intersection between two list
        Node result = findIntersection(firstList, secondList);

        //  Method call to print the intersection element between two list
        System.out.println("The intersection of two list is ");
        printList(result);
    }

    //  Method to print the intersection element between two list
    private static void printList(Node node) {
        while (node != null) {
            System.out.println(node.data + " ");
            node = node.nextNode;
        }
        System.out.println();
    }

    //  Method to find the intersection between two list
    private static Node findIntersection(Node head1, Node head2) {

        //  Declare two nodes and initialize it by head node of each list
        Node first = head1;
        Node second = head2;

        Node head = null;
        Node tail = null;

        while (first != null && second != null) {

            /**
             * nodes does not match, moving to next node in list with smaller node
             */
            if (first.data > second.data) {
                second = second.nextNode;
            } 
            
            /**
             * nodes does not match, moving to next node in list with smaller node
             */
            else if (first.data < second.data) {
                first = first.nextNode;
            } 

            //  nodes match
            else {
                if (head == null) {
                    //  creating new head for intersection list
                    head = tail = iOfTwoSortedLL.new Node(first.data);
                } else {
                    //  Insert new node at the end
                    tail.nextNode = iOfTwoSortedLL.new Node(first.data);
                    tail = tail.nextNode;
                }

                //  moving to next nodes in both list
                first = first.nextNode;
                second = second.nextNode;
            }
        }
        return head;
    }   
}