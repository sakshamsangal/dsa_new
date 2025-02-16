package com.app.dsa.binary_search_space;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class BagsBall {
    public int minimumSize(int[] nums, int maxOperations) {
        int start = 1;
        int end = Arrays.stream(nums).max().orElseThrow(NoSuchElementException::new);
        int ans = end;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (isPossible(nums, maxOperations, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int maxOperations, int mid) {
        for (int num : nums) {
            if (num > mid) {
                int opsReq = num / mid;
                if (num % mid == 0) {
                    opsReq--;
                }

                if (opsReq <= maxOperations) {
                    maxOperations -= opsReq;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BagsBall bagsBall = new BagsBall();
        int i = bagsBall.minimumSize(new int[]{7, 17}, 2);
        System.out.println("i = " + i);
    }


}