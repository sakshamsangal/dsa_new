package com.app.gfg_potd.dp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// public int orangesRotting(int[][] mat) {
//     int fresh = 0;
//     int time = 0;
//
//     Queue<Pair> rottenQueue = new LinkedList<>();
//     for (int i = 0; i < mat.length; i++) {
//         for (int j = 0; j < mat[0].length; j++) {
//             if (mat[i][j] == 1) {
//                 fresh++;
//             } else if (mat[i][j] == 2) {
//                 rottenQueue.add(new Pair(i, j));
//             }
//         }
//     }
//     while (!rottenQueue.isEmpty()) {
//
//         boolean isRotten = false;
//         int size = rottenQueue.size();
//         for (int i = 0; i < size; i++) {
//
//             Pair src = rottenQueue.remove();
//             for (Pair direction : directions) {
//                 int x = src.i + direction.i;
//                 int y = src.j + direction.j;
//
//                 if (!outOfBound(x, y, mat)
//                         && mat[x][y] == 1) {
//
//                     isRotten = true;
//                     mat[x][y] = 2;
//                     rottenQueue.add(new Pair(x, y));
//                     fresh--;
//                 }
//             }
//         }
//         if (isRotten) {
//             time++;
//         }
//
//     }
//     if (fresh == 0) {
//         return time;
//     }
//     return -1;
// }

public class RottenOranges {

    static class Pair {
        public int i;
        public int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    List<Pair> directions = List.of(
            new Pair(1, 1),
            new Pair(-1, -1),
            new Pair(-1, 1),
            new Pair(1, -1),

            new Pair(0, -1),
            new Pair(0, 1),
            new Pair(1, 0),
            new Pair(-1, 0)
    );


    private static boolean outOfBound(int x, int y, char[][] mat) {
        return x == mat.length
                || x == -1
                || y == -1
                || y == mat[0].length;
    }

    public int countIslands(char[][] grid) {
        int island = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 'L') {
                    island = getIsland(grid, i, j, island);
                }
            }
        }

        return island;
    }


    private int getIsland(char[][] grid, int i, int j, int island) {

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        grid[i][j] = 'V';

        while (!queue.isEmpty()) {

            Pair pair = queue.remove();

            for (Pair direction : directions) {
                addToQueue(grid, direction, pair, queue);
            }

        }
        island++;
        return island;
    }


    private static void addToQueue(char[][] grid, Pair direction, Pair pair, Queue<Pair> queue) {
        int x = pair.i + direction.i;
        int y = pair.j + direction.j;

        if (!outOfBound(x, y, grid)
                && grid[x][y] == 'L') {

            grid[x][y] = 'V';
            queue.add(new Pair(x, y));

        }
    }




}
