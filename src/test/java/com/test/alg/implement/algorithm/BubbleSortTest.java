package com.test.alg.implement.algorithm;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    @Test
    void bubble_sort() {
        int[] arr = {3,3, 5, 6, 7, 2, 1, 4};
        BubbleSort bubbleSort = new BubbleSort();

        int[] res = bubbleSort.sort(arr);
        System.out.println(Arrays.toString(res));
    }
}