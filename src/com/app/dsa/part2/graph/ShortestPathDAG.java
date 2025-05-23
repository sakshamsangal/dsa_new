package com.app.dsa.part2.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class ShortestPathDAG {
    private final int V;
    private final LinkedList<AdjListNode>[] adj;

    ShortestPathDAG(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList<AdjListNode>();
    }

    public static void main(String[] args) {

        ShortestPathDAG g = new ShortestPathDAG(6);
        g.addEdge(0, 1, 2);
        g.addEdge(0, 4, 1);
        g.addEdge(1, 2, 3);
        g.addEdge(4, 2, 2);
        g.addEdge(4, 5, 4);
        g.addEdge(2, 3, 6);
        g.addEdge(5, 3, 1);

        int s = 0;
        System.out.println("Following are shortest distances " +
                "from source " + s);
        g.shortestPath(s);
    }

    void addEdge(int u, int v, int weight) {
        AdjListNode node = new AdjListNode(v, weight);
        adj[u].add(node);
    }

    void topologicalSortUtil(int v, Boolean[] visited, Stack stack) {

        visited[v] = true;
        Integer i;

        for (AdjListNode node : adj[v]) {
            if (!visited[node.getV()])
                topologicalSortUtil(node.getV(), visited, stack);
        }

        stack.add(v);
    }

    void shortestPath(int s) {
        Stack stack = new Stack();
        int[] dist = new int[V];

        Boolean[] visited = new Boolean[V];
        for (int i = 0; i < V; i++)
            visited[i] = false;

        for (int i = 0; i < V; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        for (int i = 0; i < V; i++)
            dist[i] = Integer.MAX_VALUE;
        dist[s] = 0;

        while (!stack.empty()) {
            int u = (int) stack.pop();

            Iterator<AdjListNode> it;
            if (dist[u] != Integer.MAX_VALUE) {
                it = adj[u].iterator();
                while (it.hasNext()) {
                    AdjListNode i = it.next();
                    if (dist[i.getV()] > dist[u] + i.getWeight())
                        dist[i.getV()] = dist[u] + i.getWeight();
                }
            }
        }

        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.print("INF ");
            else
                System.out.print(dist[i] + " ");
        }
    }

    class AdjListNode {
        private final int v;
        private final int weight;

        AdjListNode(int _v, int _w) {
            v = _v;
            weight = _w;
        }

        int getV() {
            return v;
        }

        int getWeight() {
            return weight;
        }
    }
}
