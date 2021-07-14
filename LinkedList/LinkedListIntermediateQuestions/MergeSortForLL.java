/**
 * Merge Sort For Linked list.
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class MergeSortForLL {

    static Node headNode;
    static Node tempNode;

    public class Node {

        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {

        // Create scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        //  Ask user to enter the length of the linked list
        System.out.println("Enter the length of the linked list : ");
        int length = sc.nextInt();

        //  Create object of the class
        MergeSortForLL mSortForLL = new MergeSortForLL();

        //  Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list : ");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = mSortForLL.new Node(val);
            createNewNode(hNode);
        }
        sc.close();

        //  Method call to sort the list
        Node head = mergesort(headNode);

        //  Method call to print the sorted list
        System.out.print("The sorted list is : ");
        printList(head);
    }

    //  Method to sort the list
    private static Node mergesort(Node head) {

        if (head == null || head.nextNode == null) {
            return head;
        }

        /**
         * Splitting the list into two halves 
         * 1. First find the middle of the list 
         * 2. Then split the list into two halves, head to middle & next of the middle to
         * last. 
         * 3. Make next of the middle as null to split the list
         */
        Node middle = getMiddle(head);
        Node nextOfMiddle = middle.nextNode;
        middle.nextNode = null;

        // Calling the mergesort recursively for both parts separately
        Node left = mergesort(head);
        Node right = mergesort(nextOfMiddle);

        // Calling the merge for both halves
        Node sortedList = merge(left, right);
        return sortedList;
    }

    // Method to merge two halves of the list
    private static Node merge(Node left, Node right) {

        Node result = null;

        // Base case
        if (left == null) {
            return right;
        }

        if (right == null) {
            return left;
        }

        /**
         * comparing data in both halves and storing the smaller in result and
         * recursively calling the mergeList function for next node in result.
         */
        if (left.data < right.data) {
            result = left;
            result.nextNode = merge(left.nextNode, right);
        } else {
            result = right;
            result.nextNode = merge(left, right.nextNode);
        }
        
        //  Returning the resultant list
        return result;
    }

    //  Method to find the middle of the list
    private static Node getMiddle(Node head) {

        if (head == null) {
            return head;
        }

        /**
         * Using two pointers to find the middle element of the list
         */
        Node slow = head;
        Node fast = head;

        /**
         * first pointer, slow moves 1 node and second pointer, fast moves 2 nodes in one iteration.
         */
        while (fast.nextNode != null && fast.nextNode.nextNode != null) {
            slow = slow.nextNode;
            fast = fast.nextNode.nextNode;
        }

        //  slow pointer points to the miidle element of the list. so, we return slow
        return slow;
    }

    //  Method to print the list
    private static void printList(Node head) {
        tempNode = head;

        while (tempNode != null) {
            System.out.print(tempNode.data + " ");
            tempNode = tempNode.nextNode;
        }
        System.out.println();
    }

    //  Method to add new element in the list
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