package com.app.gfg_potd.dp;

import java.util.Arrays;
import java.util.Comparator;

class LongestStringChain {
    private boolean compareWords(String prevWord, String currWord) {
        int misMatchCount = 0;
        int i = 0;
        int j = 0;

        char[] prevWordArr = prevWord.toCharArray();
        char[] currWordArr = currWord.toCharArray();
        Arrays.sort(prevWordArr);
        Arrays.sort(currWordArr);

        System.out.println("prevWordArr = " + Arrays.toString(prevWordArr));
        System.out.println("currWordArr = " + Arrays.toString(currWordArr));

        while (i < prevWordArr.length) {
            if (prevWordArr[i] == currWordArr[j]) {
                i++;
                j++;
            } else if (misMatchCount == 1) {
                return false;
            } else {
                misMatchCount++;
                j++;
            }
        }
        return true;
    }

    public int foo(String[] words, int i, String prevWord, int[] dp) {
        if (i == words.length) {
            return 0;
        }
        if (dp[i] != -1) {
            return dp[i];
        }

        int opt1 = 0;
        if (prevWord == "" || (prevWord.length() + 1 == words[i].length() && compareWords(prevWord, words[i]))) {
            opt1 = 1 + foo(words, i + 1, words[i], dp);
        }
        int opt2 = foo(words, i + 1, prevWord, dp);

        return dp[i] = Math.max(opt1, opt2);
    }


    public int longestStringChain(String words[]) {
        int[] dp = new int[words.length];
        Arrays.sort(words, Comparator.comparingInt(String::length));

        Arrays.fill(dp, -1);
        return foo(words, 0, "", dp);
    }

    public static void main(String[] args) {
        LongestStringChain longestStringChain = new LongestStringChain();
        // String words[] = {"ba", "b", "a", "bca", "bda", "bdca"};
        String words[] = {"abcd" ,"dbqca"};
        int i = longestStringChain.longestStringChain(words);
        System.out.println("i = " + i);

    }
}