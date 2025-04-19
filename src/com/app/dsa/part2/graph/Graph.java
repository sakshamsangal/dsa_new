// package com.app.dsa.part2.graph;
//
// import java.util.ArrayList;
// import java.util.List;
//
//
// public class Graph {
//
//     public List<List<Vertex>> adjWithWeight;
//     public List<List<Integer>> adj;
//     public int size;
//     public boolean[] vis;
//
//     public Graph(int size) {
//         createGraphWithWeight(size);
//     }
//
//     public void createGraphWithWeight(int size) {
//         this.size = size;
//         this.vis = new boolean[size];
//         this.adjWithWeight = new ArrayList<>(size);
//
//         for (int i = 0; i < this.size; i++) {
//             adjWithWeight.add(new ArrayList<>());
//         }
//     }
//
//     public void addEdge(int u, int v) {
//         adj.get(u).add(v);
//     }
//
//     public void addEdgeWithWeight(int u, int v, int wt) {
//         adjWithWeight.get(u).add(new Vertex(v, wt));
//     }
//
//     public void addEdgeWithWeight2Way(int u, int v, int wt) {
//         addEdgeWithWeight(u, v, wt);
//         addEdgeWithWeight(v, u, wt);
//     }
//
// }
