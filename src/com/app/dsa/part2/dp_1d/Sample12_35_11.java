package com.app.dsa.part2.dp_1d;

import java.util.Arrays;

public class Sample12_35_11 {

    static class DpInfoMemo {
        int[] dp;

        public DpInfoMemo(int[] arr) {
            dp = new int[arr.length + 1];
            Arrays.fill(dp, -1);
        }

        public boolean isAnsAlreadyExist(int i) {
            return dp[i] != -1;
        }

        public int getAnsForIndex(int i) {
            return dp[i];
        }

        public void saveAnsForIndex(int i, int min) {
            dp[i] = min;
        }
    }

    static int getCostToReachIndex(int i, int[] cost, DpInfoMemo dpInfoMemo) {
        if (i == 0 || i == 1) {
            return 0;
        }

        if (dpInfoMemo.isAnsAlreadyExist(i)) {
            return dpInfoMemo.getAnsForIndex(i);
        }

        int opt1 = cost[i - 1] + getCostToReachIndex(i - 1, cost, dpInfoMemo);
        int opt2 = cost[i - 2] + getCostToReachIndex(i - 2, cost, dpInfoMemo);

        int min = Math.min(opt1, opt2);

        dpInfoMemo.saveAnsForIndex(i, min);
        return min;
    }

    static int minCostClimbingStairs(int[] cost) {
        DpInfoMemo dpInfoMemo = new DpInfoMemo(cost);
        return getCostToReachIndex(cost.length, cost, dpInfoMemo);
    }


    public static void main(String[] args) {
        Sample12_35_11 sample12_35_11 = new Sample12_35_11();

    }
}
