// package com.app.gfg_potd.dp;
//
// import com.app.dsa.part2.graph.Graph;
//
// import java.util.ArrayList;
// import java.util.List;
//
// public class ArtPoint {
//     public static int timer;
//     public static boolean[] ap;
//     public static int[] dis;
//     public static int[] low;
//
//
//     static void dfs(int src, Graph gp, int parent) {
//         dis[src] = timer;
//         low[src] = timer++;
//         gp.vis[src] = true;
//
//         int child = 0;
//         for (Integer nei : gp.adj.get(src)) {
//             if (!gp.vis[nei]) {
//                 child++;
//                 dfs(nei, gp, src);
//
//                 if (low[nei] < dis[src]) {
//                     low[src] = Math.min(low[src], low[nei]);
//                 } else if (parent != -1) {
//                     ap[src] = true;
//                 }
//
//             }
//
//             if (nei != parent) {
//                 low[src] = Math.min(low[src], dis[nei]);
//             }
//         }
//
//         if (parent == -1 && 1 < child) {
//             ap[src] = true;
//         }
//
//     }
//
//     public static void initGraphForAp(int size) {
//         ap = new boolean[size];
//         dis = new int[size];
//         low = new int[size];
//         timer = 0;
//     }
//
//     static ArrayList<Integer> articulationPoints(int V, int[][] edges) {
//         Graph gp = new Graph(V);
//         initGraphForAp(V);
//
//         for (int[] rows : edges) {
//             gp.addEdgeWithWeight2Way(rows[0], rows[1], 0);
//         }
//
//         List<List<Integer>> adj = gp.adj;
//         for (int i = 0; i < adj.size(); i++) {
//             if (!gp.vis[i]) {
//                 dfs(i, gp, -1);
//             }
//         }
//
//         ArrayList<Integer> ans = new ArrayList<>();
//         for (int i = 0; i < ap.length; i++) {
//             if (ap[i]) {
//                 ans.add(i);
//             }
//         }
//
//         if (ans.isEmpty()) {
//             ans.add(-1);
//         }
//         return ans;
//     }
// }
