package com.app.dsa.binary_search_space;

import java.util.Arrays;
import java.util.NoSuchElementException;

// Concrete Implementation for Book Allocation Problem
public class BookAllocation extends BinarySearchOnSpace {

    @Override
    protected int initializeLowLimit(int[] books) {
        return Arrays.stream(books).max().orElseThrow(NoSuchElementException::new);
    }

    @Override
    protected int initializeHighLimit(int[] books) {
        return Arrays.stream(books).sum();
    }

    @Override
    protected boolean isValid(int[] books, int maxLimit, int givenCount) {
        int studentsRequired = 1;
        int currentPageSum = 0;

        for (int book : books) {
            if (currentPageSum + book > maxLimit) {
                studentsRequired++;
                currentPageSum = book;

                if (studentsRequired > givenCount) {
                    return false;
                }
            } else {
                currentPageSum += book;
            }
        }

        return true;
    }


}
