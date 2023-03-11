package com.test.alg.etc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/** 이분탐색 **/
class BinarySearch {

    public void solution(BufferedReader br) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<m;i++) {
            int target = Integer.parseInt(st.nextToken());
            sb.append(search(arr,target)).append("\n");
            // Arrays.binarySearch(arr, n)로 대체가능
        }
        System.out.print(sb.toString());
    }

    public int search(int[] arr, int target) {
        int st = 0;
        int end = arr.length-1;
        while (st <= end) {
            int mid = (st + end) / 2;
//            int mid = (st + end + 1) / 2; // 무한루프 가능성시 이걸로 대체
            if(arr[mid] == target) return 1;
            else if(arr[mid] > target) {
                end = mid -1;
            }else {
                st = mid + 1;
            }
        }
        return 0;
    }

    /** 백준 10816번 숫자카드2 **/
    public void binary_search_10816(BufferedReader br) throws Exception {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            int x = Integer.parseInt(st.nextToken());
            System.out.println(end_idx(arr,x) - start_idx(arr,x));
        }
    }

    public int start_idx(int[] arr, int target) {
        int st = 0;
        int end = arr.length;

        while (st < end) {
            int mid = (st + end) / 2;
            if(arr[mid] >= target) {
                end = mid;
            }else {
                st = mid + 1;
            }
        }
        return st;
    }

    public int end_idx(int[] arr, int target) {
        int st = 0;
        int end = arr.length;

        while (st < end) {
            int mid = (st + end) / 2;
            if(arr[mid] > target) end = mid;
            else st = mid + 1;
        }
        return st;
    }

    // 구구단
    public void multiplication() {
        for(int i=2;i<=9;i++) {
            for(int j=1;j<=9;j++) {
                System.out.println(i + " * "  + j + " = " + (i * j));
            }
            System.out.println();
        }
    }
    /** test  **/
    public int func(int[] arr, int target) {
        int st = -1;
        int en = arr.length -1;
        while (st < en) {
//            int mid = (st + en) / 2; // 이렇게 되면 특정 상황에서 구간이 불균등해지면서 무한루프 발생
            int mid = (st + en + 1) / 2;
            if(arr[mid] < target) st = mid;
            else en = mid - 1;
        }
        return st;
    }

    /** 백준 18870번 좌표압축 */
    public void coordinate_compression_18870(int[] arr) {
        int[] copy = Arrays.copyOf(arr,arr.length);
        Arrays.sort(copy);

//        List<Integer> list = new ArrayList<>();
//        for(int i=0;i<copy.length;i++) {
//            if(i == 0 || copy[i-1] != copy[i]) list.add(copy[i]);
//        }
        /** 중복제거를 간단하게 구현하고 싶다면 stream을 사용하는것도 가능. */
        int[] tmp = Arrays.stream(copy).distinct().toArray();

        for(int i=0;i<arr.length;i++) {
            System.out.print(compress_cnt(tmp, arr[i]) + " ");
        }
    }
    public int compress_cnt(int[] arr, int target) {
        int st = 0;
        int end = arr.length -1;

        while(st <= end) {
            int mid = (st + end) / 2;
            if(arr[mid] == target) return mid;
            else if(arr[mid] >= target) {
                end = mid - 1;
            }else {
                st = mid + 1;
            }
        }
        return 0;
    }

    /** 백준 10815 숫자카드 */
    public void binary_search_10815(BufferedReader br) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int x = 10_000_000;
        int[] arr = new int[x * 2];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) {
            arr[x + Integer.parseInt(st.nextToken())]++;
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++) {
            sb.append(arr[x + Integer.parseInt(st.nextToken())]).append(" ");
        }
        System.out.println(sb);
    }

    /** 백준 2295번 세수의 합 */
    public void boj_2295(BufferedReader br) throws Exception {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        int[] sum = new int[n * n];
        int idx = 0;
        for (int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                sum[idx++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sum, 0, idx-1);

        for (int i=n-1;i>0;i--){
            for(int j=0;j<n;j++) {
                if(Arrays.binarySearch(sum, 0,idx-1, arr[i] - arr[j]) >= 0) {
                    System.out.println(arr[i]);
                    return;
                }
            }
        }
    }

    /** 백준 1822번 차집합 */
    public void boj_1822(BufferedReader br) throws Exception {
        String[] srr = br.readLine().split(" ");
        int n = Integer.parseInt(srr[0]);
        int m = Integer.parseInt(srr[1]);

        int[] arrA = new int[n];
        int[] arrB = new int[m];

        String[] tmp = br.readLine().split(" ");
        for (int i=0;i<n;i++) {
            arrA[i] = Integer.parseInt(tmp[i]);
        }

        String[] tmpB = br.readLine().split(" ");
        for (int i=0;i<m;i++) {
            arrB[i] = Integer.parseInt(tmpB[i]);
        }
        Arrays.sort(arrA);
        Arrays.sort(arrB);

        List<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++) {
            if(Arrays.binarySearch(arrB, arrA[i]) < 0) list.add(arrA[i]);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(list.size()).append("\n");
        for (Integer x : list) {
            sb.append(x).append(" ");
        }
        System.out.println(sb);
    }

    /** 백준 16401번 과자 나눠주기 */
    long[] arr_16401 = new long[10005];
    int n_16401, m_16401;
    public void boj_16401(BufferedReader br) throws Exception {
        String[] srr = br.readLine().split(" ");
        m_16401 = Integer.parseInt(srr[0]); // 3
        n_16401 = Integer.parseInt(srr[1]); // 10
//        과자길이 최대 10억..?
        String[] cookies = br.readLine().split(" ");
        for (int i=0;i<n_16401;i++) {
            arr_16401[i] = Long.parseLong(cookies[i]);
        }

        long st=1;
        long en = 1_000_000_000;
        while (st < en) {
            long mid = (st + en + 1) / 2;
            if(boj_16401_solve(mid)) st = mid;
            else en = mid - 1;
        }
        System.out.println(st);
    }

    public boolean boj_16401_solve(long x) {
        long cur = 0;
        for (int i=0;i<m_16401;i++) {
            cur += arr_16401[i] / x;
        }
        System.out.println("mid : " + x);
        System.out.println("cur : " + cur);
        return cur >= n_16401;
    }

    /** 백준 1654번 랜선 자르기 */
    int n_1654, k_1654;
    int[] arr = new int[10005];
    public void boj_1654(BufferedReader br) throws Exception {
        String[] srr = br.readLine().split(" ");
        k_1654 = Integer.parseInt(srr[0]); // 4
        n_1654 = Integer.parseInt(srr[1]); // 11
        for (int i=0;i<k_1654;i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long st = 1;
        long en = Integer.MAX_VALUE;
        while (st < en) {
            long mid = (st + en + 1) / 2;
            if(boj_1654_solve(mid)) st = mid;
            else en = mid -1;
        }
        System.out.println(st);
    }
    public boolean boj_1654_solve(long x) {
        long cur = 0;
        for (int i=0;i<k_1654;i++) {
            cur += arr[i] / x;
        }
        return cur >= n_1654;
    }

}
public class BinarySearchTest {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {2,7,11,11,16,19,22,22,22,32}; // 이렇게 되면 불균등해져서 무한루프
//        int[] arr = {2,7,11,11,11,16,19,22,22,22,32};
//        int[] coord = {2, 4, -10, 4, -9};
        int[] coord = {1000, 999, 1000, 999, 1000, 999};
        binarySearch.boj_16401(br);

//        System.out.println(binarySearch.func(arr, n));
//        binarySearch.coordinate_compression_18870(coord);
//        System.out.println(binarySearch.end_idx(arr,n));
//        binarySearch.binary_search_10816(br);
    }
}
