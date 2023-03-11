package com.test.alg.implement.dataStructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    @DisplayName("스택에 원소 추가")
    void push() {
        Stack<Integer> stack = new Stack<>();
        int x = 1;
        int x2 = 2;
        stack.push(x);
        stack.push(x2);

        assertEquals(x2, stack.top());
    }

    @Test
    @DisplayName("스택에서 원소 삭제")
    void pop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        stack.pop();

        assertEquals(1, stack.top());
    }

    @Test
    @DisplayName("스택의 최상단 원소 확인")
    void top() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);

        assertEquals(1, stack.top());
    }

    @Test
    @DisplayName("빈 스택에서 최상단 원소 확인")
    void emptyStack_top() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        stack.pop();
        stack.pop();

        assertThrows(EmptyStackException.class, () -> stack.top() );
    }

    @Test
    @DisplayName("빈 스택에서 원소 삭제")
    void emptyStack_pop() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        stack.pop();
        stack.pop();

        assertThrows(EmptyStackException.class, () -> stack.pop() );
    }
}