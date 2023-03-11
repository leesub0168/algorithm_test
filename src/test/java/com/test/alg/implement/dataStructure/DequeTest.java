package com.test.alg.implement.dataStructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class DequeTest {

    @Test
    @DisplayName("덱의 front에 요소 추가")
    void push_front() {
        Deque<Integer> deque = new Deque<>();
        deque.push_front(1);
        deque.push_front(2);

        assertAll(
                () -> assertEquals(2, deque.front()),
                () -> assertEquals(1, deque.back())
        );

    }

    @Test
    @DisplayName("덱의 back에 요소 추가")
    void push_back() {
        Deque<Integer> deque = new Deque<>();
        deque.push_back(1);
        deque.push_back(2);
        deque.push_back(3);

        assertAll(
                () -> assertEquals(1, deque.front()),
                () -> assertEquals(3, deque.back())
        );
    }

    @Test
    @DisplayName("덱의 back, front에 요소 추가")
    void push_front_and_back() {
        Deque<Integer> deque = new Deque<>();
        deque.push_back(1);
        deque.push_front(4);
        deque.push_back(2);

        assertAll(
                () -> assertEquals(4, deque.front()),
                () -> assertEquals(2, deque.back())
        );
    }

    @Test
    @DisplayName("덱의 front에서 요소 삭제")
    void pop_front() {
        Deque<Integer> deque = new Deque<>();
        deque.push_back(1);
        deque.push_front(2);
        deque.push_front(4);

        int result = deque.pop_front();

        assertAll(
                () -> assertEquals(4, result),
                () -> assertEquals(2, deque.front()),
                () -> assertEquals(1, deque.back())
        );
    }

    @Test
    @DisplayName("덱의 back에서 요소 삭제")
    void pop_back() {
        Deque<Integer> deque = new Deque<>();
        deque.push_back(1);
        deque.push_front(4);
        deque.push_back(2);

        int result = deque.pop_back();

        assertAll(
                () -> assertEquals(2, result),
                () -> assertEquals(4, deque.front()),
                () -> assertEquals(1, deque.back())
        );
    }

    @Test
    void integration() {
        Deque<Integer> deque = new Deque<>();
        deque.push_back(1);
        deque.push_back(5);
        deque.push_front(4);
        deque.push_back(2);
        deque.push_front(7);

        deque.pop_front();
        deque.pop_front();
        deque.pop_back();

        System.out.println(deque.toString());

        assertAll(
                () -> assertEquals(1, deque.front()),
                () -> assertEquals(5, deque.back())
        );

    }
}