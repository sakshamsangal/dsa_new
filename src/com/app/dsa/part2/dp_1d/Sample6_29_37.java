package com.app.dsa.part2.dp_1d;


public class Sample6_29_37 {

    public int getPathCount(int[] coins, int i, int sum, DpInfoMemo2d dpInfoMemo2d) {
        if (sum == 0) {
            return 1;
        }
        if (sum < 0 || i == coins.length) {
            return 0;
        }
        if (dpInfoMemo2d.isAnsAlreadyExist(i, sum)) {
            return dpInfoMemo2d.getAnsForIndex(i, sum);
        }
        int opt1 = getPathCount(coins, i, sum - coins[i], dpInfoMemo2d);
        int opt2 = getPathCount(coins, i + 1, sum, dpInfoMemo2d);


        int ans = opt1 + opt2;
        dpInfoMemo2d.saveAnsForIndex(i, sum, ans);
        return ans;
    }


    public int count(int coins[], int sum) {
        DpInfoMemo2d dpInfoMemo2d = new DpInfoMemo2d(coins.length, sum + 1);
        return getPathCount(coins, 0, sum, dpInfoMemo2d);
    }
}
