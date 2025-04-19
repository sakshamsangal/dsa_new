package com.app.gfg_potd.stack;

import java.util.ArrayList;
import java.util.Stack;

public class Sample9_54_19 {
    // Function to find the next greater element for each element of the array.
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int[] ansArr = new int[arr.length];

        Stack<Integer> descOrderStack = new Stack<>();

        for (int i = arr.length - 1; i > -1; i--) {
            removeItemsIfReq(descOrderStack, arr[i]);
            if (descOrderStack.isEmpty()) {
                ansArr[i] = -1;
            } else {
                ansArr[i] = descOrderStack.peek();
            }
            descOrderStack.push(arr[i]);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int item : ansArr) {
            ans.add(item);
        }
        return ans;
    }


    private void removeItemsIfReq(Stack<Integer> descOrderStack, int item) {
        while (!descOrderStack.isEmpty() && item >= descOrderStack.peek()) {
            descOrderStack.pop();
        }
    }
}
