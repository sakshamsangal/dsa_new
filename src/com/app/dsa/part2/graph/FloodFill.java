package com.app.dsa.part2.graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FloodFill {
    static class Cell {
        public int i;
        public int j;

        public Cell(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    List<Cell> directions = List.of(
            new Cell(0, -1),
            new Cell(0, 1),
            new Cell(1, 0),
            new Cell(-1, 0)
    );

    private static boolean outOfBound(int x, int y, int[][] mat) {
        return x == mat.length
                || x == -1
                || y == -1
                || y == mat[0].length;
    }


    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int srcColor = image[sr][sc];
        Queue<Cell> confirmedCell = new LinkedList<>();
        confirmedCell.add(new Cell(sr, sc));

        boolean[][] vis = new boolean[image.length][image[0].length];

        while (!confirmedCell.isEmpty()) {
            Cell polled = confirmedCell.poll();
            image[polled.i][polled.j] = newColor;
            vis[polled.i][polled.j] = true;

            findOtherCell(image, polled.i, polled.j, vis, confirmedCell, srcColor);
        }

        return image;
    }

    private void findOtherCell(int[][] image, int i, int j, boolean[][] vis, Queue<Cell> queue, int srcColor) {
        for (Cell direction : directions) {
            int x = i + direction.i;
            int y = j + direction.j;

            Cell cell = new Cell(x, y);

            if (!outOfBound(x, y, image)
                    && !vis[x][y]
                    && image[x][y] == srcColor) {

                queue.add(cell);
            }
        }
    }


}
