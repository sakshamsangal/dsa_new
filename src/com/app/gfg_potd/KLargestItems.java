package com.app.gfg_potd;

import java.util.*;

public class KLargestItems {

    public ArrayList<Integer> kLargest(int[] arr, int k) {
        if (k == arr.length) {
            ArrayList<Integer> ans = new ArrayList<>();
            for (int j : arr) {
                ans.add(j);
            }
            ans.sort(Comparator.reverseOrder());
            return ans;
        }
        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            pq.add(arr[i]);
        }

        for (int i = k; i < arr.length; i++) {
            pq.add(arr[i]);
            pq.poll();
        }
        Stack<Integer> stack = new Stack<>();
        while (!pq.isEmpty()) {
            stack.push(pq.poll());
        }

        ArrayList<Integer> ans = new ArrayList<>();
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }

        return ans;
    }
}
