/**
 * Reverse a Linked List in groups of given size. 
 * Write a program to reverse a linked list in group of given size. Given a linked list 
 * of size N. The task is to reverse every k nodes (where k is an input to the function) 
 * in the linked list. If the number of nodes is not a multiple of k then left-out nodes, 
 * in the end, should be considered as a group and must be reversed.
 * 
 * Example 1:
 *      Input:
 *          LinkedList: 1->2->2->4->5->6->7->8
 *          K = 4
 *      Output: 4 2 2 1 8 7 6 5 
 * Explanation: The first 4 elements 1,2,2,4 are reversed first and then the next 4 elements
 * 5,6,7,8. Hence, the resultant linked list is 4->2->2->1->8->7->6->5.
 * 
 * Example 2:
 *      Input:
 *          LinkedList: 1->2->3->4->5
 *          K = 3
 *      Output: 3 2 1 5 4 
 * Explanation: The first 3 elements are 1,2,3 are reversed first and then elements 4,5 are 
 * reversed.Hence, the resultant linked list is 3->2->1->5->4.
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LinkedList.IntermediateQuestions;

import java.util.Scanner;

public class ReverseLLInGroup {

    static Node headNode;
    static Node tempNode;

    // Node class for creating Linked List
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

        // Ask user to enter the length of the linked list
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        ReverseLLInGroup rInGroup = new ReverseLLInGroup();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = rInGroup.new Node(val);
            createNewNode(hNode);
        }

        // Print the general list
        System.out.print("The general list is : ");
        printList();

        // Ask user to enter the size of the group
        System.out.print("Enter the size of the groups : ");
        int k = sc.nextInt();

        sc.close();

        // Method call to reverse the list in group of given size
        headNode = reverse(headNode, k);

        // Print the reverse list
        System.out.print("The reverse list is : ");
        printList();
    }

    // Method to create new node in the list
    private static void createNewNode(Node node) {

        // First time when the list is empty then create the headNode
        if (headNode == null) {
            headNode = node;
            return;
        }

        // Make the headNode as tempNode
        tempNode = headNode;

        // Add other nodes in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
    }

    // Method to reverse the list in groups of given size
    private static Node reverse(Node node, int k) {

        // Use three pointer method
        Node curr = node, prev = null, next = null;

        int count = 0;

        // Reversing k elements
        while (curr != null && count < k) {

            next = curr.nextNode;
            curr.nextNode = prev;
            prev = curr;
            curr = next;
            count++;
        }

        // Checking if there are nodes ahead, Reversing those nodes recursively.
        if (curr != null) {
            node.nextNode = reverse(curr, k);
        }
        return prev;
    }

    // Method to print the list
    private static void printList() {

        tempNode = headNode;

        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.nextNode;
        }
        System.out.println("null");
    }
}