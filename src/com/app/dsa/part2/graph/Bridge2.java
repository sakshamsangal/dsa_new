// package com.app.dsa.part2.graph;
//
// import java.util.ArrayList;
// import java.util.List;
//
// public class Bridge2 {
//     public static int timer;
//     public static boolean[] ap;
//     public static int[] dis;
//     public static int[] low;
//
//     public static int dfs(int src, Graph gp, int parent, int c, int d) {
//         gp.vis[src] = true;
//         dis[src] = timer;
//         low[src] = timer++;
//
//         for (Integer nei : gp.adj.get(src)) {
//             if (!gp.vis[nei]) {
//                 int bridge = dfs(nei, gp, src, c, d);
//                 if (bridge == 1) {
//                     return 1;
//                 }
//                 if (dis[src] >= low[nei]) {
//                     // he can go up
//                     // he is not ap
//                     // let me update my top
//                     low[src] = Math.min(low[src], low[nei]);
//                 } else {
//                     // it is bridge
//                     if (src == c && nei == d) {
//                         return 1;
//                     }
//                     if (src == d && nei == c) {
//                         return 1;
//                     }
//
//                 }
//             } else if (nei != parent) {
//                 // he is ancestor
//                 // let me update my top
//                 // so that I can go up
//                 low[src] = Math.min(low[src], dis[nei]);
//             }
//         }
//         return 0;
//     }
//
//
//     //Function to find if the given edge is a bridge in graph.
//     static int isBridge(int V, List<List<Integer>> adj, int c, int d) {
//         Graph gp = new Graph(V);
//         gp.adj = adj;
//         return dfs(0, gp, -1, c, d);
//
//     }
// }
