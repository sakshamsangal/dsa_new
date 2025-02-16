package com.app.dsa.binary_search_space;

// Template Design Pattern for Binary Search on Space
abstract class BinarySearchOnSpace {

    public int solve(int[] input, int target) {
        int lowLimit = initializeLowLimit(input);
        int highLimit = initializeHighLimit(input);
        int answer = highLimit;

        while (lowLimit <= highLimit) {
            int mid = lowLimit + (highLimit - lowLimit) / 2;

            if (isValid(input, mid, target)) {
                answer = mid;
                highLimit = mid - 1;
            } else {
                lowLimit = mid + 1;
            }

        }

        return answer;
    }

    // Abstract methods to be implemented by subclasses
    protected abstract int initializeLowLimit(int[] input);

    protected abstract int initializeHighLimit(int[] input);

    protected abstract boolean isValid(int[] input, int maxLimit, int givenCount);
}