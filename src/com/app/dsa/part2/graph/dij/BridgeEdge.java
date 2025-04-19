package com.app.dsa.part2.graph.dij;

import java.util.ArrayList;
import java.util.List;

public class BridgeEdge {

    List<Edge> edgeList = new ArrayList<>();
    int timer = 0;

    private List<Vertex> getVertices(int V, int[][] edges) {
        List<Vertex> vertexList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            vertexList.add(new Vertex(i));
        }

        for (int[] row : edges) {
            Vertex u = vertexList.get(row[0]);
            Vertex v = vertexList.get(row[1]);

            Edge edge1 = new Edge(u, v);
            Edge edge2 = new Edge(v, u);
            u.adjList.add(edge1);
            v.adjList.add(edge2);

            edge1.reverse = edge2;
            edge2.reverse = edge1;

            edgeList.add(edge1);
            edgeList.add(edge2);
        }
        return vertexList;
    }


    public void dfs(Vertex src, Vertex parent) {
        src.visited = true;
        src.dis = timer;
        src.low = timer++;

        for (Edge edge : src.adjList) {
            if (!edge.v.visited) {
                dfs(edge.v, src);

                src.low = Math.min(src.low, edge.v.low);

                if (src.dis < edge.v.low) {
                    edge.bridge = true;
                    edge.reverse.bridge = true;
                }
            }

            // if ancestor
            else if (edge.v != parent) {
                src.low = Math.min(src.low, edge.v.dis);
            }
        }
    }

    public boolean isBridge(int V, int[][] edges, int c, int d) {
        timer = 0;
        List<Vertex> vertices = getVertices(V, edges);

        for (Vertex vertex : vertices) {
            if (!vertex.visited) {
                dfs(vertex, null);
            }
        }

        for (Edge edge : edgeList) {
            if (checkForVertex(c, d, edge)) {
                return edge.bridge;
            }
        }
        return false;
    }

    private static boolean checkForVertex(int c, int d, Edge edge) {
        return edge.u.key == c && edge.v.key == d;
    }

    public static void main(String[] args) {
        BridgeEdge bridgeEdge = new BridgeEdge();

        int[][] edges = {
                {6, 21}, {17, 12},
                {2, 11}, {9, 11}
        };
        boolean bridge = bridgeEdge.isBridge(29, edges, 17, 12);
        System.out.println("bridge = " + bridge);
    }
}
