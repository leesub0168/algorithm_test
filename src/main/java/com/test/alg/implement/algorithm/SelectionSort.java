package com.test.alg.implement.algorithm;

public class SelectionSort {

    /** 시간복잡도 O(N^2) */
    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j < arr.length; j++) {
                if(arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            swap(arr, i, minIdx);
        }
        return arr;
    }

    private void swap(int[] arr, int i, int minIdx) {
        int tmp = arr[i];
        arr[i] = arr[minIdx];
        arr[minIdx] = tmp;
    }
}

