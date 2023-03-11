package com.test.alg;

class DequeSample {
    final int MX = 1000005;
    int[] dat = new int[(2 * MX) + 1];
    int head = MX, tail = MX;

    public void push_front(int x) {
        dat[--head] = x;
    }
    public void push_back(int x) {
        dat[tail++] = x;
    }
    public void pop_front() {
        dat[head++] = 0;
    }
    public void pop_back() {
        dat[tail--] = 0;
    }
    public int front() {
        return dat[head];
    }
    public int back() {
        return dat[tail-1];
    }
    public void test() {
        push_back(30);
        System.out.println(front());
        System.out.println(back());
        push_front(25);
        push_back(12);
        System.out.println(back());
        push_back(62);
        pop_front();
        System.out.println(front());
        pop_front();
        System.out.println(back());
    }
}
public class DequeTest {
    public static void main(String[] args) {
        DequeSample sample = new DequeSample();
        sample.test();
    }
}
