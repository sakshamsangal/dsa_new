package com.app.gfg_potd.backtrack;

import java.util.Map;

public class WordSearch {
    private static final class Direction {
        int x;
        int y;

        public Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static final Map<Character, Direction> mapDirection = Map.of(
            'D', new Direction(1, 0),
            'L', new Direction(0, -1),
            'R', new Direction(0, 1),
            'U', new Direction(-1, 0)
    );


    public static boolean isOutOfBound(int x, int y, int rows, int cols) {
        return x < 0 || x == rows
                || y < 0 || y == cols;
    }


    public static boolean doesThisCelLeadToSolution(char[][] mat, int x, int y, String word, int i, boolean[][] visited) {
        if (i == word.length()) {
            return true;
        }
        if (isOutOfBound(x, y, mat.length, mat[0].length) || word.charAt(i) != mat[x][y] || visited[x][y]) {
            return false;
        }

        for (Direction direction : mapDirection.values()) {
            visited[x][y] = true;
            if (doesThisCelLeadToSolution(mat, x + direction.x, y + direction.y, word, i + 1, visited)) {
                return true;
            }
            visited[x][y] = false;
        }
        return false;
    }

    static boolean goToEveryCell(char[][] mat, String word, boolean[][] pathTracker) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (doesThisCelLeadToSolution(mat, i, j, word, 0, pathTracker)) {
                    return true;
                }
            }
        }
        return false;
    }

    static public boolean isWordExist(char[][] mat, String word) {
        boolean[][] recTracker = new boolean[mat.length][mat[0].length];
        return goToEveryCell(mat, word, recTracker);
    }
}
