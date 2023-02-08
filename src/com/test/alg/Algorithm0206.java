package com.test.alg;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
* 백트래킹
* */
class Test0206 {
    int[] arr = new int[10];
    boolean[] isUsed = new boolean[10];
    int n, m;
    public void n_and_m_15649(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        n_and_m_func(0, bw);

        bw.flush();
        bw.close();

    }

    public void n_and_m_func(int k, BufferedWriter bw) throws IOException{
        if(k == m) {
            for(int i=0;i<m;i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=1;i<=n;i++) {
            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                n_and_m_func(k+1, bw);
                isUsed[i] = false;
            }
        }
    }

    int cnt = 0;
    boolean[] isused1 = new boolean[40];
    boolean[] isused2 = new boolean[40];
    boolean[] isused3 = new boolean[40];
    public int n_queen_9663(int k) throws IOException {
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

    public void n_and_m_2_15650(BufferedReader br, BufferedWriter bw) throws IOException {
        String[] sArr = br.readLine().split(" ");
        n = Integer.parseInt(sArr[0]);
        m = Integer.parseInt(sArr[1]);

        n_m_func2(0,bw);

        bw.flush();
        bw.close();

    }

    public void n_m_func2(int k, BufferedWriter bw) throws IOException{
        if(k == m){
            for(int i=0;i<m;i++) {
                bw.write(arr[i]+" ");
            }
            bw.write("\n");
            return;
        }

        int st = 1;
        if(k != 0) st = arr[k-1] +1;
        for(int i=1;i<=n;i++) {
//            if(!isUsed[i]) {
                arr[k] = i;
                isUsed[i] = true;
                n_m_func2(k+1,bw);
                isUsed[i] = false;
            }
//        }
    }


    StringBuilder sb = new StringBuilder();
    public void n_and_m_2_15651(BufferedReader br) throws IOException {
        String[] sArr = br.readLine().split(" ");
        n = Integer.parseInt(sArr[0]);
        m = Integer.parseInt(sArr[1]);

        n_m_func3(0);

        System.out.println(sb);
    }
    public void n_m_func3(int k){
        if(k == m){
            for(int i=0;i<m;i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++) {
            arr[k] = i;
            n_m_func3(k+1);
        }
    }


}
public class Algorithm0206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0206 test0206 = new Test0206();
        test0206.n_and_m_2_15651(br);

    }
}
