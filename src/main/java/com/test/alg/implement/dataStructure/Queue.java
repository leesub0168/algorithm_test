package com.test.alg.implement.dataStructure;

import java.util.NoSuchElementException;

public class Queue<T> {
    private Node<T> front;
    private Node<T> last;

    public void push(T t) {
        Node<T> node = new Node<>(t);
        if (last != null) {
            last.next = node;
        }
        last = node;
        if (front == null) {
            front = last;
        }
    }

    public T pop() {
        if(front == null) throw new NoSuchElementException();
        T val = front.val;
        front = front.next;

        if (front == null) {
            last = null;
        }
        return val;
    }

    public T front() {
        if(front == null) throw new NoSuchElementException();
        return front.val;
    }

    public T back() {
        if(last == null) throw new NoSuchElementException();
        return last.val;
    }

    public boolean isEmpty() {
        return front == null;
    }

    class Node<T> {
        private T val;
        private Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }
}
