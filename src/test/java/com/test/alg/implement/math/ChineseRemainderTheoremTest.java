package com.test.alg.implement.math;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChineseRemainderTheoremTest {

    @Test
    void how_many_student() {
        ChineseRemainderTheorem chineseRemainderTheorem = new ChineseRemainderTheorem();
        int res = chineseRemainderTheorem.how_many_students();

        assertEquals(27, res);
    }

    @Test
    void what_is_remainder() {
        ChineseRemainderTheorem chineseRemainderTheorem = new ChineseRemainderTheorem();
        int res = chineseRemainderTheorem.what_is_remainder();

        assertEquals(14, res);
    }

    @Test
    void cain_calendar() {
        ChineseRemainderTheorem chineseRemainderTheorem = new ChineseRemainderTheorem();
        int n = 13;
        int m = 11;
        int x = 5;
        int y = 6;

        int res = chineseRemainderTheorem.cain_calendar(n, m, x, y);
        System.out.println(res);
        assertEquals(33, res);
    }
}