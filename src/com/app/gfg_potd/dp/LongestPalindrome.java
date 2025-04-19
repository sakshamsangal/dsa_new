package com.app.gfg_potd.dp;

class LongestPalindrome {


    private static void expandWindow(int lo, int hi, char[] arr) {
        while (isIndexWithinBound(lo, hi, arr) && arr[lo] == arr[hi]) {
            int currLen = hi - lo + 1;
            if (range.len < currLen) {
                range.lo = lo;
                range.hi = hi;
                range.len = currLen;
            }
            lo--;
            hi++;
        }
    }



    static String longestPalindrome(String s) {
        range = new Range();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            expandWindow(i - 1, i + 1, arr);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            expandWindow(i, i + 1, arr);
        }
        return s.substring(range.lo, range.hi + 1);
    }



    static class Range {
        int lo = 0;
        int hi = 0;
        int len = 1;
        int count = 0;
    }

    static Range range;

    private static boolean isIndexWithinBound(int lo, int hi, char[] arr) {
        return lo >= 0 && hi != arr.length;
    }

    private static void expandWindow1(int lo, int hi, char[] arr) {
        while (isIndexWithinBound(lo, hi, arr) && arr[lo] == arr[hi]) {
            range.count++;
            lo--;
            hi++;
        }
    }


    public int countPS(String s) {
        // code here
        range = new Range();
        char[] arr = s.toCharArray();

        for (int i = 0; i < arr.length; i++) {
            expandWindow1(i - 1, i + 1, arr);
        }

        for (int i = 0; i < arr.length - 1; i++) {
            expandWindow1(i, i + 1, arr);
        }
        return range.count;
    }

    public static void main(String[] args) {
        String s = longestPalindrome("a12870821c121");
        System.out.println("s = " + s);

    }
}