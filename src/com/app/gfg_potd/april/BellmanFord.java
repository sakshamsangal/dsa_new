package com.app.gfg_potd.april;

import com.app.dsa.part2.graph.dij.Edge;
import com.app.dsa.part2.graph.dij.Vertex;

import java.util.ArrayList;
import java.util.List;

public class BellmanFord {

    List<Edge> edgeList;

    private static void updateDistance(Edge edge) {
        if (edge.u.disFromSrc != 100000000) {
            int d = edge.u.disFromSrc + edge.wt;

            Vertex v = edge.v;
            if (d < v.disFromSrc) {
                v.disFromSrc = d;
            }
        }
    }


    private List<Vertex> getVertices(int V, int[][] edges) {
        List<Vertex> vertexList = new ArrayList<>();
        edgeList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            vertexList.add(new Vertex(i));
        }

        for (int[] row : edges) {
            Vertex u = vertexList.get(row[0]);
            Vertex v = vertexList.get(row[1]);

            Edge edge1 = new Edge(u, v, row[2]);

            u.adjList.add(edge1);

            edgeList.add(edge1);
        }
        return vertexList;
    }


    public int[] bellmanFord(int V, int[][] edges, int src) {

        List<Vertex> vertices = getVertices(V, edges);
        vertices.get(src).disFromSrc = 0;

        for (int i = 0; i < V - 1; i++) {
            for (Edge edge : edgeList) {
                updateDistance(edge);
            }
        }
        for (Edge edge : edgeList) {
            if (edge.u.disFromSrc != 100000000) {
                int d = edge.u.disFromSrc + edge.wt;

                Vertex v = edge.v;
                if (d < v.disFromSrc) {
                    return new int[]{-1};
                }
            }
        }

        int[] minDis = new int[V];
        int i = 0;
        for (Vertex vertex : vertices) {
            minDis[i++] = vertex.disFromSrc;
        }
        return minDis;
    }

}
