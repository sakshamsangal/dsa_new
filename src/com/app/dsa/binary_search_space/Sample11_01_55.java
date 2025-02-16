package com.app.dsa.binary_search_space;

// map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

import com.app.dsa.model.gfg.tree.Node;

import java.util.Arrays;
import java.util.Objects;

public class Sample11_01_55 {

    int countTriangles(int arr[]) {
        Arrays.sort(arr);
        int count = 0;
        for (int c = arr.length - 1; c >= 2; c--) {
            int a = 0;
            int b = c - 1;
            while (a < b) {
                if (arr[a] + arr[b] > arr[c]) {
                    count += b - a;
                    b--;
                } else {
                    a++;
                }

            }
        }
        return count;
    }

    public int maxWater(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        int lMax = arr[start];
        int rMax = arr[end];
        int waterCollected = 0;


        while (start < end) {
            if (arr[start] < arr[end]) {
                if (lMax > arr[start]) {
                    waterCollected += lMax - arr[start];
                } else {
                    lMax = arr[start];
                }
                start++;
            } else {
                if (rMax > arr[end]) {
                    waterCollected += rMax - arr[end];
                } else {
                    rMax = arr[end];
                }
                end--;
            }
        }

        return waterCollected;
    }

    static Node prev = null;

    public static void flatten(Node root) {
        if (Objects.isNull(root)) {
            return;
        }
        Node temp = root.right;
        // process node
        if (Objects.nonNull(prev)) {
            prev.right = root;
        }
        prev = root;

        flatten(root.left);
        flatten(temp);

    }


    public static void main(String[] args) {
        Sample11_01_55 sample11_01_55 = new Sample11_01_55();
        int[] arr = {10, 21, 22, 100, 101, 200, 300};
        int i = sample11_01_55.countTriangles(arr);
        System.out.println("i = " + i);
    }

}
