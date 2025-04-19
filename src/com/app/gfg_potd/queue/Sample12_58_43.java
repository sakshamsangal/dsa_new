package com.app.gfg_potd.queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Sample12_58_43 {
    public ArrayList<Integer> maxOfMins(int[] arr) {
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            addMax(arr, i + 1, ans);
        }
        return ans;
    }

    public void addMax(int[] arr, int size, List<Integer> ans) {
        Deque<Integer> minQueue = new ArrayDeque<>();
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < size; i++) {
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] >= arr[i]) {
                minQueue.removeFirst();
            }
            minQueue.addLast(i);
        }

        max1 = Math.max(max1, arr[minQueue.peekFirst()]);

        int start = 0;
        for (int i = size; i < arr.length; i++) {
            while (!minQueue.isEmpty() && (minQueue.peekFirst() <= start || arr[minQueue.peekLast()] >= arr[i])) {
                minQueue.removeLast();
            }

            minQueue.addLast(i);
            max1 = Math.max(max1, arr[minQueue.peekFirst()]);

            start++;
        }

        ans.add(max1);
    }

    public static void main(String[] args) {


    }
}
