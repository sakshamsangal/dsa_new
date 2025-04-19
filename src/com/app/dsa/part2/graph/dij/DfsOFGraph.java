package com.app.dsa.part2.graph.dij;

import java.util.ArrayList;
import java.util.List;

public class DfsOFGraph {

    ArrayList<Integer> ans = new ArrayList<>();

    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ans.clear();
        List<Vertex> vertexList = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            vertexList.add(new Vertex(i));
        }


        for (int i = 0; i < adj.size(); i++) {
            ArrayList<Integer> rows = adj.get(i);

            for (Integer nei : rows) {

                Vertex u = vertexList.get(i);
                Vertex v = vertexList.get(nei);

                Edge edge1 = new Edge(u, v);
                Edge edge2 = new Edge(v, u);

                v.adjList.add(edge2);
                u.adjList.add(edge1);
            }
        }

        for (Vertex vertex : vertexList) {
            if (!vertex.visited) {
                dfsRecur(vertex);
            }
        }

        return ans;
    }



    private void dfsRecur(Vertex vertex) {
        vertex.visited = true;
        ans.add(vertex.key);

        for (Edge edge : vertex.adjList) {
            if (!edge.v.visited) {
                dfsRecur(edge.v);
            }
        }

    }
}
