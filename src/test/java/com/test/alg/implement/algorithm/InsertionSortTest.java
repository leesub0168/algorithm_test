package com.test.alg.implement.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {
    @Test
    @DisplayName("삽입정렬 테스트")
    void insertion_sort() {
        int[] arr = {5, 2, 3, 3, 1, 7, 7};
        InsertionSort insertionSort = new InsertionSort();

        int[] res = insertionSort.sort(arr);
        System.out.println(Arrays.toString(res));
    }
}