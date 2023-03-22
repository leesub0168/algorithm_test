package com.test.alg.implement.dataStructure;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UseTwoStackForQueueTest {
    @Test
    void push() {
        UseTwoStackForQueue useTwoStackForQueue = new UseTwoStackForQueue();
        useTwoStackForQueue.push(1);
        useTwoStackForQueue.push(2);

        int res = useTwoStackForQueue.pop();
        assertEquals(1,res);
    }
}