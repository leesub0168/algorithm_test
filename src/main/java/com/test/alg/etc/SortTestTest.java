package com.test.alg.etc;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SortTestTest {

    @Test
    void test_mergeSort() {
        int[] arr1 = {1,1,0,5,4};
        int[] arr2 = {-1,2,3,0,4};

        SortTest sortTest = new SortTest();

        System.out.println(Arrays.toString(sortTest.mergeArray(arr1, arr2)));
    }
}