package BinaryTree.IntermediateQuestions;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;

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

    static BottomViewOfBinaryTree bottomView = new BottomViewOfBinaryTree();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the elements of the tree : ");
        String str = sc.nextLine();

        Node root = buildTree(str);

        bottomTreeView(root);
    }

    private static void bottomTreeView(Node root) {

        if (root == null) {
            return;
        }

        int step = 0;

        Queue<Node> queue = new LinkedList<>();
        Map<Integer, Integer> bottomViewMap = new TreeMap<>();


        root.steps = step;
        queue.add(root);

        System.out.println("The bottom view of the tree is : ");

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

            Set<Entry<Integer, Integer>> set = bottomViewMap.entrySet();

            Iterator<Entry<Integer, Integer>> iterator = set.iterator();

            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> val = iterator.next();
                System.out.println(val.getValue());
            }
        }
        // root.steps = stepsValue;
        // queue.add(root);

        // while (!queue.isEmpty()) {

        // Node temp =queue.remove();

        // stepsValue = temp.steps;
        // nodeValue = temp.data;

        // bottomViewMap.put(stepsValue, nodeValue);

        // if (temp.left != null) {
        // temp.left.steps = stepsValue--;
        // queue.add(temp.left);
        // }

        // if (temp.right != null) {
        // temp.right.steps = stepsValue++;
        // queue.add(temp.right);
        // }
        // }

        // for(Entry<Integer, Integer> entry : bottomViewMap.entrySet()) {
        // System.out.println(entry.getValue() + " ");
        // }
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
