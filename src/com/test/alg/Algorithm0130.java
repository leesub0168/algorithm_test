package com.test.alg;

import java.io.*;
import java.util.StringTokenizer;

class Test0130 { // 재귀
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

    public void hanoi_tower(BufferedReader br, BufferedWriter bw) throws IOException {
        int n = Integer.parseInt(br.readLine());

        bw.write(((int)Math.pow(2,n) -1)+"\n");

        move(1,3, n, bw);

        bw.flush();
        bw.close();
    }

    public void move(int a, int b, int n, BufferedWriter bw) throws IOException{
        if(n == 1) {
            bw.write(a + " " + b + "\n");
            return;
        }
        move(a, 6-a-b, n-1, bw);
        bw.write(a + " " + b + "\n");
        move(6-a-b, b, n-1, bw);
    }
}

public class Algorithm0130 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0130 test0130 = new Test0130();
        test0130.hanoi_tower(br,bw);

    }
}
