package com.test.alg.etc;

import java.util.LinkedList;
import java.util.Queue;

class QueueSample {
    final int MX = 1000005;
    int[] dat = new int[MX];
    int head = 0, tail = 0;

    public void push(int x) {
        dat[tail++] = x;
    }
    public void pop() {
        head++;
    }
    public int front() {
        return dat[head];
    }
    public int back() {
        return dat[tail-1];
    }
    public void test() {
        push(10);push(20);push(30);
        System.out.println(front());
        System.out.println(back());
        pop();pop();
        push(15);push(25);
        System.out.println(front());
        System.out.println(back());
    }

    public void queueTest() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(10);
        q.offer(20);
        q.offer(30);
        System.out.println(q.size());
        if(q.isEmpty())  {
            System.out.println("Q is Empty");
        }else {
            System.out.println("Q is not Empty");
        }
        q.poll();
        System.out.println(q.peek());
        System.out.println(q.peek());
        q.offer(40);
        q.poll();
        System.out.println(q.peek());

    }

}
public class QueueTest {
    public static void main(String[] args) {
        QueueSample queueSample = new QueueSample();
        queueSample.test();
    }
}
