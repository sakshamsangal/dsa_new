package com.app.dsa.part2.dp_1d;

public class DpUtil {

    public static void fillAllZeroInFirstRow(int[][] dp) {
        for (int j = 0; j < dp[0].length; j++) {
            dp[0][j] = 0;
        }
    }
    public static void fillAllZeroInFirstCol(int[][] dp) {
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
    }
}
