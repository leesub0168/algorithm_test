package com.test.alg.implement.algorithm;

/** 시간복잡도 평균적으로는 O(n log n), 최악인 경우 O(N^2), 추가적인 공간 필요없음 */
public class QuickSort {
    public int[] sort(int[] arr) {
        recurse(arr, 0, arr.length);
        return arr;
    }

    public void recurse(int[] arr, int st, int en) {
        if(en <= st + 1) return;
        int pivot = arr[st];
        int lt = st + 1;
        int rt = en -1;
        while (true) {
            while (lt <= rt && arr[lt] <= pivot) lt++;
            while (lt <= rt && arr[rt] > pivot) rt--;
            if(lt > rt) break;
            int tmp = arr[lt];
            arr[lt] = arr[rt];
            arr[rt] = tmp;
        }
        arr[st] = arr[rt];
        arr[rt] = pivot;
        recurse(arr, st, rt);
        recurse(arr, rt+1, en);
    }
}
