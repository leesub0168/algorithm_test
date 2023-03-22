package com.test.alg.implement.dataStructure;

import java.util.Stack;

public class UseTwoStackForQueue {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> tempStack = new Stack<>();

    public void push(int n) {
        stack.push(n);
    }

    public int pop() {
        if(!tempStack.isEmpty()) return tempStack.pop();
        int res = stack.pop();
        if(!stack.isEmpty()) {
            tempStack.push(res);
            res = stack.pop();
        }
        return res;
    }
}
