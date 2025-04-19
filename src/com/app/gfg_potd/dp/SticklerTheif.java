package com.app.gfg_potd.dp;

import java.util.Arrays;

public class SticklerTheif {

    public int explorePath(int[] arr, int i, int[] dp) {
        if (i >= arr.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int opt1 = arr[i] + explorePath(arr, i + 2, dp);
        int opt2 = explorePath(arr, i + 1, dp);

        return dp[i] = Math.max(opt1, opt2);
    }


    public static int[] getDp(int[] arr) {
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);
        return dp;
    }

    int findMaxSum(int[] arr) {
        int[] dp = new int[arr.length + 1];
        dp[0] = 0;
        dp[1] = arr[0];

        for (int i = 2; i < dp.length; i++) {
            int opt1 = arr[i - 1] + dp[i - 2];
            int opt2 = dp[i - 1];
            dp[i] = Math.max(opt1, opt2);
        }
        return dp[arr.length];
    }


    // }
    // int maxValue(int[] arr) {
    //     int[] first = new int[arr.length - 1];
    //     int[] second = new int[arr.length - 1];
    //     for (int i = 0; i < arr.length - 1; i++) {
    //         first[i] = arr[i];
    //     }
    //     for (int i = 1; i < arr.length; i++) {
    //         second[i] = arr[i];
    //     }
    //
    //     int opt1 = explorePath(first, 0, getDp(arr));
    //     int opt2 = explorePath(second, 0, getDp(arr));
    //     return Math.max(opt1, opt2);
    // }


}
