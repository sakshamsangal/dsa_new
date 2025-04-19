package com.app.gfg_potd.dp;

import java.util.Arrays;

public class TotalDecodingMessage {

    public static int[] getDp(char[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return dp;
    }

    public int explorePath(char[] arr, int i, int[] dp) {
        if (i == arr.length) {
            return 1;
        }

        if (arr[i] == '0') {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int opt1 = explorePath(arr, i + 1, dp);

        int opt2 = 0;
        if (i + 1 < arr.length && (arr[i] == '1' || (arr[i] < '2' && arr[i + 1] < '7'))) {
            opt2 = explorePath(arr, i + 2, dp);
        }
        return dp[i] = opt1 + opt2;
    }

    // public int countWays(String digits) {
    //     char[] arr = digits.toCharArray();
    //     int[] dp = getDp(arr);
    //     return explorePath(arr, 0, dp);
    // }
    public int countWays(String digits) {
        char[] arr = digits.toCharArray();
        if (arr[0] == '0') {
            return 0;
        }

        int[] dp = new int[arr.length + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < dp.length; i++) {
            int opt1 = 0;
            int opt2 = 0;

            if (arr[i - 1] != '0') {
                opt1 = dp[i - 1];
            }

            if (arr[i - 2] == '1' || (arr[i - 2] == '2' && arr[i - 1] < '7')) {
                opt2 = dp[i - 2];
            }

            if (opt1 != 0 || opt2 != 0) {
                dp[i] = opt1 + opt2;
            } else {
                return 0;
            }
        }
        return dp[arr.length];
    }

    public static void main(String[] args) {
        TotalDecodingMessage totalDecodingMessage = new TotalDecodingMessage();
        int i = totalDecodingMessage.countWays("36671106");
        System.out.println("i = " + i);
    }
}
