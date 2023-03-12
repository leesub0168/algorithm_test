package com.test.alg.implement.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    @Test
    void quick_sort() {
        int[] arr = {4, 2, 4, 6, 7, 1, 9};
        QuickSort quickSort = new QuickSort();
        int[] sort = quickSort.sort(arr);

        System.out.println(Arrays.toString(sort));
    }
}