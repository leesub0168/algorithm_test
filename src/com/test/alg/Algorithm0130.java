package com.test.alg;

import java.io.*;
import java.util.StringTokenizer;

class Test0130 {
    public void multiply_1629(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        bw.write(pow(a,b,c)+"");
        bw.flush();
        bw.close();
    }
    public long pow(long a, long b, long c) {
        if(b == 1) return a % c;
        long val = pow(a, b/2, c);
        val = val * val % c;
        if(b%2 == 0) return val;
        return val * a % c;
    }
}

public class Algorithm0130 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0130 test0130 = new Test0130();
        test0130.multiply_1629(br,bw);

    }
}
