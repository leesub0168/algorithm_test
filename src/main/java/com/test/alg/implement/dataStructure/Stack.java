package com.test.alg.implement.dataStructure;

import java.util.EmptyStackException;

public class Stack<T> {
    private Node<T> top;

    public void push(T t) {
        Node<T> node = new Node<>(t);
        node.next = top;
        top = node;
    }

    public T pop() {
        if(top == null) throw new EmptyStackException();
        T val = top.val;
        top = top.next;
        return val;
    }

    public T top() {
        if(top == null) throw new EmptyStackException();
        return top.val;
    }

    class Node<T> {
        private T val;
        private Node<T> next;

        public Node(T val) {
            this.val = val;
        }
    }
}
