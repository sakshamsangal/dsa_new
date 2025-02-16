package com.app.dsa.binary_search_space;


import com.app.dsa.model.gfg.Node;

import java.util.Arrays;
import java.util.Objects;

public class Sample3_22_25 {
    public int maxDistance(int[] position, int ballCount) {

        Arrays.sort(position);
        int minDis = 1;
        int maxDis = position[position.length - 1];
        int ans = 1;
        while (minDis <= maxDis) {
            int distance = minDis + (maxDis - minDis) / 2;
            if (isPossible(position, ballCount, distance)) {
                ans = distance;
                minDis = distance + 1;
            } else {
                maxDis = distance - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] buckets, int ballCount, int distance) {
        int prevBucket = buckets[0];
        ballCount--;
        int bucketsLength = buckets.length;
        for (int i = 1; i < bucketsLength; i++) {
            int bucket = buckets[i];
            int currDis = bucket - prevBucket;
            if (currDis >= distance) {
                ballCount--;
                prevBucket = bucket;
                if (ballCount == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Sample3_22_25 sample2_09_48 = new Sample3_22_25();
        int i = sample2_09_48.maxDistance(new int[]{1, 2, 3, 4, 7}, 3);
        System.out.println("i = " + i);
    }

    Node reverseList(Node head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }
        Node node = reverseList(head.next);
        node.next = head;

        return node;
    }

}
