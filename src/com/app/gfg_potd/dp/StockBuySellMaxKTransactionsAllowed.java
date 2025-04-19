package com.app.gfg_potd.dp;

public class StockBuySellMaxKTransactionsAllowed {

    private static int explorePath(int[] arr, int i, int k, int[][] dp) {

        explorePath(arr, i + 1, k - 1, dp);

        return 1;
    }

    static int maxProfit(int prices[], int k) {


        return k;
    }
}
