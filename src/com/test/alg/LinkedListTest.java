package com.test.alg;

import java.util.Arrays;

class LinkedList {
    final int MX = 1000005;
    int[] dat = new int[MX], pre = new int[MX], next = new int[MX];
    int unused = 1;

    public void insert(int addr, int num) {
        dat[unused] = num;
        pre[unused] = addr;
        next[unused] = next[addr];
        if(next[addr] != -1) pre[next[unused]] = unused;
        next[addr] = unused;
        unused++;
    }
    public void erase(int addr) {
        next[pre[addr]] = next[addr];
        if(next[addr] != -1) pre[next[addr]] = pre[addr];
    }

    public void traverse() {
        int cur = next[0];

        while(cur != -1) {
            System.out.println(dat[cur] + " ");
            cur = next[cur];
        }
        System.out.println("\n");
    }

    public void insert_test() {
        Arrays.fill(pre,-1);
        Arrays.fill(next,-1);
        insert(0, 10); // 10(address=1)
        traverse();
        insert(0, 30); // 30(address=2) 10
        traverse();
        insert(2, 40); // 30 40(address=3) 10
        traverse();
        insert(1, 20); // 30 40 10 20(address=4)
        traverse();
        insert(4, 70); // 30 40 10 20 70(address=5)
        traverse();
    }
    public void erase_test() {
        erase(1); // 30 40 20 70
        traverse();
        erase(2); // 40 20 70
        traverse();
        erase(4); // 40 70
        traverse();
        erase(5); // 40
        traverse();
    }
}
public class LinkedListTest {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert_test();
        linkedList.erase_test();
    }
}
