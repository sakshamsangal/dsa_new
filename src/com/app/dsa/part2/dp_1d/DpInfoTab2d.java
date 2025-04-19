package com.app.dsa.part2.dp_1d;

public class DpInfoTab2d {
    int[][] dp;
    int dpRows;
    int dpCols;

    public DpInfoTab2d(int rows, int cols, KnownAns knownAns) {
        this.dpRows = rows + 1;
        this.dpCols = cols + 1;
        this.dp = new int[dpRows][dpCols];
        knownAns.fillKnownAns(dp);
    }

    public int getAnsForIndex(int i, int j) {
        return dp[i][j];
    }

    public void saveAnsForIndex(int i, int j, int ans) {
        dp[i][j] = ans;
    }
}
