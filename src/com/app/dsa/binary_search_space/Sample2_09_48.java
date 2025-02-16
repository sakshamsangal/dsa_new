package com.app.dsa.binary_search_space;

public class Sample2_09_48 {
    public int shipWithinDays(int[] weights, int days) {
        int minCapacity = 0;
        int maxCapacity = 0;

        for (int weight : weights) {
            minCapacity = Math.max(minCapacity, weight);
            maxCapacity += weight;
        }
        int ans = maxCapacity;

        if (weights.length == days) {
            return maxCapacity;
        }

        while (minCapacity <= maxCapacity) {
            int capacity = minCapacity + (maxCapacity - minCapacity) / 2;
            if (isPossible(weights, days, capacity)) {
                ans = capacity;
                maxCapacity = capacity - 1;
            } else {
                minCapacity = capacity + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] weights, int days, int capacity) {
        int sumOfWeights = 0;
        for (int weight : weights) {
            sumOfWeights += weight;
            if (sumOfWeights > capacity) {
                days--;
                if (days == 0) {
                    return false;
                }
                sumOfWeights = weight;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Sample2_09_48 sample2_09_48 = new Sample2_09_48();
        int i = sample2_09_48.shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3);
        System.out.println("i = " + i);
    }
}
