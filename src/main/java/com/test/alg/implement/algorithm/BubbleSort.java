package com.test.alg.implement.algorithm;

public class BubbleSort {

    /** 시간복잡도 O(N^2) */
    public int[] sort(int[] arr) {
        int num = arr.length - 1;

        while (num > 0) {
            num--;
            for (int i = 1; i < arr.length; i++) {
                if (arr[i - 1] > arr[i]) {
                    swap(arr, i);
                }
            }
        }
        return arr;
    }

    public void swap(int[] arr, int idx) {
        int tmp = arr[idx - 1];
        arr[idx - 1] = arr[idx];
        arr[idx] = tmp;
    }
}
