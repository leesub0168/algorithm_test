package com.test.alg.implement.dataStructure;

import java.util.NoSuchElementException;

public class Deque<T> {
    private Node<T> front;
    private Node<T> last;

    public void push_front(T t) {
        Node<T> node = new Node<>(t);
        if(front != null) {
            front.left = node;
            node.right = front;
        }
        front = node;
        if (last == null) {
            last = front;
        }
    }
    public void push_back(T t) {
        Node<T> node = new Node<>(t);
        if (last != null) {
            last.right = node;
            node.left = last;
        }
        last = node;
        if (front == null) {
            front = last;
        }
    }

    public T pop_front() {
        if(front == null) throw new NoSuchElementException();
        T val = front.val;

        if (last == front) {
            last = front.right;
            last.right = null;
        }
        front = front.right;
        front.left = null;

        return val;
    }

    public T pop_back() {
        if (last == null) throw new NoSuchElementException();
        T val = last.val;
        if (front == last) {
            front = last.left;
            front.left = null;
        }
        last = last.left;
        last.right = null;

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

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> node = front;
        while (node != null) {
            sb.append(node.val);
            if(node.right != null) sb.append(" -> ");
            node = node.right;
        }
        return sb.toString();
    }

    class Node<T> {
        private T val;
        private Node left;
        private Node right;

        public Node(T val) {
            this.val = val;
        }
    }
}
