// package com.app.dsa.part2.graph;
//
// import java.util.Arrays;
// import java.util.Comparator;
// import java.util.PriorityQueue;
// import java.util.Queue;
//
// public class Prims {
//     public void foo(Graph gp) {
//
//         Queue<DistanceInfo> smallestEdge = new PriorityQueue<>(Comparator.comparingInt(x -> x.wt));
//         Vertex srcVertex = new Vertex(0, 0, 0);
//         smallestEdge.add(new DistanceInfo());
//
//         while (!smallestEdge.isEmpty()) {
//
//             DistanceInfo polled = smallestEdge.poll();
//             gp.vis[polled.u] = true;
//
//             for ( nei : gp.adjWithWeight.get(polled.u)) {
//                 smallestEdge.add(nei);
//             }
//         }
//
//     }
// }
