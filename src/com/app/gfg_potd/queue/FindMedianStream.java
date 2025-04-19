package com.app.gfg_potd.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianStream {

    public ArrayList<Double> getMedian(int[] arr) {
        Queue<Integer> leftMax = new PriorityQueue<>(Comparator.reverseOrder());
        Queue<Integer> rightMin = new PriorityQueue<>();

        ArrayList<Double> ans = new ArrayList<>();
        ans.add(arr[0] * 1.0);
        for (int i = 1; i < arr.length; i++) {
            if (i % 2 == 0) {
                leftMax.add(arr[i]);
                Integer leftMaxPeek = leftMax.peek();
                ans.add(leftMaxPeek * 1.0);
            } else {
                rightMin.add(arr[i]);

                Integer leftMaxPeek = leftMax.peek();
                Integer rightMinPeek = rightMin.peek();

                ans.add((leftMaxPeek + rightMinPeek) / 2.0);
            }
        }

        return ans;
    }
}
