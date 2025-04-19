package com.app.dsa.util;

import com.app.dsa.model.gfg.linklist.Node;
import com.app.dsa.part2.graph.dij.Edge;
import com.app.dsa.part2.graph.dij.Vertex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppUtil {
    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;
    }

    static void reverse(int[] nums, int start) {
        int i = start;
        int j = nums.length - 1;
        while (i < j) {
            swapArrItem(nums, i, j);
            i++;
            j--;
        }
    }

    public static void swapArrItem(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swapArrItemChar(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isVowel(Node node) {
        return (node.data == 'a' || node.data == 'e' || node.data == 'i' || node.data == 'o' || node.data == 'u');
    }

    public static int[][] getDp2d(int[] arr, int sum) {
        int[][] dp = new int[arr.length + 1][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp;
    }


    public static int[] getDp(int[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return dp;
    }

    public static void travereMat(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {

            }
        }
    }

    public List<Vertex> getVertices(int V, int[][] edges) {
        List<Vertex> vertexList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            vertexList.add(new Vertex(i));
        }

        for (int[] row : edges) {
            Vertex u = vertexList.get(row[0]);
            Vertex v = vertexList.get(row[1]);

            Edge edge1 = new Edge(u, v, row[2]);
            Edge edge2 = new Edge(u, v, row[2]);

            u.adjList.add(edge1);
            v.adjList.add(edge2);
        }
        return vertexList;
    }

}
