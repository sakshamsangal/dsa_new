package com.app.dsa;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sample3_42_03 {

    public static class Cell {
        public int i;
        public int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }

    }


    public int orangesRotting(int[][] mat) {

        Queue<Cell> queue = new LinkedList<>();
        int fresh = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 2) {
                    queue.add(new Cell(i, j));
                }
                if (mat[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) {
            return 0;
        }

        int time = -1;
        while (!queue.isEmpty()) {
            time++;
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Cell cell = queue.poll();

                for (Cell direction : directions) {

                    int a = cell.i + direction.i;
                    int b = cell.j + direction.j;
                    if (!outOfBound(a, b, mat) && mat[a][b] == 1) {
                        mat[a][b] = 2;
                        queue.add(new Cell(a, b));
                        fresh--;
                    }

                }

            }
        }
        if (0 < fresh) {
            return -1;
        }
        return time;
    }

    List<Cell> directions = List.of(
            new Cell(0, -1),
            new Cell(0, 1),
            new Cell(-1, 0),
            new Cell(1, 0)
    );


    private static boolean outOfBound(int x, int y, int[][] mat) {
        return x == mat.length
                || x == -1
                || y == -1
                || y == mat[0].length;
    }
}
