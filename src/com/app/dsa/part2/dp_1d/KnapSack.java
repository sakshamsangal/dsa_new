package com.app.dsa.part2.dp_1d;

public class KnapSack {

    DpInfoTab2d dpInfoTab2d;

    public static int getValueAtCell(int W, int[] val, int[] wt, int i, DpInfoMemo2d dpInfoMemo2d) {
        if (i == wt.length || W == 0) {
            return 0;
        }

        if (dpInfoMemo2d.isAnsAlreadyExist(i, W)) {
            return dpInfoMemo2d.getAnsForIndex(i, W);
        }

        // pick weight
        int opt1 = 0;
        if (wt[i] <= W) {
            opt1 = val[i] + getValueAtCell(W - wt[i], val, wt, i + 1, dpInfoMemo2d);
        }

        // skip
        int opt2 = getValueAtCell(W, val, wt, i + 1, dpInfoMemo2d);

        int max = Math.max(opt1, opt2);
        dpInfoMemo2d.saveAnsForIndex(i, W, max);
        return max;
    }

    static int knapsack1(int W, int val[], int wt[]) {
        DpInfoTab2d obj = new DpInfoTab2d(wt.length, W, dp -> {
            DpUtil.fillAllZeroInFirstRow(dp);
            DpUtil.fillAllZeroInFirstCol(dp);
        });

        for (int i = 1; i < obj.dpRows; i++) {
            for (int j = 1; j < obj.dpCols; j++) {

                int opt1 = 0;
                if (wt[i - 1] <= j) {
                    opt1 = val[i - 1] + obj.getAnsForIndex(i - 1, j - wt[i - 1]);
                }
                int opt2 = obj.getAnsForIndex(i - 1, j);
                int max = Math.max(opt1, opt2);

                obj.saveAnsForIndex(i, j, max);
            }
        }

        return obj.getAnsForIndex(obj.dpRows - 1, obj.dpCols - 1);
    }

    static int knapsack(int W, int val[], int wt[]) {
        int[] dp = new int[W + 1];
        for (int i = 0; i < wt.length; i++) {
            for (int j = W; j > 0; j--) {
                int opt1 = 0;
                if (wt[i] <= j) {
                    opt1 = val[i] + dp[j - wt[i]];
                }

                dp[j] =  Math.max(opt1, dp[j]);

            }
        }
        return dp[W];
    }
}
