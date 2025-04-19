package com.app.gfg_potd.dp;

import java.util.Arrays;

public class LongestPalinSubseq {

    public static int getLength(int i, int j, String s1, String s2, int[][] dp) {

        if (i < 0 || j < 0) {
            return 0;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        if (s1.charAt(i) == s2.charAt(j)) {
            return 1 + getLength(i - 1, j - 1, s1, s2, dp);
        }

        int opt1 = getLength(i, j - 1, s1, s2, dp);
        int opt2 = getLength(i - 1, j, s1, s2, dp);
        return dp[i][j] = Math.max(opt1, opt2);
    }

    static int lcs(String s1, String s2) {
        // code here
        int[][] dp = new int[s1.length()][s2.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[s1.length()];
            Arrays.fill(dp[i], -1);
        }

        return getLength(s1.length() - 1, s2.length() - 1, s1, s2, dp);
    }

    public int longestPalinSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = new int[s.length()];
            Arrays.fill(dp[i], -1);
        }


        StringBuilder sb = new StringBuilder(s);

        return getLength(s.length() - 1, s.length() - 1, s, sb.reverse().toString(), dp);
    }


}
