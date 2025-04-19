package com.app.gfg_potd.dp;

import java.util.Arrays;

public class EqualPartition {


    public static int[][] getDp2d(int[] arr, int sum) {
        int[][] dp = new int[arr.length + 1][sum + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dp;
    }

    public static boolean explorePath(int[] arr, int i, int sum, int[][] dp) {
        if (sum == 0) {
            return true;
        }
        if (i == arr.length) {
            return false;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum] == 1;
        }

        boolean opt1 = false;
        if (arr[i] <= sum) {
            opt1 = explorePath(arr, i + 1, sum - arr[i], dp);
        }
        boolean opt2 = explorePath(arr, i + 1, sum, dp);

        boolean ans = opt1 || opt2;
        dp[i][sum] = ans ? 1 : 0;
        return ans;
    }
    //
    // static boolean equalPartition(int arr[]) {
    //     int sum = 0;
    //     for (int item : arr) {
    //         sum += item;
    //     }
    //
    //     if ((sum & 1) == 1) {
    //         return false;
    //     }
    //     sum /= 2;
    //     int[][] dp2d = getDp2d(arr, sum);
    //     return explorePath(arr, 0, sum, dp2d);
    //
    // }

    static boolean equalPartition(int arr[]) {
        int sum = 0;
        for (int item : arr) {
            sum += item;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;
        boolean[][] dp = new boolean[arr.length + 1][sum + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                boolean opt1 = false;
                if (arr[i - 1] <= j) {
                    opt1 = dp[i - 1][j - arr[i - 1]];
                }
                boolean opt2 = dp[i - 1][j];
                dp[i][j] = opt1 || opt2;
            }
        }

        return dp[arr.length][sum];
    }
}
