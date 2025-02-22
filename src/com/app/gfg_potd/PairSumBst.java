package com.app.gfg_potd;

import com.app.dsa.model.gfg.tree.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PairSumBst {

    void traverse(Node root, List<Integer> nodes) {
        if (Objects.isNull(root)) {
            return;
        }
        traverse(root.left, nodes);
        nodes.add(root.data);
        traverse(root.right, nodes);
    }


    boolean findTarget(Node root, int target) {
        List<Integer> nodes = new ArrayList<>();
        traverse(root, nodes);

        if (nodes.size() < 2) {
            return false;
        }

        int start = 0;
        int end = nodes.size() - 1;

        while (start < end) {
            int sum = nodes.get(start) + nodes.get(end);
            if (sum == target) {
                return true;
            } else if (sum < target) {
                start++;
            } else {
                end--;
            }
        }
        return false;
    }
}
