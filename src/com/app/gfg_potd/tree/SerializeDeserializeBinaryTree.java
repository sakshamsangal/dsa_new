package com.app.gfg_potd.tree;

import com.app.dsa.model.gfg.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SerializeDeserializeBinaryTree {

    void traverse(Node root, List<Integer> nodes) {
        if (Objects.isNull(root)) {
            return;
        }
        traverse(root.left, nodes);
        nodes.add(root.data);
        traverse(root.right, nodes);
    }

    // Function to serialize a tree and return a list containing nodes of tree.
    public ArrayList<Integer> serialize(Node root) {
        // code here
        ArrayList<Integer> nodes = new ArrayList<>();
        traverse(root, nodes);
        return nodes;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> arr) {
        if (Objects.isNull(arr) || arr.isEmpty()) {
            return null;
        }
        List<Node> nodes = new ArrayList<>();
        nodes.add(null);
        for (Integer integer : arr) {
            if (Objects.isNull(integer)) {
                nodes.add(null);
            } else {
                nodes.add(new Node(integer));
            }
        }


        for (int i = 1; i < nodes.size(); i++) {
            Node parent = nodes.get(i);
            if (Objects.nonNull(parent)) {

                if (2 * i < nodes.size()) {
                    parent.left = nodes.get(2 * i);
                }

                if ((2 * i) + 1 < nodes.size()) {
                    parent.right = nodes.get((2 * i) + 1);
                }

            }
        }
        return nodes.get(1);
    }

}
