/**
 * @author Pradip Sahoo
 * Created on 07/08/2022
 * ----------------------------
 * Graph and its representations using Adjacency List
 */
package Love_Babbar_DSA_Sheet.Graph.Easy_Questions;

import java.util.ArrayList;
import java.util.Scanner;

public class Q01_CreateGraphAndPrint {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the no of vertex : ");
        int vertex = sc.nextInt();

        System.out.print("Enter the no of edges : ");
        int edges = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(vertex);

        for (int i = 0; i < vertex; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < edges; i++) {
            System.out.println("Enter the source and destination of the edges : ");
            int source = sc.nextInt();
            int destination = sc.nextInt();
            adj.get(source).add(destination);
            adj.get(destination).add(source);
        }

        sc.close();

        printGraph(adj);
    }

    private static void printGraph(ArrayList<ArrayList<Integer>> adj) {
        for (int i = 0; i < adj.size(); i++) {
            System.out.print("Adjacency list of vertex " + i + " --> ");

            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(adj.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}