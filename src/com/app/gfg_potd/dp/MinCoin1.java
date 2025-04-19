package com.app.gfg_potd.dp;

import com.app.dsa.util.AppUtil;

public class MinCoin1 {

    int solveMinCoin(int[] arr, int i, int sum, int[][] dp) {
        if (sum == 0) {
            return 0;
        }
        if (i == arr.length) {
            return Integer.MAX_VALUE;
        }
        if (dp[i][sum] != -1) {
            return dp[i][sum];
        }

        int opt1 = Integer.MAX_VALUE;
        if (arr[i] <= sum) {
            opt1 = solveMinCoin(arr, i, sum - arr[i], dp);
            if (opt1 != Integer.MAX_VALUE) {
                opt1++;
            }
        }
        int opt2 = solveMinCoin(arr, i + 1, sum, dp);

        return dp[i][sum] = Math.min(opt1, opt2);
    }
    public int minCoins(int[] coins, int sum) {
        int[][] dp = AppUtil.getDp2d(coins, sum);
        int ans = solveMinCoin(coins, 0, sum, dp);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

}
