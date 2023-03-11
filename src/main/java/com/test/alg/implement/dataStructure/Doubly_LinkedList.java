package com.test.alg.implement.dataStructure;

class DoubleNode {
    int val;
    DoubleNode next;
    DoubleNode prev;
}
public class Doubly_LinkedList {
    private DoubleNode header;

    public Doubly_LinkedList() {
        this.header = new DoubleNode();
    }

    public void addNode(int n) {
        DoubleNode node = new DoubleNode();
        node.val = n;
        DoubleNode end = header;

        while (end.next != null) {
            end = end.next;
        }

        node.prev = end;
        end.next = node;
    }

    public void removeNode(int n) {
        DoubleNode node = header;
        while (node.next != null) {
            if (node.next.val == n) {
                if (node.next.next != null) {
                    node.next.next.prev = node;
                }
                node.next = node.next.next;
            }else {
                node = node.next;
            }
        }
    }

    public DoubleNode get(int k) {
        DoubleNode node = header;
        int cnt = 0;
        while (node.next != null) {
            if (cnt == k) {
                break;
            }else {
                cnt++;
                node = node.next;
            }
        }
        return node;
    }

    public DoubleNode getFirst() {
        return get(1);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        DoubleNode node = header.next;
        while (node.next != null) {
            sb.append(node.val).append(" -> ");
            node = node.next;
        }
        sb.append(node.val);

        return sb.toString();
    }
}
