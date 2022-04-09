package BinaryTree.IntermediateQuestions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class BottomViewOfBinaryTree {

    // Node class for create the Nodes of the Binary Tree
    class Node {
        int data;
        int steps;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            steps = Integer.MAX_VALUE;
            left = null;
            right = null;
        }
    }

    // Create object of the class
    static BottomViewOfBinaryTree bottomView = new BottomViewOfBinaryTree();

    public static void main(String[] args) {

        // Create scanner class object to take user input
        Scanner sc = new Scanner(System.in);

        // Ask user to enter the elements of the tree
        System.out.println("Enter the elements of the tree : ");
        String str = sc.nextLine();

        sc.close();

        // Call the method to build the tree
        Node root = buildTree(str);

        // Call the method to print the bottom view of the tree
        bottomTreeView(root);
    }

    // Method to print the bottom view of the tree
    private static void bottomTreeView(Node root) {

        // Base case
        if (root == null) {
            return;
        }

        int step = 0;

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Integer> bottomViewMap = new TreeMap<>();

        root.steps = step;
        queue.add(root);

        while (!queue.isEmpty()) {

            Node temp = queue.remove();

            step = temp.steps;
            int nodeValue = temp.data;

            bottomViewMap.put(step, nodeValue);

            if (temp.left != null) {
                temp.left.steps = step - 1;
                queue.add(temp.left);
            }

            if (temp.right != null) {
                temp.right.steps = step + 1;
                queue.add(temp.right);
            }
        }

        Set<Entry<Integer, Integer>> set = bottomViewMap.entrySet();

        Iterator<Entry<Integer, Integer>> iterator = set.iterator();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> val = iterator.next();
            System.out.println(val.getValue());
        }
    }

    private static Node buildTree(String str) {
        // base case
        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        // Split the string into an array
        String ip[] = str.split(" ");

        // Create the root of the tree
        Node root = bottomView.new Node(Integer.parseInt(ip[0]));

        // Declare a queue and push the root to the queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        // Starting from the second element
        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get the front element of the queue and remove it from the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currval = ip[i];

            // If the left child is not null
            if (!currval.equals("N")) {
                // Create the left child for the current node
                currNode.left = bottomView.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) {
                break;
            }
            currval = ip[i];

            // If the right child is not null
            if (!currval.equals("N")) {

                // Create the right child for the current node
                currNode.right = bottomView.new Node(Integer.parseInt(currval));
                // Push it into the queue
                queue.add(currNode.right);
            }
            i++;
        }
        return root;
    }
}
