package com.test.alg.implement.algorithm;

public class InsertionSort {
    /** 삽입정렬 O(N^2) */
    public int[] sort(int[] arr) {
        int n = arr.length;
        while (n > 0) {
            n--;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    int tmp = arr[i-1];
                    arr[i - 1] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        return arr;
    }
}
