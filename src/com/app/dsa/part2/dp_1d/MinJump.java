package com.app.dsa.part2.dp_1d;

public class MinJump {
    static int[] jumps;
    static DpInfoTab1d dpInfoTab1d;

    public static int getJumpAtIndexTab(int hi) {
        for (int i = 1; i <= hi; i++) {

            int min = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (jumps[j] + j >= i) {
                    min = Math.min(min, dpInfoTab1d.getAnsForIndex(j));
                }
            }

            if (min == Integer.MAX_VALUE) {
                dpInfoTab1d.saveAnsForIndex(i, min);
            } else {
                dpInfoTab1d.saveAnsForIndex(i, min + 1);
            }
        }
        return dpInfoTab1d.getAnsForIndex(hi);
    }

    static int minJumps(int[] arr) {
        // code here
        jumps = arr;
        dpInfoTab1d = new DpInfoTab1d(arr, new KnownAns1d() {
            @Override
            public void fillKnownAns(int[] dp, int[] arr) {
                dp[0] = 0;
            }
        });
        int min = getJumpAtIndexTab(arr.length - 1);
        if (min == Integer.MAX_VALUE) {
            return -1;
        }
        return min;
    }

    static int minCostClimbingStairs(int[] cost) {
        DpInfoTab1d dpInfoTab1d = new DpInfoTab1d(cost, new KnownAns1d() {
            @Override
            public void fillKnownAns(int[] dp, int[] arr) {
                dp[0] = arr[0];
                dp[1] = arr[1];
            }
        });

        for (int i = 2; i < dpInfoTab1d.size; i++) {
            int opt1 = dpInfoTab1d.getAnsForIndex(i - 1);
            int opt2 = dpInfoTab1d.getAnsForIndex(i - 2);
            dpInfoTab1d.saveAnsForIndex(i, cost[i - 1] + Math.min(opt1, opt2));
        }
        return dpInfoTab1d.getAnsForIndex(dpInfoTab1d.size) - 1;
    }
}
