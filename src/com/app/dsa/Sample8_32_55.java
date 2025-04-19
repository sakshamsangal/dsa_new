package com.app.dsa;

import com.app.dsa.model.TreeNode;

import java.util.*;

public class Sample8_32_55 {

    Map<Integer, TreeNode> map = new HashMap<>();
    Set<Integer> vis = new HashSet<>();

    public int amountOfTime(TreeNode root, int start) {
        map.clear();
        vis.clear();
        inOrder(root, null);

        TreeNode startParNode = map.get(start);
        TreeNode startNode;
        if (Objects.isNull(startParNode)) {
            startNode = root;
        } else if (Objects.nonNull(startParNode.left)
                && startParNode.left.val == start) {
            startNode = startParNode.left;
        } else {
            startNode = startParNode.right;

        }

        Queue<TreeNode> newNodes = new LinkedList<>();
        newNodes.add(startNode);

        int time = -1;
        while (!newNodes.isEmpty()) {
            time++;
            int size = newNodes.size();
            for (int i = 0; i < size; i++) {
                handleNode(newNodes);
            }
        }

        return time;
    }

    private void handleNode(Queue<TreeNode> newNodes) {
        TreeNode node = newNodes.poll();
        vis.add(node.val);
        TreeNode par = map.get(node.val);

        if (Objects.nonNull(node.left)
                && !vis.contains(node.left.val)) {
            newNodes.add(node.left);
        }
        if (Objects.nonNull(node.right)
                && !vis.contains(node.right.val)) {
            newNodes.add(node.right);
        }
        if (Objects.nonNull(par)
                && !vis.contains(par.val)) {
            newNodes.add(par);
        }
    }

    private void inOrder(TreeNode root, TreeNode parent) {
        if (Objects.nonNull(root)) {
            inOrder(root.left, root);
            map.put(root.val, parent);
            inOrder(root.right, root);
        }
    }
}
