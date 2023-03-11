package com.test.alg.implement.dataStructure;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertAll;

class QueueTest {

    @Test
    @DisplayName("큐에 원소 삽입 후 front, back 확인")
    void push() {
        Queue<Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);
        queue.push(3);

        assertAll(
                () -> assertEquals(1, queue.front()),
                () -> assertEquals(3, queue.back())
        );
    }

    @Test
    @DisplayName("큐에 원소 삭제 후 front, back 확인")
    void pop() {
        Queue<Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);

        queue.pop();

        assertAll(
                () -> assertEquals(2, queue.front()),
                () -> assertEquals(2, queue.back())
        );
    }


    @Test
    @DisplayName("큐에 원소를 모두 삭제 후 front, back 호출")
    void empty_queue() {
        Queue<Integer> queue = new Queue<>();
        queue.push(1);
        queue.push(2);

        queue.pop();
        queue.pop();

        assertAll(
                () -> assertThrows(NoSuchElementException.class, () -> queue.front()),
                () -> assertThrows(NoSuchElementException.class, () -> queue.back())
        );
    }
}