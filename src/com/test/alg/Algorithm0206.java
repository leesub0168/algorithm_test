package com.test.alg;

import java.io.*;
import java.util.*;

/**
* 백트래킹
* */
class Test0206 {
    int[] arr = new int[10];
    boolean[] isUsed = new boolean[10];
    int n, m;
    int[] data;
    StringBuilder sb = new StringBuilder();
    public void n_and_m(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        data = new int[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<n;i++) {
//            set.add(Integer.parseInt(st1.nextToken()));
            data[i] = Integer.parseInt(st1.nextToken());
        }
//        data = set.stream().mapToInt(Integer::intValue).toArray();
//        n = set.size();

        Arrays.sort(data);

        n_and_m_func_9(0);

        System.out.println(sb);
    }

    // 백준 15649
    public void n_and_m_func_1(int k){
        if(k == m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=1;i<=n;i++) {
            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                n_and_m_func_1(k+1);
                isUsed[i] = false;
            }
        }
    }

    // 백준 15650
    public void n_and_m_func_2(int k){
        if(k == m){
            for(int i=0;i<m;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int st = 1;
        if(k != 0) st = arr[k-1] +1;
        for(int i=st;i<=n;i++) {
            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                n_and_m_func_2(k+1);
                isUsed[i] = false;
            }
        }
    }

    // 백준 15651
    public void n_and_m_func_3(int k){
        if(k == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++) {
            arr[k] = i;
            n_and_m_func_3(k+1);
        }
    }

    // 백준 15652
    public void n_and_m_func_4(int k){
        if(k == m){
            StringBuilder tmp = new StringBuilder();
            for(int i=0;i<m;i++) {
                if(tmp != null && (i == 0 || (arr[i-1] <= arr[i]))) {
                    tmp.append(arr[i]).append(" ");
                }else {
                    tmp = null;
                }
            }
            if(tmp != null) {
                sb.append(tmp).append("\n");
            }
            return;
        }

        for(int i=1;i<=n;i++) {
            arr[k] = i;
            n_and_m_func_4(k+1);
        }
    }
    // 백준 15652
    public void n_and_m_func_4_answer(int k){
        if(k == m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int st = 1;
        if(k != 0) st = arr[k-1];
        for(int i=st;i<=n;i++) {
            arr[k] = i;
            n_and_m_func_4_answer(k+1);
        }
    }

    public void n_and_m_func_5(int k) {
        if(k == m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i=0;i<n;i++) {
            if(!isUsed[i]) {
                arr[k] = data[i];
                isUsed[i] = true;
                n_and_m_func_5(k+1);
                isUsed[i] = false;
            }
        }
    }

    // 백준 15655
    public void n_and_m_func_6(int k) {
        if(k == m) {
            for(int i=0;i<m;i++) {
                sb.append(data[arr[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }
        int st = 0;
        if(k != 0) st = arr[k-1]+1;
        for (int i=st;i<n;i++) {
            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                n_and_m_func_6(k+1);
                isUsed[i] = false;
            }
        }
    }

    // 백준 15656
    public void n_and_m_func_7(int k) {
        if(k == m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i=0;i<n;i++) {
            arr[k] = data[i];
            n_and_m_func_7(k+1);
        }
    }

    // 백준 15657
    public void n_and_m_func_8(int k) {
        if(k == m) {
            for(int i=0;i<m;i++) {
                sb.append(data[arr[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int st = 0;
        if(k != 0) st = arr[k-1];
        for(int i=st;i<n;i++) {
            arr[k] = i;
            n_and_m_func_8(k + 1);
        }
    }

    public void n_and_m_func_8_answer(int k, int st) {
        if(k == m) {
            for(int i=0;i<m;i++) {
                sb.append(data[arr[i]]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=st;i<n;i++) {
            arr[k] = i;
            n_and_m_func_8_answer(k + 1,i);
        }
    }

    // 백준 15663
    public void n_and_m_func_9(int k) {
        if(k == m) {
            for(int i=0;i<m;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int tmp = 0;
        for(int i=0;i<n;i++) {
            if(!isUsed[i] && tmp != data[i]) {
                isUsed[i] = true;
                arr[k] = data[i];
                tmp = arr[k];
                n_and_m_func_9(k+1);
                isUsed[i] = false;
            }
        }
    }




    int cnt = 0;
    boolean[] isused1 = new boolean[40];
    boolean[] isused2 = new boolean[40];
    boolean[] isused3 = new boolean[40];
    public int n_queen_9663(int k) {
        n = k;

        n_queen_func(0);

        return cnt;
    }

    public void n_queen_func(int cur) {
        if(n == cur) {
            cnt++;
            return;
        }
        for(int i=0;i<n;i++) {
            if(isused1[i] || isused2[i+cur] || isused3[cur-i+n-1]) continue;
            isused1[i] = true;
            isused2[i+cur] = true;
            isused3[cur-i+n-1] = true;
            n_queen_func(cur+1);
            isused1[i] = false;
            isused2[i+cur] = false;
            isused3[cur-i+n-1] = false;
        }
    }

    int s;
    int[] subseq;
    boolean[] isused_1182 = new boolean[22];
    public int sum_of_subsequence_1182(BufferedReader br) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        subseq = new int[30];
        String[] sArr = br.readLine().split(" ");
        for(int i=0;i<n;i++) {
            subseq[i] = Integer.parseInt(sArr[i]);
        }

        sum_subsequence_fuc(0,0);

        if(s == 0) cnt--;
        return cnt;
    }
//    int sum = 0;
    public void sum_subsequence_fuc(int cur, int tot) {
        if(cur == n) {
            if(tot == s) cnt++;
            return;
        }
        sum_subsequence_fuc(cur + 1, tot);
        sum_subsequence_fuc(cur + 1, tot+subseq[cur]);
    }


}
public class Algorithm0206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0206 test0206 = new Test0206();
        test0206.n_and_m(br);

    }
}
