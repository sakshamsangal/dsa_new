package com.app.dsa.part2.dp_1d;

public class DpInfoTab1d {
    int[] dp;
    int size;

    public DpInfoTab1d(int[] arr, KnownAns1d knownAns) {
        this.dp = new int[arr.length+1];
        this.size = dp.length;
        knownAns.fillKnownAns(dp, arr);

    }

    public int getAnsForIndex(int i) {
        return dp[i];
    }

    public void saveAnsForIndex(int i, int ans) {
        dp[i] = ans;
    }

}
