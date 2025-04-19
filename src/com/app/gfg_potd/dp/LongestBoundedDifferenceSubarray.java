package com.app.gfg_potd.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestBoundedDifferenceSubarray {


    static class Range {
        int lo = 0;
        int hi = 0;
        int len = 1;
    }

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        // code here
        Range range = new Range();

        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> pqMin = new PriorityQueue<>();
        Queue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder());

        pqMin.add(arr[0]);
        pqMax.add(arr[0]);

        int lo = 0;
        for (int high = 1; high < arr.length; high++) {
            pqMin.add(arr[high]);
            pqMax.add(arr[high]);

            while (pqMax.size() > 1 && pqMin.size() > 1 && pqMax.peek() - pqMin.peek() > x) {
                // delete lo
                pqMin.remove(arr[lo]);
                pqMax.remove(arr[lo]);
                lo++;
            }

            int currLen = high - lo + 1;

            // potential ans
            if (range.len < currLen) {
                range.lo = lo;
                range.hi = high;
                range.len = currLen;
            }
        }
        for (int i = range.lo; i <= range.hi; i++) {
            ans.add(arr[i]);
        }

        return ans;
    }

    public static void main(String[] args) {
        LongestBoundedDifferenceSubarray longestBoundedDifferenceSubarray = new LongestBoundedDifferenceSubarray();
        // int[] arr = new int[]{8, 4, 2, 6, 7};
        int[] arr = new int[]{15, 10, 1, 2, 4, 7, 2};
        ArrayList<Integer> integers = longestBoundedDifferenceSubarray.longestSubarray(arr, 5);
        System.out.println("integers = " + integers);
    }
}
