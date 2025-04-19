package com.app.dsa;

import com.app.dsa.util.AppUtil;

import java.util.ArrayList;

public class ample1_50_11 {


    ArrayList<String> perm = new ArrayList<>();

    public void findPermutationRecur(char[] arr, int curr) {
        if (curr == arr.length) {
            perm.add(new String(arr));
        }
        for (int i = curr; i < arr.length; i++) {
            AppUtil.swapArrItemChar(arr, curr, i);
            findPermutationRecur(arr, curr + 1);
            AppUtil.swapArrItemChar(arr, curr, i);
        }

    }

    public ArrayList<String> findPermutation(String s) {
        perm.clear();
        char[] charArray = s.toCharArray();
        findPermutationRecur(charArray, 0);
        return perm;
    }

    public static void main(String[] args) {
        ample1_50_11 ample1_50_11 = new ample1_50_11();
        ArrayList<String> abc = ample1_50_11.findPermutation("ABC");
        System.out.println("abc = " + abc);
    }
}
