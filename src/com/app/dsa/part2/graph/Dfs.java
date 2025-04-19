// package com.app.dsa.part2.graph;
//
// import java.util.ArrayList;
// import java.util.List;
//
// public class Dfs {
//     public void dfs(int src, Graph undGraph) {
//         undGraph.vis[src] = true;
//         // undGraph.nodes.add(src);
//         for (Integer nei : undGraph.adj.get(src)) {
//             if (!undGraph.vis[nei]) {
//                 dfs(nei, undGraph);
//             }
//         }
//     }
//
//     public ArrayList<Integer> dfsWrapper(Graph undGraph) {
//         for (int i = 0; i < undGraph.size; i++) {
//             if (!undGraph.vis[i]) {
//                 dfs(0, undGraph);
//             }
//         }
//         return null;
//         // return undGraph.nodes;
//     }
//
//     public ArrayList<Integer> dfsOfGraph(int V, List<List<Integer>> adj) {
//         Graph undGraph = new Graph(V);
//         undGraph.adj = adj;
//         return dfsWrapper(undGraph);
//     }
// }
