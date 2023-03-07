package com.test.alg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.util.Arrays;

public class SortTest {

    public int[] mergeArray(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int[] result = new int[arr1.length + arr2.length];

        int resIdx = 0;
        int idx1 = 0;
        int idx2 = 0;

        while(idx1 < arr1.length && idx2 < arr2.length) {
            if(arr1[idx1] > arr2[idx2]) {
                result[resIdx++] = arr2[idx2++];
            }else if(arr1[idx1] <= arr2[idx2]) {
                result[resIdx++] = arr1[idx1++];
            }
        }
        return result;
    }

    public void merge_array_11728(BufferedReader br, BufferedWriter bw) throws Exception{
        String[] srr = br.readLine().split(" ");

        int[] arr1 = new int[Integer.parseInt(srr[0])];
        int[] arr2 = new int[Integer.parseInt(srr[1])];

        String[] srr1 = br.readLine().split(" ");
        for(int i=0;i<arr1.length;i++) {
            arr1[i] = Integer.parseInt(srr1[i]);
        }

        String[] srr2 = br.readLine().split(" ");
        for(int i=0;i<arr2.length;i++) {
            arr2[i] = Integer.parseInt(srr2[i]);
        }

        int idx1 = 0;
        int idx2 = 0;
        StringBuilder sb = new StringBuilder();
        for(int i=0;i< arr1.length + arr2.length;i++) {
            if(idx2 == arr2.length) {
                sb.append(arr1[idx1++]).append(" ");
            }else if(idx1 == arr1.length) {
                sb.append(arr2[idx2++]).append(" ");
            }else if(arr1[idx1] > arr2[idx2]) {
                sb.append(arr2[idx2++]).append(" ");
            }else if(arr1[idx1] <= arr2[idx2]) {
                sb.append(arr1[idx1++]).append(" ");
            }
        }
        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    public void merge_array_11728_other_answer(BufferedReader br, BufferedWriter bw) throws Exception{
        String[] srr = br.readLine().split(" ");

        int n = Integer.parseInt(srr[0]);
        int m = Integer.parseInt(srr[1]);

        int[] arr = new int[n + m];

        String[] nrr = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(nrr[i]);
        }
        String[] mrr = br.readLine().split(" ");
        for(int i=n;i<arr.length;i++) {
            arr[i] = Integer.parseInt(mrr[i-n]);
        }

        Arrays.sort(arr);

        for(int i=0;i<arr.length;i++) {
            bw.write(arr[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    static int[] arr = {15,25,22,357,16,23,-53,12,46,3};
    static int[] tmp = new int[1000001];
    public void merge_sort(int st, int en) {
        if(en == st + 1) return;
        int mid = (st + en )/ 2;
        merge_sort(st, mid);
        merge_sort(mid, en);
        merge(st, en);
    }
    public void merge(int st, int en) {
        int mid = (st + en) / 2;
        int lidx = st;
        int ridx = mid;
        for(int i=st;i<en;i++) {
            if(ridx == en) tmp[i] = arr[lidx++];
            else if(lidx == mid) tmp[i] = arr[ridx++];
            else if(arr[lidx] <= arr[ridx]) tmp[i] = arr[lidx++];
            else tmp[i] = arr[ridx++];
        }
        for (int i=st;i<en;i++) {
            arr[i] = tmp[i];
        }
    }

    public void quick_sort(int[] arr) {
        int pivot = arr[0];
        int l=1, r=arr.length-1;
        while (true) {
            while (l <= r && arr[l] <= pivot) l++;
            while (l <= r && arr[r] > pivot) r--;
            if(l > r) break;
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        int tmp = arr[0];
        arr[0] = arr[r];
        arr[r] = tmp;

        System.out.println(Arrays.toString(arr));
    }

    public void quick_sort_recurse(int st, int en) {
        if(en <= st + 1) return;
        int pivot = arr[st];
        int l = st+1;
        int r = en-1;
        while (true) {
            while (l <= r && arr[l] <= pivot) l++;
            while (l <= r && arr[r] > pivot) r--;
            if(l > r) break;
            int tmp = arr[l];
            arr[l] = arr[r];
            arr[r] = tmp;
        }
        int tmp = arr[st];
        arr[st] = arr[r];
        arr[r] = tmp;
        quick_sort_recurse(st, r);
        quick_sort_recurse(r+1, en);
    }

    public void counting_sort(int[] arr) {
        int max = Arrays.stream(arr).max().getAsInt();
        int[] result = new int[max+1];
        for(int i=0;i<arr.length;i++) {
            result[arr[i]]++;
        }
        for(int i=1;i<result.length;i++) {
            int num = result[i];
            if(num > 0) {
                while (num > 0) {
                    System.out.printf(i + " ");
                    num--;
                }
            }
        }
    }

    public void sort_11652(BufferedReader br) throws Exception {
        int n = Integer.parseInt(br.readLine());
        long[] arr = new long[n];
        for(int i=0;i<n;i++) {
            arr[i] = Long.valueOf(br.readLine());
        }
        Arrays.sort(arr);

        int cnt = 0;
        long mxVal = -Double.doubleToLongBits(Math.pow(-2, 62)) - 1;
        int mxCnt = 0;

        for(int i=0;i<n;i++) {
            if(i == 0 || arr[i-1] == arr[i]) cnt++;
            else {
                if(cnt > mxCnt) {
                    mxCnt = cnt;
                    mxVal = arr[i-1];
                }
                cnt = 1;
            }
        }
        if(cnt > mxCnt) mxVal = arr[n-1];
        System.out.println(mxVal);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


//        SortTest test = new SortTest();

//        int n = 10;

//        int[] arr1 = {6, -8, 1, 12, 8, 3, 7, -1};
//        test.quick_sort(arr1);
//
//        test.quick_sort_recurse(0, n);
//        System.out.println(Arrays.toString(arr));
//
//        int[] arr2 = {5,5,4,3,2,1};
//        test.counting_sort(arr2);

    }
}
