package com.app.dsa.binary_search_space;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class PainterPartition extends BinarySearchOnSpace {

    @Override
    protected int initializeLowLimit(int[] books) {
        return Arrays.stream(books).max().orElseThrow(NoSuchElementException::new);
    }

    @Override
    protected int initializeHighLimit(int[] books) {
        return Arrays.stream(books).sum();
    }

    @Override
    protected boolean isValid(int[] painters, int maxLimit, int givenCount) {
        int limit = 0;
        int painterCount = 1;
        for (int painter : painters) {
            if (limit + painter <= maxLimit) {
                limit += painter;
            } else {
                limit = painter;
                painterCount++;
            }
            if (painterCount > givenCount) {
                return false;
            }
        }
        return true;

    }


}