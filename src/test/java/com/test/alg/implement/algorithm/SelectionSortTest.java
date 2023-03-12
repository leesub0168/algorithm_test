package com.test.alg.implement.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SelectionSortTest {

    @Test
    void sort() {
        int[] arr = {3,5,4,2,1};
        SelectionSort selectionSort = new SelectionSort();

        int[] res = selectionSort.sort(arr);
        System.out.println(Arrays.toString(res));
    }
}