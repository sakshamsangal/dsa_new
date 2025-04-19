package com.app.gfg_potd.april;

import com.app.dsa.part2.graph.dij.Edge;
import com.app.dsa.part2.graph.dij.Vertex;

import java.util.ArrayList;
import java.util.List;

public class MinWtCycle {
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

    public int findMinCycle(int V, int[][] edges) {

        List<Vertex> vertices = getVertices(V, edges);
        dfs(vertices.get(0), null);

        return V;
    }


    private void dfs(Vertex vertex, Vertex par) {
        vertex.visited = true;
        for (Edge edge : vertex.adjList) {
            if (!edge.v.visited) {
                dfs(edge.v, vertex);
            } else if (edge.v != par) {
                // cycle
            }
        }
    }


}
