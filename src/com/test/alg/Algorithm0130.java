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

    public void hanoi_tower_11729(BufferedReader br, BufferedWriter bw) throws IOException {
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

    public void z_1074(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        bw.write(func(r,c,n)+"");
        bw.flush();
        bw.close();
    }
    public int func(int r, int c, int n) {
        if(n == 0) return 0;
        int half = (int)Math.pow(2,n-1);
        if(r < half && c < half) return func(r,c,n-1);
        if(r < half && c >= half) return half*half + func(r,c-half,n-1);
        if(r >= half && c < half) return 2*half*half + func(r-half,c,n-1);
        return 3 * half * half + func(r-half, c-half, n-1);
    }

    int cnt;
    public void recursive_17478(BufferedReader br, BufferedWriter bw) throws IOException {
        cnt = Integer.parseInt(br.readLine());
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");

        recurs(0, bw);
        bw.flush();
        bw.close();
    }
    public void recurs(int n, BufferedWriter bw) throws IOException {
        _bar("\"재귀함수가 뭔가요?\"\n", n,bw);
        if(n == cnt) {
            _bar("\"재귀함수는 자기 자신을 호출하는 함수라네\"\n", n,bw);
        }else {
            _bar("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n",n,bw);
            _bar("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n",n,bw);
            _bar("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n",n,bw);
            recurs(n+1,bw);
        }
        _bar("라고 답변하였지.\n",n,bw);
    }
    public void _bar(String str, int stk, BufferedWriter bw) throws IOException{
        for(int i=0;i<stk;i++) {
            bw.write("____");
        }
        bw.write(str);
    }
}

public class Algorithm0130 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Test0130 test0130 = new Test0130();
        test0130.recursive_17478(br,bw);
    }
}
