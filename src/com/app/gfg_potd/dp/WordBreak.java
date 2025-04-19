package com.app.gfg_potd.dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {

    Set<String> set = new HashSet<>();

    public boolean explorePaths(String str, int start, int[] dp) {
        if (start == str.length()) {
            return true;
        }
        if (dp[start] != -1) {
            return dp[start] == 1;
        }
        for (int i = start; i < str.length(); i++) {
            String substring = str.substring(start, i + 1);

            if (set.contains(substring)) {
                if (explorePaths(str, i + 1, dp)) {
                    dp[start] = 1;
                    return true;
                }
            }
        }

        dp[start] = 0;
        return false;
    }

    private static int[] getDp(String str) {
        int[] dp = new int[str.length() + 1];
        Arrays.fill(dp, -1);
        return dp;
    }

    public boolean wordBreak(String s, String[] dictionary) {
        set.addAll(Arrays.asList(dictionary));
        return explorePaths(s, 0, getDp(s));
    }

    public static void main(String[] args) {
        WordBreak wb = new WordBreak();
        // String[] dictionary = {"i", "like", "gfg"};
        // boolean b = wb.wordBreak("ilike", dictionary);

        String[] dictionary = {"i", "like", "man", "india", "gfg"};
        boolean b = wb.wordBreak1("man", dictionary);
        System.out.println("b = " + b);

    }

    public boolean wordBreak1(String s, String[] dictionary) {
        set.addAll(Arrays.asList(dictionary));
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {
            for (int j = i + 1; j < s.length(); j++) {

                String substring = s.substring(i, j);

                if (set.contains(substring)) {
                    if (dp[i] == 1) {
                        dp[i] = 1;
                    }
                }
            }
        }

        return dp[dp.length - 1] == 1;
    }
}
