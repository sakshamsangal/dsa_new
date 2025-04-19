package com.app.gfg_potd.dp;

import java.util.ArrayList;
import java.util.List;

public class Sample10_37_38 {


    public enum DirectionEnum {
        UP, DOWN, LEFT, RIGHT
    }

    public static class Cell {
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
            new Cell(-1, 0),
            new Cell(1, 0)
    );

    private static boolean outOfBound(int x, int y, char[][] mat) {
        return x == mat.length
                || x == -1
                || y == -1
                || y == mat[0].length;
    }

    public boolean explorePaths(char[][] board, String word) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {
                    char temp = board[i][j];
                    board[i][j] = '#';
                    if (explorePaths1(board, word, 1, new Cell(i, j))) {
                        board[i][j] = temp;
                        return true;
                    }
                    board[i][j] = temp;
                }
            }
        }
        return false;
    }

    public boolean explorePaths1(char[][] board, String word, int curr, Cell currCell) {
        if (curr == word.length()) {
            return true;
        }
        for (Cell cell : directions) {
            int a = currCell.i + cell.i;
            int b = currCell.j + cell.j;

            if (!outOfBound(a, b, board)) {
                if (word.charAt(curr) == board[a][b]) {
                    char temp = board[a][b];
                    board[a][b] = '#';
                    if (explorePaths1(board, word, curr + 1, new Cell(a, b))) {
                        board[a][b] = temp;
                        return true;
                    }
                    board[a][b] = temp;
                }
            }
        }
        return false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> ans = new ArrayList<>();

        for (String word : words) {
            boolean b = explorePaths(board, word);
            if (b) {
                ans.add(word);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Sample10_37_38 sample10_37_38 = new Sample10_37_38();
        // char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        // String[] words = {"oath", "pea", "eat", "rain"};
        char[][] board = {{'a', 'a'}, {'a', 'a'}};
        String[] words = {"aaaaa"};
        List<String> words1 = sample10_37_38.findWords(board, words);
        System.out.println("words1 = " + words1);
    }
}
