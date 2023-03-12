package com.test.alg.implement.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {

    @Test
    void merge_sort() {
        int[] arr1 = {3, 1, 3, 4, 2, 7};
        int[] arr2 = {5, 2, 6, 8, 1};

        MergeSort mergeSort = new MergeSort();
        int[] res = mergeSort.sort_merge_two(arr1, arr2);

        System.out.println(Arrays.toString(res));
    }

    @Test
    void merge_sort_self() {
        int[] arr1 = {3, 1, 3, 4, 2, 7};
        MergeSort mergeSort = new MergeSort();
        int[] sort = mergeSort.sort(arr1);

        System.out.println(Arrays.toString(sort));
    }
}