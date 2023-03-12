package com.test.alg.implement.algorithm;

import java.util.Arrays;

/** 시간복잡도 O(n log n) */
public class MergeSort {

    public int[] sort(int[] arr) {
        int[] tmp = new int[arr.length];
        sort(arr, tmp, 0, arr.length -1);
        return arr;
    }

    public void sort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            sort(arr, tmp, start, mid);
            sort(arr, tmp, mid+1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    public void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid +1;
        int index = start;

        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index++] = tmp[part1++];
            }else {
                arr[index++] = tmp[part2++];
            }
        }
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
    }

    public int[] sort_merge_two(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] res = new int[arr1.length + arr2.length];

        int idx = 0;
        int pointer_1 = 0;
        int pointer_2 = 0;

        while (pointer_1 < arr1.length && pointer_2 < arr2.length) {
            if(arr1[pointer_1] > arr2[pointer_2]) {
                res[idx++] = arr2[pointer_2++];
            }else {
                res[idx++] = arr1[pointer_1++];
            }
        }

        if (pointer_2 < arr2.length) {
            for (int i = pointer_2; i < arr2.length; i++) {
                res[idx++] = arr2[i];
            }
        }

        if (pointer_1 < arr1.length) {
            for (int i = pointer_1; i < arr1.length; i++) {
                res[idx++] = arr1[i];
            }
        }
        return res;
    }
}
