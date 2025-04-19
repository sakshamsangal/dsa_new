package com.app.dsa.part2.dp_1d;

public class MinCoin {

    public int pickCoinAtIndex(int hi, int sum) {
        if (sum == 0) {
            return 0;
        }
        if (hi == -1) {
            return Integer.MAX_VALUE;
        }
        if (dpInfoMemo2d.isAnsAlreadyExist(hi, sum)) {
            return dpInfoMemo2d.getAnsForIndex(hi, sum);
        }
        int opt1 = Integer.MAX_VALUE;
        if (coins[hi] <= sum) {
            opt1 = pickCoinAtIndex(hi, sum - coins[hi]);
            if (opt1 != Integer.MAX_VALUE) {
                opt1++;
            }
        }
        int opt2 = pickCoinAtIndex(hi - 1, sum);

        int min = Math.min(opt1, opt2);
        return dpInfoMemo2d.saveAnsForIndex(hi, sum, min);
    }

    DpInfoMemo2d dpInfoMemo2d;
    DpInfoTab2d dpInfoTab2d;

    int[] coins;

    public int pickCoinAtIndexTab(int rows, int cols) {

        for (int i = 1; i < rows; i++) {
            for (int sum = 1; sum < cols; sum++) {
                int opt1 = 10000;
                if (coins[i] <= sum) {
                    opt1 = 1 + dpInfoTab2d.getAnsForIndex(i, sum - coins[i]);
                }
                // skip
                int opt2 = dpInfoTab2d.getAnsForIndex(i - 1, sum);

                dpInfoTab2d.saveAnsForIndex(i, sum, Math.min(opt1, opt2));
            }
        }
        return dpInfoTab2d.getAnsForIndex(rows, cols);
    }

    // public int minCoins(int coins[], int sum) {
    //     // code here
    //     this.coins = coins;
    //     dpInfoTab2d = new DpInfoTab2d(coins.length, sum);
    //     int i = pickCoinAtIndexTab(coins.length, sum);
    //     if (i >= 10000) {
    //         return -1;
    //     }
    //     return i;
    // }
}
