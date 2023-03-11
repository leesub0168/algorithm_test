package com.test.alg.implement.dataStructure;

class CircularNode {
    int val;
    CircularNode next;
}
public class Circular_LinkedList {
    CircularNode header;

    public void add(int n) {
        CircularNode node = new CircularNode();
        node.val = n;
        if(header == null) {
            header = node;
            header.next = node;
        }else {
            CircularNode end = header;
            while (end.next != header) {
                end = end.next;
            }
            node.next = header;
            end.next = node;
        }
    }

    public void remove(int n) {
        if(n == 0) throw new ArrayIndexOutOfBoundsException();
        CircularNode node = header;
        while (node.next != header) {
            if(node.next.val == n) {
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
        if(node.next == header && node.next.val == n) {
            header = header.next;
            node.next = header;
        }
    }

    public CircularNode get(int k) {
        if(k == 0) throw new ArrayIndexOutOfBoundsException();
        CircularNode node = header;
        int cnt = 1;
        while (node.next != header) {
            if(cnt == k) break;
            else {
                node = node.next;
            }
        }
        return node;
    }

    public int getLength() {
        CircularNode node = header;
        if(node == null) return 0;
        int length = 1;
        while (node.next != header) {
            length++;
            node = node.next;
        }

        return length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        CircularNode node = header;
        while (node.next != header) {
            sb.append(node.val).append(" -> ");
            node = node.next;
        }
        sb.append(node.val);

        return sb.toString();
    }
}
