/**
 * Write a program to Merge k sorted linked list
 */
package LinkedList.LinkedListIntermediateQuestions;

import java.util.Scanner;

public class MergeKsortedLL {

    static Node headNode;
    static Node tempNode;

    class Node {

        int data;
        Node nextNode;

        Node(int data) {
            this.data = data;
            nextNode = null;
        }
    }

    // Create object of the class
    static MergeKsortedLL mKsortedLL = new MergeKsortedLL();

    public static void main(String[] args) {

        // Create Scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the total no. of arrays present in the linked list
        System.out.print("The total no of arrays in the list are : ");
        int N = sc.nextInt();

        // Initialize the size into the array
        Node a[] = new Node[N];

        for (int i = 0; i < N; i++) {

            // Ask user to enter the size of each array in the list
            System.out.print("Enter the size of the " + (i + 1) + " array : ");
            int n = sc.nextInt();

            // Enter the 1st element in the array and make it head
            System.out.println("Enter the elements of the " + (i + 1) + " array");
            Node head = mKsortedLL.new Node(sc.nextInt());
            Node tail = head;

            // Enter another elements of the array
            for (int j = 0; j < n - 1; j++) {
                tail.nextNode = mKsortedLL.new Node(sc.nextInt());
                tail = tail.nextNode;
            }
            a[i] = head;
        }
        sc.close();

        // Method call to merge k sorted linked list
        Node result = mergeKlist(a, N);

        // Method call to print the output list
        System.out.println("the output is");
        if (result != null) {
            printList(result);
        }
    }

    // Method to merge k sorted linked list
    private static Node mergeKlist(Node[] arr, int K) {

        int N = K;

        int last = N - 1;

        while (last != 0) {
            int i = 0;
            int j = last;

            while (i < j) {

                // calling merge function to merge two different list into
                // one list which has sorted elements.
                arr[i] = merge(arr[i], arr[j]);

                // going for the next pair of lists.
                i++;
                j--;

                // if all pairs are merged, we update the last.
                if (i >= j)
                    last = j;
            }
        }
        // returning the merged list.
        return arr[0];
    }

    // Function to merge two sorted list into one sorted list.
    private static Node merge(Node a, Node b) {

        if (a == null) {
            return b;
        } else if (b == null) {
            return a;
        }

        /**
         * comparing data in both lists and storing the smaller in result and
         * recursively calling the merge function for next node in result.
         */
        if (a.data < b.data) {
            a.nextNode = merge(a.nextNode, b);
            // returning the resultant list.
            return a;
        } else {
            b.nextNode = merge(a, b.nextNode);
            // returning the resultant list.
            return b;
        }
    }

    // Method to print the sorted list
    private static void printList(Node result) {

        tempNode = result;

        while (tempNode != null) {
            System.out.print(tempNode.data + "->");
            tempNode = tempNode.nextNode;
        }
        System.out.println("null");
    }
}
