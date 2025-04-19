package com.app.dsa.part2.dp_1d;

public class DpInfoMemo2d {
    int[][] dp;

    public DpInfoMemo2d(int rows, int cols) {
        this.dp = new int[rows][cols];
        for (int[] row : dp) {
            for (int i = 0; i < cols; i++) {
                row[i] = -1;
            }
        }
    }

    public boolean isAnsAlreadyExist(int i, int j) {
        return dp[i][j] != -1;
    }

    public int getAnsForIndex(int i, int j) {
        return dp[i][j];
    }

    public int saveAnsForIndex(int i, int j, int ans) {
        dp[i][j] = ans;
        return dp[i][j];
    }

}
