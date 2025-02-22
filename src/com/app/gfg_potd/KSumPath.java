package com.app.gfg_potd;

import com.app.dsa.model.gfg.tree.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class KSumPath {

    private static int count=0;
    private static final Map<Integer, Integer> pathSums = new HashMap<>();

    public void addToMap(int sum) {
        Integer freq = pathSums.getOrDefault(sum, 0);
        pathSums.put(sum, freq + 1);
    }

    public void removeFromMap(int sum) {
        Integer freq = pathSums.get(sum);
        if (freq == 1) {
            pathSums.remove(sum);
        } else {
            pathSums.put(sum, freq - 1);
        }
    }

    private void checkForTarget(int pathSum, int target) {
        int firstNum = pathSum - target;
        Integer val = pathSums.get(firstNum);
        if (Objects.nonNull(val)) {
            count += val;
        }
    }

    void traverse(Node root, int pathSum, int target) {
        if (Objects.isNull(root)) {
            return;
        }
        pathSum += root.data;

        checkForTarget(pathSum, target);

        addToMap(pathSum);

        traverse(root.left, pathSum, target);
        traverse(root.right, pathSum, target);

        removeFromMap(pathSum);
    }

    public int sumK(Node root, int k) {
        count = 0;
        pathSums.clear();
        pathSums.put(0, 1);

        traverse(root, 0, k);
        return count;
    }

}
