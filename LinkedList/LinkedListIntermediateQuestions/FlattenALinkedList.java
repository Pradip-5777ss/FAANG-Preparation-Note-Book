/**
 * Write a program to flattening a linked list
 */
package LinkedList.LinkedListIntermediateQuestions;

public class FlattenALinkedList {

    class Node {

        int data;
        Node nextNode;
        Node downNode;
    }

    public static void main(String[] args) {

        // Declare a node head and initialize it null
        Node head = null;

        // declare downNodes as arrays
        int[] arr1 = { 8, 6, 4, 1 };
        int[] arr2 = { 7, 3, 2 };
        int[] arr3 = { 9, 5 };
        int[] arr4 = { 12, 11, 10 };

        // Insert the arrays as vertical nodes
        head = createVerticalList(head, arr1);
        head.nextNode = createVerticalList(head.nextNode, arr2);
        head.nextNode.nextNode = createVerticalList(head.nextNode.nextNode, arr3);
        head.nextNode.nextNode.nextNode = createVerticalList(head.nextNode.nextNode.nextNode, arr4);

        // flatten and sort the list
        flatten(head);

        // Print the flattened and sorted linked list
        printList(head);
    }

    // Method to create linked list with elements of a given array
    private static Node createVerticalList(Node head, int[] arr) {

        // Declare a for each loop to insert the array elements in the list
        for (int key : arr) {
            head = push(head, key);
        }
        return head;
    }

    // Method to insert a new node at the beginning of a vertical linked list
    private static Node push(Node head, int data) {

        FlattenALinkedList fList = new FlattenALinkedList();

        Node newNode = fList.new Node();

        newNode.data = data;
        newNode.nextNode = null;
        newNode.downNode = head;

        return newNode;
    }

    // Recursive function to flatten and sort a given linked list
    private static Node flatten(Node head) {

        // base case: if list is empty then return
        if (head == null) {
            return head;
        }

        // Merge this list with the list on the right side
        Node sorted = sortedMerge(head, flatten(head.nextNode));

        // set next link to null after flattening
        head.nextNode = null;

        return sorted;
    }

    /**
     * Takes two lists sorted in incresing order and merge their nodes. To make one
     * big sorted list, which is returned
     */
    private static Node sortedMerge(Node leftList, Node rightList) {

        // base case
        if (leftList == null) {
            return rightList;
        } else if (rightList == null) {
            return leftList;
        }

        // Declare a node
        Node result;

        /**
         * pick either leftList or rightList and check which list data is small. take
         * that list and recursively merge and sort them.
         */
        if (leftList.data <= rightList.data) {
            result = leftList;
            result.downNode = sortedMerge(leftList.downNode, rightList);
        } else {
            result = rightList;
            result.downNode = sortedMerge(leftList, rightList.downNode);
        }

        return result;
    }

    // Method to print the list
    private static void printList(Node head) {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.downNode;
        }

        System.out.println("null");
    }
}