package com.test.alg.implement.algorithm;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    @DisplayName("원소 탐색 (값이 존재하는 경우)")
    void binarySearch() {
        int[] arr = {2, 5, 6, 7, 1, 4};
        int target = 7;
        BinarySearch binarySearch = new BinarySearch();
        int res = binarySearch.binarySearch(arr, target);

        assertEquals(3, res);
    }

    @Test
    @DisplayName("원소 탐색 (값이 존재하지 않는 경우)")
    void binarySearch_non_exists() {
        int[] arr = {2, 5, 6, 7, 1, 4};
        int target = 8;
        BinarySearch binarySearch = new BinarySearch();
        int res = binarySearch.binarySearch(arr, target);

        assertEquals(-1, res);
    }
}