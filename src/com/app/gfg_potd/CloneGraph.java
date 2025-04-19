package com.app.gfg_potd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {
    static class Node {
        int val;
        ArrayList<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int val) {
            this.val = val;
            neighbors = new ArrayList<>();
        }

        public Node(int val, ArrayList<Node> neighbors) {
            this.val = val;
            this.neighbors = neighbors;
        }
    }



    //
    // private Node dfs1(Node node) {
    //     Node newNode = map.get(node);
    //     if (Objects.nonNull(newNode)) {
    //         return newNode;
    //     }
    //     newNode = new Node(node.val);
    //     map.put(node, newNode);
    //
    //     for (Node neighbor : node.neighbors) {
    //         Node nei = dfs(neighbor);
    //         newNode.neighbors.add(nei);
    //     }
    //     return newNode;
    // }


    Map<Node, Node> map = new HashMap<>();

    Node cloneGraph(Node node) {
        map.clear();
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node) {
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node neighbor : node.neighbors) {
            if (!map.containsKey(neighbor)) {
                dfs(neighbor);
            }
            newNode.neighbors.add(map.get(neighbor));
        }
    }


}



