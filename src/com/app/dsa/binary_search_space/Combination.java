package com.app.dsa.binary_search_space;

import java.util.Arrays;

public class Combination {

    static void foo(int[] arr, int arrStart, int[] path, int pathStart) {
        if (pathStart == 3) {
            System.out.println("path = " + Arrays.toString(path));
        } else if (arrStart < arr.length) {
            path[pathStart] = arr[arrStart];
            foo(arr, arrStart + 1, path, pathStart + 1);
            foo(arr, arrStart + 1, path, pathStart);
        }
    }

    static int countTriangles(int[] arr) {
        foo(arr, 0, new int[3], 0);
        return 0;
    }

    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 7};
        countTriangles(arr);
    }
}
