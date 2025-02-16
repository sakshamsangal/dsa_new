package com.app.dsa;

import com.app.dsa.model.gfg.tree.Node;

import java.util.*;

public class LCA12 {


    private static int discovery;
    private static int node;
    private static int count;
    static Map<Integer, Integer> map = new HashMap<>();

    public int sumK(Node root, int k) {
        count = 0;
        map.clear();
        map.put(0, 1);

        processNodes(root, 0, k);
        return count;
    }

    private static final class Direction {
        int x;
        int y;

        public Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static final Map<Character, Direction> mapDirection = Map.of(
            'D', new Direction(1, 0),
            'L', new Direction(0, -1),
            'R', new Direction(0, 1),
            'U', new Direction(-1, 0)
    );

    public void travelAllPath(int[][] mat, int x, int y, int order, StringBuilder sb, ArrayList<String> ans, boolean[][] pathTracker) {

        if (x == order - 1 && y == order - 1) {
            ans.add(sb.toString());
            return;
        }
        if (x == -1 || y == -1 || x == order || y == order || mat[x][y] == 0) {
            return;
        }

        char[] directions = {'D', 'L', 'R', 'U'};
        for (char ch : directions) {


            if (!pathTracker[x][y]) {
                pathTracker[x][y] = true;
                sb.append(ch);
                Direction direction = mapDirection.get(ch);
                travelAllPath(mat, x + direction.x, y + direction.y, order, sb, ans, pathTracker);

                sb.deleteCharAt(sb.length() - 1);
                pathTracker[x][y] = false;
            }
        }
    }

    // Function to find all possible paths
    public ArrayList<String> findPath(ArrayList<ArrayList<Integer>> mat) {
        ArrayList<String> ans = new ArrayList<>();
        int[][] matrix = new int[mat.size()][mat.size()];
        boolean[][] pathTracker = new boolean[mat.size()][mat.size()];

        for (int i = 0; i < mat.size(); i++) {
            for (int j = 0; j < mat.size(); j++) {
                matrix[i][j] = mat.get(i).get(j);
            }
        }

        StringBuilder sb = new StringBuilder();
        travelAllPath(matrix, 0, 0, mat.size(), sb, ans, pathTracker);
        return ans;
    }


    public void addSum(Map<Integer, Integer> freqMap, int sum) {
        Integer freq = freqMap.getOrDefault(sum, 0);
        freqMap.put(sum, freq + 1);
    }

    public void removeSum(Map<Integer, Integer> freqMap, int sum) {
        Integer freq = freqMap.getOrDefault(sum, 0);
        if (freq == 1) {
            freqMap.remove(sum);
        } else {
            freqMap.put(sum, freq - 1);
        }
    }


    void processNodes(Node root, int sum, int target) {
        if (Objects.isNull(root)) {
            return;
        }
        sum += root.data;
        addSum(map, sum);

        checkForTarget(map, sum, target);

        processNodes(root.left, sum, target);
        processNodes(root.right, sum, target);

        removeSum(map, sum);
    }

    private void checkForTarget(Map<Integer, Integer> mapOfFirstNum, int mySum, int target) {
        int firstNum = mySum - target;
        Integer val = mapOfFirstNum.get(firstNum);
        if (Objects.nonNull(val)) {
            count += val;
        }
    }


    void iterate(Node root, List<Node> list) {
        if (Objects.isNull(root)) {
            return;
        }
        iterate(root.left, list);
        list.add(root);
        iterate(root.right, list);
    }


    void correctBST(Node root) {
        if (Objects.isNull(root)) {
            return;
        }
        List<Node> givenInorder = new ArrayList<>();
        iterate(root, givenInorder);

        List<Node> properInorder = new ArrayList<>(givenInorder);
        properInorder.sort(Comparator.comparingInt(o -> o.data));

        List<Node> findingNodes = new ArrayList<>();

        for (int i = 0; i < givenInorder.size(); i++) {
            if (givenInorder.get(i).data == properInorder.get(i).data) {
                findingNodes.add(givenInorder.get(i));
            }
        }

        Node firstNode = findingNodes.get(0);
        Node secondNode = findingNodes.get(1);

        int temp = firstNode.data;
        firstNode.data = secondNode.data;
        secondNode.data = temp;
    }

    Node LCA(Node root, Node n1, Node n2) {
        if (Objects.isNull(root)) {
            return null;
        }

        if (n1.data == root.data || root.data == n2.data) {
            return root;
        }

        Node left = LCA(root.left, n1, n2);
        Node right = LCA(root.right, n1, n2);

        if (Objects.nonNull(left) && Objects.nonNull(right)) {
            return root;
        }

        if (Objects.nonNull(left)) {
            return left;
        }

        if (Objects.nonNull(right)) {
            return right;
        }

        return root;
    }
}