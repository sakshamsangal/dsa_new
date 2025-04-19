// package com.app.dsa.part2.graph;
//
// import java.util.Arrays;
// import java.util.List;
// import java.util.Queue;
//
// public class MinimumCostConnectHousesCity {
//
//     public int minCost(int[][] houses) {
//
//         Graph gp = new Graph(houses.length);
//         for (int i = 0; i < houses.length; i++) {
//             for (int j = i + 1; j < houses.length; j++) {
//                 int wt = getWt(houses, i, j);
//                 gp.addEdgeWithWeight2Way(i, j, wt);
//             }
//         }
//
//         return gpToMst(gp);
//     }
//
//     private static void updateDistance(Vertex nei, Vertex polled, int[] minDis, Queue<Vertex> pq) {
//         int totalDis = polled.currDis + nei.wt;
//         if (minDis[nei.key] > totalDis) {
//             minDis[nei.key] = totalDis;
//
//             nei.currDis = totalDis;
//             pq.add(nei);
//         }
//     }
//
//     private int gpToMst(Graph gp) {
//         int[] minDis = new int[gp.size];
//         Arrays.fill(minDis, Integer.MAX_VALUE);
//         minDis[0] = 0;
//
//         for (List<Vertex> vertex : gp.adjWithWeight) {
//             for (Vertex nei : gp.adjWithWeight.get(polled.key)) {
//                 if (!gp.vis[nei.key]) {
//                     updateDistance(nei, polled, minDis, pq);
//                 }
//             }
//         }
//
//         return 0;
//     }
//
//     private static int getWt(int[][] houses, int i, int j) {
//         int[] point1 = houses[i];
//         int[] point2 = houses[j];
//         int x = Math.abs(point1[0] + point2[0]);
//         int y = Math.abs(point1[1] + point2[1]);
//         return x + y;
//     }
// }
