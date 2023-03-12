package com.test.alg.implement.algorithm;

public class BinarySearch {

    public int binarySearch(int[] arr, int target) {
        int st = 0;
        int end = arr.length - 1;

        while (st <= end) {
            int mid = (st + end + 1) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] > target) {
                end = mid - 1;
            }else {
                st = mid + 1;
            }
        }
        return -1;
    }
}
