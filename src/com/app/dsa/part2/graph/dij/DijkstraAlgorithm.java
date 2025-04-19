package com.app.dsa.part2.graph.dij;

import java.util.*;

public class DijkstraAlgorithm {

    public int[] dijkstra(int V, int[][] edges, int src) {

        List<Vertex> vertexList = getVertices(V, edges);

        int[] minDis = new int[V];
        Arrays.fill(minDis, Integer.MAX_VALUE);
        minDis[src] = 0;

        Vertex srcVertex = vertexList.get(src);
        srcVertex.disFromSrc = 0;

        PriorityQueue<Vertex> minDisPq = new PriorityQueue<>(Comparator.comparingInt(x -> x.disFromSrc));
        minDisPq.add(srcVertex);

        while (!minDisPq.isEmpty()) {

            Vertex u = minDisPq.poll();
            u.visited = true;

            for (Edge edge : u.adjList) {
                Vertex v = edge.v;

                if (!v.visited) {
                    int d = edge.u.disFromSrc + edge.wt;

                    if (d < minDis[v.key]) {
                        v.disFromSrc = d;
                        minDis[v.key] = d;

                        minDisPq.add(v);
                    }

                }
            }
        }
        return minDis;
    }

    private static List<Vertex> getVertices(int V, int[][] edges) {
        List<Vertex> vertexList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            vertexList.add(new Vertex(i));
        }

        for (int[] row : edges) {
            Vertex u = vertexList.get(row[0]);
            Vertex v = vertexList.get(row[1]);

            u.adjList.add(new Edge(u, v, row[2]));
            v.adjList.add(new Edge(v, u, row[2]));
        }
        return vertexList;
    }

}
