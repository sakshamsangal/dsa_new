package com.app.dsa.part2.graph.dij;

public class Edge {

    public Vertex u;
    public Vertex v;
    public boolean bridge;
    public Edge reverse;
    public int wt;

    public Edge(Vertex u, Vertex v) {
        this.u = u;
        this.v = v;
    }

    public Edge(Vertex u, Vertex v, int wt) {
        this.u = u;
        this.v = v;
        this.wt = wt;
    }
}
