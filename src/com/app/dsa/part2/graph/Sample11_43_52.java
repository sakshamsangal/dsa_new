package com.app.dsa.part2.graph;


import com.app.dsa.part2.graph.dij.Edge;
import com.app.dsa.part2.graph.dij.Vertex;

import java.util.*;

public class Sample11_43_52 {

    private List<Vertex> getVertices(int V, int[][] edges) {
        List<Vertex> vertexList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            vertexList.add(new Vertex(i));
        }

        for (int[] row : edges) {
            Vertex u = vertexList.get(row[0]);
            Vertex v = vertexList.get(row[1]);

            Edge edge1 = new Edge(u, v, row[2]);
            Edge edge2 = new Edge(v, u, row[2]);

            u.adjList.add(edge1);
            v.adjList.add(edge2);
        }
        return vertexList;
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        List<Vertex> vertices = getVertices(V, edges);
        Queue<Vertex> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x.disFromSrc));

        Vertex srcVer = vertices.get(src);
        srcVer.disFromSrc = 0;
        pq.add(srcVer);

        while (!pq.isEmpty()) {
            Vertex u = pq.poll();
            if (u.visited) {
                continue;
            }

            u.visited = true;

            for (Edge edge : u.adjList) {
                Vertex v = edge.v;
                if (!v.visited) {
                    int d = u.disFromSrc + edge.wt;
                    if (d < v.disFromSrc) {
                        v.disFromSrc = d;
                        pq.add(v);
                    }
                }
            }
        }

        int[] ans = new int[V];

        for (int i = 0; i < vertices.size(); i++) {
            Vertex vertex = vertices.get(i);
            ans[i] = vertex.disFromSrc;
        }
        return ans;
    }

}
