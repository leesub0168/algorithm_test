package com.test.alg;

import java.io.*;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

class StackSample {
    final int MX = 1000005;
    int[] dat = new int[MX];
    int pos = 0;

    public void push(int x) {
        dat[pos++] = x;
    }
    public void pop() {
        pos--;
    }
    public int top() {
        return dat[pos-1];
    }
    public void test() {
        push(5);
        push(4);
        push(3);
        System.out.println(top());
        pop();
        pop();
        System.out.println(top());
        push(10);
        push(12);
        System.out.println(top());
        pop();
        System.out.println(top());
    }

    public void test_10828(BufferedReader br, BufferedWriter bw) throws IOException {
        Arrays.fill(dat, -1);
        int n = Integer.parseInt(br.readLine());
        while(n>0) {
            n--;
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if(s.equals("push")) {
                push(Integer.parseInt(st.nextToken()));
            }else if(s.equals("pop")) {
                if(pos == 0) {
                    bw.write("-1\n");
                }else {
                    bw.write(top() + "\n");
                    pop();
                }
            }else if(s.equals("top")) {
                if(pos == 0) {
                    bw.write("-1\n");
                }else {
                    bw.write(top() + "\n");
                }
            }else if(s.equals("size")) {
                bw.write(pos + "\n");
            }else {
                if(pos == 0) {
                    bw.write("1\n");
                }else {
                    bw.write("0\n");
                }
            }
        }
        bw.flush();
        bw.close();

    }
}
public class StackTest {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StackSample stackSample = new StackSample();
        stackSample.test_10828(br,bw);
    }
}
