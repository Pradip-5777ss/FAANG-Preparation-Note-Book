/**
 * Count triplets in a sorted DLL whose sum is equal to given value	“X”.
 * Given a sorted doubly linked list of distinct nodes(no two nodes have the same data) 
 * and a value x. Count triplets in the list that sum up to a given value x.
 * 
 * Example:
 *      Input: DLL: 1<->2<->4<->5<->6<->8<->9
 *             x = 15
 *      Output: 5
 * 
 * Time Complexity : O(N)
 * Space Complexity : O(1)
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class CountTriplesInSortedDLL {

    static Node headNode;
    static Node tempNode;

    // Node class for creating linked list
    class Node {

        int data;
        Node nextNode;
        Node prevNode;

        public Node(int data) {
            this.data = data;
            nextNode = null;
            prevNode = null;
        }
    }

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the length of the linked list
        System.out.print("Enter the length of the linked list : ");
        int length = sc.nextInt();

        // Create object of the class
        CountTriplesInSortedDLL countTriplets = new CountTriplesInSortedDLL();

        // Ask user to enter the elements of the list
        System.out.println("Enter the elements of the list");
        for (int i = 0; i < length; i++) {
            int val = sc.nextInt();
            Node hNode = countTriplets.new Node(val);
            createNewNode(hNode);
        }

        // Ask user to enter the value to find triplets
        System.out.print("Enter the value to find triplets : ");
        int x = sc.nextInt();

        sc.close();

        // Method call to count the triplets of the given sum
        System.out.println("There are " + countTriplets(headNode, x) + " triplets in this doubly Linked list");
    }

    // Method to create new nodes in the list
    private static void createNewNode(Node node) {

        // First time when the list is empty then create headNode
        if (headNode == null) {
            headNode = node;
            headNode.prevNode = null;
            return;
        }

        // Make headNode as tempNode
        tempNode = headNode;

        // Add other nodes in the list
        while (tempNode.nextNode != null) {
            tempNode = tempNode.nextNode;
        }
        tempNode.nextNode = node;
        node.prevNode = tempNode;
    }

    /**
     * Method to count triplets in a sorted doubly linked list whose sum is equal to
     * a given value x
     */
    private static int countTriplets(Node head, int val) {

        // If list is empty
        if (head == null) {
            return 0;
        }

        Node curr, first, last;
        int count = 0;

        // get pointer to the last node of the doubly linked list
        last = head;
        while (last.nextNode != null) {
            last = last.nextNode;
        }

        // Traversing the doubly linked list
        curr = head;
        while (curr != null) {

            // for each current data
            first = curr.nextNode;

            /**
             * Count pairs with sum in the range first to last and add it to the count of
             * triplets
             */
            count = count + countPairs(first, last, val - curr.data);

            // Update the current node
            curr = curr.nextNode;
        }
        return count;
    }

    // Method to count pairs whose sum is equal to given value
    private static int countPairs(Node first, Node second, int val) {

        int count = 0;

        /**
         * The loop terminates when either two pointers become null, or they cross each
         * other, or they become same
         */
        while (first != null && second != null && first != second && second.nextNode != first) {

            // If pair found
            if ((first.data + second.data) == val) {

                // increment count
                count++;

                // Move first in forward direction
                first = first.nextNode;

                // Move second in backward direction
                second = second.prevNode;
            }

            /**
             * If the value is greater than the sum then move second first in forward
             * direction
             */
            else if ((first.data + second.data) < val) {
                first = first.nextNode;
            }

            // else move the second in backward direction
            else {
                second = second.prevNode;
            }
        }
        return count;
    }
}