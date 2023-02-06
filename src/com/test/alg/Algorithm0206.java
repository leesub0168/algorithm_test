package com.test.alg;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Test0206 {
    int[] arr = new int[10];
    boolean[] isUsed = new boolean[10];
    int n, m;
    public void n_and_m(BufferedReader br, BufferedWriter bw) throws IOException {
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        n = Integer.parseInt(st.nextToken());
//        m = Integer.parseInt(st.nextToken());
//
//        n_and_m_func(0, bw);
        test(10);

        bw.flush();
        bw.close();

    }
    public void test(int k) {
        if(k == 0) return;
        for(int i=1;i<=2;i++) {
            test(k-1);
        }
        System.out.println(k);
    }
    public void n_and_m_func(int k, BufferedWriter bw) throws IOException{
        System.out.println("k :" + k);
        if(k == m) {
            for(int i=0;i<m;i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }
        for(int i=1;i<=n;i++) {
            System.out.println(">> i :" + i);
            System.out.println("isUsed :" + isUsed[i]);
            if(!isUsed[i]) {
                System.out.println("i :" + i);
                arr[k] = i;
                isUsed[i] = true;
                n_and_m_func(k+1, bw);
                isUsed[i] = false;
            }
        }
    }
}
public class Algorithm0206 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0206 test0206 = new Test0206();
        test0206.n_and_m(br,bw);

    }
}
