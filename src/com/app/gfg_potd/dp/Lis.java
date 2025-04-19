package com.app.gfg_potd.dp;

public class Lis {
    static int lis(int arr[]) {
        int[] lisArray = new int[arr.length];
        int max = 1;
        for (int i = 0; i < arr.length; i++) {
            findLis(arr, i, lisArray);
            max = Math.max(max, lisArray[i]);
        }
        return max;
    }

    public static void findLis(int[] arr, int i, int[] lisArray) {
        int lis = 0;
        for (int j = 0; j < i; j++) {
            if (arr[j] < arr[i]) {
                lis = Math.max(lis, lisArray[j]);
            }
        }
        lisArray[i] = lis + 1;
    }

    public static void main(String[] args) {
        lis(new int[]{1,2,3});
    }
}
